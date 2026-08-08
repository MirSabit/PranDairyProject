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

public class LoyaltyProgramController {

    @FXML
    private TextField programNameTextField;

    @FXML
    private ComboBox<String> programTypeComboBox;

    @FXML
    private TextField discountTextField;

    @FXML
    private TextField pointsTextField;

    @FXML
    private DatePicker expiryDatePicker;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TableView<LoyaltyProgram> loyaltyTableView;

    @FXML
    private TableColumn<LoyaltyProgram, String> programIdColumn;

    @FXML
    private TableColumn<LoyaltyProgram, String> programNameColumn;

    @FXML
    private TableColumn<LoyaltyProgram, String> programTypeColumn;

    @FXML
    private TableColumn<LoyaltyProgram, Double> discountColumn;

    @FXML
    private TableColumn<LoyaltyProgram, Integer> pointsColumn;

    private final ObservableList<LoyaltyProgram> loyaltyList =
            FXCollections.observableArrayList();

    private int programCounter = 1;

    @FXML
    public void initialize() {

        programTypeComboBox.getItems().addAll(
                "Silver",
                "Gold",
                "Platinum"
        );

        programIdColumn.setCellValueFactory(new PropertyValueFactory<>("programId"));
        programNameColumn.setCellValueFactory(new PropertyValueFactory<>("programName"));
        programTypeColumn.setCellValueFactory(new PropertyValueFactory<>("programType"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        pointsColumn.setCellValueFactory(new PropertyValueFactory<>("points"));

        loyaltyTableView.setItems(loyaltyList);
    }

    @FXML
    public void onSaveButtonClick() {

        if (programNameTextField.getText().isEmpty()
                || programTypeComboBox.getValue() == null
                || discountTextField.getText().isEmpty()
                || pointsTextField.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required fields.");
            alert.showAndWait();
            return;
        }

        LoyaltyProgram loyalty = new LoyaltyProgram(
                "LP-" + programCounter++,
                programNameTextField.getText(),
                programTypeComboBox.getValue(),
                Double.parseDouble(discountTextField.getText()),
                Integer.parseInt(pointsTextField.getText())
        );

        loyaltyList.add(loyalty);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Loyalty Program Saved Successfully.");
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

        programNameTextField.clear();
        discountTextField.clear();
        pointsTextField.clear();
        descriptionTextArea.clear();

        programTypeComboBox.setValue(null);
        expiryDatePicker.setValue(null);
    }
}