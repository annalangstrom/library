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
import java.sql.Date;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import loan.Loan;
import loan.LoanItem;

/**
 *
 * @author annalangstrom
 */
public class LoanControl {
    
    private int borrower = 3;
    private final ArrayList<LoanItem> loanItems = new ArrayList<>();
    Loan loan = null;

    public int getBorrower() {
        return borrower;
    }

    public void setBorrower(int borrower) {
        this.borrower = borrower;
    }
    
    private final String COPY_SELECT = "SELECT * FROM Copy WHERE barcodeNo = ?";
    private final String LOAN_INSERT = "INSERT INTO Loan (borrowerID, startDate) VALUES (?, ?)";
    private final String LOANITEM_INSERT = "INSERT INTO LoanItem (barcodeNo, loanNo) VALUES (?, ?)";
    
    private final PreparedStatement selectCopy;
    private final PreparedStatement insertLoan;
    private final PreparedStatement insertLoanItem;
    
     JDBCconnection connection = new JDBCconnection();
    private Connection con = null;

    //Konstruktor
    public LoanControl() throws ClassNotFoundException, 
            SQLException{
       //Koppla upp
       
       con = connection.connectToDb(con); 
       selectCopy = con.prepareStatement(COPY_SELECT);
       insertLoan = con.prepareStatement(LOAN_INSERT, Statement.RETURN_GENERATED_KEYS);
       insertLoanItem = con.prepareStatement(LOANITEM_INSERT, Statement.RETURN_GENERATED_KEYS);
    }
    
    public void createLoan() throws SQLException{
        loan = new Loan(borrower, loanItems);
        insertLoan.setInt(1, borrower);
        insertLoan.setDate(2, Date.valueOf(loan.getStartDate()));
        insertLoan.executeUpdate();
        
        try (ResultSet generatedKeys = insertLoan.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                loan.setLoanNo(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating item failed, no ID obtained.");
            }
        }
    }
    
    public void createLoanItem(Copy copy) throws SQLException{
        LoanItem loanItem = new LoanItem(copy);
        loanItems.add(loanItem);
        
        insertLoanItem.setInt(1, copy.getBarcodeNo());
        insertLoanItem.setInt(2, loan.getLoanNo());
        insertLoanItem.executeUpdate();
        
        try (ResultSet generatedKeys = insertLoanItem.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                loanItem.setLoanItemNo(generatedKeys.getInt(1));
            }
            else {
                throw new SQLException("Creating item failed, no ID obtained.");
            }
        }
    }
    
    public void printReceipt(){
    
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
