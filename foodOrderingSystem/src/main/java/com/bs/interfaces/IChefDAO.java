/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main.java.com.bs.interfaces;

import java.util.ArrayList;
import main.java.com.bs.model.Chef;

/**
 *
 * @author Group4 - chathumi 
 */
public interface IChefDAO {
    
        ArrayList<Chef>selectAllChef(int chefId);
    	ArrayList<Chef>selectChef(int chefId);
	public boolean insertChef (Chef chef);
	public boolean updateChef (Chef chef);
	public boolean deleteChef (int chefId);
        
}
