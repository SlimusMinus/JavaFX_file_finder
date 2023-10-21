module com.example.fxasync {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxasync to javafx.fxml;
    exports com.example.fxasync;
}