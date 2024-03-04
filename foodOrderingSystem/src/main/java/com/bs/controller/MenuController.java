/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.controller;

import main.java.com.bs.dao.MenuDAO;
import main.java.com.bs.interfaces.IMenuDAO;
import main.java.com.bs.model.Menu;


/**
 *
 * @author Miyulakshi
 */

public class MenuController {
    
    private final IMenuDAO menuDAO;

    public MenuController() {
        this.menuDAO = new MenuDAO();
    }
  
    public void addMenu(String menuName, String description, double price, String category){
        
        Menu menu = new Menu();
        
        menu.setManuName(menuName);
        menu.setDescription(description);
        menu.setPrice(price);
        menu.setCategory(category);
        menuDAO.insertMenu(menu);
            
    }
    
    public void updateMenu(int itemId, String menuName, String description, double price, String category){
        
        Menu menu = new Menu();
        
        menu.setItemId(itemId);
        menu.setManuName(menuName);
        menu.setDescription(description);
        menu.setPrice(price);
        menu.setCategory(category);
        menuDAO.updateMenu(menu);
        
    }
    
    public void deleteMenu(int itemId){
        
        menuDAO.deleteMenu(itemId);
    }
    
    public void selectMenu(int menuId){
        
        menuDAO.selectMenu(menuId);
    }
    
    
}
