/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.model;

/**
 *
 * @author Group 4 - Ama
 */

import java.time.LocalDateTime;

public class Order {
<<<<<<< HEAD
    
=======
>>>>>>> 85f4f67c3ed0f9ef557d7c30194ce7e710165b20
    
    private int orderId;
    private int customerId;
    private LocalDateTime orderDate;
    private String  recAddress;
    private String sendAddress;
    private double totalAmount;
    private boolean orderStatus;
    private boolean isActive;
    
    //default constructor
    public Order() {
    }
    
    //parametric constructor 
    public Order(int orderId, int customerId, LocalDateTime orderDate,String recAddress,String sendAddress,double totalAmount, boolean orderStatus, boolean isActive){
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.recAddress = recAddress;
        this.sendAddress = sendAddress;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.isActive = isActive;
    }

    public Order(int returnCustomerId, int returnOrderId, LocalDateTime orderDate, String recAddress, String sendAddress, double totalAmount, boolean orderStatus, boolean active, String activeStatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //Getter and Setters for orderId
    public int getOrderId(){
        return orderId;
    }
    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    
    
    //Getter and Setters for customerId
    public int getCustomerId(){
        return customerId;
    }
    
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    
    // Getter and Setter for orderDate
    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    
    
    // Getter and Setter for recAddress
    public String getRecAddress() {
        return recAddress;
    }

    public void setRecAddress(String recAddress) {
        this.recAddress = recAddress;
    }
    
    // Getter and Setter for sendAddress
    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }
    
    
    //Getter and Setters for totalAmount
    public double getTotalAmount(){
        return totalAmount;
    }
    
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
    // Getter and Setter for isActive
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    
    // Getter and Setter for orderStatus
    public boolean getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
    }
    
     @Override
    public String toString() {
        return "Order{" +
            "orderId=" + orderId +
            "customerId=" + customerId +
            ", orderDate='" + orderDate + '\'' +
            ", recAddress='" + recAddress + '\'' +
            ", sendAddress='" + sendAddress + '\'' +
            ", totalAmount='" + totalAmount + '\'' +
            ", orderStatus='" + orderStatus + '\'' +
            ", isActive=" + isActive +
            '}';
    }

    public void setIsActiveStatus(String activeStatus) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
}