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

public class SupplierPaymentsController {

    @FXML
    private TextField supplierIdTextField;

    @FXML
    private TextField supplierNameTextField;

    @FXML
    private TextField purchaseOrderTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private ComboBox<String> paymentMethodComboBox;

    @FXML
    private DatePicker paymentDatePicker;

    @FXML
    private TableView<SupplierPayment> supplierPaymentTableView;

    @FXML
    private TableColumn<SupplierPayment,String> paymentIdColumn;

    @FXML
    private TableColumn<SupplierPayment,String> supplierIdColumn;

    @FXML
    private TableColumn<SupplierPayment,String> supplierNameColumn;

    @FXML
    private TableColumn<SupplierPayment,String> purchaseOrderColumn;

    @FXML
    private TableColumn<SupplierPayment,Double> amountColumn;

    @FXML
    private TableColumn<SupplierPayment,String> paymentMethodColumn;

    @FXML
    private TableColumn<SupplierPayment,String> paymentDateColumn;

    private final ObservableList<SupplierPayment> paymentList =
            FXCollections.observableArrayList();

    private int paymentCounter = 1;

    @FXML
    public void initialize() {

        paymentMethodComboBox.getItems().addAll(
                "Bank Transfer",
                "Cash",
                "bKash",
                "Nagad",
                "Card"
        );

        paymentIdColumn.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        supplierIdColumn.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        supplierNameColumn.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        purchaseOrderColumn.setCellValueFactory(new PropertyValueFactory<>("purchaseOrder"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));

        supplierPaymentTableView.setItems(paymentList);
    }

    @FXML
    public void onRecordPaymentButtonClick() {

        if (supplierIdTextField.getText().isEmpty()
                || supplierNameTextField.getText().isEmpty()
                || purchaseOrderTextField.getText().isEmpty()
                || amountTextField.getText().isEmpty()
                || paymentMethodComboBox.getValue() == null
                || paymentDatePicker.getValue() == null) {

            showAlert("Please complete all fields.");
            return;
        }

        try {

            double amount = Double.parseDouble(amountTextField.getText());

            String paymentId = String.format("PAY-%04d", paymentCounter++);

            paymentList.add(new SupplierPayment(
                    paymentId,
                    supplierIdTextField.getText(),
                    supplierNameTextField.getText(),
                    purchaseOrderTextField.getText(),
                    amount,
                    paymentMethodComboBox.getValue(),
                    paymentDatePicker.getValue().toString()
            ));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Supplier payment recorded successfully.");
            alert.showAndWait();

            clearFields();

        } catch (NumberFormatException e) {
            showAlert("Amount must be numeric.");
        }

    }

    @FXML
    public void onClearButtonClick() {
        clearFields();
    }

    private void clearFields() {

        supplierIdTextField.clear();
        supplierNameTextField.clear();
        purchaseOrderTextField.clear();
        amountTextField.clear();

        paymentMethodComboBox.setValue(null);

        paymentDatePicker.setValue(null);
    }

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("AccountantDashboard.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.setTitle("Accountant Dashboard");

        stage.show();

    }

    private void showAlert(String message){

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }

}