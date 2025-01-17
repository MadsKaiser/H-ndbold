package com.example.handbold;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;database=hbold";
        String user = "Mads";
        String password = "Hestfisk100";
        return DriverManager.getConnection(url, user, password);
    }
}