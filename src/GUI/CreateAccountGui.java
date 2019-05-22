/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlClasses.CreateAccountControl;
import controlClasses.SignInControl;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author annalangstrom
 */
public class CreateAccountGui extends javax.swing.JFrame {
   
   private HomePageGui homePage;

    /**
     * Creates new form CreateAccount
     */
    public CreateAccountGui(HomePageGui homePage) {
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
      btnHomePage = new javax.swing.JButton();
      txtSsn = new javax.swing.JTextField();
      jLabel2 = new javax.swing.JLabel();
      jLabel3 = new javax.swing.JLabel();
      jLabel4 = new javax.swing.JLabel();
      txtFirstName = new javax.swing.JTextField();
      jLabel5 = new javax.swing.JLabel();
      txtLastName = new javax.swing.JTextField();
      jLabel6 = new javax.swing.JLabel();
      cmbCategory = new javax.swing.JComboBox<>();
      txtEmail = new javax.swing.JLabel();
      jLabel7 = new javax.swing.JLabel();
      txtMail = new javax.swing.JTextField();
      jLabel8 = new javax.swing.JLabel();
      txtPhoneNumber = new javax.swing.JTextField();
      btnCreateAccount = new javax.swing.JButton();
      btnCancel = new javax.swing.JButton();
      jLabel9 = new javax.swing.JLabel();
      txtStreet = new javax.swing.JTextField();
      jLabel10 = new javax.swing.JLabel();
      txtPostcode = new javax.swing.JTextField();
      jLabel11 = new javax.swing.JLabel();
      txtCity = new javax.swing.JTextField();
      jLabel12 = new javax.swing.JLabel();
      btnSignIn = new javax.swing.JButton();
      txtPassword = new javax.swing.JPasswordField();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

      jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
      jLabel1.setText("Create account");

      btnHomePage.setText("Home Page");
      btnHomePage.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnHomePageActionPerformed(evt);
         }
      });

      txtSsn.setForeground(new java.awt.Color(204, 204, 204));
      txtSsn.setText("YYMMDDXXXX");
      txtSsn.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            txtSsnFocusGained(evt);
         }
      });
      txtSsn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            txtSsnActionPerformed(evt);
         }
      });

      jLabel2.setText("Social security number:");

      jLabel3.setText("Password:");

      jLabel4.setText("First name:");

      jLabel5.setText("Last name:");

      jLabel6.setText("Category:");

      cmbCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Public", "Student", "Teacher", "Reasercher" }));

      jLabel7.setText("Email:");

      txtMail.setForeground(new java.awt.Color(204, 204, 204));
      txtMail.setText("example@gmail.com");
      txtMail.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            txtMailFocusGained(evt);
         }
      });

      jLabel8.setText("Phone number:");

      btnCreateAccount.setText("Create account");
      btnCreateAccount.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCreateAccountActionPerformed(evt);
         }
      });

      btnCancel.setText("Cancel");
      btnCancel.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnCancelActionPerformed(evt);
         }
      });

      jLabel9.setText("Street:");

      jLabel10.setText("Postcode:");

      jLabel11.setText("City:");

      jLabel12.setText("Have you got an account?");

      btnSignIn.setText("Sign in");
      btnSignIn.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnSignInActionPerformed(evt);
         }
      });

      txtPassword.setForeground(new java.awt.Color(204, 204, 204));
      txtPassword.setText("123456");
      txtPassword.addFocusListener(new java.awt.event.FocusAdapter() {
         public void focusGained(java.awt.event.FocusEvent evt) {
            txtPasswordFocusGained(evt);
         }
      });

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addComponent(btnSignIn)
               .addGroup(layout.createSequentialGroup()
                  .addGap(54, 54, 54)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6))
                     .addComponent(txtSsn)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                     .addComponent(txtFirstName)
                     .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           .addComponent(jLabel3)
                           .addComponent(jLabel4)
                           .addComponent(jLabel5)))
                     .addComponent(txtLastName)
                     .addComponent(cmbCategory, 0, 163, Short.MAX_VALUE)
                     .addComponent(txtPassword))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(66, 66, 66)
                  .addComponent(txtEmail)
                  .addGap(18, 18, 18)
                  .addComponent(jLabel7)
                  .addGap(0, 0, Short.MAX_VALUE))
               .addGroup(layout.createSequentialGroup()
                  .addGap(80, 80, 80)
                  .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMail)
                        .addComponent(txtPhoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addComponent(txtStreet)
                        .addComponent(txtPostcode)
                        .addGroup(layout.createSequentialGroup()
                           .addGap(6, 6, 6)
                           .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                              .addComponent(jLabel8)
                              .addComponent(jLabel9)
                              .addComponent(jLabel10)))
                        .addComponent(txtCity)
                        .addComponent(jLabel11))
                     .addComponent(btnCreateAccount))
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(btnCancel)))
            .addContainerGap())
         .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(btnHomePage)
                  .addGap(94, 94, 94)
                  .addComponent(jLabel1))
               .addComponent(jLabel12))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
               .addGroup(layout.createSequentialGroup()
                  .addGap(31, 31, 31)
                  .addComponent(jLabel1))
               .addGroup(layout.createSequentialGroup()
                  .addContainerGap()
                  .addComponent(btnHomePage)))
            .addGap(33, 33, 33)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel2)
               .addComponent(txtEmail)
               .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtSsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel3)
               .addComponent(jLabel8))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(15, 15, 15)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel4)
               .addComponent(jLabel9))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtStreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel5)
               .addComponent(jLabel10))
            .addGap(9, 9, 9)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(jLabel6)
               .addComponent(jLabel11))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jLabel12)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(btnSignIn)
               .addComponent(btnCreateAccount)
               .addComponent(btnCancel))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      pack();
      setLocationRelativeTo(null);
   }// </editor-fold>//GEN-END:initComponents

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
      SignInGui signIn = new SignInGui(homePage);
      signIn.setVisible(true);
      super.dispose();
    }//GEN-LAST:event_btnSignInActionPerformed

    private void btnHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomePageActionPerformed
        
        super.dispose();
    }//GEN-LAST:event_btnHomePageActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        super.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAccountActionPerformed
        JFrame frame = new JFrame();
        
        if(!luhn(txtSsn.getText())){
            JOptionPane.showMessageDialog(frame, "Invalid social security number.");
            return;
        }
        if(!passwordCheck(txtPassword.getText())){
            return;
        }
        
        try {
            CreateAccountControl control = new CreateAccountControl();
            
            control.addBorrowerToDB(txtSsn.getText(), cmbCategory.getSelectedIndex(),
                    txtFirstName.getText(), txtLastName.getText(), txtPassword.getText(),
                    txtMail.getText(), txtPhoneNumber.getText(), txtStreet.getText(),
                    txtPostcode.getText(), txtCity.getText());
            
            JOptionPane.showMessageDialog(frame, "Creation completed!");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Something went wrong, " + ex.getMessage());
            Logger.getLogger(CreateAccountGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Logga in den nyskapade användaren
        try {
            // TODO add your handling code here:
            SignInControl control = new SignInControl(homePage);
            control.signIn(txtSsn.getText(), txtPassword.getText());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SignInGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        super.dispose();
            
        
    }//GEN-LAST:event_btnCreateAccountActionPerformed

    private void txtSsnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSsnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSsnActionPerformed

    private void txtSsnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSsnFocusGained
        // TODO add your handling code here:
        txtSsn.setText("");
        txtSsn.setForeground(Color.black);
    }//GEN-LAST:event_txtSsnFocusGained

    private void txtPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPasswordFocusGained
        // TODO add your handling code here:
        txtPassword.setText("");
        txtPassword.setForeground(Color.black);
    }//GEN-LAST:event_txtPasswordFocusGained

    private void txtMailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMailFocusGained
        // TODO add your handling code here:
        txtMail.setText("");
        txtMail.setForeground(Color.black);
    }//GEN-LAST:event_txtMailFocusGained

    
    private boolean luhn(String pnr){
        JFrame frame = new JFrame();
        //ifall angivet personnummer är längre än 10 anges antalet extrasiffror i "extra"
        int extra = pnr.length() - 10; 

        //ifall extrasiffrorna är färre än noll så innebär det att personnumret var 
        //färre än 10 siffror, vilket ett giltigt persnr måste vara, därför skrivs
        //ett felmeddelande ut och resultatet blir false och går tillbaka till "fillPnr"-metoden
        if (extra < 0) {
            JOptionPane.showMessageDialog(frame, "Social security number needs to contain of at least 10 numbers.");
            
            return false;
        }

        pnr = pnr.substring(extra, 10 + extra);
        int sum = 0;

        for (int i = 0; i < pnr.length(); i++){

            char c = pnr.charAt(i); 

            int num = c - '0'; 

            int product;
            if (i % 2 != 0){
                product = num * 1;
            }else{
                product = num * 2;
            }

            if (product > 9){
            product -= 9;
            }
            sum += product;              
        }
    
        //metoden returnerar sant ifall att "remaindern" av 10 är 0, 
        //alltså att summan gick att dela med 10 utan rester, i annat fall returneras false
        return (sum % 10 == 0);
    }
    
    private boolean passwordCheck(String password){
        if (password.length() < 6){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Password is too short, need to be at least 6 characters.");
            return false;
        }
        else 
            return true;
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
//            java.util.logging.Logger.getLogger(CreateAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CreateAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CreateAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CreateAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CreateAccountGui().setVisible(true);
//            }
//        });
//    }

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton btnCancel;
   private javax.swing.JButton btnCreateAccount;
   private javax.swing.JButton btnHomePage;
   private javax.swing.JButton btnSignIn;
   private javax.swing.JComboBox<String> cmbCategory;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JLabel jLabel10;
   private javax.swing.JLabel jLabel11;
   private javax.swing.JLabel jLabel12;
   private javax.swing.JLabel jLabel2;
   private javax.swing.JLabel jLabel3;
   private javax.swing.JLabel jLabel4;
   private javax.swing.JLabel jLabel5;
   private javax.swing.JLabel jLabel6;
   private javax.swing.JLabel jLabel7;
   private javax.swing.JLabel jLabel8;
   private javax.swing.JLabel jLabel9;
   private javax.swing.JTextField txtCity;
   private javax.swing.JLabel txtEmail;
   private javax.swing.JTextField txtFirstName;
   private javax.swing.JTextField txtLastName;
   private javax.swing.JTextField txtMail;
   private javax.swing.JPasswordField txtPassword;
   private javax.swing.JTextField txtPhoneNumber;
   private javax.swing.JTextField txtPostcode;
   private javax.swing.JTextField txtSsn;
   private javax.swing.JTextField txtStreet;
   // End of variables declaration//GEN-END:variables
}
