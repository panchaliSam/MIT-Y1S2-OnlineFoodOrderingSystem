/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.controller;

import main.java.com.bs.dao.DeliveryPersonDAO;
import main.java.com.bs.interfaces.IDeliveryPersonDAO;
import main.java.com.bs.model.DeliveryPerson;

/**
 *
 * @author Group4 - Nisala
 */
public class DeliveryPersonController {
    
    private final IDeliveryPersonDAO deliverypersonDAO;
    
    public DeliveryPersonController () {
        
        this.deliverypersonDAO = new DeliveryPersonDAO () ;
        
    }
    
    public void addDeliveryPerson (String fname, String lname, String email, String telNo) {
        DeliveryPerson deliveryperson = new DeliveryPerson ();
        deliveryperson.setFirstName(fname);
        deliveryperson.setLastName(lname);
        deliveryperson.setEmail(email);
        deliveryperson.setTelNo(telNo);
        deliverypersonDAO.insertDeliveryPerson(deliveryperson);
    }
    
    public void updateDeliveryPerson (int id, String fname, String lname, String email, String telNo) {
        DeliveryPerson deliveryperson = new DeliveryPerson();
        deliveryperson.setDeliveryPersonId(id);
        deliveryperson.setFirstName(fname);
        deliveryperson.setLastName(lname);
        deliveryperson.setEmail(email);
        deliveryperson.setTelNo(telNo);
        deliverypersonDAO.updateDeliveryPerson(deliveryperson);
        
    }
    
    public void deleteDeliveryPerson (int id) {
        deliverypersonDAO.deleteDeliveryPerson(id);
    }
    
    public void selectDeliveryPerson (int id) {
        deliverypersonDAO.selectDeliveryPerson(id);
    }
    
}
