/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import item.AuthorArtist;
import item.Item;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author annalangstrom
 */
public class Movie extends Item {
    private int ageLimit;
    private String pCountry;

    public Movie(int ageLimit, String pCountry, String title, int publishYear, 
            String location, ArrayList<String> keywords, ArrayList<String> genres, 
            ArrayList<AuthorArtist> authorArtist) {
        super(title, publishYear, location, keywords, genres, authorArtist);
        this.ageLimit = ageLimit;
        this.pCountry = pCountry;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getpCountry() {
        return pCountry;
    }

    public void setpCountry(String pCountry) {
        this.pCountry = pCountry;
    }
    
    public void putMovieIntoDB(String title, Year publishYear, int ageLimit, 
            String pCountry, String location){}
}
