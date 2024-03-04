/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main.java.com.bs.interfaces;

import java.util.ArrayList;
import main.java.com.bs.model.Menu;

/**
 *
 * @author User
 */
public interface IMenuDAO {
    
    ArrayList<Menu>selectAllMenu(int itemId);
    ArrayList<Menu>selectMenu(int itemId);
    public boolean insertMenu(Menu menu);
    public boolean updateMenu(Menu menu);
    public boolean deleteMenu(int itemId);
    
}
