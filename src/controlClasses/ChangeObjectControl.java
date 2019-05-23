/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//caroline håller på i homepageGui och returnGui, kolla i signincontrol och signin
//rebecca jobbar search 
package controlClasses;

//import JDBCconnection.JDBCconnection;
//import item.AuthorArtist;
//import item.Book;
//import item.Item;
//import item.Magazine;
//import item.Movie;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;

/**
 *
 * @author annalangstrom
 */
public class ChangeObjectControl {
//    private final String ITEM_SELECT = "SELECT * FROM Item WHERE itemNo = ?";
//    private final String KEYWORD_SELECT = "SELECT * FROM Keyword WHERE itemNo = ?";
//    private final String GENRE_SELECT = "SELECT * FROM Genre WHERE itemNo = ?";
//    private final String AA_ITEM_SELECT = "SELECT * FROM AAitem WHERE itemNo = ?";
//    private final String AUTART_SELECT = "SELECT * FROM AuthorArtist WHERE aNo = ?";
//    private final String ITEM_UPDATE = "UPDATE Item SET isbn = ?, title = ?, ageLimit = ?, "
//            + "pCountry = ?, publisher = ?, publishYear = ?, location = ? WHERE itemNo = ?";
//    
//    private final PreparedStatement selectItem;
//    private final PreparedStatement selectKeyword;
//    private final PreparedStatement selectGenre;
//    private final PreparedStatement selectAAitem;
//    private final PreparedStatement selectAutArt;
//    private final PreparedStatement updateItem;
//    
//    JDBCconnection connection = new JDBCconnection();
//    private Connection con = null;
//
//    //Konstruktor
//    public ChangeObjectControl() throws ClassNotFoundException, 
//            SQLException{
//       //Koppla upp
//       
//       con = connection.connectToDb(con); 
//       selectItem = con.prepareStatement(ITEM_SELECT);
//       selectKeyword = con.prepareStatement(KEYWORD_SELECT);
//       selectGenre = con.prepareStatement(GENRE_SELECT);
//       selectAAitem = con.prepareStatement(AA_ITEM_SELECT);
//       selectAutArt = con.prepareStatement(AUTART_SELECT);
//       updateItem = con.prepareStatement(ITEM_UPDATE);
//    }
//    
//    public void updateInfo(Item item) throws SQLException{
//    updateItem.setString(1, item.getTitle());
//    }
//    
//    public void comfirmSaving(){
//        JFrame frame = new JFrame();
//        JOptionPane.showMessageDialog(frame, "Change completed!");
//    }
//    
//    public Item getItemFromDB(int itemNo) throws SQLException, ClassNotFoundException{
//        ResultSet rs;
//        String isbn = null;
//        String publisher = null;
//        String title = null;
//        int publishYear = 0;
//        String location = null;
//        int ageLimit = 0;
//        String pCountry = null;
//        ArrayList<String> keywords = new ArrayList<>();
//        ArrayList<String> genres = new ArrayList<>();
//        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
//        Book book;
//        Movie movie;
//        Magazine magazine;
//        
//        selectItem.setInt(1, itemNo);
//        rs = selectItem.executeQuery();
//        while(rs.next()){
//            isbn = rs.getString("isbn");
//            publisher = rs.getString("publisher");
//            title = rs.getString("title");
//            publishYear = rs.getInt("publishYear");
//            location = rs.getString("location");
//            ageLimit = rs.getInt("ageLimit");
//            pCountry = rs.getString("pCountry");
//        }
//        
//        selectKeyword.setInt(1, itemNo);
//        ResultSet rs2 = selectKeyword.executeQuery();
//        while(rs2.next()){
//            String keyword = rs2.getString("word");
//            keywords.add(keyword);
//        }
//        
//        selectGenre.setInt(1, itemNo);
//        rs = selectGenre.executeQuery();
//        while(rs.next()){
//            String genre = rs.getString("genre");
//            genres.add(genre);
//        }
//        
//        selectAAitem.setInt(1, itemNo);
//        rs = selectAAitem.executeQuery();
//        while(rs.next()){
//            int aNo = rs.getInt("aNo");
//            selectAutArt.setInt(1, aNo);
//            ResultSet rs3 = selectAutArt.executeQuery();
//            while(rs3.next()){
//                String fname = rs3.getString("fName");
//                String sname = rs3.getString("sName");
//                AuthorArtist autArt = new AuthorArtist(fname, sname, itemNo);
//                authorArtists.add(autArt);
//            }
//        }
//        
//        if(ageLimit == 0 && pCountry == null){
//            book = new Book(isbn, publisher, title, publishYear, location, 
//                keywords, genres, authorArtists);
//            return book;
//        }
//        else if(isbn == null && publisher == null){
//            movie = new Movie(ageLimit, pCountry, title, publishYear, location, 
//                    keywords, genres, authorArtists);
//            return movie;
//        }
//        else if(isbn == null && ageLimit == 0 && pCountry == null){
//            magazine = new Magazine(publisher, title, publishYear, location, 
//                    keywords, genres, authorArtists);
//            return magazine;
//        }
//        else
//            return null;
//    }
//    
//    public void updateObject(String isbn, String title, int ageLimit, String pCountry,
//            String publisher, int publishYear, String location) throws SQLException{
//        updateItem.setString(1, isbn);
//        updateItem.setString(2, title);
//        updateItem.setInt(3, ageLimit);
//        updateItem.setString(4, pCountry);
//        updateItem.setString(5, publisher);
//        updateItem.setInt(6, publishYear);
//        updateItem.setString(7, location);
//        updateItem.executeUpdate();
//    }
}
