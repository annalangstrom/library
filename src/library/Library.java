/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import item.AuthorArtist;
import item.Copy;
import item.*;
import item.LoanCategory;
import item.itemCategories.Book;
import java.time.Year;
import java.util.ArrayList;
import loan.LoanItem;

/**
 *
 * @author annalangstrom
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> keywords = new ArrayList<>();
        ArrayList<String> genres = new ArrayList<>();
        ArrayList<AuthorArtist> aas = new ArrayList<>();
        Book book1 = new Book("Hej", "hej", "hallå", Year.now(), "hortlax", keywords, genres, aas);
        LoanCategory lc = new LoanCategory(LCname.MOVIE, 5);
        Copy copy1 = new Copy(1, book1, lc, LoanStatus.BORROWED, "fine");
        
        Copy copy2 = new Copy(1);
        
        
    }
    
}
