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
public class Magazine extends Item{
    private String publisher;

    public Magazine(String publisher, String title, Year publishYear, String location, ArrayList<String> keywords, ArrayList<String> genres, ArrayList<AuthorArtist> authorArtist) {
        super(title, publishYear, location, keywords, genres, authorArtist);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    
}
