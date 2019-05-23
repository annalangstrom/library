/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlClasses.ReturnLoanItemControl;


public class ReturnGui extends javax.swing.JFrame {

   private HomePageGui homePage;
   
   
   public ReturnGui(HomePageGui homePage) {
      initComponents();
      this.homePage = homePage;
      
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      labelLoan = new javax.swing.JLabel();
      btnHomePage = new javax.swing.JButton();
      txtEnterBarcode = new javax.swing.JTextField();
      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      btnReturn = new javax.swing.JButton();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

      labelLoan.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
      labelLoan.setText("Return");
      labelLoan.setFocusable(false);

      btnHomePage.setText("Home Page");
      btnHomePage.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnHomePageActionPerformed(evt);
         }
      });

      txtEnterBarcode.setForeground(new java.awt.Color(153, 153, 153));
      txtEnterBarcode.setText("enter barcode...");

      jLabel2.setText("Please enter the barcode on the item you want to return:");

      btnReturn.setText("Return");
      btnReturn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnReturnActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(btnHomePage)
                  .addGap(105, 105, 105)
                  .addComponent(labelLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(123, 123, 123)
                  .addComponent(jLabel1))
               .addGroup(layout.createSequentialGroup()
                  .addGap(102, 102, 102)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                     .addComponent(txtEnterBarcode)))
               .addGroup(layout.createSequentialGroup()
                  .addGap(222, 222, 222)
                  .addComponent(btnReturn)))
            .addContainerGap(109, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(22, 22, 22)
                  .addComponent(labelLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(btnHomePage)))
            .addGap(72, 72, 72)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtEnterBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnReturn)
            .addContainerGap(111, Short.MAX_VALUE))
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
      homePage.setVisible(true);
      super.dispose();
   }//GEN-LAST:event_btnHomePageActionPerformed

   private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
      ReturnLoanItemControl returnLoanItem = new ReturnLoanItemControl();
      int inputBarcode = Integer.parseInt(txtEnterBarcode.getText());
      returnLoanItem.cancelLoanItem(inputBarcode);
   }//GEN-LAST:event_btnReturnActionPerformed

//   /**
//    * @param args the command line arguments
//    */
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
//         java.util.logging.Logger.getLogger(ReturnGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (InstantiationException ex) {
//         java.util.logging.Logger.getLogger(ReturnGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (IllegalAccessException ex) {
//         java.util.logging.Logger.getLogger(ReturnGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//         java.util.logging.Logger.getLogger(ReturnGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//      }
//      //</editor-fold>
//
//      /* Create and display the form */
//      java.awt.EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            new ReturnGui().setVisible(true);
//         }
//      });
//   }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnHomePage;
   private javax.swing.JButton btnReturn;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel labelLoan;
   private javax.swing.JTextField txtEnterBarcode;
   // End of variables declaration//GEN-END:variables
}
