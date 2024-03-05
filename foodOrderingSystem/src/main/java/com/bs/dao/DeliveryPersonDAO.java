package main.java.com.bs.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.java.com.bs.interfaces.IDeliveryPersonDAO;
import main.java.com.bs.model.DeliveryPerson;

import main.java.com.bs.utility.DBConnectionManditha;


/**
 *
 * @author Group4 - Nisala
 */

public class DeliveryPersonDAO implements IDeliveryPersonDAO {
    
   private static final String SELECT_ALL_DELIVERYPERSONS = "SELECT delivery_person_id, first_name, last_name, email, tel_no, "
                                                    + "is_active "
                                                    + "FROM delivery_person";
   
   private static final String SELECT_DELIVERYPERSON_BY_ID = "SELECT delivery_person_id, first_name, last_name, email, tel_no, "
                                                    + "is_active "
                                                    + "FROM delivery_person "
                                                    + "WHERE delivery_person_id = ?";

   private static final String INSERT_DELIVERYPERSON = "INSERT INTO delivery_person(first_name, last_name, email, tel_no) "
                                            + "VALUES(?, ?, ?, ?);";
   
   private static final String UPDATE_DELIVERYPERSON = "UPDATE delivery_person SET first_name = ?, last_name = ?, email = ?, tel_no = ? WHERE delivery_person_id = ?";
   
   private static final String DELETE_DELIVERYPERSON = "DELETE FROM delivery_person WHERE delivery_person_id = ?";

    @Override
    public ArrayList<DeliveryPerson> selectAllDeliveryPerson(int deliverypersonId) {
        //creating DeliveryPerson arraylist
        ArrayList<DeliveryPerson> deliverypersons = new ArrayList<>();
        
        try{

            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_DELIVERYPERSONS);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnDeliveryPersonId = rs.getInt("delivery_person_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                boolean isActive = rs.getBoolean("is_active");
                String isActiveStatus = isActive ? "Active" : "Inactive";
                
                DeliveryPerson deliveryperson = new DeliveryPerson(returnDeliveryPersonId, firstName, lastName, email, telNo, isActive, isActiveStatus);
                
                deliveryperson.setIsActiveStatus(isActiveStatus);
                
                deliverypersons.add(deliveryperson);
                
                //Polymorphism for deliveryperson myTask();
                deliveryperson.myTask();

            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return deliverypersons;
        

    }

    @Override
    public ArrayList<DeliveryPerson> selectDeliveryPerson(int deliverypersonId) {
       
                        //Cretaing deliveryperson arraylist
        ArrayList<DeliveryPerson> deliverypersons = new ArrayList<>();
        
        try{
            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_DELIVERYPERSON_BY_ID);
            stmt.setInt(1, deliverypersonId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnDeliveryPersonId = rs.getInt("delivery_person_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                boolean isActive = rs.getBoolean("is_active");
                String isActiveStatus = null;
                
                //DeliveryPerson deliveryperson = new DeliveryPerson(returnDeliveryPersonId, firstName, lastName, email, telNo, isActive,);
                            
                DeliveryPerson deliveryperson = new DeliveryPerson(returnDeliveryPersonId, firstName, lastName, email, telNo, isActive, isActiveStatus);
                     
                deliveryperson.setDeliveryPersonId(returnDeliveryPersonId);
                deliveryperson.setFirstName(firstName);
                deliveryperson.setLastName(lastName);
                deliveryperson.setEmail(email);
                deliveryperson.setTelNo(telNo);
                deliveryperson.setIsActive(isActive);
                
                deliveryperson.add(deliveryperson);       
                
                //Polymorphism for deliveryperson myTask();
                deliveryperson.myTask();
                
                System.out.println("\nSelected DeliveryPerson: " + deliveryperson.toString());
            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return deliverypersons;
        }

   @Override
    public boolean insertDeliveryPerson(DeliveryPerson deliveryperson) {
        
      System.out.println(INSERT_DELIVERYPERSON);
      boolean rowInserted = false;
      
      try{
          

          Connection con = DBConnectionManditha.getConnection();
          PreparedStatement stmt = con.prepareStatement(INSERT_DELIVERYPERSON);
          
          stmt.setString(1, deliveryperson.getFirstName()); 
          stmt.setString(2, deliveryperson.getLastName());
          stmt.setString(3, deliveryperson.getEmail());
          stmt.setString(4, deliveryperson.getTelNo());
          
          stmt.executeUpdate();
          
          //Polymorphism for deliveryperson myTask();
          deliveryperson.myTask();
          
          rowInserted = true;
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowInserted;
    }

    @Override
    public boolean updateDeliveryPerson(DeliveryPerson deliveryperson) {
        
      System.out.println(UPDATE_DELIVERYPERSON);
      boolean rowUpdate = false;
      
      try{
          

          Connection con = DBConnectionManditha.getConnection();
          PreparedStatement stmt = con.prepareStatement(UPDATE_DELIVERYPERSON);
          
          stmt.setString(1, deliveryperson.getFirstName());
          stmt.setString(2, deliveryperson.getLastName());
          stmt.setString(3, deliveryperson.getEmail());
          stmt.setString(4, deliveryperson.getTelNo());
          
          stmt.setInt(7, deliveryperson.getDeliveryPersonId());
          
          rowUpdate = stmt.executeUpdate() > 0;
          
          
          //Polymorphism for deliveryperson myTask();
          deliveryperson.myTask();
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowUpdate;
        
    }

    @Override
    public boolean deleteDeliveryPerson(int deliverypersonId) {
        
        System.out.println(DELETE_DELIVERYPERSON);
        boolean rowDelete = false;
        
        try{
            

            Connection con =  DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_DELIVERYPERSON);
            
            stmt.setInt(1, deliverypersonId);
            
            rowDelete = stmt.executeUpdate() > 0;
            
             DeliveryPerson deliveryperson = new DeliveryPerson();
            
            //Polymorphism for deliveryperson myTask();
            deliveryperson.myTask();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rowDelete;
        
    }
    
   
}
