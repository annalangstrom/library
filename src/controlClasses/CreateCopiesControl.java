/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import GUI.AddCopy;
import JDBCconnection.JDBCconnection;
import item.Copy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author annalangstrom
 */
public class CreateCopiesControl {
    private final String COPY_INSERT = "INSERT INTO Copy (itemNo, lcNo, loanStatus, title) "
            + "VALUES (?, ?, ?, ?)";
    private final String COPY_SELECT = "SELECT * FROM Copy";
    
    private Connection con = null;
    private final PreparedStatement insertCopy;
    private final PreparedStatement selectAllCopies;
    
    List<Copy> lstCopies; 
    JDBCconnection connection;
    private AddCopy addCopy = null;
    
    //Konstruktor
    public CreateCopiesControl(AddCopy addCopy) throws ClassNotFoundException, 
            SQLException{
        this();
        this.addCopy = addCopy;
        
    }
    //Konstruktor
    public CreateCopiesControl() throws ClassNotFoundException, 
            SQLException{
        connection = new JDBCconnection();
        
       //Koppla upp
       con = connection.connectToDb(con); 
       insertCopy = con.prepareStatement(COPY_INSERT);
       selectAllCopies = con.prepareStatement(COPY_SELECT);
    }
    
    public void addCopy(int barcode, int itemNo, int category, String loanStatus, String condition) throws SQLException, ClassNotFoundException{
        String title = "title";
        
        //insertCopy.setInt(1, barcode);
        insertCopy.setInt(1, itemNo);
        insertCopy.setInt(2, category + 1);
        insertCopy.setString(3, loanStatus);
        //insertCopy.setString(4, condition);
        insertCopy.setString(4, title);
        
        insertCopy.executeUpdate();
        this.loadCopies();
    }
    
    public void loadCopies() throws SQLException, ClassNotFoundException {
        //Exekvera SQL-uttrycket
        ResultSet rs = selectAllCopies.executeQuery();
        this.lstCopies = new ArrayList<>();
        //loopa resultat från SQL-uttrycket och ladda ArrayList
        while (rs.next()){
            //Skapa nytt Message-objekt för varje post som returneras, 
            //data från resultset som inparametrar till konstruktorn i Message
            this.lstCopies.add(new Copy(
                rs.getInt(1), rs.getString(5), rs.getInt(3), rs.getString(4)));
            //barcode, condition, loanCategory, loanStatus
        } 
        this.addCopy.setCopyList(lstCopies);
        this.addCopy.loadTableData();
        //Stäng uppkoppling...
        connection.closeDbConnection(); 
    }
    
    

    
    
}
