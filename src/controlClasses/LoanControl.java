/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import GUI.PrintLoanReceiptGUI;
import JDBCconnection.JDBCconnection;
import item.Copy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Statement;
import loan.Loan;
import loan.LoanItem;
import persons.*;
import persons.User;

//Kom ihåg att implementera metoden printReceipt()
/**
 *
 * @author annalangstrom
 */
public class LoanControl {
    
    //private int borrower = 3;
    private User user;
    private final ArrayList<LoanItem> loanItems = new ArrayList<>();
    private final ArrayList<String> title_returndate = new ArrayList<>();
    Loan loan = null;

    public User getUser() {
        return user;
    }

    public void setBorrower(User user) {
        this.user = user;
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
    public LoanControl(User user) throws ClassNotFoundException, 
            SQLException{
       
       this.user = user;
       //Koppla upp
       
       con = connection.connectToDb(con); 
       selectCopy = con.prepareStatement(COPY_SELECT);
       insertLoan = con.prepareStatement(LOAN_INSERT, Statement.RETURN_GENERATED_KEYS);
       insertLoanItem = con.prepareStatement(LOANITEM_INSERT, Statement.RETURN_GENERATED_KEYS);
    }
    
    public void createLoan() throws SQLException{
        loan = new Loan(user.getId(), loanItems);
        insertLoan.setInt(1, user.getId());
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
        
        title_returndate.add(copy.getTitle() + ", " + loanItem.getLastReturnDate().toString());
    }
    
    public void printReceipt(){
        PrintLoanReceiptGUI gui = new PrintLoanReceiptGUI();
        gui.setThings(title_returndate);
        gui.setStartDate(Date.valueOf(loan.getStartDate()));
        gui.setVisible(true);
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
