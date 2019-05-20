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
    
    private final String EMAIL_UPDATE = "UPDATE Borrower SET email = ? WHERE borrowerID = ?";
    private final String PHONE_UPDATE = "UPDATE Borrower SET phoneNo = ? WHERE borrowerID = ?";
    private final String FNAME_UPDATE = "UPDATE Borrower SET fName = ? WHERE borrowerID = ?";
    private final String SNAME_UPDATE = "UPDATE Borrower SET sName = ? WHERE borrowerID = ?";
    private final String PASSWORD_UPDATE = "UPDATE Borrower SET password = ? WHERE borrowerID = ?";
    private final String STREET_UPDATE = "UPDATE Borrower SET street = ? WHERE borrowerID = ?";
    private final String POSTCODE_UPDATE = "UPDATE Borrower SET postcode = ? WHERE borrowerID = ?";
    private final String CITY_UPDATE = "UPDATE Borrower SET city = ? WHERE borrowerID = ?";
    private final String CATEGORY_UPDATE = "UPDATE Borrower SET category = ? WHERE borrowerID = ?";
    
    private final PreparedStatement setBorrowerInactive;
    private final PreparedStatement updateBorrower;
    private final PreparedStatement selectBorrower;
    private final PreparedStatement updateEmail;
    private final PreparedStatement updatePhone;
    private final PreparedStatement updateFname;
    private final PreparedStatement updateSname;
    private final PreparedStatement updatePassword;
    private final PreparedStatement updateStreet;
    private final PreparedStatement updatePostcode;
    private final PreparedStatement updateCity;
    private final PreparedStatement updateCategory;
    
    JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    //Konstruktor
    public BorrowerControl() throws ClassNotFoundException, 
            SQLException{
       //Koppla upp
       
       con = connection.connectToDb(con); 
       setBorrowerInactive = con.prepareStatement(BORROWER_SET_INACTIVE);
       updateBorrower = con.prepareStatement(BORROWER_UPDATE);
       selectBorrower = con.prepareStatement(BORROWER_SELECT);
       updateEmail = con.prepareStatement(EMAIL_UPDATE);
       updatePhone = con.prepareStatement(PHONE_UPDATE);
       updateFname = con.prepareStatement(FNAME_UPDATE);
       updateSname = con.prepareStatement(SNAME_UPDATE);
       updatePassword = con.prepareStatement(PASSWORD_UPDATE);
       updateStreet = con.prepareStatement(STREET_UPDATE);
       updatePostcode = con.prepareStatement(POSTCODE_UPDATE);
       updateCity = con.prepareStatement(CITY_UPDATE);
       updateCategory = con.prepareStatement(CATEGORY_UPDATE);
    }
    
    public void createBorrower(){
        //Ange inparametrar
    }
    
    public void showBorrower(){}
    
    public void updateBorrower( int borrowerID, String fname, String sname, 
            String password, String email, String phoneNo, String street, 
            String postcode, String city, int category) throws SQLException{
        
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
    
    public void inactivateUser(int borrowerID) throws SQLException{
        setBorrowerInactive.setInt(1, borrowerID);
        setBorrowerInactive.executeUpdate();
    }
    
    public Borrower getBorrowerFromDB(int borrowerID) throws SQLException{
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
        while(rs.next()){
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
        
        Student student = new Student(ssn, fname, sname, password, email, phoneNo, street, postcode, city, category);
        
        return student;
    }
}
