/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.model;

/**
 *
 * @author Group4 Panchali
 */
abstract public class Person {
    
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String telNo;
  
    // Default constructor
    public Person(){
        
    }
    
    // Overloaded constructor
    public Person(String firstName, String lastName,String email, String telNo){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telNo = telNo;
    }
    
    // Getter and Setter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for telNo
    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }
    
    abstract public void myTask();
}

