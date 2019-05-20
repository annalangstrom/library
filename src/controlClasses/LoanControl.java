/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

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
public class LoanControl {
    
    private final String COPY_SELECT = "SELECT * FROM Copy WHERE barcodeNo = ?";
    
    private final PreparedStatement selectCopy;
    
     JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    //Konstruktor
    public LoanControl() throws ClassNotFoundException, 
            SQLException{
       //Koppla upp
       
       con = connection.connectToDb(con); 
       selectCopy = con.prepareStatement(COPY_SELECT);
    }
    
    public void createLoanItem(int barcode){}
    
    public void printReceipt(List<Copy> copies){
    
    }
    
    public Copy getCopyFromDB(int barcode) throws SQLException{
        int item = 0;
        int loanCategory = 0;
        String loanStatus = null;
        String condition = null;
        String title = null;
        
        selectCopy.setInt(1, barcode);
        ResultSet rs = selectCopy.executeQuery();
        while(rs.next()){
            item = rs.getInt("itemNo");
            loanCategory = rs.getInt("lcNo");
            loanStatus = rs.getString("loanStatus");
            condition = rs.getString("item_condition");
            title = rs.getString("title");
        }
        
        Copy copy = new Copy(barcode, item, loanCategory, loanStatus, condition, title);
        return copy;
    }
    
}
