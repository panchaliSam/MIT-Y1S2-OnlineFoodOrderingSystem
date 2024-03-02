/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.controller;

import main.java.com.bs.dao.PaymentDAO;
import main.java.com.bs.interfaces.IPaymentDAO;
import main.java.com.bs.model.Payment;

/**
 *
 * @author Group4 - Dulan
 */
public class PaymentController {
    
    private final IPaymentDAO paymentDAO;

    public PaymentController() {
        
        this.paymentDAO = new PaymentDAO();
    }
    
    public void addPayment(double amount, String paymentMethod, String paymentStatus, int customerId){
        
        Payment payment = new Payment();
        
        payment.setAmount(amount);
        payment.setPayment_method(paymentMethod);
        payment.setPayment_status(paymentStatus);
        payment.setCustomer_id(customerId);
        paymentDAO.insertPayment(payment);
            
    }
    
    public void updatePayment(int paymentId, double amount, String paymentMethod, String paymentStatus, int customerId){
        
        Payment payment = new Payment();
        
        payment.setPayment_id(paymentId);
        payment.setAmount(amount);
        payment.setPayment_method(paymentMethod);
        payment.setPayment_status(paymentStatus);
        payment.setCustomer_id(customerId);
        paymentDAO.updatePayment(payment);
        
    }
    
    public void deletePayment(int paymentId){
        
        paymentDAO.deletePayment(paymentId);
    }
    
    public void selectPayment(int paymentId){
        
        paymentDAO.selectPayment(paymentId);
    }
    
    
}
