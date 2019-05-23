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



public class ReturnLoanItemControl {
   
   private final String RETURN_ITEM = "UPDATE LoanItem SET actualReturnDate = ? WHERE barcodeNo = ? AND actualReturnDate IS NULL";

   private final PreparedStatement checkInlog;
   private final JDBCconnection connection = new JDBCconnection();
   private Connection con = null;
   
   
   public ReturnLoanItemControl()throws ClassNotFoundException, 
            SQLException {
      con = connection.connectToDb(con);
      checkInlog = con.prepareStatement(RETURN_ITEM);
   }

   //Ta barcoden på återlämnat item
   //Hämta dagens datum och sätt in i statement
   //Sätt in barcode från textruta i statement
   //Skicka in i databas
   //Om det lycktas - skriv ut meddelande
   //Annars - skriv ut felmeddelande
   
    public void cancelLoanItem(int barcode) throws ClassNotFoundException {
        
    }
    
  
}
