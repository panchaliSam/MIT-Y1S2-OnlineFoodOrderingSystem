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
        Customer customer = new Customer();
        customer.setFirstName(fname);
        customer.setLastName(lname);
        customer.setEmail(email);
        customer.setTelNo(telNo);
        customer.setUserName(userName);
        customer.setPassword(password);
        customerDAO.insertCustomer(customer);
    }
    
    public void updateCustomer(int id, String fname, String lname, String email, String telNo,String userName, String password){
        Customer customer = new Customer(id, fname, lname, email, telNo, userName, password);
        customerDAO.updateCustomer(customer);
    }
    
    public void deleteCustomer(int id){
        customerDAO.deleteCustomer(id);
    }
    
    public void selectCustomer(int id){
        customerDAO.selectCustomer(id);
    }
}
