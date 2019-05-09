/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import GUI.SignIn;
import JDBCconnection.JDBCconnection;
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
    
    public void signIn(String user, String password) throws ClassNotFoundException{
        ResultSet rs = null;
        JDBCconnection con;
        JFrame frame = new JFrame();
        
        try {                              
            con = new JDBCconnection();
            rs = con.checkValidInlog(user, password, rs);
            printSignInResult(rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Something went wrong.", "Error message", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void printSignInResult(ResultSet rs) throws SQLException{
        JFrame frame = new JFrame();
        String fullname = "";
        
        
        if (rs!=null){
            while (rs.next()){
                fullname = rs.getString("fName") + " " + rs.getString("sName");
            }
            
            if (fullname.equals(""))
                JOptionPane.showMessageDialog(frame, "User account or password was wrong.");
            else
            JOptionPane.showMessageDialog(frame, "You are signed is as " + fullname + ".");
        }
        else {
            JOptionPane.showMessageDialog(frame, "You are not signed in.");
        }
    }
}
