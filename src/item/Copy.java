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
    private int item;
    private int loanCategory;
    private String loanStatus;
    private String condition;
    private String title;

    public Copy(int barcodeNo, int item, int loanCategory, String loanStatus, String condition, String title) {
        this.barcodeNo = barcodeNo;
        this.item = item;
        this.loanCategory = loanCategory;
        this.loanStatus = loanStatus;
        this.condition = condition;
        this.title = title;
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

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    public void searchCopy(Item item){
        //sätt returtyp Copy
    }
    
    
    
    public void setDBitem(){}
    
    public void setDBloanCategory(){}
    
}
