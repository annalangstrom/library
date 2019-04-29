/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import item.Item;
import java.util.Date;
import persons.Borrower;
import persons.Staff;

/**
 *
 * @author annalangstrom
 */
public class Reservation {
    private final int reservationNo;
    private final Borrower borrower;
    private final Item item;
    private final Staff staff;
    private final Date date;

    public Reservation(int reservationNo, Borrower borrower, Item item, Staff staff, Date date) {
        this.reservationNo = reservationNo;
        this.borrower = borrower;
        this.item = item;
        this.staff = staff;
        this.date = date;
    }

    public int getReservationNo() {
        return reservationNo;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public Item getItem() {
        return item;
    }

    public Staff getStaff() {
        return staff;
    }

    public Date getDate() {
        return date;
    }
    
    public boolean reservationExists(Borrower borrower, String title){
        return false;
    }
    
    public void deleteReservation(Borrower borrower, String title){}
}
