/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import main.java.com.bs.interfaces.IOrderDAO;
import main.java.com.bs.model.Order;
import main.java.com.bs.utility.DBConnectionPanchali;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Group 4 - Ama
 */
        
public class OrderDAO implements IOrderDAO {
    
    private static final String SELECT_ALL_ORDERS ="SELECT order_id, customer_id, order_date, "
                                                  + "rec_address, send_address, total_amount, order_status, is_active "
                                                  + "FROM orders";
    
private static final String SELECT_ORDER_BY_ID = "SELECT order_id, customer_id, order_date, "
                                                   + "rec_address, send_address, total_amount, order_status, is_active "
                                                   + "FROM orders "
                                                   + "WHERE order_id = ?";
  
    
    private static final String INSERT_ORDER = "INSERT INTO orders(customer_id, rec_address, send_address, total_amount, order_status) "
                                             + "VALUES(?, ?, ?, ?, ?);";
    
    private static final String UPDATE_ORDER = "UPDATE orders SET rec_address = ?, send_address = ?, total_amount = ?, order_status = ? WHERE customer_id = ? AND order_id = ?";
   
    private static final String DELETE_ORDER = "DELETE FROM orders WHERE order_id = ?";

    @Override
    public ArrayList<Order> selectAllOrders(int orderId) {
       //creating order arraylist
        ArrayList<Order> orders = new ArrayList<>();
        
        try{
            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ALL_ORDERS);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                int returnOrderId = rs.getInt("order_id");
                int returnCusId =  rs.getInt("customer_id");
                LocalDateTime orderDate = rs.getTimestamp("order_date").toLocalDateTime();
                String recAddress = rs.getString("rec_address");
                String sendAddress = rs.getString("send_address");
                double totalAmount = rs.getDouble("total_amount");
                boolean orderStatus = rs.getBoolean("order_status");
                boolean isActive = rs.getBoolean("is_active");
                String isActiveStatus = isActive ? "Active" : "Inactive";
                
                Order order = new Order(returnOrderId,returnCusId,orderDate, recAddress, sendAddress, totalAmount, orderStatus, isActive, isActiveStatus );
                
                order.setIsActiveStatus(isActiveStatus);
                
                orders.add(order);
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return orders;
    }

    @Override
    public ArrayList<Order> selectOrder(int orderId) {
        //creating order arraylist
        ArrayList<Order> orders = new ArrayList<>();
        
        try{
            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_ORDER_BY_ID);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                int returnOrderId = rs.getInt("order_id");
                int returnCusId =  rs.getInt("customer_id");
                LocalDateTime orderDate = rs.getTimestamp("order_date").toLocalDateTime();
                String recAddress = rs.getString("rec_address");
                String sendAddress = rs.getString("send_address");
                double totalAmount = rs.getDouble("total_amount");
                boolean orderStatus = rs.getBoolean("order_status");
                boolean isActive = rs.getBoolean("is_active");
                
                
                //Order order = new Order(returnOrderId,orderDate, recAddress, sendAddress, totalAmount, orderStatus, isActive, isActiveStatus );
                
                Order order = new Order();
               
                order.setOrderId(returnOrderId);
                order.setCustomerId(returnCusId);
                order.setOrderDate(orderDate);
                order.setRecAddress(recAddress);
                order.setSendAddress(sendAddress);
                order.setTotalAmount(totalAmount);
                order.setOrderStatus(orderStatus);
                order.setIsActive(isActive);
                
                orders.add(order);
                
                System.out.println("\nSelected Order: " + order.toString());
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return orders;
    }

    @Override
    public boolean insertOrder(Order order) {
        System.err.append(INSERT_ORDER);
        boolean rowInserted = false;
        
        try{
            
            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(INSERT_ORDER);
            
            stmt.setInt(1, order.getCustomerId());
            stmt.setString(2, order.getRecAddress());
            stmt.setString(3, order.getSendAddress());
            stmt.setDouble(4, order.getTotalAmount());
            stmt.setBoolean(5, order.getOrderStatus());
            
            stmt.executeUpdate();
            
            rowInserted = true;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rowInserted;
    }

    @Override
    public boolean updateOrder(Order order) {
        System.err.append(UPDATE_ORDER);
        boolean rowUpdate = false;
        
        try{
            
            Connection con = DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(UPDATE_ORDER);
            
            
            stmt.setString(1, order.getRecAddress());
            stmt.setString(2, order.getSendAddress());
            stmt.setDouble(3, order.getTotalAmount());
            stmt.setBoolean(4, order.getOrderStatus());
            
            stmt.setInt(5, order.getCustomerId());
            stmt.setInt(6, order.getOrderId());
            
            rowUpdate = stmt.executeUpdate() > 0;
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return rowUpdate;
        
    }

    @Override
    public boolean deleteOrder(int orderId) {
        System.out.println(DELETE_ORDER);
        boolean rowDelete = false; 
        
        try{
            Connection con =  DBConnectionPanchali.getConnection();
            PreparedStatement stmt = con.prepareStatement(DELETE_ORDER);
            
            stmt.setInt(1, orderId);
            
            rowDelete = stmt.executeUpdate() > 0;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return rowDelete;
    }
    
    
}