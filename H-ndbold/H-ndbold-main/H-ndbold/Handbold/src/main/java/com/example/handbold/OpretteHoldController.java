package com.example.handbold;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OpretteHoldController {

    @FXML
    private TextField IndtastHoldText;
    @FXML
    private Button MenuKnap;
    @FXML
    private Button OpretHoldKnap;

    @FXML
    void OnIndtastHoldClick(ActionEvent event) {

    }
    @FXML
    private TextField nameField;
    @FXML
    public void initialize() {
        // Sørg for at fx:id matcher præcist med FXML
        if (nameField != null) {
            nameField.setText("Indtast dit navn her...");
        } else {
            System.out.println("TextField er ikke initialiseret korrekt!");
        }
    }

    @FXML
    private void OnMenuKnapClick(ActionEvent event) {
        try {
            // Lukker nuværende vindue
            Stage currentStage = (Stage) MenuKnap.getScene().getWindow();
            currentStage.close();

            // Loader Kamp.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();

            // Opretter et nyt stage og viser det
            Stage secondStage = new Stage();
            secondStage.setTitle("Menu");
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private TextField getNameField;

    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;database=hbold";

    @FXML
    public void OnOpretHoldKnapClick(ActionEvent event) {
        String teamName = nameField.getText();

        // Validate that the input is not blank
        if (teamName.isBlank()) {
            showAlert("Fejl", "Holdnavn kan ikke være tomt!");
            return;
        }

        // Database operation
        try (Connection conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=hbold;user=mikkel;password=mikkel;encrypt=true;trustServerCertificate=true");
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO Ligastilling (navn) VALUES (?)")) {

            // Set parameter for prepared statement
            pstmt.setString(1, teamName);

            // Execute the update and check rows affected
            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                showAlert("Succes", "Holdet blev oprettet!");
                nameField.clear();
                System.out.println("Holdet " + teamName + " blev oprettet!");
            } else {
                showAlert("Fejl", "Holdet kunne ikke oprettes.");
            }

        } catch (SQLException e) {
            // Improved error handling with detailed message
            e.printStackTrace();
            showAlert("Database Fejl", "Kunne ikke oprette forbindelse til databasen: " + e.getMessage());
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
