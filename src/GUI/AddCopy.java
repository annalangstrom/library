/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlClasses.CreateCopiesControl;
import item.Copy;
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
 * @author annalangstrom
 */
public class AddCopy extends javax.swing.JFrame {

    List <Copy> copyList = new ArrayList<>();
    private Object[][] data = new Object[10][4]; 
    DefaultTableModel tblModel;
    CreateCopiesControl control;
    /**
     * Creates new form AddCopy
     */
    public AddCopy() {
        initComponents();
        initTable();
    }
    
    private void initTable(){
        //Relaterar data till JTable(tblMessages) som visar innehållet 
        String[] columnNames = {"Barcode","Condition", "Category", "Loan status"};
        tblModel = new DefaultTableModel(this.data, columnNames);
        tblCopies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblCopies.setModel(tblModel);
//        tblCopies.getColumnModel().getColumn(0).setPreferredWidth(5);
//        tblCopies.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblCopies.setShowGrid(true);
    }
    
    public void loadTableData(){
        int rows = this.copyList.size();
        //håller data i en 2d array 
        //initierar storleken med rader & kolumner
        this.data = new Object[rows][4];
        //läs in data från ArrayList till data arrayen
        int row=0; 
        for (Copy copy : this.copyList){
            data[row][0] = copy.getBarcodeNo();
            data[row][1] = copy.getCondition();
            data[row][2] = copy.getCategory();
            data[row][3] = copy.getStatus();
            row++;
        }
        this.initTable();

    }
    
    public void setCopyList(List<Copy> copyList) {
        this.copyList = copyList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabel1 = new javax.swing.JLabel();
      txtBarcode = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      txtCondition = new javax.swing.JTextField();
      jLabel3 = new javax.swing.JLabel();
      cmbCategory = new javax.swing.JComboBox<>();
      jLabel4 = new javax.swing.JLabel();
      cmbLoanStatus = new javax.swing.JComboBox<>();
      jScrollPane1 = new javax.swing.JScrollPane();
      tblCopies = new javax.swing.JTable();
      btnAdd = new javax.swing.JButton();
      btnRemove = new javax.swing.JButton();
      btnCancel = new javax.swing.JButton();
      btnSave = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      jLabel1.setText("Barcode:");

      jLabel2.setText("Condition:");

      jLabel3.setText("Category:");

      cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Movie", "Course litterature", "Other litterature", "Reference litterature" }));

      jLabel4.setText("Loan status:");

      cmbLoanStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "On shelf", "Borrowed", "Missing" }));

      tblCopies.setModel(new javax.swing.table.DefaultTableModel(
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
      jScrollPane1.setViewportView(tblCopies);

      btnAdd.setText("Add");
      btnAdd.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddActionPerformed(evt);
         }
      });

      btnRemove.setText("Remove");
      btnRemove.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnRemoveActionPerformed(evt);
         }
      });

      btnCancel.setText("Cancel");
      btnCancel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelActionPerformed(evt);
         }
      });

      btnSave.setText("Save");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
               .addGroup(layout.createSequentialGroup()
                  .addGap(14, 14, 14)
                  .addComponent(jLabel1))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                     .addComponent(txtBarcode)))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addComponent(txtCondition)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                           .addComponent(jLabel3)
                           .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                           .addComponent(jLabel4)
                           .addComponent(cmbLoanStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(29, 29, 29))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btnSave)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCancel))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGap(17, 17, 17)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(jLabel1)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jLabel2)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(txtCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jLabel3)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jLabel4)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(cmbLoanStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(btnAdd)
                     .addComponent(btnRemove))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnCancel)
               .addComponent(btnSave)))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JFrame frame = new JFrame();
        try {
            //Hur ska jag lyckas få tag i itemNo??????
            
            control = new CreateCopiesControl(this);
            control.addCopy(Integer.parseInt(txtBarcode.getText()), 1, cmbCategory.getSelectedIndex(), 
                    cmbLoanStatus.getSelectedItem().toString(), txtCondition.getText());
            //int barcode, int itemNo, int category, int loanStatus, String condition
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(this, "Something went wrong, "+ ex.getMessage());
            Logger.getLogger(AddCopy.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(frame, "Copy added!");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(AddCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCopy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCopy().setVisible(true);
            }
        });
    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnAdd;
   private javax.swing.JButton btnCancel;
   private javax.swing.JButton btnRemove;
   private javax.swing.JButton btnSave;
   private javax.swing.JComboBox<String> cmbCategory;
   private javax.swing.JComboBox<String> cmbLoanStatus;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JScrollPane jScrollPane1;
   private javax.swing.JTable tblCopies;
   private javax.swing.JTextField txtBarcode;
   private javax.swing.JTextField txtCondition;
   // End of variables declaration//GEN-END:variables
}
