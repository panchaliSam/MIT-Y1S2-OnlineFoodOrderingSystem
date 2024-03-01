/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.controller;

import main.java.com.bs.dao.AdminDAO;
import main.java.com.bs.interfaces.IAdminDAO;
import main.java.com.bs.model.Admin;

/**
 *
 * @author User
 */
public class AdminController {
    
    private final IAdminDAO adminDAO;
    
    public AdminController(){
        
        this.adminDAO = new AdminDAO();
        
    }
    
    public void addAdmin(String fname, String lname, String email, String telNo,String role, String userName, String password){
        Admin admin = new Admin();
        admin.setFirstName(fname);
        admin.setLastName(lname);
        admin.setEmail(email);
        admin.setEmail(email);
        admin.setTelNo(telNo);
        admin.setRole(role);
        admin.setUserName(userName);
        admin.setPassword(password);
        adminDAO.insertAdmin(admin);
    }
    
    public void updateAdmin(int id, String fname, String lname, String email, String telNo,String role, String userName, String password){
        Admin admin = new Admin();
        admin.setAdminId(id);
        admin.setFirstName(fname);
        admin.setLastName(lname);
        admin.setEmail(email);
        admin.setEmail(email);
        admin.setTelNo(telNo);
        admin.setRole(role);
        admin.setUserName(userName);
        admin.setPassword(password);
        adminDAO.updateAdmin(admin);
    }
    
    public void deleteAdmin(int id){
        adminDAO.deleteAdmin(id);
    }
    
    public void selectAdmin(int id){
        adminDAO.selectAdmin(id);
    }
    
}
