
package main.java.com.bs.dao;

        
/**
 *
 * @author Group-Chathumi 
 */

import java.util.ArrayList;
import main.java.com.bs.interfaces.IVehicleDAO;
import main.java.com.bs.model.Vehicle;
import main.java.com.bs.utility.DBConnectionChathumi;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet; 
        

public class VehicleDAO implements IVehicleDAO{
    private static final String SELECT_ALL_VEHICLES = "SELECT vehicle_id, type, registration_number, model "
                                                    + "is_active "
                                                    + "FROM vehicle";
   
   private static final String SELECT_VEHICLE_BY_ID = "SELECT vehicle_id, type, registration_number, model "
                                                    + "is_active "
                                                    + "FROM vehicle "
                                                    + "WHERE vehicle_id = ?";

   private static final String INSERT_VEHICLE = "INSERT INTO vehicle(type, registration_number, model) "
                                            + "VALUES(?, ?, ?);";
   
   private static final String UPDATE_VEHICLE = "UPDATE vehicle SET type = ?, registration_number = ?, model = ? WHERE vehicle_id = ?";
   
   private static final String DELETE_VEHICLE = "DELETE FROM vehicle WHERE vehicle_id = ?";
   

    @Override
    public ArrayList<Vehicle> selectAllVehicle(int vehicleId) {
                //Cretaing vehicle arraylist
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        
        try{
            Connection con = DBConnectionChathumi.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_VEHICLES);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnVehicleId = rs.getInt("vehicle_id");
                String type = rs.getString("type");
                String registration_number = rs.getString("registration_number");
                String model = rs.getString("model");
                boolean isActive = rs.getBoolean("is_active");
                
                
                Vehicle vehicle = new Vehicle(returnVehicleId, type, registration_number, model, isActive);
                
                vehicles.add(vehicle);
                
                

            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return vehicles;
        
    }

    @Override
    public ArrayList<Vehicle> selectVehicle(int vehicleId) {
        
                        //Cretaing vehicle arraylist
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        
        try{
            Connection con = DBConnectionChathumi.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_VEHICLE_BY_ID);
            stmt.setInt(1, vehicleId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnVehicleId = rs.getInt("vehicle_id");
                String type = rs.getString("type");
                String registration_number = rs.getString("registration_number");
                String model = rs.getString("model");
                boolean isActive = rs.getBoolean("is_active");
                
                
                //Vehicle vehicle = new Vehicle(returnVehicleId, type, registration_number, model, is_active);
                            
                Vehicle vehicle = new Vehicle();
                     
                vehicle.setvehicleId(returnVehicleId);
                vehicle.settype(type);
                vehicle.setregistrationNumber(registration_number);
                vehicle.setmodel(model);
                vehicle.setIsActive(isActive);
                
                
                vehicles.add(vehicle);       
                
                
                
                System.out.println("\nSelected Vehicle: " + vehicle.toString());
            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return vehicles;
        
    }

    @Override
    public boolean insertVehicle(Vehicle vehicle) {
        
      System.out.println(INSERT_VEHICLE);
      boolean rowInserted = false;
      
      try{
          
          Connection con = DBConnectionChathumi.getConnection();
          PreparedStatement stmt = con.prepareStatement(INSERT_VEHICLE);
          
          stmt.setString(1, vehicle.gettype()); 
          stmt.setString(2,vehicle.getregistrationNumber());
          stmt.setString(3, vehicle.getmodel());
         
          
          stmt.executeUpdate();
          
         
          rowInserted = true;
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowInserted;
    }

    @Override
    public boolean updateVehicle(Vehicle vehicle) {
        
      System.out.println(UPDATE_VEHICLE);
      boolean rowUpdate = false;
      
      try{
          
          Connection con = DBConnectionChathumi.getConnection();
          PreparedStatement stmt = con.prepareStatement(UPDATE_VEHICLE);
          
          stmt.setString(1, vehicle.gettype());
          stmt.setString(2,vehicle.getregistrationNumber());
          stmt.setString(3, vehicle.getmodel());
          
          stmt.setInt(4, vehicle.getvehicleId());
          
          rowUpdate = stmt.executeUpdate() > 0;
          
          
          
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowUpdate;
        
    }

    @Override
    public boolean deleteVehicle(int vehicleId) {
        
        System.out.println(DELETE_VEHICLE);
        boolean rowDelete = false;
        
        try{
            
            Connection con =  DBConnectionChathumi.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_VEHICLE);
            
            stmt.setInt(1, vehicleId);
            
            rowDelete = stmt.executeUpdate() > 0;
            
             Vehicle vehicle = new Vehicle();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rowDelete;
        
    }

    
}
