package com.example.handbold;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button LigaStillingKnap;

    @FXML
    private Button OpretHoldKnap;

    @FXML
    private Label MenuLabel;

    @FXML
    private Button OpretKampKnap;

    @FXML
    private void OnLigaStillingClick() {
        try {
            // Lukker nuværende vindue
            Stage currentStage = (Stage) LigaStillingKnap.getScene().getWindow();
            currentStage.close();

            // Loader LigaStilling.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Ligastilling.fxml"));
            Parent root = loader.load();

            // Opretter et nyt stage og viser det
            Stage secondStage = new Stage();
            secondStage.setTitle("Liga");
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void OnOpretKampClick(ActionEvent event) {
        try {
            // Lukker nuværende vindue
            Stage currentStage = (Stage) OpretKampKnap.getScene().getWindow();
            currentStage.close();

            // Loader Kamp.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LaveKamp.fxml"));
            Parent root = loader.load();

            // Opretter et nyt stage og viser det
            Stage secondStage = new Stage();
            secondStage.setTitle("LaveKamp");
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void OnOpretHoldKnapClick(ActionEvent event) {
        try {
            // Lukker nuværende vindue
            Stage currentStage = (Stage) OpretHoldKnap.getScene().getWindow();
            currentStage.close();

            // Loader Kamp.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OpretteHold.fxml"));
            Parent root = loader.load();

            // Opretter et nyt stage og viser det
            Stage secondStage = new Stage();
            secondStage.setTitle("OpretHold");
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}