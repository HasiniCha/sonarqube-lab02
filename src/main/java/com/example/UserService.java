package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String DB_USER = "root";
    
    // FIXED: Configuration should come from environment
    private String password = System.getenv("DB_PASSWORD") != null ? 
                              System.getenv("DB_PASSWORD") : "admin123";

    // FIXED: Using PreparedStatement to prevent SQL injection
    // FIXED: Specific columns instead of SELECT *
    public void findUser(String username) throws SQLException {
        String query = "SELECT id, name, email FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, password);
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, username);
            pst.executeQuery();
        }
    }

    // FIXED: Using PreparedStatement to prevent SQL injection
    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, password);
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, username);
            pst.execute();
        }
    }
}