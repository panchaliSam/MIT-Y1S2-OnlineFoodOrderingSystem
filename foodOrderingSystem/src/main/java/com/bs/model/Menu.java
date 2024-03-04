/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.model;

/**
 *
 * @author User
 */
public class Menu {
    
    private int itemId;
    private String menuName;
    private String description;
    private double price;
    private String category;
    private boolean isActive;
    
    //default constructor
    public Menu(){
    }
    
    
    //parametric constuctor
    public Menu(int itemId, String menuName, String description, int price, String category, boolean isActive) {
        this.itemId = itemId;
        this.menuName = menuName;
        this.description = description;
        this.price = price;
        this.category = category;
        this.isActive = isActive;
    }

    public Menu(int return_item_id, String menu_name, String desription, double price, String category, boolean _active) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //getter and setter for itemId
    public int getItemId() {
        return itemId;
    }
    
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
    
    //getter and setter for menuName
    public String getMenuName() {
        return menuName;
    }
    
    public void setManuName(String menuName) {
        this.menuName = menuName;
    }
    
    //getter and setter for description
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    //getter and setter for price
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    //getter and setter for category
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
       //getter and setter for isActive
    public boolean getIsActive() {
        return isActive;
    }
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    @Override
    public String toString() {
        return "Menu{" +
            "itemId=" + itemId +
            ", menuName='" + menuName + '\'' +
            ", description='" + description + '\'' +
            ", price='" + price + '\'' +
            ", category=" + category +
            ", isActive='" + isActive + 
            '}';
    }

   
}
