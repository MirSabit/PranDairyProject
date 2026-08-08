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

public class AdvertisementController {

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField linkTextField;

    @FXML
    private TextField imageTextField;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TableView<Advertisement> advertisementTableView;

    @FXML
    private TableColumn<Advertisement, String> advertisementIdColumn;

    @FXML
    private TableColumn<Advertisement, String> titleColumn;

    @FXML
    private TableColumn<Advertisement, String> typeColumn;

    @FXML
    private TableColumn<Advertisement, String> statusColumn;

    @FXML
    private TableColumn<Advertisement, String> startDateColumn;

    @FXML
    private TableColumn<Advertisement, String> endDateColumn;

    private final ObservableList<Advertisement> advertisementList =
            FXCollections.observableArrayList();

    private int advertisementCounter = 1;

    @FXML
    public void initialize() {

        typeComboBox.getItems().addAll(
                "Banner",
                "Popup",
                "Video",
                "Social Media"
        );

        statusComboBox.getItems().addAll(
                "Active",
                "Inactive"
        );

        advertisementIdColumn.setCellValueFactory(new PropertyValueFactory<>("advertisementId"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        advertisementTableView.setItems(advertisementList);
    }

    @FXML
    public void onSaveButtonClick() {

        if (titleTextField.getText().isEmpty()
                || typeComboBox.getValue() == null
                || statusComboBox.getValue() == null
                || startDatePicker.getValue() == null
                || endDatePicker.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required fields.");
            alert.showAndWait();
            return;
        }

        Advertisement advertisement = new Advertisement(
                "AD-" + advertisementCounter++,
                titleTextField.getText(),
                typeComboBox.getValue(),
                statusComboBox.getValue(),
                startDatePicker.getValue().toString(),
                endDatePicker.getValue().toString()
        );

        advertisementList.add(advertisement);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Advertisement Saved Successfully.");
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

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Marketing Officer Dashboard");
        stage.show();
    }

    private void clearFields() {

        titleTextField.clear();
        linkTextField.clear();
        imageTextField.clear();

        typeComboBox.setValue(null);
        statusComboBox.setValue(null);

        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
    }
}