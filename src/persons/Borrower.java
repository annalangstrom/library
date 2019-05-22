/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persons;

/**
 *
 * @author annalangstrom
 */
public class Borrower extends User{
    private String ssn;
    private String fname;
    private String sname;
    private String password;
    private String email;
    private String phoneNo;
    private String street;
    private String postcode;
    private String city;
    private int noOfLoans = 0;
    private boolean active = true;
    private int category;

    public Borrower(int id){
       super.setId(id);
    }
    
    public Borrower(String ssn, String fname, String sname, String password, String email, 
            String phoneNo, String street, String postcode, String city, int category) {
        this.ssn = ssn;
        this.fname = fname;
        this.sname = sname;
        this.password = password;
        this.email = email;
        this.phoneNo = phoneNo;
        this.street = street;
        this.postcode = postcode;
        this.city = city;
        this.category = category;
    }
    
    
    @Override
    public void setId(int id){
       super.setId(id);
    }
    
    @Override
    public int getId(){
       return super.getId();
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNoOfLoans() {
        return noOfLoans;
    }

    public void setNoOfLoans(int noOfLoans) {
        this.noOfLoans = noOfLoans;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
    
}
