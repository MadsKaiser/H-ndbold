package com.example.handbold;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Loader Menu.fxml
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent menuRoot = menuLoader.load();
        primaryStage.setTitle("Menu");
        primaryStage.setScene(new Scene(menuRoot));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception {
        // Opretter databaseforbindelse
        DatabaseConnection.getConnection();

        // Starter applikationen
        launch(args);
    }
}