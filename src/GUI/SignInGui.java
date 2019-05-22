/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlClasses.SignInControl;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author annalangstrom
 */
public class SignInGui extends javax.swing.JFrame {
   
   private HomePageGui homePage;

    /**
     * Creates new form SignIn
     */
    public SignInGui(HomePageGui homePage) {
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

      jLabel1 = new javax.swing.JLabel();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      txtUserAccount = new javax.swing.JTextField();
      jLabel4 = new javax.swing.JLabel();
      btnSignIn = new javax.swing.JButton();
      lblNoAccount = new javax.swing.JLabel();
      btnCreateAccount = new javax.swing.JButton();
      btnHomePage = new javax.swing.JButton();
      btnCancel = new javax.swing.JButton();
      txtPassword = new javax.swing.JPasswordField();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
      jLabel1.setText("Sign in");

      jLabel2.setText("Please fill in your SSN or staff number, and password.");

      jLabel3.setText("User SSN/staff number:");

      jLabel4.setText("Password:");

      btnSignIn.setText("Sign in");
      btnSignIn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSignInActionPerformed(evt);
         }
      });

      lblNoAccount.setText("Haven't you got an account?");

      btnCreateAccount.setText("Create account");
      btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCreateAccountActionPerformed(evt);
         }
      });

      btnHomePage.setText("Home Page");
      btnHomePage.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnHomePageActionPerformed(evt);
         }
      });

      btnCancel.setText("Cancel");
      btnCancel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelActionPerformed(evt);
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
                  .addGap(144, 144, 144)
                  .addComponent(jLabel1))
               .addGroup(layout.createSequentialGroup()
                  .addGap(222, 222, 222)
                  .addComponent(jLabel3))
               .addGroup(layout.createSequentialGroup()
                  .addGap(263, 263, 263)
                  .addComponent(jLabel4))
               .addGroup(layout.createSequentialGroup()
                  .addGap(138, 138, 138)
                  .addComponent(jLabel2))
               .addGroup(layout.createSequentialGroup()
                  .addGap(257, 257, 257)
                  .addComponent(btnSignIn))
               .addGroup(layout.createSequentialGroup()
                  .addGap(199, 199, 199)
                  .addComponent(lblNoAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(153, Short.MAX_VALUE))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addComponent(txtUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(229, 229, 229))
               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                  .addComponent(btnCreateAccount)
                  .addGap(181, 181, 181)
                  .addComponent(btnCancel)
                  .addContainerGap())))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(btnHomePage))
               .addGroup(layout.createSequentialGroup()
                  .addGap(28, 28, 28)
                  .addComponent(jLabel1)))
            .addGap(33, 33, 33)
            .addComponent(jLabel2)
            .addGap(18, 18, 18)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(txtUserAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(btnSignIn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
            .addComponent(lblNoAccount)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btnCreateAccount)
            .addGap(14, 14, 14))
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(btnCancel)
            .addContainerGap())
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        CreateAccountGui gui = new CreateAccountGui(homePage);
        gui.setVisible(true);
        super.dispose();
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_btnHomePageActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        try {
            // TODO add your handling code here:
            SignInControl control = new SignInControl(homePage);
            control.signIn(txtUserAccount.getText(), txtPassword.getText());
            super.dispose();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignInGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSignInActionPerformed

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
//            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SignIn().setVisible(true);
//            }
//        });
//    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnCancel;
   private javax.swing.JButton btnCreateAccount;
   private javax.swing.JButton btnHomePage;
   private javax.swing.JButton btnSignIn;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel lblNoAccount;
   private javax.swing.JPasswordField txtPassword;
   private javax.swing.JTextField txtUserAccount;
   // End of variables declaration//GEN-END:variables
}
