/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author annalangstrom
 */
public class Book extends Item{
    private String isbn;
    private String publisher;

    public Book(String isbn, String publisher, String title, int publishYear, 
            String location, ArrayList<String> keywords, ArrayList<String> genres, 
            ArrayList<AuthorArtist> authorArtist) throws ClassNotFoundException, SQLException {
        super(title, publishYear, location, keywords, genres, authorArtist);
        this.isbn = isbn;
        this.publisher = publisher;
    }
    
    public Book(){}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void putBookIntoDB(String title, String isbn, String publisher, 
            Year publishYear, String location){}
}
