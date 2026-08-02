package com.example.prandairyproject;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class HelloController {

    @FXML private ComboBox<String> roleComboBox;
    @FXML private TextField userIdTextField;
    @FXML private PasswordField passwordField;
    @FXML private TextField visiblePasswordField;
    @FXML private CheckBox showPasswordCheckBox;
    @FXML private CheckBox rememberMeCheckBox;
    @FXML private Hyperlink forgotPasswordLink;
    @FXML private Label statusLabel;
    @FXML private Label dateTimeLabel;
    @FXML private ImageView logoImageView;

    private final Map<String,User> users=new HashMap<>();

    @FXML
    public void initialize() {
        roleComboBox.getItems().addAll(
                "CEO","Inventory Manager","Marketing Officer","Accountant",
                "Quality Control Officer","Supplier","Customer","Customer Service Manager");

        users.put("1001",new User("1001","1234","CEO"));
        users.put("2001",new User("2001","1234","Inventory Manager"));
        users.put("3001",new User("3001","1234","Marketing Officer"));
        users.put("4001",new User("4001","1234","Accountant"));
        users.put("5001",new User("5001","1234","Quality Control Officer"));
        users.put("6001001",new User("6001001","1234","Supplier"));
        users.put("7001001",new User("7001001","1234","Customer"));
        users.put("8001",new User("8001","1234","Customer Service Manager"));

        try{
            logoImageView.setImage(new Image(getClass().getResourceAsStream(
                    "/com/example/prandairyproject/images/pran_logo.png")));
        }catch(Exception ignored){}

        Timeline t=new Timeline(new KeyFrame(Duration.seconds(1),e->
                dateTimeLabel.setText(LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss a")))));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();

        visiblePasswordField.textProperty().bindBidirectional(passwordField.textProperty());
    }

    @FXML
    private void onLoginButtonClick(ActionEvent e){
        String role=roleComboBox.getValue();
        String id=userIdTextField.getText().trim();
        String pw=passwordField.isVisible()?passwordField.getText():visiblePasswordField.getText();

        if(role==null){statusLabel.setText("Please select a role.");return;}
        if(!(id.matches("\\d{4}")||id.matches("\\d{7}"))){statusLabel.setText("User ID must be 4 or 7 digits.");return;}
        User u=users.get(id);
        if(u==null){statusLabel.setText("User not found.");return;}
        if(!u.role.equals(role)){statusLabel.setText("Role does not match.");return;}
        if(!u.password.equals(pw)){statusLabel.setText("Incorrect password.");return;}
        statusLabel.setText("Login Successful");

        String path=switch(role){
            case "Marketing Officer"->"/com/example/prandairyproject/Marketing_Officer/MarketingOfficerDashboard.fxml";
            case "Accountant"->"/com/example/prandairyproject/Accountant/AccountantDashboard.fxml";
            case "CEO"->"/com/example/prandairyproject/CEO/CEODashboard.fxml";
            case "Inventory Manager"->"/com/example/prandairyproject/Inventory/InventoryDashboard.fxml";
            case "Quality Control Officer"->"/com/example/prandairyproject/Quality/QualityDashboard.fxml";
            case "Supplier"->"/com/example/prandairyproject/Supplier/SupplierDashboard.fxml";
            case "Customer"->"/com/example/prandairyproject/Customer/CustomerDashboard.fxml";
            default->"/com/example/prandairyproject/CustomerService/CustomerServiceDashboard.fxml";
        };
        loadScene(path,e);
    }

    @FXML private void onClearButtonClick(ActionEvent e){
        roleComboBox.getSelectionModel().clearSelection();
        userIdTextField.clear(); passwordField.clear(); visiblePasswordField.clear();
        rememberMeCheckBox.setSelected(false); showPasswordCheckBox.setSelected(false);
        passwordField.setVisible(true); passwordField.setManaged(true);
        visiblePasswordField.setVisible(false); visiblePasswordField.setManaged(false);
        statusLabel.setText("");
    }

    @FXML private void onExitButtonClick(ActionEvent e){
        ((Stage)statusLabel.getScene().getWindow()).close();
    }

    @FXML private void onShowPasswordClick(){
        boolean show=showPasswordCheckBox.isSelected();
        visiblePasswordField.setVisible(show);
        visiblePasswordField.setManaged(show);
        passwordField.setVisible(!show);
        passwordField.setManaged(!show);
    }

    @FXML private void onForgotPasswordClick(){
        new Alert(Alert.AlertType.INFORMATION,"Please contact the System Administrator.")
                .showAndWait();
    }

    private void loadScene(String fxml,ActionEvent e){
        try{
            Parent root=FXMLLoader.load(getClass().getResource(fxml));
            Stage s=(Stage)((Button)e.getSource()).getScene().getWindow();
            s.setScene(new Scene(root));
            s.show();
        }catch(IOException ex){
            statusLabel.setText("Dashboard not available.");
        }
    }

    private static class User{
        String id,password,role;
        User(String i,String p,String r){id=i;password=p;role=r;}
    }
}