/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.bs.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Group4 - Manditha
 */
public class DBConnectionImesh {
    
        private static String url = "jdbc:mysql://localhost:3306/onlinefoodorderingsystem";
        private static String user = "root";
        private static String password = "1234";
        
        //JDBC variable for opening, closing and managing connection
        private static Connection con = null;
        
        public static Connection getConnection(){
            
            try{
                
                //Load the jdbc Driver class dynamicaaly
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                //The Java DriverManager class's getConnection() method attempts to establish a connection to a database using the given database URL
                con = (Connection) DriverManager.getConnection(url, user, password);
                
            }catch(ClassNotFoundException | SQLException e){
                
                System.out.println("Database connectivity failed.");
                
            }
            
            return con;
        }
           
}
