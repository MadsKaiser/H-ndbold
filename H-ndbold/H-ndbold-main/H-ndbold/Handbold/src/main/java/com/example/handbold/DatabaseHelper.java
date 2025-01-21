package com.example.handbold;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String query = "SELECT * FROM Ligastilling ORDER BY Point DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            int position = 1;
            while (resultSet.next()) {
                String name = resultSet.getString("navn");
                int points = resultSet.getInt("Point");
                teams.add(new Hold(name, points, position));
                position++;
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

    public static void updateTeamPoints(String teamName, int newPoints) {
        String query = "UPDATE Ligastilling SET Point = ? WHERE navn = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, newPoints);
            preparedStatement.setString(2, teamName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
