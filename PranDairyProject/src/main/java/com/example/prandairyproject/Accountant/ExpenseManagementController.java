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
import java.time.LocalDate;

public class ExpenseManagementController {

    @FXML
    private ComboBox<String> categoryComboBox;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField paidToTextField;

    @FXML
    private TableView<Expense> expenseTableView;

    @FXML
    private TableColumn<Expense, String> expenseIdColumn;

    @FXML
    private TableColumn<Expense, String> categoryColumn;

    @FXML
    private TableColumn<Expense, String> descriptionColumn;

    @FXML
    private TableColumn<Expense, Double> amountColumn;

    @FXML
    private TableColumn<Expense, String> dateColumn;

    @FXML
    private TableColumn<Expense, String> paidToColumn;

    private final ObservableList<Expense> expenseList =
            FXCollections.observableArrayList();

    private int expenseCounter = 1;

    @FXML
    public void initialize() {

        categoryComboBox.getItems().addAll(
                "Raw Materials",
                "Equipment",
                "Utilities",
                "Salary",
                "Transport",
                "Marketing"
        );

        expenseIdColumn.setCellValueFactory(new PropertyValueFactory<>("expenseId"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        paidToColumn.setCellValueFactory(new PropertyValueFactory<>("paidTo"));

        expenseTableView.setItems(expenseList);
    }

    @FXML
    public void onSaveButtonClick() {

        if (categoryComboBox.getValue() == null) {
            showAlert("Please select a category.");
            return;
        }

        if (descriptionTextField.getText().length() < 5) {
            showAlert("Description must be at least 5 characters.");
            return;
        }

        double amount;

        try {
            amount = Double.parseDouble(amountTextField.getText());

            if (amount <= 0) {
                showAlert("Amount must be greater than 0.");
                return;
            }

        } catch (Exception e) {
            showAlert("Enter a valid amount.");
            return;
        }

        if (datePicker.getValue() == null) {
            showAlert("Please select a date.");
            return;
        }

        if (datePicker.getValue().isAfter(LocalDate.now())) {
            showAlert("Date cannot be in the future.");
            return;
        }

        if (paidToTextField.getText().isEmpty()) {
            showAlert("Enter Paid To.");
            return;
        }

        String expenseId = String.format("EXP-%04d", expenseCounter++);

        Expense expense = new Expense(
                expenseId,
                categoryComboBox.getValue(),
                descriptionTextField.getText(),
                amount,
                datePicker.getValue().toString(),
                paidToTextField.getText()
        );

        expenseList.add(expense);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Expense saved successfully.\nExpense ID: " + expenseId);
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
                getClass().getResource("AccountantDashboard.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.setTitle("Accountant Dashboard");

        stage.show();
    }

    private void clearFields() {

        categoryComboBox.setValue(null);
        descriptionTextField.clear();
        amountTextField.clear();
        datePicker.setValue(null);
        paidToTextField.clear();
    }

    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }
}