/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import item.Item;
import JDBCconnection.JDBCconnection;
import java.sql.*;
import GUI.SearchGUI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annalangstrom
 */
public class Search {
    
    
    private final String SEARCH_TITLE = "SELECT * FROM item WHERE title = ?";
    private PreparedStatement psSearchTitle;

    JDBCconnection connection;
    private Connection con = null;
    String searchedItems;
    ResultSet rs = null;

    public Search() {
        try {
            this.connection = new JDBCconnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet searchItem(String searchedItems) throws ClassNotFoundException, SQLException {
        con = connection.connectToDb(con);
        psSearchTitle = con.prepareCall(SEARCH_TITLE);
        rs = psSearchTitle.executeQuery();
        return rs;
        
    }

    // public void searchItem(String string){
    //}
    public void searchCopy(Item item) {

    }
}
