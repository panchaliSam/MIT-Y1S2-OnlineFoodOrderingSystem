/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.controller;

import main.java.com.bs.dao.VehicleDAO;
import main.java.com.bs.interfaces.IVehicleDAO;
import main.java.com.bs.model.Vehicle;

/**
 *
 * @author Group4-Chathumi
 */
public class VehicleController {
    private final IVehicleDAO vehicleDAO;
    
    public VehicleController(){
        
        this.vehicleDAO = new VehicleDAO();
        
    }
    
    public void addVehicle(int delpID,String type, String registration_number, String model){
        
        Vehicle vehicle = new Vehicle();
        vehicle.setdelpID(delpID);
        vehicle.settype(type);
        vehicle.setregistrationNumber(registration_number);
        vehicle.setmodel(model);
        vehicleDAO.insertVehicle(vehicle);
    }
    
    public void updateVehicle(int id,int delpID, String type, String registration_number, String model){
        Vehicle vehicle = new Vehicle();
        vehicle.setvehicleId(id);
        vehicle.setdelpID(delpID);
        vehicle.settype(type);
        vehicle.setregistrationNumber(registration_number);
        vehicle.setmodel(model);
        vehicleDAO.updateVehicle(vehicle);
    }
    
    public void deleteVehicle(int id){
        vehicleDAO.deleteVehicle(id);
    }
    
    public void selectVehicle(int id){
        vehicleDAO.selectVehicle(id);
    }
}
