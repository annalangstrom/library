/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import GUI.SearchGUI;
import JDBCconnection.JDBCconnection;
import item.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author annalangstrom
 */
public class Search {

    private final String SEARCH_KEYWORD_GENRE_ITEMNO = "SELECT * FROM Keyword k JOIN "
            + "Item i ON k.itemNo = i.itemNo JOIN Genre g ON g.itemNo = i.itemNo "
            + "WHERE i.itemNo = ?";
    
    private final String SEARCH_KEYWORD_GENRE = "SELECT * FROM Keyword k JOIN "
            + "Item i ON k.itemNo = i.itemNo JOIN Genre g ON g.itemNo = i.itemNo "
            + "WHERE word = ? OR genre = ? OR title = ? OR isbn = ? OR pCountry = ? OR publisher = ?";
    
    private final String SEARCH_AUTART = "SELECT * FROM Item i JOIN AAitem ai ON "
            + "i.itemNo = ai.itemNo JOIN AuthorArtist aa ON ai.aNo = aa.aNo WHERE fName LIKE ? OR sName LIKE ?";
    
    private final String SEARCH_AUTART_ITEMNO = "SELECT * FROM Item i JOIN AAitem ai ON "
            + "i.itemNo = ai.itemNo JOIN AuthorArtist aa ON ai.aNo = aa.aNo WHERE i.itemNo = ?";

    
    private final PreparedStatement psSearchKeyGenItemNo;
    private final PreparedStatement psSearchKeywordGenre;
    private final PreparedStatement psSearchAutArt;
    private final PreparedStatement psSearchAutArtItemNo;
    
    JDBCconnection connection;
    private Connection con = null;
    private SearchGUI sGUI = null;
    ResultSet searchResults = null;
    List<Item> items = new ArrayList<>();

    
    public Search(SearchGUI sGUI) throws SQLException, ClassNotFoundException{
        //koppling till SearchGUI
        this();
        this.sGUI = sGUI;
    }

    public Search() throws SQLException, ClassNotFoundException {
        this.connection = new JDBCconnection();
        con = connection.connectToDb(con);
        psSearchKeyGenItemNo = con.prepareStatement(SEARCH_KEYWORD_GENRE_ITEMNO);
        psSearchKeywordGenre = con.prepareStatement(SEARCH_KEYWORD_GENRE);
        psSearchAutArt = con.prepareStatement(SEARCH_AUTART);
        psSearchAutArtItemNo = con.prepareStatement(SEARCH_AUTART_ITEMNO);
    }

    public void searchItem(String string) throws SQLException, ClassNotFoundException {
        String isbn;
        String publisher;
        String title;
        int publishYear;
        String location;
        int ageLimit;
        String pCountry;
        int itemNo;
        ArrayList<String> keywords = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        
        psSearchKeywordGenre.setString(1, string);
        psSearchKeywordGenre.setString(2, string);
        psSearchKeywordGenre.setString(3, string);
        psSearchKeywordGenre.setString(4, string);
        psSearchKeywordGenre.setString(5, string);
        psSearchKeywordGenre.setString(6, string);
        searchResults = psSearchKeywordGenre.executeQuery();
        
        psSearchAutArt.setString(1, "%" + string + "%");
        psSearchAutArt.setString(2, "%" + string + "%");
        ResultSet searchResults2 = psSearchAutArt.executeQuery();
        
            while (searchResults.next()) {
                genres.add(searchResults.getString("genre"));
                keywords.add(searchResults.getString("word"));
                isbn = searchResults.getString("isbn");
                publisher = searchResults.getString("publisher");
                title = searchResults.getString("title");
                publishYear = searchResults.getInt("publishYear");
                location = searchResults.getString("location");
                ageLimit = searchResults.getInt("ageLimit");
                pCountry = searchResults.getString("pCountry");
                itemNo = searchResults.getInt("itemNo");
                authorArtists.addAll(searchAutArtOnItemNo(itemNo, keywords, genres));
                keywords.addAll(searchKeyOnItemNo(itemNo, authorArtists));
                genres.addAll(searchGenOnItemNo(itemNo, authorArtists));

                    while(searchResults2.next()){
                    String fname = searchResults2.getString("fName");
                    String sname = searchResults2.getString("sName");
                    itemNo = searchResults2.getInt("itemNo");
                    AuthorArtist autArt = new AuthorArtist(fname, sname, itemNo);
                    authorArtists.add(autArt);
                    }

                addItemToList(isbn, publisher, title, publishYear, location, ageLimit, 
                    pCountry, keywords, genres, authorArtists, itemNo);
                
            }
        
        
            while(searchResults2.next()){
                isbn = searchResults2.getString("isbn");
                publisher = searchResults2.getString("publisher");
                title = searchResults2.getString("title");
                publishYear = searchResults2.getInt("publishYear");
                location = searchResults2.getString("location");
                ageLimit = searchResults2.getInt("ageLimit");
                pCountry = searchResults2.getString("pCountry");
                String fname = searchResults2.getString("fName");
                String sname = searchResults2.getString("sName");
                itemNo = searchResults2.getInt("itemNo");
                AuthorArtist autArt = new AuthorArtist(fname, sname, itemNo);
                authorArtists.add(autArt);

                    while (searchResults.next()) {
                        genres.add(searchResults.getString("genre"));
                        keywords.add(searchResults.getString("word"));

                        authorArtists.addAll(searchAutArtOnItemNo(itemNo, keywords, genres));
                        keywords.addAll(searchKeyOnItemNo(itemNo, authorArtists));
                        genres.addAll(searchGenOnItemNo(itemNo, authorArtists));
                    }
                
                    

                addItemToList(isbn, publisher, title, publishYear, location, ageLimit, 
                    pCountry, keywords, genres, authorArtists, itemNo);

            }
        
        
    }
    
    public ArrayList<AuthorArtist> searchAutArtOnItemNo(int itemNo, ArrayList<String> keywords, 
            ArrayList<String> genres) throws SQLException, ClassNotFoundException{
        
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        
        psSearchAutArtItemNo.setInt(1, itemNo);
        searchResults = psSearchAutArtItemNo.executeQuery();

            while (searchResults.next()) {
                String fname = searchResults.getString("fName");
                String sname = searchResults.getString("sName");
                AuthorArtist autArt = new AuthorArtist(fname, sname, itemNo);
                authorArtists.add(autArt);

            }
        
        return authorArtists;
    }
    
    private ArrayList<String> searchKeyOnItemNo(int itemNo, ArrayList<AuthorArtist> authorArtists) 
            throws SQLException, ClassNotFoundException{
        
        ArrayList<String> keywords = new ArrayList<>();
        
        psSearchKeyGenItemNo.setInt(1, itemNo);
        searchResults = psSearchKeyGenItemNo.executeQuery();

            while (searchResults.next()) {
                keywords.add(searchResults.getString("word"));
            }
        
        return keywords;
    }
    
    private ArrayList<String> searchGenOnItemNo(int itemNo, ArrayList<AuthorArtist> authorArtists) 
            throws SQLException, ClassNotFoundException{
        
        ArrayList<String> genres = new ArrayList<>();
        
        psSearchKeyGenItemNo.setInt(1, itemNo);
        searchResults = psSearchKeyGenItemNo.executeQuery();

            while (searchResults.next()) {
                genres.add(searchResults.getString("genre"));
            }
        
        return genres;
    }
    
    private void addItemToList(String isbn, String publisher, String title, int publishYear, 
            String location, int ageLimit, String pCountry, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<AuthorArtist> authorArtists, int itemNo) throws ClassNotFoundException, SQLException{
        
        if(ageLimit == 0 && pCountry == null){
            Book book = new Book(isbn, publisher, title, publishYear, location, 
                keywords, genres, authorArtists);
            items.add(book);
            book.setItemNo(itemNo);
        }
        else if(isbn == null && publisher == null){
            Movie movie = new Movie(ageLimit, pCountry, title, publishYear, location, 
                    keywords, genres, authorArtists);
            items.add(movie);
            movie.setItemNo(itemNo);
            
        }
        else if(isbn == null && ageLimit == 0 && pCountry == null){
            Magazine magazine = new Magazine(publisher, title, publishYear, location, 
                    keywords, genres, authorArtists);
            items.add(magazine);
            magazine.setItemNo(itemNo);
        }
        
    }
    
    public void loadCopies() throws SQLException, ClassNotFoundException {
        this.sGUI.setItemList(items);
        this.sGUI.loadTableData();
        connection.closeDbConnection(); 
    }
}
