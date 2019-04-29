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
public class LoanCategory {
    
    private int LoanCategoryNo;
    private LCname name;
    private int loanPeriod;

    public LoanCategory(int LoanCategoryNo, LCname name, int loanPeriod) {
        this.LoanCategoryNo = LoanCategoryNo;
        this.name = name;
        this.loanPeriod = loanPeriod;
    }
    
    public LoanCategory(int loanCategoryNo){
        this.LoanCategoryNo = loanCategoryNo;
    }

    public LCname getName() {
        return name;
    }

    public void setName(LCname name) {
        this.name = name;
    }

    public int getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(int loanPeriod) {
        this.loanPeriod = loanPeriod;
    }
    
    public void setDBloanPeriod(){}
}
