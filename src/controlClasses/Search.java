/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import item.Item;
import JDBCconnection.JDBCconnection;
import item.AuthorArtist;
import item.Book;
import item.Magazine;
import item.Movie;
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
    
    private final String SEARCH_KEYWORD_GENRE_ITEMNO = "SELECT * FROM Keyword k JOIN "
            + "Item i ON k.itemNo = i.itemNo JOIN Genre g ON g.itemNo = i.itemNo "
            + "WHERE itemNo = ?";
    
    private final String SEARCH_KEYWORD_GENRE = "SELECT * FROM Keyword k JOIN "
            + "Item i ON k.itemNo = i.itemNo JOIN Genre g ON g.itemNo = i.itemNo "
            + "WHERE word = ? OR genre = ? OR title = ? OR isbn = ? OR pCountry = ? OR publisher = ?";
    
    private final String SEARCH_AUTART = "SELECT * FROM Item i JOIN AAitem ai ON "
            + "i.itemNo = ai.itemNo JOIN AuthorArtist aa ON ai.aNo = aa.aNo WHERE fName LIKE ? OR sName LIKE ?";
    
    private final String SEARCH_AUTART_ITEMNO = "SELECT * FROM Item i JOIN AAitem ai ON "
            + "i.itemNo = ai.itemNo JOIN AuthorArtist aa ON ai.aNo = aa.aNo WHERE itemNo = ?";
    
    
    private final PreparedStatement psSearchTitle;
    private final PreparedStatement psSearchKeyGenItemNo;
    private final PreparedStatement psSearchKeywordGenre;
    private final PreparedStatement psSearchAutArt;
    private final PreparedStatement psSearchAutArtItemNo;
    
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
        psSearchKeyGenItemNo = con.prepareStatement(SEARCH_KEYWORD_GENRE_ITEMNO);
        psSearchKeywordGenre = con.prepareStatement(SEARCH_KEYWORD_GENRE);
        psSearchAutArt = con.prepareStatement(SEARCH_AUTART);
        psSearchAutArtItemNo = con.prepareStatement(SEARCH_AUTART_ITEMNO);
    }
//
//    public ArrayList<Integer> searchKeyword(String string) throws SQLException{
//        ArrayList<Integer> itemNumbers = new ArrayList<>();
//        psSearchKeyword.setString(1, string);
//        searchResults = psSearchKeyword.executeQuery();    
//        while (searchResults.next()){
//            itemNumbers.add(searchResults.getInt("itemNo"));
//        }
//        return itemNumbers;
//    }
//    
    public List<Item> searchItem(String string) throws SQLException, ClassNotFoundException {
        
        ArrayList<String> keywords = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        
        ArrayList<Integer> itemNumbers = new ArrayList<>();
        psSearchKeywordGenre.setString(1, string);
        psSearchKeywordGenre.setString(2, string);
        psSearchKeywordGenre.setString(3, string);
        psSearchKeywordGenre.setString(4, string);
        psSearchKeywordGenre.setString(5, string);
        psSearchKeywordGenre.setString(6, string);
        searchResults = psSearchKeywordGenre.executeQuery();
        
        while (searchResults.next()) {
            genres.add(searchResults.getString("genre"));
            keywords.add(searchResults.getString("word"));
            itemNumbers.add(searchResults.getInt("itemNo"));
        }
        
        for(int i = 0; i < itemNumbers.size(); i++){
            searchAutArtOnItemNo(itemNumbers.get(i), keywords, genres);
        }
        
        itemNumbers.clear();
        
        psSearchAutArt.setString(1, "%" + string + "%");
        psSearchAutArt.setString(2, "%" + string + "%");
        searchResults = psSearchAutArt.executeQuery();
        
        while(searchResults.next()){
            String fname = searchResults.getString("fName");
            String sname = searchResults.getString("sName");
            int itemNo = searchResults.getInt("itemNo");
            AuthorArtist autArt = new AuthorArtist(fname, sname, itemNo);
            authorArtists.add(autArt);
            itemNumbers.add(itemNo);
        }
        
        for(int i = 0; i < itemNumbers.size(); i++){
            searchKeyGenOnItemNo(itemNumbers.get(i), authorArtists);
        }
        
        return items;
    }
    
    private void searchAutArtOnItemNo(int itemNo, ArrayList<String> keywords, 
            ArrayList<String> genres) throws SQLException, ClassNotFoundException{
        
        String isbn = null;
        String publisher = null;
        String title = null;
        int publishYear = 0;
        String location = null;
        int ageLimit = 0;
        String pCountry = null;
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        
        psSearchAutArtItemNo.setInt(1, itemNo);
        searchResults = psSearchAutArtItemNo.executeQuery();

        while (searchResults.next()) {

            isbn = searchResults.getString("isbn");
            publisher = searchResults.getString("publisher");
            title = searchResults.getString("title");
            publishYear = searchResults.getInt("publishYear");
            location = searchResults.getString("location");
            ageLimit = searchResults.getInt("ageLimit");
            pCountry = searchResults.getString("pCountry");
            String fname = searchResults.getString("fName");
            String sname = searchResults.getString("sName");
            AuthorArtist autArt = new AuthorArtist(fname, sname, itemNo);
            authorArtists.add(autArt);
        }

        addItemToList(isbn, publisher, title, publishYear, location, ageLimit, 
                pCountry, keywords, genres, authorArtists);
    }
    
    private void searchKeyGenOnItemNo(int itemNo, ArrayList<AuthorArtist> authorArtists) 
            throws SQLException, ClassNotFoundException{
        
        String isbn = null;
        String publisher = null;
        String title = null;
        int publishYear = 0;
        String location = null;
        int ageLimit = 0;
        String pCountry = null;
        ArrayList<String> keywords = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();
        
        psSearchKeyGenItemNo.setInt(1, itemNo);
        searchResults = psSearchKeyGenItemNo.executeQuery();

        while (searchResults.next()) {
            isbn = searchResults.getString("isbn");
            publisher = searchResults.getString("publisher");
            title = searchResults.getString("title");
            publishYear = searchResults.getInt("publishYear");
            location = searchResults.getString("location");
            ageLimit = searchResults.getInt("ageLimit");
            pCountry = searchResults.getString("pCountry");
            genres.add(searchResults.getString("genre"));
            keywords.add(searchResults.getString("word"));
        }
        
        addItemToList(isbn, publisher, title, publishYear, location, ageLimit, 
                pCountry, keywords, genres, authorArtists);
    }
    
    private void addItemToList(String isbn, String publisher, String title, int publishYear, 
            String location, int ageLimit, String pCountry, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<AuthorArtist> authorArtists) throws ClassNotFoundException, SQLException{
        if(ageLimit == 0 && pCountry == null){
            items.add(new Book(isbn, publisher, title, publishYear, location, 
                keywords, genres, authorArtists));
        }
        else if(isbn == null && publisher == null){
            items.add(new Movie(ageLimit, pCountry, title, publishYear, location, 
                    keywords, genres, authorArtists));
        }
        else if(isbn == null && ageLimit == 0 && pCountry == null){
            items.add(new Magazine(publisher, title, publishYear, location, 
                    keywords, genres, authorArtists));
        }
    }
    
//    public ResultSet searchItem(String string) throws SQLException {
//        ArrayList<String> keyWords = new ArrayList<>();
//        psSearchKeywordGenre.setString(1, string);
//        psSearchKeywordGenre.setString(2, string);
//        psSearchKeywordGenre.setString(3, string);
//        psSearchKeywordGenre.setString(4, string);
//        psSearchKeywordGenre.setString(5, string);
//        psSearchKeywordGenre.setString(6, string);
//        
//        searchResults = psSearchKeywordGenre.executeQuery();
//        
//        psSearchAutArt.setString(1, "%" + string + "%");
//        psSearchAutArt.setString(2, "%" + string + "%");
//        
//        
//        ResultSet searchResults2 = psSearchAutArt.executeQuery();
//        
//        while(searchResults.next()) {
//            while(searchResults2.next()){
//                items.add(new Item());
//            }
//        }
//        
//        psSearchTitle.setString(1, string);
//        psSearchTitle.setString(2, string);
//        psSearchTitle.setString(3, string);
//        psSearchTitle.setString(4, string);
//        psSearchTitle.setString(5, string);
//
//        searchResults = psSearchTitle.executeQuery();
//        return searchResults;
//        while (searchResults.next()) {
//            items.add(new Item)
//        }
//        //String title, int publishYear, String location, ArrayList<String> keywords, 
//        // ArrayList<String> genres, ArrayList<AuthorArtist> authorArtist
//        
//
//    }

    // public void searchItem(String string){
    //}
    public void searchCopy(Item item) { //detta för reserve

    }
}
