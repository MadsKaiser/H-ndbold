package com.example.handbold;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {

    @FXML
    private Label HoldEt;

    @FXML
    private Label HoldTo;

    @FXML
    private Label KampTid;

    @FXML
    private ListView<String> KampUdskrift;

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
    public void onGoalClickLeft(ActionEvent event) {
        String teamName = HoldEt.getText();

        // Øger antallet af mål og opdaterer MålLabel
        målCountEt++;
        MålEt.setText(String.valueOf(målCountEt));

        // Tilføjer mål til KampUdskrift
        KampUdskrift.getItems().add(0, teamName + " scorede ved " + String.format("%02d", timeElapsed) + " sekunder.");
    }
    @FXML
    public void onGoalClickRight(ActionEvent event) {
        String teamName = HoldTo.getText();

        // Øger antallet af mål og opdaterer MålLabel
        målCountTo++;
        MålTo.setText(String.valueOf(målCountTo));

        // Tilføjer mål til KampUdskrift
        KampUdskrift.getItems().add(0, teamName + " scorede ved " + String.format("%02d", timeElapsed) + " sekunder.");
    }

    @FXML
    public void OnBanClickLeft(ActionEvent event) {
        String teamName = HoldEt.getText();
        KampUdskrift.getItems().add(0, teamName + " fik udvisning " + String.format("%02d", timeElapsed) + " sekunder.");
    }
    @FXML
    public void OnBanClickRight(ActionEvent event) {
        String teamName = HoldTo.getText();
        KampUdskrift.getItems().add(0, teamName + " fik udvisning " + String.format("%02d", timeElapsed) + " sekunder.");
    }


    // Denne metode kan kaldes, når kampen er slut
    public void printKampUdskrift() {
        // Hent alle elementer fra KampUdskrift (ListView)
        ObservableList<String> items = KampUdskrift.getItems();

        // Opret en fil, hvor vi skal gemme kampens udskrift
        File file = new File("KampUdskrifte.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            // Skriv kampens udskrift til filen
            for (String item : items) {
                writer.write(item);
                writer.newLine();  // Tilføj en ny linje for hvert element
            }
            System.out.println("Kampens udskrift er gemt i filen 'KampUdskrift.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metode til at opdatere slutresultatet
    public void updateFinalScore() {
        // Hent værdierne fra labels
        String team1Score = MålEt.getText();  // Score for hold 1
        String team2Score = MålTo.getText(); // Score for hold 2

        // Opret slutresultat teksten
        String finalScore = "Slutstilling: " + team1Score + " - " + team2Score;

        // Tilføj slutresultatet øverst i KampUdskrift
        KampUdskrift.getItems().add(0, finalScore);
    }

    @FXML
    private void OnAfslutKamp(ActionEvent event) {
        updateFinalScore();  // Opdater listen med den endelige stilling
    }
}