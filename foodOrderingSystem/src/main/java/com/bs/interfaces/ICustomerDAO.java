package main.java.com.bs.interfaces;

import java.util.ArrayList;
import main.java.com.bs.model.Customer;

public interface ICustomerDAO {
    
        ArrayList<Customer>selectAllMovie(int customerId);
    	ArrayList<Customer>selectMovie(int customerId);
	public boolean insertCustomer (Customer customer);
	public boolean updateCustomer (Customer customer);
	public boolean deleteCustomer (int customerId);
    
}
