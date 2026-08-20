package com.techquiz.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    private static Connection connection;
    private static final Logger logger = Logger.getLogger(DBConnection.class.getName());
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            logger.log(Level.INFO,"Driver loaded successfully");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/techquiz", "techquiz", "techquiz");
            logger.log(Level.INFO,"Database connected successfully");
        } catch (Exception ex) {
            DBInitializer.destroy();
            logger.log(
                    Level.SEVERE,
                    "Cannot connect to database",
                    ex
            );
        }
    }
    public static Connection getConnection() {
        return connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
            logger.log(Level.INFO,"Connection closed successfully");
        }catch (SQLException ex) {
            logger.log(
                    Level.SEVERE,
                    "Error disconnecting from database",
                    ex
            );
        }
    }
}
