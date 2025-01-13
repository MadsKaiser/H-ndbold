package com.example.haandbold;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.util.Duration;

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

    @FXML
    private Button StartKnap;

    private int målCountEt = 0;
    private int målCountTo = 0;

    private Timeline timeline;
    private int timeElapsed = 0;
    private boolean running = false;

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

    @FXML
    public void OnStartClick(ActionEvent event) {
        if (running) {
            // Stopper timeren og nulstiller
            timeline.stop();
            timeElapsed = 0;
            KampTid.setText("00");
            StartKnap.setText("Start");
            running = false;
        } else {
            // Starter timeren
            timeElapsed = 0;
            KampTid.setText("00");
            running = true;
            StartKnap.setText("Stop");

            timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
                timeElapsed++;
                KampTid.setText(String.format("%02d", timeElapsed)); // Formatterer tallet med to cifre
                if (timeElapsed >= 30) {
                    timeline.stop();
                    StartKnap.setText("Start");
                    running = false;
                }
            }));

            timeline.setCycleCount(30);
            timeline.play();
        }
    }
    @FXML
    public void ongoalClickLeft(ActionEvent event) {
        String HoldEt = HoldEt.getText();
        KampUdskrift.setText(KampUdskrift.getText() + "\n" + HoldEt + " scorede ved " + String.format("%02d", timeElapsed) + " sekunder.");
    }
    }