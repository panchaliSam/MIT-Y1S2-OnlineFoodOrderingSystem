/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.controller;

import main.java.com.bs.dao.OrderDAO;
import main.java.com.bs.interfaces.IOrderDAO;
import main.java.com.bs.model.Order;

/**
 *
 * @author Group 4 - Ama
 */
public class OrderController {
    
    private final IOrderDAO orderDAO;
    
    public OrderController(){
        
        this.orderDAO = new OrderDAO();
    }
    
    public void addOrder(String recAddress, String sendAddress, double totalAmount, boolean orderStatus){
        Order order = new Order();
        order.setRecAddress(recAddress);
        order.setSendAddress(sendAddress);
        order.setTotalAmount(totalAmount);
        order.setOrderStatus(orderStatus);
        orderDAO.insertOrder(order);
        
    }
    
    public void updateOrder(int orderId, int customerId, String recAddress, String sendAddress, double totalAmount, boolean orderStatus){
        Order order = new Order();
        order.setOrderId(orderId);
        order.setCustomerId(customerId);
        order.setRecAddress(recAddress);
        order.setSendAddress(sendAddress);
        order.setTotalAmount(totalAmount);
        order.setOrderStatus(orderStatus);
        orderDAO.updateOrder(order);
        
    }
    
    public void deleteOrder(int orderId){
        orderDAO.deleteOrder(orderId);
    }
    
    public void selectOrder(int orderId){
        orderDAO.selectOrder(orderId);
    }
    
}
