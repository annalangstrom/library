/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Remove - stoppa in aktuell användares borrowerID
//Update - stoppa in akutell användares borrowerID
package GUI;

import controlClasses.BorrowerControl;
import item.Item;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import persons.*;

/**
 *
 * @author Caroline
 */
public class MyPageBorrowerGui extends javax.swing.JFrame {

    private User user;
    private HomePageGui homePage;
   
    
    private ArrayList<String> date;
    private ArrayList<String> title;
    private ArrayList<String> autArt;
    private Object[][] dataRes = new Object[10][3]; //Reservation
    
   /**
    * Creates new form MyPageBorrowerGui
    */
   public MyPageBorrowerGui(User user, HomePageGui homePage) {
      initComponents();
      this.user = user;
      this.homePage = homePage;
   }
   
   private void initTableReservation() {  
        String[] columnNames = {"Title", "Author/Artist", "Date"};
        DefaultTableModel tblModel = new DefaultTableModel(this.dataRes, columnNames);
        tblReservation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblReservation.setModel(tblModel);
        tblReservation.setShowGrid(true);
    }
   
   public void loadTableDataRes() {
        int rows = this.title.size();
        //håller data i en 2d array 
        //initierar storleken med rader & kolumner
        this.dataRes = new Object[rows][6];
        //läs in data från ArrayList till data arrayen
        int row = 0;
        for (int i=0; i<title.size(); i++) {
            
            dataRes[row][0] = title.get(i); //fyller på title           
            dataRes[row][1] = date.get(i);
            dataRes[row][2] = autArt.get(i);
            row++;
        }
        
        this.initTableReservation();

    }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHomePage1 = new javax.swing.JButton();
        list1 = new java.awt.List();
        jButton1 = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnHomePage = new javax.swing.JButton();
        btnUpdatePersonalData = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaMyPersonalData = new javax.swing.JTextArea();
        scrollMyLoans = new javax.swing.JScrollBar();
        scrollMyReservations = new javax.swing.JScrollBar();
        btnEraseMyAcount = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblReservation = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLoan = new javax.swing.JTable();

        btnHomePage1.setText("Home Page");
        btnHomePage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomePage1ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(663, 437));

        btnSignOut.setText("Sign out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("My page");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("My Personal Data");

        btnHomePage.setText("Home Page");
        btnHomePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomePageActionPerformed(evt);
            }
        });

        btnUpdatePersonalData.setText("Update Personal Data");
        btnUpdatePersonalData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePersonalDataActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("My Loans");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("My Reservations");

        txtAreaMyPersonalData.setColumns(20);
        txtAreaMyPersonalData.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        txtAreaMyPersonalData.setRows(11);
        txtAreaMyPersonalData.setTabSize(5);
        txtAreaMyPersonalData.setText("Borrower ID:\t123456 \nCategory:\tStudent \nFirst name:\tKalle \nSurname:\tKarlsson \nSSN:\t\t780123-9718 \nStreet:\t\tStorgatan 1 \nPostcode:\t55500 \nCity:\t\tStorstad \nPhone:\t\t070 67 89 345\n E-mail:\t\tkalle@karlsson.com \nPassword:\t********");
        jScrollPane1.setViewportView(txtAreaMyPersonalData);

        btnEraseMyAcount.setText("Erase my acount");
        btnEraseMyAcount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEraseMyAcountActionPerformed(evt);
            }
        });

        tblReservation.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblReservation);

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
        jScrollPane3.setViewportView(tblLoan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSignOut, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnUpdatePersonalData, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(btnEraseMyAcount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollMyLoans, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollMyReservations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(709, 709, 709))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnHomePage)))
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdatePersonalData)
                        .addGap(18, 18, 18)
                        .addComponent(btnEraseMyAcount)
                        .addGap(40, 40, 40)
                        .addComponent(btnSignOut)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(scrollMyLoans, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scrollMyReservations, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 43, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   private void btnHomePage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePage1ActionPerformed
      // TODO add your handling code here:
      //Vet ej vart denna kommer ifrån??? - Vilken knapp Är btnHompage1?
   }//GEN-LAST:event_btnHomePage1ActionPerformed

   private void btnUpdatePersonalDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePersonalDataActionPerformed
       try {
           ChangeAccountGui gui = new ChangeAccountGui(user.getId());
           gui.setTextInFields(user.getId());
           gui.setVisible(true);
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(MyPageBorrowerGui.class.getName()).log(Level.SEVERE, null, ex);
       }
   }//GEN-LAST:event_btnUpdatePersonalDataActionPerformed

    private void btnEraseMyAcountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEraseMyAcountActionPerformed
       try {
           BorrowerControl control;
           int input = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to erase your account?", 
                   "Are you sure?", JOptionPane.YES_NO_CANCEL_OPTION);
           
           if(input == 0){
               control = new BorrowerControl();
               control.inactivateUser(user.getId());
           }
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(MyPageBorrowerGui.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnEraseMyAcountActionPerformed

   private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
      // TODO add your handling code here:
      homePage.setVisible(true);
      super.dispose();
   }//GEN-LAST:event_btnHomePageActionPerformed

   private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
      // TODO add your handling code here:
      user.setSignedIn(false);
      homePage.setVisible(true);
      super.dispose();
   }//GEN-LAST:event_btnSignOutActionPerformed

   /**
    * @param args the command line arguments
    */
//   public static void main(String args[]) {
//      /* Set the Nimbus look and feel */
//      //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//      /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//       */
//      try {
//         for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//            if ("Nimbus".equals(info.getName())) {
//               javax.swing.UIManager.setLookAndFeel(info.getClassName());
//               break;
//            }
//         }
//      } catch (ClassNotFoundException ex) {
//         java.util.logging.Logger.getLogger(MyPageBorrowerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (InstantiationException ex) {
//         java.util.logging.Logger.getLogger(MyPageBorrowerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (IllegalAccessException ex) {
//         java.util.logging.Logger.getLogger(MyPageBorrowerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//         java.util.logging.Logger.getLogger(MyPageBorrowerGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      }
//      //</editor-fold>
//
//      /* Create and display the form */
//      java.awt.EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            new MyPageBorrowerGui().setVisible(true);
//         }
//      });
//   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEraseMyAcount;
    private javax.swing.JButton btnHomePage;
    private javax.swing.JButton btnHomePage1;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JButton btnUpdatePersonalData;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.awt.List list1;
    private javax.swing.JScrollBar scrollMyLoans;
    private javax.swing.JScrollBar scrollMyReservations;
    private javax.swing.JTable tblLoan;
    private javax.swing.JTable tblReservation;
    private javax.swing.JTextArea txtAreaMyPersonalData;
    // End of variables declaration//GEN-END:variables
}
