/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlClasses.ReservationControl;
import controlClasses.Search;
import item.Book;
import item.Item;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import loan.Reservation;
import persons.*;

/**
 *
 * @author Rebec
 */
public class SearchGUI extends javax.swing.JFrame {

    private List<Item> itemList;
    private Object[][] data = new Object[10][6];
    private final User user;
    private final HomePageGui homePage;

    /**
     * Creates new form Search
     */

    private void initTable() { 
        String[] columnNames = {"Title", "Author/Artist", "ISBN", "Publisher", "Publish Year", "Genre"};
        DefaultTableModel tblModel = new DefaultTableModel(this.data, columnNames);
        tblSearch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblSearch.setModel(tblModel);
        tblSearch.setShowGrid(true);
    }

    public void loadTableData() {
        int rows = this.itemList.size();
        this.data = new Object[rows][6];
        int row = 0;
        for (Item item : this.itemList) {
            data[row][0] = item.getTitle();
            data[row][1] = item.getAuthorArtists();
            data[row][4] = item.getPublishYear();
            data[row][5] = item.getGenres();
            
            Book book = (Book)item;
            data[row][2] = book.getIsbn();          
            data[row][3] = book.getPublisher();
            row++;
        }
        this.initTable();

    }

    public SearchGUI(User user, HomePageGui homePage) throws SQLException {
        initComponents();
        initTable();
        this.user = user;
        this.homePage = homePage;
        itemList = new ArrayList<>();
        
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      panelSearchConfirm = new javax.swing.JPanel();
      btnSearchSearch = new javax.swing.JButton();
      panelReservationConfirm = new javax.swing.JLabel();
      labelSearch = new javax.swing.JLabel();
      txtSearch = new javax.swing.JTextField();
      btnSearch = new javax.swing.JButton();
      btnSearchReserve = new javax.swing.JButton();
      jScrollPane2 = new javax.swing.JScrollPane();
      tblSearch = new javax.swing.JTable();
      btnHomePage = new javax.swing.JButton();

      btnSearchSearch.setText("Go to Search");

      panelReservationConfirm.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      panelReservationConfirm.setText("<html>\n<body>\n<p>\n<center>The reservation successful!</center>\n<br><center>You can see an overview of your reservations under \"My Page\".</center>\n</p>\n</body>");

      javax.swing.GroupLayout panelSearchConfirmLayout = new javax.swing.GroupLayout(panelSearchConfirm);
      panelSearchConfirm.setLayout(panelSearchConfirmLayout);
      panelSearchConfirmLayout.setHorizontalGroup(
         panelSearchConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelSearchConfirmLayout.createSequentialGroup()
            .addGap(68, 68, 68)
            .addComponent(panelReservationConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(82, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSearchConfirmLayout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSearchSearch)
            .addGap(343, 343, 343))
      );
      panelSearchConfirmLayout.setVerticalGroup(
         panelSearchConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelSearchConfirmLayout.createSequentialGroup()
            .addContainerGap(75, Short.MAX_VALUE)
            .addComponent(panelReservationConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30, 30, 30)
            .addComponent(btnSearchSearch)
            .addGap(30, 30, 30))
      );

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      labelSearch.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
      labelSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
      labelSearch.setText("Search");

      btnSearch.setText("Search");
      btnSearch.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchActionPerformed(evt);
         }
      });

      btnSearchReserve.setText("Reserve");
      btnSearchReserve.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchReserveActionPerformed(evt);
         }
      });

      tblSearch.setModel(new javax.swing.table.DefaultTableModel(
         new Object [][] {
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null},
            {null, null, null, null}
         },
         new String [] {
            "Title 1", "Title 2", "Title 3", "Title 4"
         }
      ));
      jScrollPane2.setViewportView(tblSearch);

      btnHomePage.setText("Home Page");
      btnHomePage.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnHomePageActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(294, 294, 294)
                  .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(142, 142, 142)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(btnSearchReserve)
                     .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                     .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
                  .addGap(18, 18, 18)
                  .addComponent(btnSearch)))
            .addGap(0, 63, Short.MAX_VALUE))
         .addGroup(layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnHomePage)
            .addGap(21, 21, 21)
            .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnSearch)
               .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnSearchReserve)
            .addContainerGap(19, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            Search control = new Search(this);
            control.searchItem(txtSearch.getText());
            control.loadCopies();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            Logger.getLogger(SearchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearchReserveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchReserveActionPerformed
        if((user instanceof Borrower) && (user.getSignedIn() == true)) {  
            try {
                ReservationControl control = new ReservationControl();
                Reservation reservation = new Reservation(user.getId(),
                        itemList.get(tblSearch.getSelectedRow()).getItemNo());
            
                control.createNewReservation(reservation.getBorrower(), 
                        reservation.getItem(), reservation.getDate());
                panelSearchConfirm.setVisible(true);
                JOptionPane.showMessageDialog(rootPane, "Reservation created!");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(SearchGUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "You have to be signed in as a borrower to reserve an item.");
        }
    }//GEN-LAST:event_btnSearchReserveActionPerformed

   private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
      homePage.setVisible(true);
      super.dispose();
   }//GEN-LAST:event_btnHomePageActionPerformed

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnHomePage;
   private javax.swing.JButton btnSearch;
   private javax.swing.JButton btnSearchReserve;
   private javax.swing.JButton btnSearchSearch;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JLabel labelSearch;
   private javax.swing.JLabel panelReservationConfirm;
   private javax.swing.JPanel panelSearchConfirm;
   private javax.swing.JTable tblSearch;
   private javax.swing.JTextField txtSearch;
   // End of variables declaration//GEN-END:variables
}
