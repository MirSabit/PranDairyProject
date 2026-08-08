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

public class CampaignController {

    @FXML
    private TextField campaignNameTextField;

    @FXML
    private ComboBox<String> campaignTypeComboBox;

    @FXML
    private ComboBox<String> targetGroupComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TextField budgetTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableView<Campaign> campaignTableView;

    @FXML
    private TableColumn<Campaign, String> campaignIdColumn;

    @FXML
    private TableColumn<Campaign, String> campaignNameColumn;

    @FXML
    private TableColumn<Campaign, String> campaignTypeColumn;

    @FXML
    private TableColumn<Campaign, String> targetGroupColumn;

    @FXML
    private TableColumn<Campaign, Double> budgetColumn;

    @FXML
    private TableColumn<Campaign, String> statusColumn;

    private final ObservableList<Campaign> campaignList = FXCollections.observableArrayList();

    private int campaignCounter = 1;

    @FXML
    public void initialize() {

        campaignTypeComboBox.getItems().addAll(
                "Discount",
                "Festival",
                "Seasonal",
                "Product Launch"
        );

        targetGroupComboBox.getItems().addAll(
                "Retail",
                "Wholesale",
                "Corporate"
        );

        campaignIdColumn.setCellValueFactory(new PropertyValueFactory<>("campaignId"));
        campaignNameColumn.setCellValueFactory(new PropertyValueFactory<>("campaignName"));
        campaignTypeColumn.setCellValueFactory(new PropertyValueFactory<>("campaignType"));
        targetGroupColumn.setCellValueFactory(new PropertyValueFactory<>("targetGroup"));
        budgetColumn.setCellValueFactory(new PropertyValueFactory<>("budget"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        campaignTableView.setItems(campaignList);
    }

    @FXML
    public void onSaveButtonClick() {

        if (campaignNameTextField.getText().isEmpty()
                || campaignTypeComboBox.getValue() == null
                || targetGroupComboBox.getValue() == null
                || budgetTextField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Input Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill in all required fields.");
            alert.showAndWait();
            return;
        }

        Campaign campaign = new Campaign(
                "CMP-" + campaignCounter++,
                campaignNameTextField.getText(),
                campaignTypeComboBox.getValue(),
                targetGroupComboBox.getValue(),
                Double.parseDouble(budgetTextField.getText()),
                "Active"
        );

        campaignList.add(campaign);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("Campaign Saved Successfully.");
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
                getClass().getResource("MarketingOfficerDashboard.fxml")
        );

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Marketing Officer Dashboard");
        stage.show();
    }

    private void clearFields() {

        campaignNameTextField.clear();
        budgetTextField.clear();
        descriptionTextArea.clear();

        campaignTypeComboBox.setValue(null);
        targetGroupComboBox.setValue(null);

        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
    }
}