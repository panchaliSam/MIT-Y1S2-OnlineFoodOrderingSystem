package main.java.com.bs.dao;

/**
 *
 * @author Group4 - Panchali
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import main.java.com.bs.interfaces.ICustomerDAO;
import main.java.com.bs.model.Customer;
import main.java.com.bs.utility.DBConnectionPanchali;

public class CustomerDAO implements ICustomerDAO{
    
   private static final String SELECT_ALL_CUSTOMERS = "SELECT customer_id, first_name, last_name, email, tel_no, "
                                                    + "user_name, password, is_active, registration_date "
                                                    + "FROM customer";
   
   private static final String SELECT_CUSTOMER_BY_ID = "SELECT customer_id, first_name, last_name, email, tel_no, "
                                                    + "user_name, password, is_active, registration_date "
                                                    + "FROM customer "
                                                    + "WHERE customer_id = ?";

   private static final String INSERT_CUSTOMER = "INSERT INTO customer(first_name, last_name, email, tel_no, "
                                            + "user_name, password)"
                                            + "VALUES(?, ?, ?, ?, ?, ?);";
   
   private static final String UPDATE_CUSTOMER = "UPDATE customer SET first_name = ?, last_name = ?, email = ?, tel_no = ?, user_name = ?, password = ? WHERE customer_id = ?";
   
   private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE customer_id = ?";
   

    @Override
    public ArrayList<Customer> selectAllCustomer(int customerId) {
                //Cretaing customer arraylist
        ArrayList<Customer> customers = new ArrayList<>();
        
        try{
            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnCustomerId = rs.getInt("customer_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                boolean isActive = rs.getBoolean("is_active");
                String isActiveStatus = isActive ? "Active" : "Inactive";
                LocalDateTime registrationDate = rs.getTimestamp("registration_date").toLocalDateTime();
                
                Customer customer = new Customer(returnCustomerId, firstName, lastName, email, telNo, userName, password, isActive, isActiveStatus, registrationDate);
                
                customer.setIsActiveStatus(isActiveStatus);
                
                customers.add(customer);
                
                //Polymorphism for customer myTask();
                customer.myTask();

            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return customers;
        
    }

    @Override
    public ArrayList<Customer> selectCustomer(int customerId) {
        
                        //Cretaing customer arraylist
        ArrayList<Customer> customers = new ArrayList<>();
        
        try{
            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_CUSTOMER_BY_ID);
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnCustomerId = rs.getInt("customer_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                boolean isActive = rs.getBoolean("is_active");
                LocalDateTime registrationDate = rs.getTimestamp("registration_date").toLocalDateTime();
                
                //Customer customer = new Customer(returnCustomerId, firstName, lastName, email, telNo, userName, password, isActive, registrationDate);
                            
                Customer customer = new Customer();
                     
                customer.setCustomerId(returnCustomerId);
                customer.setFirstName(firstName);
                customer.setLastName(lastName);
                customer.setEmail(email);
                customer.setTelNo(telNo);
                customer.setUserName(userName);
                customer.setPassword(password);
                customer.setIsActive(isActive);
                customer.setRegistrationDate(registrationDate);
                
                customers.add(customer);       
                
                //Polymorphism for customer myTask();
                customer.myTask();
                
                System.out.println("\nSelected Customer: " + customer.toString());
            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return customers;
        
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        
      System.out.println(INSERT_CUSTOMER);
      boolean rowInserted = false;
      
      try{
          
          Connection con = DBConnectionPanchali.getConnection();
          PreparedStatement stmt = con.prepareStatement(INSERT_CUSTOMER);
          
          stmt.setString(1, customer.getFirstName()); 
          stmt.setString(2,customer.getLastName());
          stmt.setString(3, customer.getEmail());
          stmt.setString(4, customer.getTelNo());
          stmt.setString(5, customer.getUserName());
          stmt.setString(6, customer.getPassword());
          
          stmt.executeUpdate();
          
          //Polymorphism for customer myTask();
          customer.myTask();
          
          rowInserted = true;
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowInserted;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        
      System.out.println(UPDATE_CUSTOMER);
      boolean rowUpdate = false;
      
      try{
          
          Connection con = DBConnectionPanchali.getConnection();
          PreparedStatement stmt = con.prepareStatement(UPDATE_CUSTOMER);
          
          stmt.setString(1, customer.getFirstName());
          stmt.setString(2,customer.getLastName());
          stmt.setString(3, customer.getEmail());
          stmt.setString(4, customer.getTelNo());
          stmt.setString(5, customer.getUserName());
          stmt.setString(6, customer.getPassword());
          
          stmt.setInt(7, customer.getCustomerId());
          
          rowUpdate = stmt.executeUpdate() > 0;
          
          
          //Polymorphism for customer myTask();
          customer.myTask();
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowUpdate;
        
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        
        System.out.println(DELETE_CUSTOMER);
        boolean rowDelete = false;
        
        try{
            
            Connection con =  DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_CUSTOMER);
            
            stmt.setInt(1, customerId);
            
            rowDelete = stmt.executeUpdate() > 0;
            
             Customer customer = new Customer();
            
            //Polymorphism for customer myTask();
            customer.myTask();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rowDelete;
        
    }
    
}