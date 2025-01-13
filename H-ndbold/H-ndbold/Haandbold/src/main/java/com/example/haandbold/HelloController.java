package com.example.haandbold;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class HelloController {

    @FXML
    private Label HoldEt;

    @FXML
    private Label HoldTo;

    @FXML
    private Label KampTid;

    @FXML
    private ListView<?> KampUdskrift;

    @FXML
    private Label MålEt;

    @FXML
    private Button MålKnapEt;

    @FXML
    private Button MålKnapTo;

    @FXML
    private Label MålTo;

    @FXML
    private Button UdvisningKnapEt;

    @FXML
    private Button UdvisningknapTo;

    private int målCountEt = 0;
    private int målCountTo = 0;

    @FXML
    void OnBanClickEt(ActionEvent event) {

    }

    @FXML
    void OnBanClickTo(ActionEvent event) {

    }

    @FXML
    private void onGoalClickLeft() {
        // Øg tælleren og opdater label'en med den nye tællerværdi
        MålEt.setText(String.valueOf(++målCountEt));
    }

    @FXML
    private void onGoalClickRight() {
        // Øg tælleren og opdater label'en med den nye tællerværdi
        MålTo.setText(String.valueOf(++målCountTo));
    }

}
