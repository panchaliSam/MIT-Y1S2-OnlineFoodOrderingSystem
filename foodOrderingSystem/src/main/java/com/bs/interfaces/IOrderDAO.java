/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main.java.com.bs.interfaces;

/**
 *
 * @author amahitiarachchi
 */

import java.util.ArrayList;
import main.java.com.bs.model.Order;

public interface IOrderDAO {
    
     //retreive all the orders for a specific customer
        ArrayList<Order>selectAllOrders(int orderId);
        
        //retreive specific order for a specific customer
    	ArrayList<Order>selectOrder(int orderId);
        
	public boolean insertOrder (Order order);
        
	public boolean updateOrder (Order order);
        
	public boolean deleteOrder (int orderId);
    
}
