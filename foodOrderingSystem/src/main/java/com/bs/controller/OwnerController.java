
package main.java.com.bs.controller;

import main.java.com.bs.dao.OwnerDAO;
import main.java.com.bs.interfaces.IOwnerDAO;
import main.java.com.bs.model.Owner;


/**
 *
 * @author Group4 Imesh
 */
public class OwnerController {
    
    private final IOwnerDAO ownerDAO;
    
    public OwnerController(){
        
        this.ownerDAO = new OwnerDAO();
        
    }
    
    public void addOwner(String fname, String lname, String email, String telNo, String position, String password){
        Owner owner = new Owner();
        owner.setFirstName(fname);
        owner.setLastName(lname);
        owner.setEmail(email);
        owner.setTelNo(telNo);
        owner.setPosition(position);
        owner.setPassword(password);
        ownerDAO.insertOwner(owner);
    }
    
    public void updateOwner(int id, String fname, String lname, String email, String telNo,String position, String password){
        Owner owner = new Owner();
        owner.setOwner_Id(id);
        owner.setFirstName(fname);
        owner.setLastName(lname);
        owner.setEmail(email);
        owner.setTelNo(telNo);
        owner.setPosition(position);
        owner.setPassword(password);
        ownerDAO.updateOwner(owner);
    }
    
    public void deleteOwner(int id){
        ownerDAO.deleteOwner(id);
    }
    
    public void selectOwner(int id){
        ownerDAO.selectOwner(id);
    }
    
    
}
