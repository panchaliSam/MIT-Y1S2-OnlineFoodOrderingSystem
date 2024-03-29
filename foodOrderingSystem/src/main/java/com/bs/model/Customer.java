package main.java.com.bs.model;

/**
 *
 * @author Group4 - Panchali
 */

import java.time.LocalDateTime;

public class Customer extends Person {

    private int customerId;
    private String userName;
    private String password;
    private boolean isActive;
    private String isActiveStatus;
    private LocalDateTime registrationDate;

    // Default constructor
    public Customer() {
    }

    // Parametric constructor
    public Customer(int customerId,String firstName, String lastName,String email, String telNo,String userName, String password, boolean isActive, String isActiveStatus, LocalDateTime registrationDate) {
        super(firstName, lastName, email, telNo);
        this.customerId = customerId;
        this.userName = userName;
        this.password = password;
        this.isActive = isActive;
        this.isActiveStatus = isActiveStatus;
        this.registrationDate = registrationDate;
    }

    public Customer(int returnCustomerId, String firstName, String lastName, String email, String telNo, String userName, String password, boolean active, LocalDateTime registrationDate) {
        
    }

    public Customer(String firstName, String lastName, String email, String telNo, String userName, String password) {
        
    }

    public Customer(int i, String fname, String lname, String email, String telNo, String userName, String password) {
        
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
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
        // Getter and Setter for isActiveStatus
    public String getIsActiveStatus() {
        return isActiveStatus;
    }

    public void setIsActiveStatus(String isActiveStatus) {
        this.isActiveStatus = isActiveStatus;
    }

    // Getter and Setter for registrationDate
    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
    
        @Override
    public void setFirstName(String firstName) {
        // Add custom logic if needed
        super.setFirstName(firstName); // Call the superclass method if you want to retain its functionality
    }
    
    @Override
    public String toString() {
        return "Customer{" +
            "customerId=" + customerId +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", telNo='" + telNo + '\'' +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", isActive=" + isActive +
            ", isActiveStatus='" + isActiveStatus + '\'' +
            ", registrationDate=" + registrationDate +

            '}';
    }

    @Override
    public void myTask() {
        System.out.println("Customer can select menu and place orders.");
    }
    
}
