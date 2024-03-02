/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
import java.sql.*;

public class MySQLTest {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Provide the connection details
            String url = "jdbc:mysql://localhost:3306/onlinefoodorderingsystem";
            String user = "root";
            String password = "2001chathu";

            // Establish the connection
            conn = DriverManager.getConnection(url, user, password);
            
            // Check if the connection is successful
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
            System.err.println("SQLState: " + e.getSQLState());
            System.err.println("VendorError: " + e.getErrorCode());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                System.err.println("SQLException: " + e.getMessage());
            }
        }
    }
}
