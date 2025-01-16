package com.example.handbold;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/handbold";
        String user = "Morten";
        String password = "Morten";
        return DriverManager.getConnection(url, user, password);
    }
}