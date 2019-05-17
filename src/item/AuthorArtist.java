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
    private int aNo;
    private String fname;
    private String sname;
    private ArrayList<Integer> items = new ArrayList<>();

    public AuthorArtist(String fname, String sname, int item) {
        this.fname = fname;
        this.sname = sname;
        items.add(item);
    }

    public void setaNo(int aNo) {
        this.aNo = aNo;
    }
    
    public int getaNo() {
        return aNo;
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

    public ArrayList<Integer> getItems() {
        return items;
    }

    public void setItems(ArrayList<Integer> items) {
        this.items = items;
    }
    
    
}
