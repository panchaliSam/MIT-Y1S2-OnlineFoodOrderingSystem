/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.model;

import java.time.LocalDateTime;

/**
 *
 * @author group4 - Dulan
 */
public class Payment {
    
    private int payment_id;
    private int customer_id;
    private String payment_method;
    private double amount;
    private String payment_status;
    private boolean is_active;
    private String isActiveStatus;
    private LocalDateTime payment_date;
    

    public Payment() {
    }

    public Payment(int payment_id, int customer_id, String payment_method, double amount, String payment_status, boolean is_active, LocalDateTime payment_date) {
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.payment_method = payment_method;
        this.amount = amount;
        this.payment_status = payment_status;
        this.is_active = is_active;
        this.payment_date = payment_date;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public LocalDateTime getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDateTime payment_date) {
        this.payment_date = payment_date;
    }

    public String getIsActiveStatus() {
        return isActiveStatus;
    }

    public void setIsActiveStatus(String isActiveStatus) {
        this.isActiveStatus = isActiveStatus;
    }
    
    @Override
    public String toString() {
        return "Payment{" +
            "paymentId=" + payment_id +
            ", customerid='" + customer_id + '\'' +
            ", paymentMethod='" + payment_method + '\'' +
            ", amount='" + amount + '\'' +
            ", paymentStatus='" + payment_status + '\'' +
            ", isActive=" + is_active +
            ", isActiveStatus='" + isActiveStatus + '\'' +
            ", payment date=" + payment_date +

            '}';
    }
    
       
}
