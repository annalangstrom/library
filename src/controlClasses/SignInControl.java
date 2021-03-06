/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import GUI.HomePageGui;
import persons.*;
import GUI.SignInGui;
import JDBCconnection.JDBCconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author annalangstrom
 */
public class SignInControl {
    
    private final String CHECK_INLOG = "SELECT * FROM Borrower WHERE ssn = ? AND password = ?";
    private final String CHECK_INLOG_STAFF = "SELECT * FROM Staff WHERE staffID = ? AND password = ?";
    
    private final PreparedStatement checkInlog;
    JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    private User user;
    private final HomePageGui homePage;
    private final int idLength;
    

    //Konstruktor
    public SignInControl(HomePageGui homePage, int idLenght) throws ClassNotFoundException, 
            SQLException{
       this.homePage = homePage;
       this.idLength = idLenght;
       //Koppla upp
       con = connection.connectToDb(con);
       if(idLenght < 10) {
          checkInlog = con.prepareStatement(CHECK_INLOG_STAFF);
       } else {
          checkInlog = con.prepareStatement(CHECK_INLOG);
       } 
    }
    
    
    public void signIn(String user, String password) throws ClassNotFoundException{
        ResultSet rs = null;
        JDBCconnection conn;
        JFrame frame = new JFrame();
        
        try {                              
            conn = new JDBCconnection();
            rs = checkValidInlog(user, password, rs);
            int id = printSignInResult(rs);
            
            if(idLength < 10) {
               this.user = new Staff(id);
            } else {
               this.user = new Borrower(id);
            }
            // Add Observer
            this.user.addObserver(homePage);
            homePage.setUser(this.user);
            this.user.setSignedIn(true);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Something went wrong.", "Error message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SignInGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private int printSignInResult(ResultSet rs) throws SQLException{
        JFrame frame = new JFrame();
        String fullname = "";
        int id = 0;
        
        if (rs!=null){
            while (rs.next()){
                fullname = rs.getString("fName") + " " + rs.getString("sName");
                if(idLength < 10) {
                  id = rs.getInt("staffID"); 
                } else {
                  id = rs.getInt("borrowerID");
                }
            }
            
            if (fullname.equals(""))
                JOptionPane.showMessageDialog(frame, "User account or password was wrong.");
            else{
                JOptionPane.showMessageDialog(frame, "You are signed is as " + fullname + ".");

            }
        }
        else {
            JOptionPane.showMessageDialog(frame, "You are not signed in.");
        }
        return id;
    }
    
    
    public ResultSet checkValidInlog(String user, String password, ResultSet rs) throws SQLException{
        checkInlog.setString(1, user);
        checkInlog.setString(2, password);
        rs = checkInlog.executeQuery();
        return rs;
    }
}
