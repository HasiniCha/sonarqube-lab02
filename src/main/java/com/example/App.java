package main.java.com.example;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        try {
            Calculator calc = new Calculator();
            System.out.println(calc.calculate(10, 5, "add"));
            
            UserService service = new UserService();
            service.findUser("admin");
            service.deleteUser("admin");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Database error occurred", e);
        }
    }
}