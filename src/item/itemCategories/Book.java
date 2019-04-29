/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item.itemCategories;

import item.AuthorArtist;
import item.Item;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author annalangstrom
 */
public class Book extends Item{
    private String isbn;
    private String publisher;

    public Book(String isbn, String publisher, String title, Year publishYear, String location, ArrayList<String> keywords, ArrayList<String> genres, ArrayList<AuthorArtist> authorArtist) {
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
    
    
}
