package com.example.handbold;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    void OnOpretHoldKnapClick(ActionEvent event) {

    }

}
