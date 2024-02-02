package org.example.mokkiproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AreaApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AreaApplication.class.getResource("area-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Mokki-project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}