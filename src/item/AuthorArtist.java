/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

import java.util.ArrayList;

/**
 *
 * @author annalangstrom
 */
public class AuthorArtist {
    private String fname;
    private String sname;
    private ArrayList<Item> items;

    public AuthorArtist(String fname, String sname, ArrayList<Item> items) {
        this.fname = fname;
        this.sname = sname;
        this.items = items;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    
    
}
