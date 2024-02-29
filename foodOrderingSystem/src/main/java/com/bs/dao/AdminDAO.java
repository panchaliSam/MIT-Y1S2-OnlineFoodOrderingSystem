/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import main.java.com.bs.interfaces.IAdminDAO;
import main.java.com.bs.model.Admin;
import main.java.com.bs.utility.DBConnectionManditha;

/**
 *
 * @author Manditha Madushanka
 */
public class AdminDAO implements IAdminDAO{
    
    private static final String SELECT_ALL_ADMINS = "SELECT admin_id, owner_id, first_name, last_name, email, tel_no, role, "
                                                    + "user_name, password, registration_date, is_active "
                                                    + "FROM admin";
   
   private static final String SELECT_ADMIN_BY_ID = "SELECT admin_id, owner_id, first_name, last_name, email, tel_no, role, "
                                                    + "user_name, password, registration_date, is_active "
                                                    + "FROM admin "
                                                    + "WHERE admin_id = ?";

   private static final String INSERT_ADMIN = "INSERT INTO admin(owner_id, first_name, last_name, email, tel_no, role, "
                                            + "user_name, password)"
                                            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
   
   private static final String UPDATE_ADMIN = "UPDATE admin SET owner_id = ?, first_name = ?, last_name = ?, email = ?, tel_no = ?, role = ?, user_name = ?, password = ? WHERE admin_id = ?";
   
   private static final String DELETE_ADMIN = "DELETE FROM admin WHERE admin_id = ?";

    @Override
    public ArrayList<Admin> selectAllAdmin(int adminId) {
                //Cretaing admin arraylist
        ArrayList<Admin> admins = new ArrayList<>();
        
        try{
            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_ADMINS);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnAdminId = rs.getInt("customer_id");
                int ownerId = rs.getInt("owner_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                String role = rs.getString("role");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                LocalDateTime registrationDate = rs.getTimestamp("registration_date").toLocalDateTime();
                boolean isActive = rs.getBoolean("is_active");
                
                Admin admin = new Admin(returnAdminId, ownerId, firstName, lastName, email, telNo, role, userName, password, registrationDate, isActive);
                
                admins.add(admin);
                
                //Polymorphism for admin();
                admin.myTask();

            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return admins;
    }

    @Override
    public ArrayList<Admin> selectAdmin(int adminId) {
                //Cretaing admin arraylist
        ArrayList<Admin> admins = new ArrayList<>();
        
        try{
            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ADMIN_BY_ID);
            stmt.setInt(1, adminId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){

                int returnAdminId = rs.getInt("customer_id");
                int ownerId = rs.getInt("owner_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String telNo = rs.getString("tel_no");
                String role = rs.getString("role");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                LocalDateTime registrationDate = rs.getTimestamp("registration_date").toLocalDateTime();
                boolean isActive = rs.getBoolean("is_active");
                
                //Admin admin = new Admin(returnAdminId, ownerId, firstName, lastName, email, telNo, role, userName, password, registrationDate, isActive);
                
                Admin admin = new Admin();
                
                admin.setAdminId(returnAdminId);
                admin.setOwnerId(ownerId);
                admin.setFirstName(firstName);
                admin.setLastName(lastName);
                admin.setEmail(email);
                admin.setTelNo(telNo);
                admin.setRole(role);
                admin.setUserName(userName);
                admin.setPassword(password);
                admin.setRegistrationDate(registrationDate);
                admin.setIsActive(isActive);
                
                admins.add(admin);
                
                //Polymorphism for admin();
                admin.myTask();
                
                System.out.println("\nSelected Admin: " + admin.toString());              
            }
                        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return admins;
        
    }

    @Override
    public boolean insertAdmin(Admin admin) {
        
        System.out.println(INSERT_ADMIN);
        boolean rowInserted = false;
        
        try{
          
          Connection con = DBConnectionManditha.getConnection();
          PreparedStatement stmt = con.prepareStatement(INSERT_ADMIN);
          
          stmt.setInt(1, admin.getOwnerId());
          stmt.setString(2, admin.getFirstName()); 
          stmt.setString(3,admin.getLastName());
          stmt.setString(4, admin.getEmail());
          stmt.setString(5, admin.getTelNo());
          stmt.setString(6, admin.getRole());
          stmt.setString(7, admin.getUserName());
          stmt.setString(8, admin.getPassword());
          
          stmt.executeUpdate();
          
          //Polymorphism for admin myTask();
          admin.myTask();
          
          rowInserted = true;
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowInserted;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        System.out.println(UPDATE_ADMIN);
        boolean rowUpdate = false;
        
        try{
          
          Connection con = DBConnectionManditha.getConnection();
          PreparedStatement stmt = con.prepareStatement(UPDATE_ADMIN);
          
          stmt.setInt(1, admin.getOwnerId());
          stmt.setString(2, admin.getFirstName()); 
          stmt.setString(3,admin.getLastName());
          stmt.setString(4, admin.getEmail());
          stmt.setString(5, admin.getTelNo());
          stmt.setString(6, admin.getRole());
          stmt.setString(7, admin.getUserName());
          stmt.setString(8, admin.getPassword());
          
          stmt.setInt(9, admin.getAdminId());
          
          rowUpdate = stmt.executeUpdate() > 0;
          
          //Polymorphism for admin myTask();
          admin.myTask();
          
          rowUpdate = true;
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowUpdate;
    }

    @Override
    public boolean deleteAdmin(int adminId) {
        
        System.out.println(DELETE_ADMIN);
        boolean rowDelete = false;
        
        try{
            
            Connection con =  DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_ADMIN);
            
            stmt.setInt(1, adminId);
            
            rowDelete = stmt.executeUpdate() > 0;
            
             Admin admin = new Admin();
            
            //Polymorphism for customer myTask();
            admin.myTask();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rowDelete;
    }
    
    
    
}
