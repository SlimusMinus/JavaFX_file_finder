package com.example.fxasync;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXAsync extends Application {
    public static ObservableList<String> items = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(JavaFXAsync.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 550, 500);
        stage.setTitle("Simple finder!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}