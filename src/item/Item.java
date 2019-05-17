/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import JDBCconnection.JDBCconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author annalangstrom
 */
public abstract class Item {
    private int itemNo;
    private String title;
    private int publishYear;
    private String location;
    private ArrayList<String> keywords;
    private ArrayList<String> genres;
    private ArrayList<AuthorArtist> authorArtist;
    private boolean active = true;
    
//    private final String ITEM_SELECT = "SELECT itemNo FROM Item";
//    
//    private PreparedStatement selectItem = null;
//    
//    JDBCconnection connection;
//    private Connection con = null;
//
//    //Konstruktor
//    public CreateObjectControl() throws ClassNotFoundException, 
//            SQLException{
//       //Koppla upp
//       
//       con = connection.connectToDb(con); 
//       insertBook = con.prepareStatement(BOOK_INSERT);

    public Item(String title, int publishYear, String location, ArrayList<String> keywords, 
            ArrayList<String> genres, ArrayList<AuthorArtist> authorArtist){
        this.title = title;
        this.publishYear = publishYear;
        this.location = location;
        this.keywords = keywords;
        this.genres = genres;
        this.authorArtist = authorArtist;
        
//        connection = new JDBCconnection();
//        con = connection.connectToDb(con); 
//        selectItem = con.prepareStatement(ITEM_SELECT);
    }
    
    public Item (){}

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }
    
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<AuthorArtist> getAuthorArtist() {
        return authorArtist;
    }

    public void setAuthorArtist(ArrayList<AuthorArtist> authorArtist) {
        this.authorArtist = authorArtist;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public void inactivateItem(){
        this.setActive(false);
    }
    
    public Item searchItem(String word){
        
        Book book = new Book();
        
        return book;
    }
    
    public void setDBtitle(){}
}
