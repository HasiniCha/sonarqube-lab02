package main.java.com.example;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            System.out.println(calc.calculate(10, 5, "add"));
            
            UserService service = new UserService();
            service.findUser("admin");
            service.deleteUser("admin");
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}