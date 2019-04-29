/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loan;

import java.time.LocalDate;
import java.util.ArrayList;
import persons.Borrower;
import persons.Staff;

/**
 *
 * @author annalangstrom
 */
public class Loan {
    
    private int loanNo;
    private Borrower borrower;
    private Staff staff;
    private LocalDate startDate;
    private ArrayList<LoanItem> loanItems;

    public Loan(int loanNo, Borrower borrower, Staff staff, ArrayList<LoanItem> loanItems) {
        this.loanNo = loanNo;
        this.borrower = borrower;
        this.staff = staff;
        this.startDate = LocalDate.now();
        this.loanItems = loanItems;
    }

    public Loan(Borrower borrower){}
    
    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
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
