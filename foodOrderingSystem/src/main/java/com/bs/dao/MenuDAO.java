/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.dao;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import main.java.com.bs.interfaces.IMenuDAO;
import main.java.com.bs.model.Menu;

import main.java.com.bs.utility.DBConnectionManditha;

/**
 *
 * @author Group4
 */
public class MenuDAO implements IMenuDAO{

private static final String SELECT_ALL_MENU = "SELECT item_id, menu_name, description, price, category, "
                                                    + "is_active "
                                                    + "FROM menu";
    
private static final String SELECT_ALL_MENU_BY_ID = "SELECT item_id, menu_name, description, price, category, "
                                                    + "is_active "
                                                    + "FROM menu "
                                                    + "WHERE item_id = ?";

    
    private static final String INSERT_MENU = "INSERT INTO menu(menu_name, description, price, category) "
                                            + "VALUES(?, ?, ?, ?);";
    
    private static final String UPDATE_MENU = "UPDATE menu SET  menu_name = ?, description = ?, price = ?, category = ?  WHERE item_id = ?"; 
    
    private static final String DELETE_MENU = "DELETE FROM menu WHERE item_id = ?";

   
    @Override
    public ArrayList<Menu> selectAllMenu(int itemId) {
        
        ArrayList<Menu> menus = new ArrayList<>();
        
        try{

            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_MENU);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                int return_item_id = rs.getInt("item_id");
                String menu_name = rs.getString("menu_name");
                String desription = rs.getString("desription");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                boolean is_active = rs.getBoolean("is_active");
               
                
                Menu menu = new Menu(return_item_id, menu_name, desription, price, category , is_active );
               
                
                menus.add(menu);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return menus;
    }

    @Override
    public ArrayList<Menu> selectMenu(int itemId) {
        
        ArrayList<Menu> menus = new ArrayList<>();
        
        try{

            Connection con = DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_MENU_BY_ID);
            stmt.setInt(1, itemId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
               
                int return_item_id = rs.getInt("item_id");
                String menu_name = rs.getString("menu_name");
                String desription = rs.getString("description");
                double price = rs.getDouble("price");
                String category = rs.getString("category");
                boolean is_active = rs.getBoolean("is_active");
                
                Menu menu = new Menu();
                
                menu.setItemId(return_item_id);
                menu.setManuName(menu_name);
                menu.setDescription(desription);
                menu.setPrice(price);
                menu.setCategory(category);
                menu.setIsActive(is_active);
                             
                             
                menus.add(menu);
                
                System.out.println("\nSelected Menu: " + menu.toString());
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return menus;
    }

    @Override
    public boolean insertMenu(Menu menu) {
       System.out.println(INSERT_MENU);
      boolean rowInserted = false;
      
      try{
          

          Connection con = DBConnectionManditha.getConnection();
          PreparedStatement stmt = con.prepareStatement(INSERT_MENU);
          
          stmt.setString(1, menu.getMenuName());
          stmt.setString(2, menu.getDescription());
          stmt.setDouble(3, menu.getPrice()); 
          stmt.setString(4, menu.getCategory());       
          
          stmt.executeUpdate();    
          
          rowInserted = true;
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowInserted;
    }

    @Override
    public boolean updateMenu(Menu menu) {
        
       System.out.println(UPDATE_MENU);
      boolean rowUpdate = false;
      
      try{
          

          Connection con = DBConnectionManditha.getConnection();
          PreparedStatement stmt = con.prepareStatement(UPDATE_MENU);
                    
          
          stmt.setString(1, menu.getMenuName());
          stmt.setString(2, menu.getDescription());
          stmt.setDouble(3, menu.getPrice()); 
          stmt.setString(4, menu.getCategory());
          
          stmt.setInt(5, menu.getItemId());
          
          rowUpdate = stmt.executeUpdate() > 0;
          
         
          
      }catch(Exception e){
          e.printStackTrace();
      }
        
      return rowUpdate; 
    }

    @Override
    public boolean deleteMenu(int itemId) {
       
        System.out.println(DELETE_MENU);
        boolean rowDelete = false;
        
        try{
            

            Connection con =  DBConnectionManditha.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_MENU);
            
            stmt.setInt(1, itemId);
            
            rowDelete = stmt.executeUpdate() > 0;
            
             
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rowDelete;
    }
    
    
}
