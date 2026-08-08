package com.example.prandairyproject.Accountant;

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

public class BudgetManagementController {

    @FXML
    private ComboBox<String> monthComboBox;

    @FXML
    private TextField rawMaterialsTextField;

    @FXML
    private TextField equipmentTextField;

    @FXML
    private TextField utilitiesTextField;

    @FXML
    private TextField salaryTextField;

    @FXML
    private TextField transportTextField;

    @FXML
    private TextField marketingTextField;

    @FXML
    private TableView<Budget> budgetTableView;

    @FXML
    private TableColumn<Budget, String> monthColumn;

    @FXML
    private TableColumn<Budget, Double> rawMaterialsColumn;

    @FXML
    private TableColumn<Budget, Double> equipmentColumn;

    @FXML
    private TableColumn<Budget, Double> utilitiesColumn;

    @FXML
    private TableColumn<Budget, Double> salaryColumn;

    @FXML
    private TableColumn<Budget, Double> transportColumn;

    @FXML
    private TableColumn<Budget, Double> marketingColumn;

    @FXML
    private TableColumn<Budget, Double> totalColumn;

    private final ObservableList<Budget> budgetList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        monthComboBox.getItems().addAll(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        );

        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        rawMaterialsColumn.setCellValueFactory(new PropertyValueFactory<>("rawMaterials"));
        equipmentColumn.setCellValueFactory(new PropertyValueFactory<>("equipment"));
        utilitiesColumn.setCellValueFactory(new PropertyValueFactory<>("utilities"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        transportColumn.setCellValueFactory(new PropertyValueFactory<>("transport"));
        marketingColumn.setCellValueFactory(new PropertyValueFactory<>("marketing"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        budgetTableView.setItems(budgetList);
    }

    @FXML
    public void onSaveButtonClick() {

        if (monthComboBox.getValue() == null) {
            showAlert("Please select a month.");
            return;
        }

        try {

            double raw = Double.parseDouble(rawMaterialsTextField.getText());
            double equip = Double.parseDouble(equipmentTextField.getText());
            double util = Double.parseDouble(utilitiesTextField.getText());
            double sal = Double.parseDouble(salaryTextField.getText());
            double trans = Double.parseDouble(transportTextField.getText());
            double market = Double.parseDouble(marketingTextField.getText());

            if (raw < 0 || equip < 0 || util < 0 || sal < 0 || trans < 0 || market < 0) {
                showAlert("Budget amounts cannot be negative.");
                return;
            }

            double total = raw + equip + util + sal + trans + market;

            Budget budget = new Budget(
                    monthComboBox.getValue(),
                    raw,
                    equip,
                    util,
                    sal,
                    trans,
                    market,
                    total
            );

            budgetList.add(budget);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Budget saved successfully.\nTotal Budget: BDT " + total);
            alert.showAndWait();

            clearFields();

        } catch (NumberFormatException e) {

            showAlert("Please enter valid numeric values.");

        }

    }

    @FXML
    public void onClearButtonClick() {

        clearFields();

    }

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("AccountantDashboard.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.setTitle("Accountant Dashboard");

        stage.show();

    }

    private void clearFields() {

        monthComboBox.setValue(null);

        rawMaterialsTextField.clear();
        equipmentTextField.clear();
        utilitiesTextField.clear();
        salaryTextField.clear();
        transportTextField.clear();
        marketingTextField.clear();

    }

    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();

    }

}