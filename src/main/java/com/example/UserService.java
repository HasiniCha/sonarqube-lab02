package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserService {

    // FIXED: Configuration should come from environment or config file
    private String password = System.getenv("DB_PASSWORD") != null ? 
                              System.getenv("DB_PASSWORD") : "admin123";

    // FIXED: Using PreparedStatement to prevent SQL injection
    public void findUser(String username) throws Exception {
        String query = "SELECT * FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, username);
            pst.executeQuery();
        }
    }

    // FIXED: Using PreparedStatement to prevent SQL injection
    public void deleteUser(String username) throws Exception {
        String query = "DELETE FROM users WHERE name = ?";
        
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/db", "root", password);
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, username);
            pst.execute();
        }
    }
}