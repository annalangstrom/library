/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import item.Item;
import JDBCconnection.JDBCconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import GUI.SearchGUI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annalangstrom
 */
public class Search {

    private final String SEARCH_TITLE = "SELECT * FROM Item WHERE ISBN = ?, "
            + "title = ?, pCountry = ?, publisher = ?, publishYear = ?"; //detta tillfälligt för test
    private final String SEARCH_KEYWORD = "SELECT * FROM Keyword.k JOIN Item.i ON k.itemNo = i.itemNo  WHERE word = ?";
    private final PreparedStatement psSearchTitle;
    private final PreparedStatement psSearchKeyword;
    JDBCconnection connection;
    private Connection con = null;
    private GUI.SearchGUI sGUI;
    ResultSet searchResults = null;
    List<Item> items;

    public void setSearchGUI(GUI.SearchGUI sGUI) {
        //koppling till SearchGUI
        this.sGUI = sGUI;
    }

    public Search() throws SQLException, ClassNotFoundException {
        //konstruktor
        this.connection = new JDBCconnection();
        con = connection.connectToDb(con);
        psSearchTitle = con.prepareStatement(SEARCH_TITLE);
        psSearchKeyword = con.prepareStatement(SEARCH_KEYWORD);
    }

//    public ArrayList<Integer> searchKeyword(String string) throws SQLException{
//        ArrayList<Integer> itemNumbers = new ArrayList<>();
//        psSearchKeyword.setString(1, string);
//        searchResults = psSearchKeyword.executeQuery();    
//        while (searchResults.next()){
//            itemNumbers.add(searchResults.getInt("itemNo"));
//        }
//        return itemNumbers;
//    }
    public ResultSet searchItem(String string) throws SQLException {
        ArrayList<String> keyWords = new ArrayList<>();
        psSearchKeyword.setString(1, string);
        searchResults = psSearchKeyword.executeQuery();
        while (searchResults.next()) {
            keyWords.add(searchResults.getString("word"));
        }
        
        psSearchTitle.setString(1, string);
        psSearchTitle.setString(2, string);
        psSearchTitle.setString(3, string);
        psSearchTitle.setString(4, string);
        psSearchTitle.setString(5, string);

        searchResults = psSearchTitle.executeQuery();
        return searchResults;
        while (searchResults.next()) {
            items.add(new Item)
        }
        //String title, int publishYear, String location, ArrayList<String> keywords, 
        // ArrayList<String> genres, ArrayList<AuthorArtist> authorArtist
        

    }

    // public void searchItem(String string){
    //}
    public void searchCopy(Item item) { //detta för reserve

    }
}
