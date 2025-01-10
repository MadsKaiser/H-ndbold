import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
 @Override
 public void start(Stage primaryStage) {
  // Create a button
  Button button = new Button("Click Me");
  button.setOnAction(e -> System.out.println("Hello, JavaFX!"));
  // Create a layout
  StackPane layout = new StackPane();
  layout.getChildren().add(button);

  // Create a scene
  Scene scene = new Scene(layout, 300, 200);

  // Set up the stage
  primaryStage.setTitle("Hello JavaFX");
  primaryStage.setScene(scene);
  primaryStage.show();
 }

 public static void main(String[] args) {
  launch(args); // Launch the application
 }
}