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
    
        ArrayList<Admin>selectAllAdmin(int adminId);
    	ArrayList<Admin>selectAdmin(int adminId);
	public boolean insertAdmin (Admin admin);
	public boolean updateAdmin (Admin admin);
	public boolean deleteAdmin (int adminId);
        
}
