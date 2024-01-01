package main.java.com.bs.interfaces;

/**
 *
 * @author Group4 - Panchali
 */

import java.util.ArrayList;
import main.java.com.bs.model.Customer;

public interface ICustomerDAO {
    
        ArrayList<Customer>selectAllCustomer(int customerId);
    	ArrayList<Customer>selectCustomer(int customerId);
	public boolean insertCustomer (Customer customer);
	public boolean updateCustomer (Customer customer);
	public boolean deleteCustomer (int customerId);
    
}
