/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import item.Item;
import java.sql.Date;
import java.time.LocalDate;
import persons.Borrower;
import persons.Staff;

/**
 *
 * @author annalangstrom
 */
public class Reservation {
    private int reservationNo = 0;
    private final int borrower;
    private final int item;
    private int staff;
    private final Date date;

    public Reservation(int borrower, int item, int staff) {
        this.borrower = borrower;
        this.item = item;
        this.staff = staff;
        this.date = Date.valueOf(LocalDate.now());
    }

    public Reservation(int borrower, int item) {
        this.borrower = borrower;
        this.item = item;
        this.date = Date.valueOf(LocalDate.now());
    }
    
    public void setReservationNo(int reservationNo){
        this.reservationNo = reservationNo;
    }

    public int getReservationNo() {
        return reservationNo;
    }

    public int getBorrower() {
        return borrower;
    }

    public int getItem() {
        return item;
    }

    public int getStaff() {
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
