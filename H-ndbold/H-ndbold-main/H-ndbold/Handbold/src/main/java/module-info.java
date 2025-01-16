module com.example.handbold {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.handbold to javafx.fxml;
    exports com.example.handbold;
}