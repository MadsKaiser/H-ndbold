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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LigaStilling.fxml"));
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
    void OnOpretKampClick(ActionEvent event) {

    }
}


