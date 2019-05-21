/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlClasses.LoanControl;
import item.Copy;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rebec
 */
public class LoanGUI extends javax.swing.JFrame {

    private Object[][] data = new Object[10][4]; 
    private List<Copy> copies = new ArrayList<>();
    LoanControl control;
    
    /**
     * Creates new form Loan
     */
    public LoanGUI() {
        super("Loan item");
        initComponents();
        initTable();
        try {
            control = new LoanControl();
            control.createLoan();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoanGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void initTable(){ 
        String[] columnNames = {"Barcode","Title"};
        DefaultTableModel tblModel = new DefaultTableModel(this.data, columnNames);
        tblLoan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblLoan.setModel(tblModel);
        tblLoan.setShowGrid(true);
    }
    
    public void loadTableData(){
        int rows = this.copies.size();
        //håller data i en 2d array 
        //initierar storleken med rader & kolumner
        this.data = new Object[rows][2];
        //läs in data från ArrayList till data arrayen
        int row=0; 
        for (Copy copy : this.copies){
            data[row][0] = copy.getBarcodeNo();
            data[row][1] = copy.getTitle();
            row++;
        }
        this.initTable();

    }
    
    public void setCopyList(List<Copy> copyList) {
        this.copies = copyList;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      panelLoanConfirm = new javax.swing.JPanel();
      labelLoanConfirm = new javax.swing.JLabel();
      btnLoanConfMyPage = new javax.swing.JButton();
      btnLoanConfSearch = new javax.swing.JButton();
      btnLoanHomePage = new javax.swing.JButton();
      labelLoan = new javax.swing.JLabel();
      btnLoanLoan = new javax.swing.JButton();
      btnLoanSignOut = new javax.swing.JButton();
      btnAdd = new javax.swing.JButton();
      btnRemove = new javax.swing.JButton();
      jScrollPane2 = new javax.swing.JScrollPane();
      tblLoan = new javax.swing.JTable();
      txtAdd = new javax.swing.JTextField();

      labelLoanConfirm.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
      labelLoanConfirm.setText("<html>\n<body>\n<p>\n<center>The loan was successful!</center>\n<br><center>You can see an overview of your borrowed items under \"My Page\".</center>\n</p>\n</body>");

      btnLoanConfMyPage.setText("Go to My Page");

      btnLoanConfSearch.setText("Go to Search");

      javax.swing.GroupLayout panelLoanConfirmLayout = new javax.swing.GroupLayout(panelLoanConfirm);
      panelLoanConfirm.setLayout(panelLoanConfirmLayout);
      panelLoanConfirmLayout.setHorizontalGroup(
         panelLoanConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelLoanConfirmLayout.createSequentialGroup()
            .addGap(61, 61, 61)
            .addGroup(panelLoanConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(panelLoanConfirmLayout.createSequentialGroup()
                  .addComponent(btnLoanConfMyPage)
                  .addGap(494, 494, 494)
                  .addComponent(btnLoanConfSearch))
               .addComponent(labelLoanConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(36, Short.MAX_VALUE))
      );
      panelLoanConfirmLayout.setVerticalGroup(
         panelLoanConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelLoanConfirmLayout.createSequentialGroup()
            .addContainerGap(56, Short.MAX_VALUE)
            .addComponent(labelLoanConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35)
            .addGroup(panelLoanConfirmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnLoanConfMyPage)
               .addComponent(btnLoanConfSearch))
            .addGap(44, 44, 44))
      );

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      btnLoanHomePage.setText("Home Page");
      btnLoanHomePage.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLoanHomePageActionPerformed(evt);
         }
      });

      labelLoan.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
      labelLoan.setText("Loan");
      labelLoan.setFocusable(false);

      btnLoanLoan.setText("Loan");
      btnLoanLoan.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLoanLoanActionPerformed(evt);
         }
      });

      btnLoanSignOut.setText("Sign out");
      btnLoanSignOut.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLoanSignOutActionPerformed(evt);
         }
      });

      btnAdd.setText("Add item");
      btnAdd.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddActionPerformed(evt);
         }
      });

      btnRemove.setText("Remove item");
      btnRemove.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRemoveActionPerformed(evt);
         }
      });

      tblLoan.setModel(new javax.swing.table.DefaultTableModel(
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
      jScrollPane2.setViewportView(tblLoan);

      txtAdd.setForeground(new java.awt.Color(204, 204, 204));
      txtAdd.setText("Write your barcode number here");
      txtAdd.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            txtAddFocusGained(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLoanHomePage)
                        .addGap(178, 178, 178)
                        .addComponent(labelLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addGroup(layout.createSequentialGroup()
                              .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                              .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                           .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                           .addComponent(txtAdd))))
                  .addGap(0, 187, Short.MAX_VALUE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addComponent(btnLoanLoan)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnLoanSignOut)))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(btnLoanHomePage))
               .addGroup(layout.createSequentialGroup()
                  .addGap(14, 14, 14)
                  .addComponent(labelLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
            .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnAdd)
               .addComponent(btnRemove))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(19, 19, 19)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnLoanSignOut)
               .addComponent(btnLoanLoan))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

    private void btnLoanHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanHomePageActionPerformed
        super.dispose();
    }//GEN-LAST:event_btnLoanHomePageActionPerformed

    private void btnLoanSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanSignOutActionPerformed
        super.dispose();
    }//GEN-LAST:event_btnLoanSignOutActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int index = tblLoan.getSelectedRow();
        copies.remove(index);
        loadTableData();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        try {
            Copy copy = control.getCopyFromDB(Integer.parseInt(txtAdd.getText()));
            if (copy.getLoanCategory() == 4 || copy.getLoanCategory() == 5){ //reference litterature or magazine
                JOptionPane.showMessageDialog(rootPane, "This item cannot be borrowed.");
                return;
            }
            copies.add(copy);
            loadTableData();
            control.createLoanItem(copy);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
            Logger.getLogger(LoanGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtAddFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAddFocusGained
        txtAdd.setText("");
        txtAdd.setForeground(Color.black);
    }//GEN-LAST:event_txtAddFocusGained

    private void btnLoanLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanLoanActionPerformed
        
            control.printReceipt();
        
    }//GEN-LAST:event_btnLoanLoanActionPerformed

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
            java.util.logging.Logger.getLogger(LoanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoanGUI().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAdd;
   private javax.swing.JButton btnLoanConfMyPage;
   private javax.swing.JButton btnLoanConfSearch;
   private javax.swing.JButton btnLoanHomePage;
   private javax.swing.JButton btnLoanLoan;
   private javax.swing.JButton btnLoanSignOut;
   private javax.swing.JButton btnRemove;
   private javax.swing.JScrollPane jScrollPane2;
   private javax.swing.JLabel labelLoan;
   private javax.swing.JLabel labelLoanConfirm;
   private javax.swing.JPanel panelLoanConfirm;
   private javax.swing.JTable tblLoan;
   private javax.swing.JTextField txtAdd;
   // End of variables declaration//GEN-END:variables
}
