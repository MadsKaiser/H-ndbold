package com.example.handbold;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaveKampController {

    @FXML
    private ChoiceBox<String> HjemmeHoldValg;
    @FXML
    private Label HjemmeholdLabel;
    @FXML
    private Label KampOverskrift;
    @FXML
    private Button MenuKnap;
    @FXML
    private Button OpretKampKnap;
    @FXML
    private Label UdeHoldLabel;
    @FXML
    private ChoiceBox<String> UdeHoldValg;

    // Database oplysninger (tilpas disse efter din database)
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=hbold;encrypt=true;trustServerCertificate=true";
    private final String USER = "Morten";
    private final String PASSWORD = "Morten";

    @FXML
    public void initialize() {
        loadLigastillingData();
    }

    private void loadLigastillingData() {
        ObservableList<String> holdListe = FXCollections.observableArrayList();

        String sqlQuery = "SELECT navn FROM Ligastilling";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery)) {

            while (rs.next()) {
                holdListe.add(rs.getString("navn"));
            }

            HjemmeHoldValg.setItems(holdListe);
            UdeHoldValg.setItems(holdListe);

        } catch (SQLException e) {
            System.err.println("Fejl ved hentning af hold fra databasen: " + e.getMessage());
            e.printStackTrace();

            // Hvis der opstår en fejl, sættes tomme lister for at undgå fejl i UI
            HjemmeHoldValg.setItems(FXCollections.observableArrayList());
            UdeHoldValg.setItems(FXCollections.observableArrayList());
        }
    }

    @FXML
    private void OnOpretKampClick(ActionEvent event) {
        try {
            System.out.println("Opret Kamp knap klikket");

            // Hent det valgte hjemmehold og udehold
            String hjemmehold = HjemmeHoldValg.getValue();
            String udehold = UdeHoldValg.getValue();

            if (hjemmehold != null && udehold != null) {
                // Lukker nuværende vindue
                Stage currentStage = (Stage) OpretKampKnap.getScene().getWindow();
                currentStage.close();

                // Loader Kamp.fxml
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Kamp.fxml"));
                Parent root = loader.load();

                // Hent KampController instansen fra loaderen
                KampController kampController = loader.getController();

                // Send de valgte hold videre til KampController
                kampController.updateHomeTeamLabel(hjemmehold);
                kampController.updateAwayTeamLabel(udehold);

                // Opretter et nyt stage og viser det
                Stage secondStage = new Stage();
                secondStage.setTitle("Kamp");
                secondStage.setScene(new Scene(root));
                secondStage.show();
            } else {
                System.out.println("Vælg både hjemmehold og udehold.");
            }
        } catch (Exception e) {
            System.err.println("Fejl ved indlæsning af Kamp.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void OnMenuKnapClick(ActionEvent event) {
        try {
            System.out.println("Menu knap klikket");

            // Lukker nuværende vindue
            Stage currentStage = (Stage) MenuKnap.getScene().getWindow();
            currentStage.close();

            // Loader Menu.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();

            // Opretter et nyt stage og viser det
            Stage secondStage = new Stage();
            secondStage.setTitle("Menu");
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (Exception e) {
            System.err.println("Fejl ved indlæsning af Menu.fxml: " + e.getMessage());
            e.printStackTrace();
        }
    }
}