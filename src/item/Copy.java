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
    private int loanCategory;
    private String loanStatus;
    private String condition;

    public Copy(int barcodeNo, Item item, int loanCategory, String loanStatus, String condition) {
        this.barcodeNo = barcodeNo;
        this.item = item;
        this.loanCategory = loanCategory;
        this.loanStatus = loanStatus;
        this.condition = condition;
    }
    
    public Copy(int barcode, String condition, int loanCategory, String loanStatus){
        this.barcodeNo = barcode;
        this.condition = condition;
        this.loanCategory = loanCategory;
        this.loanStatus = loanStatus;
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

    public int getLoanCategory() {
        return loanCategory;
    }

    public void setLoanCategory(int loanCategory) {
        this.loanCategory = loanCategory;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
    
    public void searchCopy(Item item){
        //sätt returtyp Copy
    }
    
    
    
    public void setDBitem(){}
    
    public void setDBloanCategory(){}
    
}
