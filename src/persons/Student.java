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
public class Student extends Borrower{
    
    public Student(String ssn, String fname, String sname, String password, String email, String phoneNo, String street, String postcode, String city, int category) {
        super(ssn, fname, sname, password, email, phoneNo, street, postcode, city, category);
    }
    
}
