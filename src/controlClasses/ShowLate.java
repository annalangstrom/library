/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlClasses;

import GUI.SearchGUI;
import GUI.ShowLateGUI;
import JDBCconnection.JDBCconnection;
import item.Item;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author annalangstrom
 */
public class ShowLate {
    
    String[] info = new String[7];
    List<String[]> infoList = new ArrayList<>();
    
    private final String LATEITEMS_SELECT = "select b.fName, b.sName, b.email, "
            + "b.phoneNo, c.title, c.barcodeNo, li.lastReturnDate from LoanItem "
            + "li JOIN COPY c ON li.barcodeNo = c.barcodeNo JOIN Loan l ON l.loanNo "
            + "= li.loanNo JOIN Borrower b ON b.borrowerID = l.borrowerID "
            + "WHERE lastReturnDate < ?";

    
    private final PreparedStatement selectLateItems;
    
    JDBCconnection connection;
    private Connection con = null;
    private ShowLateGUI sGUI = null;
    ResultSet searchResults = null;
    List<Item> items = new ArrayList<>();

    
    public ShowLate(ShowLateGUI sGUI) throws SQLException, ClassNotFoundException{
        //koppling till SearchGUI
        this();
        this.sGUI = sGUI;
    }

    public ShowLate() throws SQLException, ClassNotFoundException {
        this.connection = new JDBCconnection();
        con = connection.connectToDb(con);
        selectLateItems = con.prepareStatement(LATEITEMS_SELECT);
        
    }
    
    public List<String[]> showLateItems() throws SQLException{
        Date date = Date.valueOf(LocalDate.now());
        selectLateItems.setDate(1, date);
        ResultSet rs = selectLateItems.executeQuery();
        
        while(rs.next()){
            info[0] = rs.getString("fName");
            info[1] = rs.getString("sName");
            info[2] = rs.getString("email");
            info[3] = rs.getString("phoneNo");
            info[4] = rs.getString("title");
            info[5] = rs.getString("barcodeNo");
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
            String strDate = dateFormat.format(rs.getDate("lastReturnDate"));  
            info[6] = strDate;
            infoList.add(info);
        }
        return infoList;
    }
    
    public void loadCopies() throws SQLException, ClassNotFoundException {
        this.sGUI.setItemList(infoList);
        this.sGUI.loadTableData();
        connection.closeDbConnection(); 
    }
    
}
