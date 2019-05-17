/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import GUI.CreateAccountGui;
import JDBCconnection.JDBCconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author annalangstrom
 */
public class CreateAccountControl {
    
    private final String BORROWER_INSERT = "INSERT INTO Borrower (ssn, category, fName, "
            + "sName, password, email, phoneNo, street, postcode, city) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
    
    private PreparedStatement insertBorrower;
    JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    private CreateAccountGui ca = null;
    
    //Konstruktor
    public CreateAccountControl(CreateAccountGui ca) throws ClassNotFoundException, 
            SQLException{
        this();
        this.ca = ca;
        
    }
    //Konstruktor
    public CreateAccountControl() throws ClassNotFoundException, 
            SQLException{
       //Koppla upp
       con = connection.connectToDb(con); 
       insertBorrower = con.prepareStatement(BORROWER_INSERT);
    }
    
    
    public void addBorrowerToDB(String ssn, int category, String fname, String sname, 
            String password, String email, String phoneNo, String street, 
            String postcode, String city) throws SQLException{
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
    
}
