/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import GUI.CreateAccount;
import GUI.CreateObject;
import JDBCconnection.JDBCconnection;
import java.time.Year;
import item.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Year.parse;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annalangstrom
 */
public class CreateObjectControl {
    
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
    
    
    private PreparedStatement insertBook;
    private PreparedStatement insertMagazine;
    private PreparedStatement insertMovie;
    private PreparedStatement insertKeyword;
    private PreparedStatement insertGenre;
    private PreparedStatement insertAutArt;
    private PreparedStatement insertAAitem;
    
    JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    private CreateObject co = null;
    
    //Konstruktor
    public CreateObjectControl(CreateObject co) throws ClassNotFoundException, 
            SQLException{
        this();
        this.co = co;
        
    }
    //Konstruktor
    public CreateObjectControl() throws ClassNotFoundException, 
            SQLException{
       //Koppla upp
       con = connection.connectToDb(con); 
       insertBook = con.prepareStatement(BOOK_INSERT);
       insertMagazine = con.prepareStatement(MAGAZINE_INSERT);
       insertMovie = con.prepareStatement(MOVIE_INSERT);
       insertKeyword = con.prepareStatement(KEYWORD_INSERT);
       insertGenre = con.prepareStatement(GENRE_INSERT);
       insertAutArt = con.prepareStatement(AUTHOR_ARTIST_INSERT);
       insertAAitem = con.prepareStatement(AA_ITEM_INSERT);
    }
    
    public Book createBook(String title, String isbn, String publisher, 
            int publishYear, String location, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<AuthorArtist> authorArtist){
        
//        Year pubYear = parse(publishYear);
        
        Book book = new Book(isbn, publisher, title, publishYear, location, keywords, 
                genres, authorArtist);
        
        return book;
    }
    
    public Movie createMovie(String title, int publishYear, int ageLimit, 
            String pCountry, String location, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<AuthorArtist> authorArtist){
        
//        Year pubYear = parse(publishYear);
        
        Movie movie = new Movie(ageLimit, pCountry, title, publishYear, location, keywords, 
                genres, authorArtist);
        
        return movie;
    }
    
    public Magazine createMagazine(String title, String publisher, 
            int publishYear, String location, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<AuthorArtist> authorArtist){
        
        Magazine magazine = new Magazine(publisher, title, publishYear, location, 
        keywords, genres, authorArtist);
        
        return magazine;
    }
    
    public String confirmSaving(){
        return "Creation completed!";
    }
    
    public void finish(){}
    
    public void addBookToDB(String isbn, String publisher, String title, 
            int publishYear, String location, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<String> authorArtist) throws SQLException{
        
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        Book book = createBook(title, isbn, publisher, 
            publishYear, location, keywords, genres, authorArtists);
        
        //insert into Item (isbn, title, publisher, publishYear, location) values (?,?,?,?,?)
        insertBook.setString(1, isbn);
        insertBook.setString(2, title);
        insertBook.setString(3, publisher);
        insertBook.setInt(4, publishYear);
        insertBook.setString(5, location);
        insertBook.executeUpdate();
        
        if(!keywords.isEmpty())
            insertIntoKeyword(keywords, book);
        if(!genres.isEmpty())
            insertIntoGenre(genres, book);
        if(!authorArtist.isEmpty())
            insertIntoAuthorArtist(authorArtist, book, authorArtists);
        
        //uppdatera arraylisten med de ifyllda posterna
        book.setAuthorArtist(authorArtists);
    }
    
    public void addMagazineToDB(String publisher, String title, int publishYear, 
            String location, ArrayList<String> keywords, ArrayList<String> genres, 
            ArrayList<String> authorArtist) throws SQLException{
        
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        Magazine magazine = createMagazine(title, publisher, publishYear, location, 
                keywords, genres, authorArtists);
        
        //insert into item (title, publisher, publishYear, location) values (?, ?, ?, ?)
        insertMagazine.setString(1, title);
        insertMagazine.setString(2, publisher);
        insertMagazine.setInt(3, publishYear);
        insertMagazine.setString(4, location);
        
        insertIntoKeyword(keywords, magazine);
        insertIntoGenre(genres, magazine);
        insertIntoAuthorArtist(authorArtist, magazine, authorArtists);
        
        //uppdatera arraylisten med de ifyllda posterna
        magazine.setAuthorArtist(authorArtists);
    }
    
    public void addMovieToDB(int ageLimit, String pCountry, String title, 
            int publishYear, String location, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<String> authorArtist) throws SQLException{
        
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        Movie movie = createMovie(title, publishYear, ageLimit, pCountry, location, keywords, 
                genres, authorArtists);
        
        //insert into item (title, ageLimit, pCountry, publishYear, location) values (?, ?, ?, ?, ?)
        insertMovie.setString(1, title);
        insertMovie.setInt(2, ageLimit);
        insertMovie.setString(3, pCountry);
        insertMovie.setInt(4, publishYear);
        insertMovie.setString(5, location);
        insertMovie.executeUpdate();
        
        insertIntoKeyword(keywords, movie);
        insertIntoGenre(genres, movie);
        insertIntoAuthorArtist(authorArtist, movie, authorArtists);
        
        //uppdatera arraylisten med de ifyllda posterna
        movie.setAuthorArtist(authorArtists);
    }
    
    private void insertIntoKeyword(ArrayList<String> keywords, Item item) throws SQLException{
        //insert into Keyword (itemNo, word) values (?, ?)
        for (int i = 0; i < keywords.size(); i++) {
            //Hur få tag i itemNo?
            insertKeyword.setInt(1, item.getItemNo());
            insertKeyword.setString(2, keywords.get(i));
        }
        insertKeyword.executeUpdate();
    }
    
    private void insertIntoGenre(ArrayList<String> genres, Item item) throws SQLException{
        //insert into Genre (itemNo, genre) values (?, ?)
        for (int i = 0; i < genres.size(); i++){
            //hur få tag i itemNo?
            insertGenre.setInt(1, item.getItemNo());
            insertGenre.setString(2, genres.get(i));
        }
        insertGenre.executeUpdate();
    }
    
    private ArrayList<AuthorArtist> insertIntoAuthorArtist(ArrayList<String> authorArtist, 
            Item item, ArrayList<AuthorArtist> authorArtists) throws SQLException{
        AuthorArtist autArt;
        
        //insert into AuthorArtist (fName, sName) values (?, ?)
        for (int i = 0; i < authorArtist.size(); i++){
            String fname, lname, fullname;
            fullname = authorArtist.get(i);
            fname = fullname.substring(0, fullname.indexOf(" "));
            lname = fullname.substring(fullname.indexOf(" "));
            insertAutArt.setString(1, fname);
            insertAutArt.setString(2, lname);
            
            autArt = new AuthorArtist(fname, lname, item);
            authorArtists.add(autArt);
            
            //insert into AAitem (itemNo, aNo) values (?, ?)
            insertAAitem.setInt(1, item.getItemNo());
            insertAAitem.setInt(2, autArt.getaNo());
        }
        insertAutArt.executeUpdate();
        insertAAitem.executeUpdate();
        
        return authorArtists;
    }
}
