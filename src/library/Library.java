/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import GUI.HomePageGui;
import persons.User;

/**
 *
 * @author annalangstrom
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         // Skapar Observable user object och Observer.
         User user = new User();
         HomePageGui homePage = new HomePageGui(user);
         // Add Observer
         user.addObserver(homePage);
         
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new HomePageGui().setVisible(true);
                homePage.setVisible(true);
            }
        });
    }
    
}
