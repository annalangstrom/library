/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import item.*;
import java.util.ArrayList;

/**
 *
 * @author annalangstrom
 */
public class CreateObject {
    
    public Book createBook(String title, String isbn, String publisher, 
            int publishYear, String location){
        
        ArrayList<String> keywords = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();
        ArrayList<AuthorArtist> authorArtists = new ArrayList<>();
        
        Book book = new Book(isbn, publisher, title, publishYear, 
                location, keywords, genres, authorArtists);
        
        return book;
    }
    
    public void createMovie(String title, int publishYear, int ageLimit, 
            String pCountry, String location){
        //same as for book
    }
    
    public void createMagazine(String title, String publisher, 
            int publishYear, String location){
        //same as for book
    }
    
    public String confirmSaving(){
        return "Creation completed!";
    }
    
    public void finish(){}
}
