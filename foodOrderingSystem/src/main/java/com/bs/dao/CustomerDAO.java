package main.java.com.bs.dao;

import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import main.java.com.bs.interfaces.ICustomerDAO;
import main.java.com.bs.model.Customer;
import main.java.com.bs.utility.DBConnection;

public class CustomerDAO implements ICustomerDAO{
    
   private static final String SELECT_ALL_CUSTOMERS = "SELECT customer_id, first_name, last_name, email, tel_no, "
                                                    + "user_name, password, is_active, registration_date "
                                                    + "FROM customer";


    @Override
    public ArrayList<Customer> selectMovie(int customerId) {
        
        //Cretaing customer arraylist
        ArrayList<Customer> customers = new ArrayList<>();
        
        try{
            Connection con = DBConnection.getConnection();
                        
        }catch(Exception e){
            
        }
        
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean deleteCustomer(int customerId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}