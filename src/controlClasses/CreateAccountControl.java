/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import GUI.CreateAccount;
import JDBCconnection.JDBCconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author annalangstrom
 */
public class CreateAccountControl {
    
//    private final String BORROWER_INSERT = "INSERT INTO Borrower (ssn, category, fName, "
//            + "sName, password, email, phoneNo, street, postcode, city) "
//            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
//    
//    private final PreparedStatement insertBorrower;
//    JDBCconnection connection = new JDBCconnection();
//    private final Connection con = null;
//
//    private CreateAccount ca = null;
////    List<Message> lstMessages; 
//    
//    //Konstruktor
//    public CreateAccountControl(CreateAccount ca) throws ClassNotFoundException, 
//            SQLException{
//        this();
//        this.ca = ca;
//        
//    }
//    //Konstruktor
//    public CreateAccountControl() throws ClassNotFoundException, 
//            SQLException{
//       //Koppla upp
//       connection.connectToDb(); 
//       insertBorrower = con.prepareStatement(BORROWER_INSERT);
//    }
    
    
    public void addBorrowerToDB(String ssn, int category, String fname, String sname, 
            String password, String email, String phoneNo, String street, 
            String postcode, String city) throws SQLException, ClassNotFoundException{
        
        JDBCconnection con = new JDBCconnection();
        con.addBorrowerToDB(ssn, category, fname, sname, password, email, phoneNo, street, postcode, city);
//        insertBorrower.setString(1, ssn);
//        insertBorrower.setInt(2, category + 1);
//        insertBorrower.setString(3, fname);
//        insertBorrower.setString(4, sname);
//        insertBorrower.setString(5, password);
//        insertBorrower.setString(6, email);
//        insertBorrower.setString(7, phoneNo);
//        insertBorrower.setString(8, street);
//        insertBorrower.setString(9, postcode);
//        insertBorrower.setString(10, city);
//        
//        insertBorrower.executeUpdate();
//        
//        JFrame frame = new JFrame();
//        JOptionPane.showMessageDialog(frame, "Its completed!");
    }
    
}
