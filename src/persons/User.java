/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

import java.util.Observable;


/**
 *
 * @author annalangstrom
 */
public class User extends Observable {
   
    private boolean signedIn;
    private int id;
   
    
   public User() {
      signedIn = false;
   }
   
   public boolean getSignedIn() {
      return signedIn;
   }
    
   //Ändra SigendIn och meddelar Observers att en ändring skett
   public void setSignedIn(boolean signedIn) {
      this.signedIn = signedIn;
      setChanged();
      notifyObservers(Boolean.valueOf(signedIn));
   }
   
   public int getId(){
     return id; 
   }
   
   public void setId(int id){
      this.id = id;
   }
   
   public void signOut(){
        
   }
    
}
