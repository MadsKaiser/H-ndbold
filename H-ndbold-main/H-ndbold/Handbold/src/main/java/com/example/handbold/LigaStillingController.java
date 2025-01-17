package com.example.handbold;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LigaStillingController {

    @FXML
    private TableView<String> ligaStillingTable;
    @FXML
    private Button PrintKnap;
    @FXML
    private Button MenuKnap;

    @FXML
    private TableColumn<String, String> holdnavn;

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
    public void OnPrintKnapClick() {
        // Hent alle elementer fra Liga (TableView)
        ObservableList<String> items = ligaStillingTable.getItems();

        // Opret en fil, hvor vi skal gemme Ligaens udskrift
        File file = new File("LigaStilling.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Skriv Ligaens udskrift til filen
            for (String item : items) {
                writer.write(item);
                writer.newLine();  // Tilføj en ny linje for hvert element
            }
            System.out.println("Ligaens stilling er gemt i filen 'LigaStilling.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    }