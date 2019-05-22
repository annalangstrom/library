/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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

/**
 *
 * @author Rebec
 */
public class SearchGUI extends javax.swing.JFrame {

    private Search controlSearch;
//    private String results;
//    DefaultTableModel mod = new DefaultTableModel();
    private List<Item> itemList;
    private Object[][] data = new Object[10][6];

    /**
     * Creates new form Search
     */

//    public void setControlSearch(controlClasses.Search controlSearch) {
//        this.controlSearch = controlSearch;
//    }

    private void initTable() { //author artist -> en kolumn, + typ av item? 
        String[] columnNames = {"Title", "Author/Artist", "ISBN", "Publisher", "Publish Year", "Genre"};
        DefaultTableModel tblModel = new DefaultTableModel(this.data, columnNames);
        tblSearch.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblSearch.setModel(tblModel);
        tblSearch.setShowGrid(true);
    }

    public void loadTableData() {
        int rows = this.itemList.size();
        //håller data i en 2d array 
        //initierar storleken med rader & kolumner
        this.data = new Object[rows][6];
        //läs in data från ArrayList till data arrayen
        int row = 0;
        for (Item item : this.itemList) {
            data[row][0] = item.getTitle();
            data[row][1] = item.getAuthorArtists();
            data[row][4] = item.getPublishYear();
            data[row][5] = item.getGenres();
            
            Book book = (Book)item;
            data[row][2] = book.getIsbn(); //ISBN?            
            data[row][3] = book.getPublisher();  //Publisher?
            row++;
        }
        this.initTable();

    }

    public SearchGUI() throws SQLException {
        initComponents();
        initTable(); 
        try {
            controlSearch = new Search(this);
            itemList = new ArrayList<>();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            Logger.getLogger(SearchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Item> getItemList() {
        return itemList;
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
        btnSearchSignOut = new javax.swing.JButton();
        btnSearchReserve = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSearch = new javax.swing.JTable();

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

        btnSearchSignOut.setText("Sign out");

        btnSearchReserve.setText("Reserve");

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSearchReserve)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                                .addComponent(btnSearchSignOut))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(txtSearch, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearch)))
                .addGap(0, 63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(labelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchReserve)
                    .addComponent(btnSearchSignOut))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            controlSearch.searchItem(txtSearch.getText());
            controlSearch.loadCopies();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
            Logger.getLogger(SearchGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SearchGUI().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SearchGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchReserve;
    private javax.swing.JButton btnSearchSearch;
    private javax.swing.JButton btnSearchSignOut;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelSearch;
    private javax.swing.JLabel panelReservationConfirm;
    private javax.swing.JPanel panelSearchConfirm;
    private javax.swing.JTable tblSearch;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
