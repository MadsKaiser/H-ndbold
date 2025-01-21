package com.example.handbold;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseHelper {
    public static ObservableList<Hold> getTeams() {
        ObservableList<Hold> teams = FXCollections.observableArrayList();
        String query = "SELECT * FROM Ligastilling";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("navn");
                int points = resultSet.getInt("Point");
                int position = resultSet.getInt("Placering");
                teams.add(new Hold(name, points, position));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return teams;
    }
    public static List<String> getHoldNavne() {
        List<String> holdNavne = new ArrayList<>();
        String query = "SELECT navn FROM Hold";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                String name = resultSet.getString("navn");
                holdNavne.add(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return holdNavne;
    }
}
