/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import JDBCconnection.JDBCconnection;
import item.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author annalangstrom
 */
public class ObjectControl {
    
    private final String BOOK_INSERT = "insert into Item (isbn, title, publisher, "
            + "publishYear, location) values (?, ?, ?, ?, ?)";
    private final String MAGAZINE_INSERT = "insert into item (title, publisher, "
            + "publishYear, location) values (?, ?, ?, ?)";
    private final String MOVIE_INSERT = "insert into item (title, ageLimit, pCountry, "
            + "publishYear, location) values (?, ?, ?, ?, ?)";
    private final String KEYWORD_INSERT = "insert into Keyword (itemNo, word) values (?, ?)";
    private final String GENRE_INSERT = "insert into Genre (itemNo, genre) values (?, ?)";
    private final String AUTHOR_ARTIST_INSERT = "insert into AuthorArtist (fName, sName) values (?, ?)";
    private final String AA_ITEM_INSERT = "insert into AAitem (itemNo, aNo) values (?, ?)";
    private final String AUTHOR_ARTIST_SELECTALL = "select * from AuthorArtist";
    private final String ITEM_SELECT = "SELECT * FROM Item WHERE itemNo = ?";
    private final String KEYWORD_SELECT = "SELECT * FROM Keyword WHERE itemNo = ?";
    private final String GENRE_SELECT = "SELECT * FROM Genre WHERE itemNo = ?";
    private final String AA_ITEM_SELECT = "SELECT * FROM AAitem WHERE itemNo = ?";
    private final String AUTART_SELECT = "SELECT * FROM AuthorArtist WHERE aNo = ?";
    private final String ITEM_UPDATE = "UPDATE Item SET isbn = ?, title = ?, ageLimit = ?, "
            + "pCountry = ?, publisher = ?, publishYear = ?, location = ? WHERE itemNo = ?";
    private final String ITEM_INACTIVATE = "UPDATE Item SET active = 0 WHERE itemNo = ?";
    
    private final PreparedStatement inactivateItem;
    private final PreparedStatement selectItem;
    private final PreparedStatement selectKeyword;
    private final PreparedStatement selectGenre;
    private final PreparedStatement selectAAitem;
    private final PreparedStatement selectAllAutArt;
    private final PreparedStatement updateItem;
    private final PreparedStatement insertBook;
    private final PreparedStatement insertMagazine;
    private final PreparedStatement insertMovie;
    private final PreparedStatement insertKeyword;
    private final PreparedStatement insertGenre;
    private final PreparedStatement insertAutArt;
    private final PreparedStatement insertAAitem;
    private final PreparedStatement selectAutArt;
    
    JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    public ObjectControl() throws ClassNotFoundException, 
            SQLException{
       con = connection.connectToDb(con); 
       insertBook = con.prepareStatement(BOOK_INSERT, Statement.RETURN_GENERATED_KEYS);
       insertMagazine = con.prepareStatement(MAGAZINE_INSERT, Statement.RETURN_GENERATED_KEYS);
       insertMovie = con.prepareStatement(MOVIE_INSERT, Statement.RETURN_GENERATED_KEYS);
       insertKeyword = con.prepareStatement(KEYWORD_INSERT);
       insertGenre = con.prepareStatement(GENRE_INSERT);
       insertAutArt = con.prepareStatement(AUTHOR_ARTIST_INSERT, Statement.RETURN_GENERATED_KEYS);
       insertAAitem = con.prepareStatement(AA_ITEM_INSERT);
       selectAllAutArt = con.prepareStatement(AUTHOR_ARTIST_SELECTALL);
       selectItem = con.prepareStatement(ITEM_SELECT);
       selectKeyword = con.prepareStatement(KEYWORD_SELECT);
       selectGenre = con.prepareStatement(GENRE_SELECT);
       selectAAitem = con.prepareStatement(AA_ITEM_SELECT);
       selectAutArt = con.prepareStatement(AUTART_SELECT);
       updateItem = con.prepareStatement(ITEM_UPDATE);
       inactivateItem = con.prepareStatement(ITEM_INACTIVATE);
    }
    
    
    public void confirmSaving(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Saved!");
    }
    
    public void finish(){}
    
    public void addBookToDB(String isbn, String publisher, String title, 
            int publishYear, String location, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<String> authorArtist) throws SQLException, ClassNotFoundException{
        
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        
        Book book = new Book(isbn, publisher, title, publishYear, location, keywords, 
                genres, authorArtists);
        
        insertBook.setString(1, isbn);
        insertBook.setString(2, title);
        insertBook.setString(3, publisher);
        insertBook.setInt(4, publishYear);
        insertBook.setString(5, location);
        insertBook.executeUpdate();
        
        try (ResultSet generatedKeys = insertBook.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                book.setItemNo(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating item failed, no ID obtained.");
            }
        }
        
        if(!keywords.isEmpty())
            insertIntoKeyword(keywords, book);
        if(!genres.isEmpty())
            insertIntoGenre(genres, book);
        if(!authorArtist.isEmpty())
            insertIntoAuthorArtist(authorArtist, book, authorArtists);
        
        book.setAuthorArtist(authorArtists);
        if(con != null)
            insertBook.close();
    }
    
    public void addMagazineToDB(String publisher, String title, int publishYear, 
            String location, ArrayList<String> keywords, ArrayList<String> genres, 
            ArrayList<String> authorArtist) throws SQLException, ClassNotFoundException{
        
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        
        Magazine magazine = new Magazine(publisher, title, publishYear, location, 
        keywords, genres, authorArtists);
        
        insertMagazine.setString(1, title);
        insertMagazine.setString(2, publisher);
        insertMagazine.setInt(3, publishYear);
        insertMagazine.setString(4, location);
        insertMagazine.executeUpdate();
        
        try (ResultSet generatedKeys = insertMagazine.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                magazine.setItemNo(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating item failed, no ID obtained.");
            }
        }
        
        if(!keywords.isEmpty())
            insertIntoKeyword(keywords, magazine);
        if(!genres.isEmpty())
            insertIntoGenre(genres, magazine);
        if(!authorArtist.isEmpty())
            insertIntoAuthorArtist(authorArtist, magazine, authorArtists);
        
        magazine.setAuthorArtist(authorArtists);
        if(con != null)
            insertMagazine.close();
    }
    
    public void addMovieToDB(int ageLimit, String pCountry, String title, 
            int publishYear, String location, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<String> authorArtist) throws SQLException, ClassNotFoundException{
        
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        Movie movie = new Movie(ageLimit, pCountry, title, publishYear, location, keywords, 
                genres, authorArtists);
        
        insertMovie.setString(1, title);
        insertMovie.setInt(2, ageLimit);
        insertMovie.setString(3, pCountry);
        insertMovie.setInt(4, publishYear);
        insertMovie.setString(5, location);
        insertMovie.executeUpdate();
        
        try (ResultSet generatedKeys = insertMovie.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                movie.setItemNo(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating item failed, no ID obtained.");
            }
        }
        
        if(!keywords.isEmpty())
            insertIntoKeyword(keywords, movie);
        if(!genres.isEmpty())
            insertIntoGenre(genres, movie);
        if(!authorArtist.isEmpty())
            insertIntoAuthorArtist(authorArtist, movie, authorArtists);
        
        movie.setAuthorArtist(authorArtists);
        if(con != null)
            insertMovie.close();
    }
    
    private void insertIntoKeyword(ArrayList<String> keywords, Item item) throws SQLException{
        
        for (int i = 0; i < keywords.size(); i++) {
            insertKeyword.setInt(1, item.getItemNo());
            insertKeyword.setString(2, keywords.get(i));
            insertKeyword.executeUpdate();
        }
        if(con != null)
            insertKeyword.close();
    }
    
    private void insertIntoGenre(ArrayList<String> genres, Item item) throws SQLException{
        
        for (int i = 0; i < genres.size(); i++){
            insertGenre.setInt(1, item.getItemNo());
            insertGenre.setString(2, genres.get(i));
            insertGenre.executeUpdate();
        }
        if(con != null)
            insertGenre.close();
    }
    
    private ArrayList<AuthorArtist> insertIntoAuthorArtist(ArrayList<String> authorArtist, 
            Item item, ArrayList<AuthorArtist> authorArtists) throws SQLException{
        AuthorArtist autArt;
        ArrayList<String> autArt_db = new ArrayList<>();
        ArrayList<Integer> aNo_db = new ArrayList<>();
        
        ResultSet rs = getAAfromDB();
        while(rs.next()){
            String fullname_db = rs.getString("fName") + " " + rs.getString("sName");
            autArt_db.add(fullname_db);
            int aNo = rs.getInt("aNo");
            aNo_db.add(aNo);
        }
        
        for (int i = 0; i < authorArtist.size(); i++){
            String fullname = authorArtist.get(i);
            String fname = fullname.substring(0, fullname.indexOf(" "));
            String lname = fullname.substring(fullname.indexOf(" ") + 1);
            
            if(!autArt_db.contains(fullname)){
                insertAutArt.setString(1, fname);
                insertAutArt.setString(2, lname);
                insertAutArt.executeUpdate();
            } 
            
            autArt = new AuthorArtist(fname, lname, item.getItemNo());
            authorArtists.add(autArt);
            
            if(!autArt_db.contains(fullname)){
                try (ResultSet generatedKeys = insertAutArt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        autArt.setaNo(generatedKeys.getInt(1));
                    }
                    else {
                        throw new SQLException("Creating item failed, no ID obtained.");
                    }
                }
            }
            else {
                autArt.setaNo(aNo_db.get(autArt_db.indexOf(fullname)));
            }
            
            insertAAitem.setInt(1, item.getItemNo());
            insertAAitem.setInt(2, autArt.getaNo());
            insertAAitem.executeUpdate();
        }
        if(con != null){
            insertAutArt.close();
            insertAAitem.close();
        }
        
        return authorArtists;
    }
    
    public ResultSet getAAfromDB() throws SQLException{
        ResultSet rs = selectAllAutArt.executeQuery();
        return rs;
    }
    
    public void updateInfo(Item item) throws SQLException{
        updateItem.setString(1, item.getTitle());
    }
    
    public Item getItemFromDB(int itemNo) throws SQLException, ClassNotFoundException{
        ResultSet rs;
        String isbn = null;
        String publisher = null;
        String title = null;
        int publishYear = 0;
        String location = null;
        int ageLimit = 0;
        String pCountry = null;
        ArrayList<String> keywords = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        Book book;
        Movie movie;
        Magazine magazine;
        
        selectItem.setInt(1, itemNo);
        rs = selectItem.executeQuery();
        while(rs.next()){
            isbn = rs.getString("isbn");
            publisher = rs.getString("publisher");
            title = rs.getString("title");
            publishYear = rs.getInt("publishYear");
            location = rs.getString("location");
            ageLimit = rs.getInt("ageLimit");
            pCountry = rs.getString("pCountry");
        }
        
        selectKeyword.setInt(1, itemNo);
        ResultSet rs2 = selectKeyword.executeQuery();
        while(rs2.next()){
            String keyword = rs2.getString("word");
            keywords.add(keyword);
        }
        
        selectGenre.setInt(1, itemNo);
        rs = selectGenre.executeQuery();
        while(rs.next()){
            String genre = rs.getString("genre");
            genres.add(genre);
        }
        
        selectAAitem.setInt(1, itemNo);
        rs = selectAAitem.executeQuery();
        while(rs.next()){
            int aNo = rs.getInt("aNo");
            selectAutArt.setInt(1, aNo);
            ResultSet rs3 = selectAutArt.executeQuery();
            while(rs3.next()){
                String fname = rs3.getString("fName");
                String sname = rs3.getString("sName");
                AuthorArtist autArt = new AuthorArtist(fname, sname, itemNo);
                authorArtists.add(autArt);
            }
        }
        
        if(ageLimit == 0 && pCountry == null){
            book = new Book(isbn, publisher, title, publishYear, location, 
                keywords, genres, authorArtists);
            return book;
        }
        else if(isbn == null && publisher == null){
            movie = new Movie(ageLimit, pCountry, title, publishYear, location, 
                    keywords, genres, authorArtists);
            return movie;
        }
        else if(isbn == null && ageLimit == 0 && pCountry == null){
            magazine = new Magazine(publisher, title, publishYear, location, 
                    keywords, genres, authorArtists);
            return magazine;
        }
        else
            return null;
    }
    
    public void updateObject(String isbn, String title, int ageLimit, String pCountry,
            String publisher, int publishYear, String location) throws SQLException{
        updateItem.setString(1, isbn);
        updateItem.setString(2, title);
        updateItem.setInt(3, ageLimit);
        updateItem.setString(4, pCountry);
        updateItem.setString(5, publisher);
        updateItem.setInt(6, publishYear);
        updateItem.setString(7, location);
        updateItem.executeUpdate();
    }
    
    public void removeItem(Item item) throws SQLException{
            item.setActive(false); 
            inactivateItem.setInt(1, item.getItemNo());
    }
    
    public void confirmInactivating(){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Remove completed!");
    }
    
}
