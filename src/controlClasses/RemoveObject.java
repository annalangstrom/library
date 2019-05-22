/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import JDBCconnection.JDBCconnection;
import item.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author annalangstrom
 */
public class RemoveObject {
    
    private final String ITEM_INACTIVATE = "UPDATE Item SET active = 0 WHERE itemNo = ?";
    
    private final PreparedStatement inactivateItem;
    
    JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    //Konstruktor
    public RemoveObject() throws ClassNotFoundException, 
            SQLException{
       con = connection.connectToDb(con); 
       inactivateItem = con.prepareStatement(ITEM_INACTIVATE);
    }
    
    public void removeItem(Item item) throws SQLException{
            item.setActive(false); 
            inactivateItem.setInt(1, item.getItemNo());
    }
    
    public void confirmActivating(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Remove completed!");
    }

}
