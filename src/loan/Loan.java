/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import persons.Borrower;
import persons.Staff;

/**
 *
 * @author annalangstrom
 */
public class Loan {
    
    private int loanNo;
    private int borrower;
    private Staff staff;
    private LocalDate startDate;
    private ArrayList<LoanItem> loanItems;

    public Loan(int borrower, Staff staff, ArrayList<LoanItem> loanItems) {
        this.borrower = borrower;
        this.staff = staff;
        this.startDate = LocalDate.now();
        this.loanItems = loanItems;
    }
    
    public Loan(int borrower, ArrayList<LoanItem> loanItems) {
        this.borrower = borrower;
        this.startDate = LocalDate.now();
        this.loanItems = loanItems;
    }

    public Loan(int borrower){}

    public int getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(int loanNo) {
        this.loanNo = loanNo;
    }
    
    public int getBorrower() {
        return borrower;
    }

    public void setBorrower(int borrower) {
        this.borrower = borrower;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public ArrayList<LoanItem> getLoanItems() {
        return loanItems;
    }

    public void setLoanItems(ArrayList<LoanItem> loanItems) {
        this.loanItems = loanItems;
    }
    
    public void addLoanItem(int barcode, int loanPeriod){}
    
    public ArrayList<Borrower> getLateBorrowers(){
        ArrayList<Borrower> borrowers = new ArrayList<>();
        
        return borrowers;
    }
}
