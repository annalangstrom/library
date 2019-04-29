/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package item;

/**
 *
 * @author annalangstrom
 */
public class Copy {
    private int barcodeNo;
    private Item item;
    private LoanCategory loanCategory;
    private LoanStatus loanStatus;
    private String condition;

    public Copy(int barcodeNo, Item item, LoanCategory loanCategory, LoanStatus loanStatus, String condition) {
        this.barcodeNo = barcodeNo;
        this.item = item;
        this.loanCategory = loanCategory;
        this.loanStatus = loanStatus;
        this.condition = condition;
    }
    
    public Copy(int barcodeNo){
        this.barcodeNo = barcodeNo;
    }

    public int getBarcodeNo() {
        return barcodeNo;
    }

    public void setBarcodeNo(int barcodeNo) {
        this.barcodeNo = barcodeNo;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LoanCategory getLoanCategory() {
        return loanCategory;
    }

    public void setLoanCategory(LoanCategory loanCategory) {
        this.loanCategory = loanCategory;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    
}
