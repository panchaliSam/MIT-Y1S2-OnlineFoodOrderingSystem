package main.java.com.bs.utility;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {  
        
        private static String url = "jdbc:mysql://localhost:3306/onlinefoodorderingsystem";
        private static String user = "root";
        private static String password = "*272617Ps*";
        
        //JDBC variable for opening, closing and managing connection
        private static Connection con = null;
        
        public static Connection getConnection(){
            
            try{
                
                Class.forName("com.mysql.jdbc.Driver");
                
                con = (Connection) DriverManager.getConnection(url, user, password);
                
            }catch(ClassNotFoundException | SQLException e){
                
                System.out.println("Database connectivity failed.");
                
            }
            
            return con;
        }

}

