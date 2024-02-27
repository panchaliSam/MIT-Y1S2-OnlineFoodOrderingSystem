/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main.java.com.bs.interfaces;

import java.util.ArrayList;
import main.java.com.bs.model.Admin;

/**
 *
 * @author Group4 - Manditha 
 */
public interface IAdminDAO {
    
        ArrayList<Admin>selectAllCustomer(int adminId);
    	ArrayList<Admin>selectCustomer(int adminId);
	public boolean insertCustomer (Admin admin);
	public boolean updateCustomer (Admin admin);
	public boolean deleteCustomer (int adminId);
        
}
