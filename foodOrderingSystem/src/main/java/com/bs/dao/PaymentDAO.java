/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import main.java.com.bs.interfaces.IPaymentDAO;
import main.java.com.bs.model.Payment;
import main.java.com.bs.utility.DBConnectionDulan;

/**
 *
 * @author Group4 - Dulan
 */
public class PaymentDAO implements IPaymentDAO{
    
    private static final String SELECT_ALL_PAYMENT = "SELECT payment_id, customer_id, payment_method, amount, payment_status, "
                                                    + "payment_date, is_active "
                                                    + "FROM payment";
    
    private static final String SELECT_ALL_PAYMENT_BY_ID = "SELECT payment_id, customer_id, payment_method, amount, payment_status, "
                                                    + "payment_date, is_active "
                                                    + "FROM payment "
                                                    + "WHERE payment_id = ?";
    
    private static final String INSERT_PAYMENT = "INSERT INTO payment(amount, payment_method, payment_status, customer_id) "
                                            + "VALUES(?, ?, ?, ?);";
    
    private static final String UPDATE_PAYMENT = "UPDATE payment SET amount = ?, payment_method = ?, payment_status = ?, customer_id = ? WHERE payment_id = ?"; 
    
    private static final String DELETE_PAYMENT = "DELETE FROM payment WHERE payment_id = ?";

    @Override
    public ArrayList<Payment> selectAllPayment(int paymentId) {
        
        ArrayList<Payment> payments = new ArrayList<>();
        
        try{
            Connection con = DBConnectionDulan.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_PAYMENT);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                int return_payment_id = rs.getInt("payment_id");
                int return_customer_id = rs.getInt("customer_id");
                String payment_method = rs.getString("payment_method");
                double amount = rs.getDouble("amount");
                String payment_status = rs.getString("payment_status");
                boolean is_active = rs.getBoolean("is_active");
                String isActiveStatus = is_active ? "Active" : "Inactive";
                LocalDateTime payment_date = rs.getTimestamp("payment_date").toLocalDateTime();
                
                Payment payment = new Payment(return_payment_id, return_customer_id, payment_method, amount, payment_status, is_active, payment_date);
                
                payment.setIsActiveStatus(isActiveStatus);
                
                payments.add(payment);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return payments;
    }

    @Override
    public ArrayList<Payment> selectPayment(int paymentId) {
        
        ArrayList<Payment> payments = new ArrayList<>();
        
        try{
            Connection con = DBConnectionDulan.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_PAYMENT_BY_ID);
            stmt.setInt(1, paymentId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                int return_payment_id = rs.getInt("payment_id");
                int return_customer_id = rs.getInt("customer_id");
                String payment_method = rs.getString("payment_method");
                double amount = rs.getDouble("amount");
                String payment_status = rs.getString("payment_status");
                boolean is_active = rs.getBoolean("is_active");
                String isActiveStatus = is_active ? "Active" : "Inactive";
                LocalDateTime payment_date = rs.getTimestamp("payment_date").toLocalDateTime();
                
                Payment payment = new Payment();
                
                payment.setPayment_id(return_payment_id);
                payment.setCustomer_id(return_customer_id);
                payment.setPayment_method(payment_method);
                payment.setAmount(amount);
                payment.setPayment_status(payment_status);
                payment.setIs_active(is_active);
                payment.setPayment_date(payment_date);
                
                
                
                payments.add(payment);
                
                System.out.println("\nSelected Payment: " + payment.toString());
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return payments;
    }

    @Override
    public boolean insertPayment(Payment payment) {
       System.out.println(INSERT_PAYMENT);
      boolean rowInserted = false;
      
      try{
          
          Connection con = DBConnectionDulan.getConnection();
          PreparedStatement stmt = con.prepareStatement(INSERT_PAYMENT);
          
          stmt.setDouble(1, payment.getAmount()); 
          stmt.setString(2,payment.getPayment_method());
          stmt.setString(3, payment.getPayment_status());
          stmt.setInt(4, payment.getCustomer_id());
          
          
          stmt.executeUpdate();
          
          
          
          
          rowInserted = true;
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowInserted;
    }

    @Override
    public boolean updatePayment(Payment payment) {
        
       System.out.println(UPDATE_PAYMENT);
      boolean rowUpdate = false;
      
      try{
          
          Connection con = DBConnectionDulan.getConnection();
          PreparedStatement stmt = con.prepareStatement(UPDATE_PAYMENT);
          
          stmt.setDouble(1, payment.getAmount()); 
          stmt.setString(2,payment.getPayment_method());
          stmt.setString(3, payment.getPayment_status());
          stmt.setInt(4, payment.getCustomer_id());
          
          stmt.setInt(5, payment.getPayment_id());
          
          rowUpdate = stmt.executeUpdate() > 0;
          
         
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowUpdate; 
    }

    @Override
    public boolean deletePayment(int paymentId) {
       
        System.out.println(DELETE_PAYMENT);
        boolean rowDelete = false;
        
        try{
            
            Connection con =  DBConnectionDulan.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_PAYMENT);
            
            stmt.setInt(1, paymentId);
            
            rowDelete = stmt.executeUpdate() > 0;
            
             
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rowDelete;
    }
    
    
    
}
