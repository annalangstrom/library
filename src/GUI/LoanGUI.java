/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Rebec
 */
public class LoanGUI extends javax.swing.JFrame {

    private final DefaultListModel model;
    
    /**
     * Creates new form Loan
     */
    public LoanGUI() {
        super("Loan item");
        model = new DefaultListModel();
        initComponents();
        initList();
    }

    private void initList(){
        lstLoan.setModel(model);
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
        btnLoanToSearch = new javax.swing.JButton();
        labelLoan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLoan = new javax.swing.JList<>();
        btnLoanLoan = new javax.swing.JButton();
        btnLoanSignOut = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

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

        btnLoanToSearch.setText("To Search");
        btnLoanToSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoanToSearchActionPerformed(evt);
            }
        });

        labelLoan.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        labelLoan.setText("Loan");
        labelLoan.setFocusable(false);

        jScrollPane1.setViewportView(lstLoan);

        btnLoanLoan.setText("Loan");

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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnLoanHomePage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnLoanToSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLoanLoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLoanSignOut)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(labelLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLoanHomePage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoanToSearch)
                .addGap(4, 4, 4)
                .addComponent(labelLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLoanSignOut)
                    .addComponent(btnLoanLoan))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoanHomePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanHomePageActionPerformed
        // TODO add your handling code here:
        HomePageGui gui = new HomePageGui();
        gui.setVisible(true);
    }//GEN-LAST:event_btnLoanHomePageActionPerformed

    private void btnLoanToSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanToSearchActionPerformed
        // TODO add your handling code here:
        SearchGUI gui = new SearchGUI();
        gui.setVisible(true);
    }//GEN-LAST:event_btnLoanToSearchActionPerformed

    private void btnLoanSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoanSignOutActionPerformed
        // TODO add your handling code here:
        HomePageGui gui = new HomePageGui();
        gui.setVisible(true);
    }//GEN-LAST:event_btnLoanSignOutActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int index = lstLoan.getSelectedIndex();
//        things.remove(index);
        model.remove(index);
        
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String input = JOptionPane.showInputDialog(rootPane, "Which barcode do you wanna add to your loan?");
        
//        model.addElement(txtAdd.getText());
//        things.add(txtAdd.getText());
//        txtAdd.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

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
    private javax.swing.JButton btnLoanToSearch;
    private javax.swing.JButton btnRemove;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLoan;
    private javax.swing.JLabel labelLoanConfirm;
    private javax.swing.JList<String> lstLoan;
    private javax.swing.JPanel panelLoanConfirm;
    // End of variables declaration//GEN-END:variables
}
