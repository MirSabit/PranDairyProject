package com.example.prandairyproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> roleComboBox;

    @FXML
    public void initialize() {

        roleComboBox.getItems().addAll(
                "Marketing Officer",
                "Accountant"
        );

    }

    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {

        String role = roleComboBox.getValue();

        if (role == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select a role.");
            alert.show();
            return;
        }

        Parent root;

        if (role.equals("Marketing Officer")) {

            root = FXMLLoader.load(getClass().getResource(
                    "/com/example/prandairyproject/Marketing_Officer/MarketingOfficerDashboard.fxml"));

        } else {

            root = FXMLLoader.load(getClass().getResource(
                    "/com/example/prandairyproject/Accountant/AccountantDashboard.fxml"));

        }

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();

    }

}