/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author annalangstrom
 */
public class HomePageGui extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePageGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jLabelTheLibrary = new javax.swing.JLabel();
      btnSearch = new javax.swing.JButton();
      btnLoanItem = new javax.swing.JButton();
      btnReturnItem = new javax.swing.JButton();
      panelSignedIn = new javax.swing.JPanel();
      btnSignIn = new javax.swing.JButton();
      btnCreateAccount = new javax.swing.JButton();
      panelNotSignedIn = new javax.swing.JPanel();
      btnToMyAccount = new javax.swing.JButton();
      btnSignOut = new javax.swing.JButton();
      txtSearch = new javax.swing.JTextField();

      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      getContentPane().setLayout(null);

      jLabelTheLibrary.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
      jLabelTheLibrary.setText("The Library");
      getContentPane().add(jLabelTheLibrary);
      jLabelTheLibrary.setBounds(226, 68, 178, 47);

      btnSearch.setText("SEARCH");
      btnSearch.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSearchActionPerformed(evt);
         }
      });
      getContentPane().add(btnSearch);
      btnSearch.setBounds(430, 160, 79, 51);

      btnLoanItem.setText("Loan item");
      btnLoanItem.setActionCommand("");
      btnLoanItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnLoanItemActionPerformed(evt);
         }
      });
      getContentPane().add(btnLoanItem);
      btnLoanItem.setBounds(170, 240, 120, 25);

      btnReturnItem.setText("Return item");
      btnReturnItem.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnReturnItemActionPerformed(evt);
         }
      });
      getContentPane().add(btnReturnItem);
      btnReturnItem.setBounds(310, 240, 120, 25);

      btnSignIn.setText("Sign in");
      btnSignIn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSignInActionPerformed(evt);
         }
      });

      btnCreateAccount.setText("Create account");
      btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCreateAccountActionPerformed(evt);
         }
      });

      javax.swing.GroupLayout panelSignedInLayout = new javax.swing.GroupLayout(panelSignedIn);
      panelSignedIn.setLayout(panelSignedInLayout);
      panelSignedInLayout.setHorizontalGroup(
         panelSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelSignedInLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(btnCreateAccount))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      panelSignedInLayout.setVerticalGroup(
         panelSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelSignedInLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnSignIn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCreateAccount)
            .addContainerGap(20, Short.MAX_VALUE))
      );

      getContentPane().add(panelSignedIn);
      panelSignedIn.setBounds(300, 310, 140, 90);

      btnToMyAccount.setText("To my account");

      btnSignOut.setText("Sign out");

      javax.swing.GroupLayout panelNotSignedInLayout = new javax.swing.GroupLayout(panelNotSignedIn);
      panelNotSignedIn.setLayout(panelNotSignedInLayout);
      panelNotSignedInLayout.setHorizontalGroup(
         panelNotSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelNotSignedInLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(panelNotSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNotSignedInLayout.createSequentialGroup()
                  .addGap(0, 0, Short.MAX_VALUE)
                  .addComponent(btnToMyAccount))
               .addComponent(btnSignOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
      );
      panelNotSignedInLayout.setVerticalGroup(
         panelNotSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(panelNotSignedInLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(btnToMyAccount)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnSignOut)
            .addContainerGap(20, Short.MAX_VALUE))
      );

      getContentPane().add(panelNotSignedIn);
      panelNotSignedIn.setBounds(160, 310, 140, 90);

      txtSearch.setForeground(new java.awt.Color(102, 102, 102));
      txtSearch.setText("Search items...");
      getContentPane().add(txtSearch);
      txtSearch.setBounds(120, 160, 300, 51);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void btnLoanItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanItemActionPerformed
      /*  Ändra till rätt namn på sida +
      IF låntagare inloggad - gå till lånsidan
      ELSE gå till inloggningssidan*/
      String[] args = null;
//      Loan.main(args);
      //Loan.main(args);
   }//GEN-LAST:event_btnLoanItemActionPerformed

   private void btnReturnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnItemActionPerformed
      /*  Ändra till rätt namn på sida +
      IF låntagare inloggad - gå till återlämningssidan
      ELSE gå till inloggningssidan*/
      String[] args = null;
//      Return.main(args);
      //Return.main(args);
   }//GEN-LAST:event_btnReturnItemActionPerformed

   private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
      /*Ta text från textrutan
      Stoppa in i sökmetod
      Dirigera om till Söksidan*/
      String[] args = null;
//      Search.main(args);
      //Search.main(args);
   }//GEN-LAST:event_btnSearchActionPerformed

   private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
      // TODO add your handling code here:
      SignIn signIn = new SignIn();
      signIn.setVisible(true);
   }//GEN-LAST:event_btnSignInActionPerformed

   private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
      // TODO add your handling code here:
      CreateAccount createAccount = new CreateAccount();
      createAccount.setVisible(true);
   }//GEN-LAST:event_btnCreateAccountActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(HomePageGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HomePageGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HomePageGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HomePageGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HomePageGui().setVisible(true);
//            }
//        });
//    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnCreateAccount;
   private javax.swing.JButton btnLoanItem;
   private javax.swing.JButton btnReturnItem;
   private javax.swing.JButton btnSearch;
   private javax.swing.JButton btnSignIn;
   private javax.swing.JButton btnSignOut;
   private javax.swing.JButton btnToMyAccount;
   private javax.swing.JLabel jLabelTheLibrary;
   private javax.swing.JPanel panelNotSignedIn;
   private javax.swing.JPanel panelSignedIn;
   private javax.swing.JTextField txtSearch;
   // End of variables declaration//GEN-END:variables
}
