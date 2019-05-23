/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import JDBCconnection.JDBCconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; //till reservation
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import persons.*;

/**
 *
 * @author annalangstrom
 */
public class BorrowerControl {

    private final String BORROWER_SET_INACTIVE = "UPDATE Borrower SET active = 0 WHERE borrowerID = ?";
    private final String BORROWER_UPDATE = "UPDATE Borrower SET fName = ?, sName = ?, "
            + "email = ?, phoneNo = ?, password = ?, street = ?, postcode = ?, city = ?, category = ? "
            + "WHERE borrowerID = ?";
    private final String BORROWER_SELECT = "SELECT * FROM Borrower WHERE BorrowerID = ?";
    private final String BORROWER_INSERT = "INSERT INTO Borrower (ssn, category, fName, "
            + "sName, password, email, phoneNo, street, postcode, city) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?)";

    private final String BORROWER_SHOW_RESERVATIONS_RES = "SELECT itemNo, date "
            + "FROM Reservation WHERE borrowerID = ?"; //show reservation
    private final String BORROWER_SHOW_RESERVATIONS_ITEM = "SELECT  i.title, a.fName, a.sName "
            + "FROM Item i, AAItem aa, AuthorArtist a WHERE i.itemNo=aa.itemNo AND aa.aNo=a.aNo AND i.itemNo=?";
    private final PreparedStatement borrowerShowResRes; //show reservation
    private final PreparedStatement borrowerShowResItem; //show reservation
    ResultSet reservationResults;

    private final String STAFF_SELECT = "SELECT * FROM Staff WHERE StaffID = ?";
    
    private final PreparedStatement insertBorrower;
    private final PreparedStatement setBorrowerInactive;
    private final PreparedStatement updateBorrower;
    private final PreparedStatement selectBorrower;

    ArrayList<Integer> itemNo = new ArrayList<>(); //första query
    ArrayList<String> date = new ArrayList<>(); //första query ska visas
    ArrayList<String> title = new ArrayList<>(); //andra query ska visas
    ArrayList<String> autArt = new ArrayList<>(); //andra query ska visas
    
  
    private final PreparedStatement selectStaff;


   
    
    private final JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    //Konstruktor
    public BorrowerControl() throws ClassNotFoundException,
            SQLException {
        //Koppla upp

        con = connection.connectToDb(con);
        setBorrowerInactive = con.prepareStatement(BORROWER_SET_INACTIVE);
        updateBorrower = con.prepareStatement(BORROWER_UPDATE);
        selectBorrower = con.prepareStatement(BORROWER_SELECT);
        insertBorrower = con.prepareStatement(BORROWER_INSERT);

        borrowerShowResRes = con.prepareStatement(BORROWER_SHOW_RESERVATIONS_RES); //visa reserv
        borrowerShowResItem = con.prepareCall(BORROWER_SHOW_RESERVATIONS_ITEM); //visa reserv
        selectStaff = con.prepareStatement(STAFF_SELECT);
    }

    public void getReservations(int borrowerID) throws SQLException { //får id från inlogg

        borrowerShowResRes.setInt(1, borrowerID);
        reservationResults = borrowerShowResRes.executeQuery();
        while (reservationResults.next()) { //går igenom hela resultset
            itemNo.add(reservationResults.getInt("itemNo"));
            date.add(reservationResults.getString("date"));
        }

        int j = 0;
        for (int i = 0; i < itemNo.size(); i++) {
            j = itemNo.get(i);
            borrowerShowResItem.setInt(1, j);
            reservationResults = borrowerShowResItem.executeQuery();
            title.add(reservationResults.getString("title"));
            autArt.add(reservationResults.getString("fName") + " " + (reservationResults.getString("sName")));

        }

    }

    public void createBorrower(String ssn, int category, String fname, String sname,
            String password, String email, String phoneNo, String street,
            String postcode, String city) throws SQLException {
        insertBorrower.setString(1, ssn);
        insertBorrower.setInt(2, category + 1);
        insertBorrower.setString(3, fname);
        insertBorrower.setString(4, sname);
        insertBorrower.setString(5, password);
        insertBorrower.setString(6, email);
        insertBorrower.setString(7, phoneNo);
        insertBorrower.setString(8, street);
        insertBorrower.setString(9, postcode);
        insertBorrower.setString(10, city);

        insertBorrower.executeUpdate();
    }

    public void confirmCreation() {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Creation completed!");
    }

    public void showBorrower() {
    }

    public void updateBorrower(int borrowerID, String fname, String sname,
            String password, String email, String phoneNo, String street,
            String postcode, String city, int category) throws SQLException {

        updateBorrower.setString(1, fname);
        updateBorrower.setString(2, sname);
        updateBorrower.setString(3, email);
        updateBorrower.setString(4, phoneNo);
        updateBorrower.setString(5, password);
        updateBorrower.setString(6, street);
        updateBorrower.setString(7, postcode);
        updateBorrower.setString(8, city);
        updateBorrower.setInt(9, category);
        updateBorrower.setInt(10, borrowerID);
        updateBorrower.executeUpdate();
    }

    public void inactivateUser(int borrowerID) throws SQLException {
        setBorrowerInactive.setInt(1, borrowerID);
        setBorrowerInactive.executeUpdate();
    }

    public Borrower getBorrowerFromDB(int borrowerID) throws SQLException {
        String ssn = null;
        String fname = null;
        String sname = null;
        String email = null;
        String phoneNo = null;
        String password = null;
        String street = null;
        String postcode = null;
        String city = null;
        int category = 0;

        selectBorrower.setInt(1, borrowerID);
        ResultSet rs = selectBorrower.executeQuery();
        while (rs.next()) {
            ssn = rs.getString("ssn");
            fname = rs.getString("fName");
            sname = rs.getString("sName");
            email = rs.getString("email");
            phoneNo = rs.getString("phoneNo");
            password = rs.getString("password");
            street = rs.getString("street");
            postcode = rs.getString("postcode");
            city = rs.getString("city");
            category = rs.getInt("category");
        }

        Borrower borrower = new Borrower(ssn, fname, sname, password, email, phoneNo, street, postcode, city, category);

        return borrower;
    }
    
    public Staff getStaffFromDB(int staffID) throws SQLException{
        String fname = null;
        String sname = null;
        String category = null;
        String password = null;
        
        selectStaff.setInt(1, staffID);
        ResultSet rs = selectStaff.executeQuery();
        while(rs.next()){
            fname = rs.getString("fName");
            sname = rs.getString("sName");
            category = rs.getString("category");
            password = rs.getString("password");
        }
        
        Staff staff = new Staff(fname, sname, category, password);
        
        return staff;
    }
    
    public boolean luhn(String pnr){
        JFrame frame = new JFrame();
        //ifall angivet personnummer är längre än 10 anges antalet extrasiffror i "extra"
        int extra = pnr.length() - 10; 

        //ifall extrasiffrorna är färre än noll så innebär det att personnumret var 
        //färre än 10 siffror, vilket ett giltigt persnr måste vara, därför skrivs
        //ett felmeddelande ut och resultatet blir false och går tillbaka till "fillPnr"-metoden
        if (extra < 0) {
            JOptionPane.showMessageDialog(frame, "Social security number needs to contain of at least 10 numbers.");
            
            return false;
        }

        pnr = pnr.substring(extra, 10 + extra);
        int sum = 0;

        for (int i = 0; i < pnr.length(); i++){

            char c = pnr.charAt(i); 

            int num = c - '0'; 

            int product;
            if (i % 2 != 0){
                product = num * 1;
            }else{
                product = num * 2;
            }

            if (product > 9){
            product -= 9;
            }
            sum += product;              
        }
    
        //metoden returnerar sant ifall att "remaindern" av 10 är 0, 
        //alltså att summan gick att dela med 10 utan rester, i annat fall returneras false
        return (sum % 10 == 0);
    }
    
    public boolean passwordCheck(String password){
        if (password.length() < 6){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Password is too short, need to be at least 6 characters.");
            return false;
        }
        else 
            return true;
    }
}
