/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import item.Copy;
import java.util.Date;

/**
 *
 * @author annalangstrom
 */
public class LoanItem {
    private Copy copy;
    private Date lastReturnDate;
    private Date actualReturnDate = null;

    public LoanItem(Copy copy, Date lastReturnDate) {
        this.copy = copy;
        
        
    }

    public Copy getCopy() {
        return copy;
    }

    public void setCopy(Copy copy) {
        this.copy = copy;
    }

    public Date getLastReturnDate() {
        return lastReturnDate;
    }

    public void setLastReturnDate(Date lastReturnDate) {
        this.lastReturnDate = lastReturnDate;
    }

    public Date getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Date actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }
    
    public LoanItem setReturned(Copy copy){
        return this;
    }
            
}
