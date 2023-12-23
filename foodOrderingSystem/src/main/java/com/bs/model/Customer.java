package main.java.com.bs.model;

import java.time.LocalDateTime;

public class Customer extends Person {

    private int customerId;
    private String userName;
    private String password;
    private int isActive;
    private LocalDateTime registrationDate;

    // Default constructor
    public Customer() {
    }

    // Overloaded constructor
    public Customer(String firstName, String lastName,String email, String telNo, String userName, String password) {
        super(firstName, lastName, email, telNo);
        this.userName = userName;
        this.password = password;
    }

    // Getter and Setter for customerId
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Getter and Setter for userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter and Setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter for isActive
    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    // Getter and Setter for registrationDate
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
