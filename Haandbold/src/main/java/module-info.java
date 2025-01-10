module com.example.haandbold {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.haandbold to javafx.fxml;
    exports com.example.haandbold;
}