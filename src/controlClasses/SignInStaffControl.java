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


public class SignInStaffControl {
    private String CHECK_INLOG = "SELECT * FROM Staff WHERE staffID = ? AND password = ?";
    
    private final PreparedStatement checkInlog;
    JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    private User user;
    private HomePageGui homePage;
//    List<Message> lstMessages; 
    
    //Konstruktor
    public SignInStaffControl(HomePageGui homePage) throws ClassNotFoundException, 
            SQLException{
        this();
        this.homePage = homePage;
        
    }
    //Konstruktor
    public SignInStaffControl() throws ClassNotFoundException, 
            SQLException{
       //Koppla upp
       con = connection.connectToDb(con); 
       checkInlog = con.prepareStatement(CHECK_INLOG);//.......................................................
    }
    
    
    public void signIn(String user, String password) throws ClassNotFoundException{
        ResultSet rs = null;
        JDBCconnection con;
        JFrame frame = new JFrame();
        
        try {                              
            con = new JDBCconnection();
            rs = checkValidInlog(user, password, rs);
            int id = printSignInResult(rs);
            
            this.user = new Staff(id);//......................................................................
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
                id = rs.getInt("staffID");//..........................................................................
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
