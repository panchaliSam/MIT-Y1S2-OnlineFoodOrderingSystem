/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.model;

import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class Admin extends Person {
    
    private int adminId;
    private int ownerId;
    private String role;
    private String userName;
    private String password;
    private LocalDateTime registrationDate;
    private boolean isActive;
    
    public Admin(int adminId, int ownerId, String firstName, String lastName, String email, String telNo, String role, String userName, String password, LocalDateTime registrationDate, boolean isActive){
        super(firstName,lastName,email,telNo);
        this.adminId = adminId;
        this.ownerId = ownerId;
        this.role = role;
        this.userName = userName;
        this.password = password;
        this.registrationDate = registrationDate;
        this.isActive = isActive;
    }
    
    public int getAdminId(){
        return adminId;
    }
    
    public void setAdminId(int adminId){
        this.adminId = adminId;
    }
    
    public int getOwnerId(){
        return ownerId;
    }
    
    public void setOwnerId(int ownerId){
        this.ownerId = ownerId;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public LocalDateTime getRegistrationDate(){
        return registrationDate;
    }
    
    public void setRegistrationDate(LocalDateTime registrationDate){
        this.registrationDate = registrationDate;
    }
    
    public boolean getIsActive(){
        return isActive;
    }
    
    public void setIsActive(boolean isActive){
        this.isActive = isActive;
    }
    
    @Override
    public String toString(){
        return "Admin{" +
            "adminId=" + adminId +
            ", ownerId='" + ownerId + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", telNo='" + telNo + '\'' +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", isActive=" + isActive +
            ", registrationDate=" + registrationDate +

            '}';
    }

    @Override
    public void myTask() {
        System.out.println("Admin can update the menu.");
    }
    
}
