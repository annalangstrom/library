/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JOptionPane;
import controlClasses.Search;
import java.sql.SQLException;
import java.util.Observer;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import persons.*;

/**
 *
 * @author annalangstrom
 */
public class HomePageGui extends javax.swing.JFrame implements Observer  {

   private User user;
   
   
    public HomePageGui() {
        initComponents();
        panelSignedIn.setVisible(false);

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
        panelNotSignedIn = new javax.swing.JPanel();
        btnSignIn = new javax.swing.JButton();
        btnCreateAccount = new javax.swing.JButton();
        panelSignedIn = new javax.swing.JPanel();
        btnToMyAccount = new javax.swing.JButton();
        btnSignOut = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(630, 440));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(null);

        jLabelTheLibrary.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabelTheLibrary.setText("The Library");
        getContentPane().add(jLabelTheLibrary);
        jLabelTheLibrary.setBounds(226, 68, 197, 43);

        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(430, 160, 100, 51);

        btnLoanItem.setText("Loan item");
        btnLoanItem.setActionCommand("");
        btnLoanItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoanItemActionPerformed(evt);
            }
        });
        getContentPane().add(btnLoanItem);
        btnLoanItem.setBounds(170, 240, 120, 29);

        btnReturnItem.setText("Return item");
        btnReturnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnItemActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturnItem);
        btnReturnItem.setBounds(310, 240, 120, 29);

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

        javax.swing.GroupLayout panelNotSignedInLayout = new javax.swing.GroupLayout(panelNotSignedIn);
        panelNotSignedIn.setLayout(panelNotSignedInLayout);
        panelNotSignedInLayout.setHorizontalGroup(
            panelNotSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotSignedInLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNotSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateAccount))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelNotSignedInLayout.setVerticalGroup(
            panelNotSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotSignedInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSignIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreateAccount)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(panelNotSignedIn);
        panelNotSignedIn.setBounds(300, 310, 140, 90);

        btnToMyAccount.setText("To my account");
        btnToMyAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToMyAccountActionPerformed(evt);
            }
        });

        btnSignOut.setText("Sign out");
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSignedInLayout = new javax.swing.GroupLayout(panelSignedIn);
        panelSignedIn.setLayout(panelSignedInLayout);
        panelSignedInLayout.setHorizontalGroup(
            panelSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSignedInLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSignedInLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnToMyAccount))
                    .addComponent(btnSignOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSignedInLayout.setVerticalGroup(
            panelSignedInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSignedInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnToMyAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSignOut)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(panelSignedIn);
        panelSignedIn.setBounds(160, 310, 140, 90);

        txtSearch.setForeground(new java.awt.Color(102, 102, 102));
        txtSearch.setText("Search items...");
        getContentPane().add(txtSearch);
        txtSearch.setBounds(120, 160, 300, 51);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

   private void btnLoanItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanItemActionPerformed
      
      if((user instanceof Borrower) && (user.getSignedIn() == true)) {
         LoanGUI loan = new LoanGUI(user, this);
         loan.setVisible(true);
         this.setVisible(false);
      } else {
         JOptionPane.showMessageDialog(this, "You have to be signed in as a borrower to loan an item.");
      }
   }//GEN-LAST:event_btnLoanItemActionPerformed

   private void btnReturnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnItemActionPerformed
      ReturnGui returnItem = new ReturnGui();
      returnItem.setVisible(true);
   }//GEN-LAST:event_btnReturnItemActionPerformed

   private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            //Dirigera om till Söksidan:
            SearchGUI search = new SearchGUI();
            search.setVisible(true);
            //Ta text från textrutan & Stoppa in i sökmetod
            Search input = new Search();
            input.searchItem(txtSearch.getText());
            input.loadCopies();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(HomePageGui.class.getName()).log(Level.SEVERE, null, ex);
        }
   }//GEN-LAST:event_btnSearchActionPerformed

   private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
      // TODO add your handling code here:
      SignInGui signIn = new SignInGui(this);
      signIn.setVisible(true);
   }//GEN-LAST:event_btnSignInActionPerformed

   private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
      // TODO add your handling code here:
      CreateAccountGui createAccount = new CreateAccountGui(this);
      createAccount.setVisible(true);
      this.setVisible(false);
   }//GEN-LAST:event_btnCreateAccountActionPerformed

   private void btnToMyAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToMyAccountActionPerformed
      // TODO add your handling code here:
      if(user instanceof Staff) {
         MyPageStaffGui MyPage = new MyPageStaffGui(user, this);
         MyPage.setVisible(true);
         this.setVisible(false);
      } else {
         MyPageBorrowerGui MyPage = new MyPageBorrowerGui(user, this);
         MyPage.setVisible(true);
         this.setVisible(false);
      }
      
   }//GEN-LAST:event_btnToMyAccountActionPerformed

   private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed
      // TODO add your handling code here:
      user.setSignedIn(false);
   }//GEN-LAST:event_btnSignOutActionPerformed

   //metod som anropas varje gång attributet signedIn ändras hos user
   @Override
   public void update(Observable obj, Object arg) {
      if(arg instanceof Boolean) {
         boolean signedIn = (Boolean) arg;
         if(signedIn == true){
         panelSignedIn.setVisible(true);
         panelNotSignedIn.setVisible(false);
         } else {
         panelSignedIn.setVisible(false);
         panelNotSignedIn.setVisible(true);
         }
      }
   }
   
   public void setUser(User user){
      this.user = user;
   }
   
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
