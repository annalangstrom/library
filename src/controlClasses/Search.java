/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import item.Item;
import JDBCconnection.JDBCconnection;
import java.sql.*;
//import GUI.SearchGUI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annalangstrom
 */
public class Search {

    private final String SEARCH_TITLE = "SELECT sName FROM AuthorArtist WHERE fName = ?"; //detta tillfälligt för test
    private final PreparedStatement psSearchTitle;
    JDBCconnection connection;
    private Connection con = null;
    private GUI.SearchGUI sGUI;
    ResultSet searchResults = null;

    public void setSearchGUI(GUI.SearchGUI sGUI) {
        //koppling till SearchGUI
        this.sGUI = sGUI;
    }

    public Search() throws SQLException, ClassNotFoundException {
        //konstruktor
        this.connection = new JDBCconnection();
        con = connection.connectToDb(con);
        psSearchTitle = con.prepareCall(SEARCH_TITLE);
    }

    public ResultSet searchItem(String string) throws SQLException {        
        searchResults = psSearchTitle.executeQuery();
        return searchResults;
        while (searchResults.next()){
            
        }
        
    }

    // public void searchItem(String string){
    //}
    public void searchCopy(Item item) { //detta för reserve

    }
}
