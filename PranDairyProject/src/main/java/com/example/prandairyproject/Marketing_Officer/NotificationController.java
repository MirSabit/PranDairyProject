package com.example.prandairyproject.Marketing_Officer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class NotificationController {

    @FXML
    private TextField titleTextField;

    @FXML
    private ComboBox<String> recipientComboBox;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private DatePicker sendDatePicker;

    @FXML
    private TableView<Notification> notificationTableView;

    @FXML
    private TableColumn<Notification, String> notificationIdColumn;

    @FXML
    private TableColumn<Notification, String> titleColumn;

    @FXML
    private TableColumn<Notification, String> recipientColumn;

    @FXML
    private TableColumn<Notification, String> sendDateColumn;

    @FXML
    private TableColumn<Notification, String> statusColumn;

    private final ObservableList<Notification> notificationList =
            FXCollections.observableArrayList();

    private int notificationCounter = 1;

    @FXML
    public void initialize() {

        recipientComboBox.getItems().addAll(
                "All Customers",
                "Premium Customers",
                "New Customers"
        );

        notificationIdColumn.setCellValueFactory(new PropertyValueFactory<>("notificationId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        recipientColumn.setCellValueFactory(new PropertyValueFactory<>("recipient"));
        sendDateColumn.setCellValueFactory(new PropertyValueFactory<>("sendDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        notificationTableView.setItems(notificationList);
    }

    @FXML
    public void onSendButtonClick() {

        if (titleTextField.getText().isEmpty()
                || recipientComboBox.getValue() == null
                || messageTextArea.getText().isEmpty()
                || sendDatePicker.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required fields.");
            alert.showAndWait();
            return;
        }

        Notification notification = new Notification(
                "NT-" + notificationCounter++,
                titleTextField.getText(),
                recipientComboBox.getValue(),
                sendDatePicker.getValue().toString(),
                "Sent"
        );

        notificationList.add(notification);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Notification Sent Successfully.");
        alert.showAndWait();

        clearFields();
    }

    @FXML
    public void onClearButtonClick() {
        clearFields();
    }

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("MarketingOfficerDashboard.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Marketing Officer Dashboard");
        stage.show();
    }

    private void clearFields() {

        titleTextField.clear();
        messageTextArea.clear();

        recipientComboBox.setValue(null);

        sendDatePicker.setValue(null);
    }
}