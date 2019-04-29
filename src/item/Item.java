/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author annalangstrom
 */
public abstract class Item {
    private String title;
    private Year publishYear;
    private String location;
    private ArrayList<String> keywords;
    private ArrayList<String> genres;
    private ArrayList<AuthorArtist> authorArtist;
    private boolean active = true;

    public Item(String title, Year publishYear, String location, ArrayList<String> keywords, ArrayList<String> genres, ArrayList<AuthorArtist> authorArtist) {
        this.title = title;
        this.publishYear = publishYear;
        this.location = location;
        this.keywords = keywords;
        this.genres = genres;
        this.authorArtist = authorArtist;
    }
    
    public Item (){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Year getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(Year publishYear) {
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
