package com.example.handbold;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        // Defining the connection string
        String connectionString =
                "jdbc:sqlserver://localhost:1433;databaseName=Hbold;user=Morten;password=Morten;encrypt=true;trustServerCertificate=true";

        Connection conn = null;

        try {
            // Trying to establish connection
            System.out.println("Connecting to database: Hbold...\n");
            conn = DriverManager.getConnection(connectionString);
            System.out.println("Connection successful!\n");
        } catch (SQLException e) {
            // Error handling that prints a stacktrace for debugging
            System.out.println("Could not connect to database: Hbold!\n");
            System.out.println(e.getMessage() + "\nSTACK TRACE: \n");
            e.printStackTrace();
        }

        return conn;
    }
}
