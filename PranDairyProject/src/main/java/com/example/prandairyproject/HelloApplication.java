package com.example.prandairyproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("hello-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 1100, 720);

        stage.setTitle("PRAN Dairy Management System");

        // Application Icon (Optional)
        try {
            stage.getIcons().add(
                    new Image(
                            HelloApplication.class.getResourceAsStream(
                                    "/com/example/prandairyproject/images/pran_logo.png"
                            )
                    )
            );
        } catch (Exception e) {
            System.out.println("Application icon not found.");
        }

        stage.setScene(scene);

        stage.setResizable(false);

        stage.centerOnScreen();

        stage.show();

    }

    @Override
    public void stop() {
        System.out.println("Application Closed.");
    }

    public static void main(String[] args) {
        launch(args);
    }
}