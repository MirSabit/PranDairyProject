package com.example.prandairyproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // SceneManager needs the primary stage before anything else loads,
        // so every controller's SceneManager.switchScene(...) call works.
        SceneManager.setPrimaryStage(stage);

        // TODO: point this at your team's real login FXML once it's merged
        // in, e.g. new FXMLLoader(HelloApplication.class.getResource("YourPackage/YourLogin.fxml"))
        // Loading the CEO dashboard directly for now so the app has
        // somewhere to start.
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CEO/CEODashboard.fxml"));
        Parent root = fxmlLoader.load();

        Scene scene = new Scene(root);
        stage.setTitle("Pran Dairy");
        stage.setScene(scene);
        stage.show();
    }
}
