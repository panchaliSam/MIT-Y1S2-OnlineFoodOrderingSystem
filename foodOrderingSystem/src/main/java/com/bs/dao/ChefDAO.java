/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.java.com.bs.interfaces.IChefDAO;
import main.java.com.bs.model.Chef;
import main.java.com.bs.utility.DBConnectionImesh;

/**
 *
 * @author chathumi
 */
public class ChefDAO implements IChefDAO{
    
    private static final String SELECT_ALL_CHEFS = "SELECT chef_id, first_name, last_name, email, tel_no, specialiation, "
                                                    + "shift, is_active "
                                                    + "FROM chef";
   
   private static final String SELECT_CHEF_BY_ID = "SELECT chef_id, first_name, last_name, email, tel_no, specialiation, "
                                                    + "shift, is_active "
                                                    + "FROM chef "
                                                    + "WHERE chef_id = ?";

   private static final String INSERT_CHEF = "INSERT INTO chef(first_name, last_name, email, tel_no, specialiation, "
                                            + "shift)"
                                            + "VALUES(?, ?, ?, ?, ?, ?);";
   
   private static final String UPDATE_CHEF = "UPDATE chef SET first_name = ?, last_name = ?, email = ?, tel_no = ?, specialiation = ?, shift = ? WHERE chef_id = ?";
   
   private static final String DELETE_CHEF = "DELETE FROM chef WHERE chef_id = ?";

    @Override
    public ArrayList<Chef> selectAllChef(int chefId) {
                //Cretaing chef arraylist
        ArrayList<Chef> chefs = new ArrayList<>();
        
        try{
            Connection con = DBConnectionImesh.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_CHEFS);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnChefId = rs.getInt("chef_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                String specialiation = rs.getString("specialiation");
                String shift = rs.getString("shift");
                boolean isActive = rs.getBoolean("is_active");
                
                Chef chef = new Chef(returnChefId, firstName, lastName, email, telNo, specialiation, shift, isActive);
                
                chefs.add(chef);
                
                //Polymorphism for chef();
                chef.myTask();

            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return chefs;
    }

    @Override
    public ArrayList<Chef> selectChef(int chefId) {
                //Cretaing chef arraylist
        ArrayList<Chef> chefs = new ArrayList<>();
        
        try{
            Connection con = DBConnectionImesh.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_CHEF_BY_ID);
            stmt.setInt(1, chefId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnChefId = rs.getInt("chef_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                String specialiation = rs.getString("specialiation");
                String shift = rs.getString("shift");
                boolean isActive = rs.getBoolean("is_active");
                
               
                
                Chef chef = new Chef();
                
                chef.setChefId(returnChefId);
                chef.setFirstName(firstName);
                chef.setLastName(lastName);
                chef.setEmail(email);
                chef.setTelNo(telNo);
                chef.setspecialiation(specialiation);
                chef.setshift(shift);
                chef.setIsActive(isActive);
                
                chefs.add(chef);
                
                //Polymorphism for chef();
                chef.myTask();
                
                System.out.println("\nSelected Chef: " + chef.toString());              
            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return chefs;
        
    }

    @Override
    public boolean insertChef(Chef chef) {
        
        System.out.println(INSERT_CHEF);
        boolean rowInserted = false;
        
        try{
          
          Connection con = DBConnectionImesh.getConnection();
          PreparedStatement stmt = con.prepareStatement(INSERT_CHEF);
          
          stmt.setString(1, chef.getFirstName()); 
          stmt.setString(2,chef.getLastName());
          stmt.setString(3, chef.getEmail());
          stmt.setString(4, chef.getTelNo());
          stmt.setString(5, chef.getspecialiation());
          stmt.setString(6, chef.getshift());
          
          stmt.executeUpdate();
          
          //Polymorphism for chef myTask();
          chef.myTask();
          
          rowInserted = true;
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowInserted;
    }

    @Override
    public boolean updateChef(Chef chef) {
        System.out.println(UPDATE_CHEF);
        boolean rowUpdate = false;
        
        try{
          
          Connection con = DBConnectionImesh.getConnection();
          PreparedStatement stmt = con.prepareStatement(UPDATE_CHEF);
          
          stmt.setString(1, chef.getFirstName()); 
          stmt.setString(2,chef.getLastName());
          stmt.setString(3, chef.getEmail());
          stmt.setString(4, chef.getTelNo());
          stmt.setString(5, chef.getspecialiation());
          stmt.setString(6, chef.getshift());
          
          stmt.setInt(7, chef.getChefId());
          
          rowUpdate = stmt.executeUpdate() > 0;
          
          //Polymorphism for admin myTask();
          chef.myTask();
          
          rowUpdate = true;
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowUpdate;
    }

    @Override
    public boolean deleteChef(int chefId) {
        
        System.out.println(DELETE_CHEF);
        boolean rowDelete = false;
        
        try{
            
            Connection con =  DBConnectionImesh.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_CHEF);
            
            stmt.setInt(1, chefId);
            
            rowDelete = stmt.executeUpdate() > 0;
            
             Chef chef = new Chef();
            
            //Polymorphism for chefr myTask();
            chef.myTask();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rowDelete;
    }
    
    
    
}
