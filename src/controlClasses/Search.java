/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import item.Item;
import java.sql.PreparedStatement;
import JDBCconnection.JDBCconnection;
import java.sql.Connection;
import GUI.SearchGUI;
/**
 *
 * @author annalangstrom
 */
public class Search {
    private final String SEARCH_TITLE = "SELECT * FROM item WHERE title = ?";
    private final PreparedStatement searchTitle;
    
    JDBCconnection connection = new JDBCconnection();
    private Connection con = null;
    
    public void searchItem(String word){
        
    }
    
    public void searchCopy(Item item){
        
    }
}
