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
import java.sql.Date;

/**
 *
 * @author annalangstrom
 */
public class CreateReservation {
    
    private final String INSERT_RESERVATION = "INSERT INTO Reservation (borrowerID, itemNo, date) VALUES (?, ?, ?)";
    
    private final PreparedStatement insertReservation;
    
    JDBCconnection connection;
    private Connection con = null;
    
    public CreateReservation() throws ClassNotFoundException, SQLException{
        this.connection = new JDBCconnection();
        con = connection.connectToDb(con);
        insertReservation = con.prepareStatement(INSERT_RESERVATION);
    }
    
    public void createNewReservation(int borrower, int item, Date date) throws SQLException{
        insertReservation.setInt(1, borrower);
        insertReservation.setInt(2, item);
        insertReservation.setDate(3, date);
        insertReservation.executeUpdate();
    }
    
    
}
