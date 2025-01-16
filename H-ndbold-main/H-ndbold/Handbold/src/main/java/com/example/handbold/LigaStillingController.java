package com.example.handbold;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class LigaStillingController {

    @FXML
    private TableView<String> ligaStillingTable;
    @FXML
    private TableColumn<String, String> Holdnavn;

    @FXML
    public void initialize() {
        Holdnavn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()));
        ObservableList<String> holdNavne = FXCollections.observableArrayList(DatabaseHelper.getHoldNavne());
        ligaStillingTable.setItems(holdNavne);
    }
}