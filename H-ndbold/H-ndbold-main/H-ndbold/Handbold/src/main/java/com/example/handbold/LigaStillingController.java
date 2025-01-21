package com.example.handbold;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class LigaStillingController {

    @FXML
    private TableView<Hold> ligaStillingTable;
    @FXML
    private TableColumn<Hold, String> holdnavn;
    @FXML
    private TableColumn<Hold, Integer> point;
    @FXML
    private TableColumn<Hold, Integer> placering;
    @FXML
    private Button PrintKnap;
    @FXML
    private Button MenuKnap;

    public void initialize() {
        holdnavn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        point.setCellValueFactory(new PropertyValueFactory<>("point"));
        placering.setCellValueFactory(new PropertyValueFactory<>("placering"));

        ObservableList<Hold> hold = DatabaseHelper.getTeams();
        ligaStillingTable.setItems(hold);
    }

    @FXML
    private void OnMenuKnapClick(ActionEvent event) {
        try {
            Stage currentStage = (Stage) MenuKnap.getScene().getWindow();
            currentStage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
            Parent root = loader.load();

            Stage secondStage = new Stage();
            secondStage.setTitle("Menu");
            secondStage.setScene(new Scene(root));
            secondStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void OnPrintKnapClick() {
        // Existing code for printing
    }
}