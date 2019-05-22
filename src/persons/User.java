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
   
    public boolean signedIn;
   
    
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
   
   public void signOut(){
        
   }
    
}
