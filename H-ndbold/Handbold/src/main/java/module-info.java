module com.example.handbold {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.handbold;


    opens com.example.handbold to javafx.fxml;

}