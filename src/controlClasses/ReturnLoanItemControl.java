/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import JDBCconnection.JDBCconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;




public class ReturnLoanItemControl {
   
   private final String RETURN_ITEM = "UPDATE LoanItem SET actualReturnDate = ? "
           + "WHERE barcodeNo = ? AND actualReturnDate IS NULL";

   private final PreparedStatement returnItem;
   
   private final JDBCconnection connection = new JDBCconnection();
   private Connection con = null;
   
   
   public ReturnLoanItemControl()throws ClassNotFoundException, 
            SQLException {
      con = connection.connectToDb(con);
      returnItem = con.prepareStatement(RETURN_ITEM);
   }
   
    public void cancelLoanItem(int barcode) throws ClassNotFoundException, 
            SQLException {
      
       LocalDate localDate = LocalDate.now();
     
       returnItem.setDate(1, Date.valueOf(localDate));
       returnItem.setInt(2, barcode);
        
       returnItem.executeUpdate();
    }
    
  
}
