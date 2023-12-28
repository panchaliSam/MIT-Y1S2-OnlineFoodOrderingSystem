/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.controller;

import main.java.com.bs.dao.CustomerDAO;
import main.java.com.bs.interfaces.ICustomerDAO;
import main.java.com.bs.model.Customer;

/**
 *
 * @author Group 4
 */
public class CustomerController {
    
    private final ICustomerDAO customerDAO;
    
    public CustomerController(){
        
        this.customerDAO = new CustomerDAO();
        
    }
    
    public void addCustomer(String fname, String lname, String email, String telNo, String userName, String password){
        Customer customer = new Customer(0, fname, lname, email, telNo, userName, password);
        customerDAO.insertCustomer(customer);
    }
    
    public void updateCustomer(int id, String fname, String lname, String email, String telNo,String userName, String password){
        Customer customer = new Customer(id, fname, lname, email, telNo, userName, password);
        customerDAO.updateCustomer(customer);
    }
    
    
}
