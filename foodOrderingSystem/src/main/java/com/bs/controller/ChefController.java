/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.controller;

import main.java.com.bs.dao.ChefDAO;
import main.java.com.bs.interfaces.IChefDAO;
import main.java.com.bs.model.Chef;

/**
 *
 * @author -chathumi
 */
public class ChefController {
    
    private final IChefDAO chefDAO;
    
    public ChefController(){
        
        this.chefDAO = new ChefDAO();
        
    }
    
    public void addChef(String fname, String lname, String email, String telNo,String specialiation, String shift){
        Chef chef = new Chef();
        chef.setFirstName(fname);
        chef.setLastName(lname);
        chef.setEmail(email);
        chef.setTelNo(telNo);
        chef.setspecialiation(specialiation);
        chef.setshift(shift);
         chefDAO.insertChef(chef);
    }
    
    public void updateChef(int id, String fname, String lname, String email, String telNo,String specialiation, String shift){
        Chef chef = new Chef();
        chef.setChefId(id);
        chef.setFirstName(fname);
        chef.setLastName(lname);
        chef.setEmail(email);
        chef.setTelNo(telNo);
        chef.setspecialiation(specialiation);
        chef.setshift(shift);
        chefDAO.updateChef(chef);
    }
    
    public void deleteChef(int id){
        chefDAO.deleteChef(id);
    }
    
    public void selectChef(int id){
        chefDAO.selectChef(id);
    }
    
}