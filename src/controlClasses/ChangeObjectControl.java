/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import JDBCconnection.JDBCconnection;
import item.AuthorArtist;
import item.Book;
import item.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author annalangstrom
 */
public class ChangeObjectControl {
    private final String ITEM_SELECT = "SELECT * FROM Item WHERE ItemNo = ?";
    private final String KEYWORD_SELECT = "SELECT * FROM Keyword WHERE itemNo = ?";
    private final String GENRE_SELECT = "SELECT * FROM Genre WHERE itemNo = ?";
    private final String AA_ITEM_SELECT = "SELECT * FROM AAitem WHERE itemNo = ?";
    private final String AUTART_SELECT = "SELECT * FROM AuthorArtist WHERE aNo = ?";
    
    private final PreparedStatement selectItem;
    private final PreparedStatement selectKeyword;
    private final PreparedStatement selectGenre;
    private final PreparedStatement selectAAitem;
    private final PreparedStatement selectAutArt;
    
    JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    //Konstruktor
    public ChangeObjectControl() throws ClassNotFoundException, 
            SQLException{
       //Koppla upp
       
       con = connection.connectToDb(con); 
       selectItem = con.prepareStatement(ITEM_SELECT);
       selectKeyword = con.prepareStatement(KEYWORD_SELECT);
       selectGenre = con.prepareStatement(GENRE_SELECT);
       selectAAitem = con.prepareStatement(AA_ITEM_SELECT);
       selectAutArt = con.prepareStatement(AUTART_SELECT);
    }
    
    public void updateInfo(Item item){}
    
    public String comfirmSaving(){
        return "Change completed!";
    }
    
    public void finish(){
        
    }
    
    public Item getItemFromDB(int itemNo) throws SQLException, ClassNotFoundException{
        ResultSet rs;
        String isbn = null;
        String publisher = null;
        String title = null;
        int publishYear = 0;
        String location = null;
        ArrayList<String> keywords = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        
        selectItem.setInt(1, itemNo);
        rs = selectItem.executeQuery();
        while(rs.next()){
            isbn = rs.getString("isbn");
            publisher = rs.getString("publisher");
            title = rs.getString("title");
            publishYear = rs.getInt("publishYear");
            location = rs.getString("location");
        }
        
        selectKeyword.setInt(1, itemNo);
        rs = selectKeyword.executeQuery();
        while(rs.next()){
            String keyword = rs.getString("word");
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
            ResultSet rs2 = selectAutArt.executeQuery();
            while(rs2.next()){
                String fname = rs2.getString("fName");
                String sname = rs2.getString("sName");
                AuthorArtist autArt = new AuthorArtist(fname, sname, itemNo);
                authorArtists.add(autArt);
            }
        }
        
        Book item = new Book(isbn, publisher, title, publishYear, location, 
                keywords, genres, authorArtists);
        return item;
    }
    
    
}
