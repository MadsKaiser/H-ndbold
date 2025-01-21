package com.example.handbold;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHelper {
    public static ObservableList<Hold> getTeams() {
        ObservableList<Hold> teams = FXCollections.observableArrayList();
        String query = "SELECT * FROM hold";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int points = resultSet.getInt("points");
                int position = resultSet.getInt("position");
                teams.add(new Hold(name, points, position));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teams;
    }
}