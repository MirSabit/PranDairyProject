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

public class InvoiceManagementController {

    @FXML
    private ComboBox<String> customerComboBox;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private TableView<Invoice> invoiceTableView;

    @FXML
    private TableColumn<Invoice,String> invoiceIdColumn;

    @FXML
    private TableColumn<Invoice,String> customerColumn;

    @FXML
    private TableColumn<Invoice,String> orderIdColumn;

    @FXML
    private TableColumn<Invoice,Double> amountColumn;

    @FXML
    private TableColumn<Invoice,String> issueDateColumn;

    @FXML
    private TableColumn<Invoice,String> dueDateColumn;

    @FXML
    private TableColumn<Invoice,String> statusColumn;

    private final ObservableList<Invoice> invoiceList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        customerComboBox.getItems().addAll(
                "All Customers",
                "Rahim",
                "Karim",
                "Sakib"
        );

        statusComboBox.getItems().addAll(
                "Paid",
                "Unpaid",
                "Overdue"
        );

        invoiceIdColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceId"));
        customerColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        issueDateColumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        invoiceTableView.setItems(invoiceList);
    }

    @FXML
    public void onLoadButtonClick() {

        invoiceList.clear();

        invoiceList.add(new Invoice(
                "INV001",
                "Rahim",
                "ORD101",
                2500,
                "01/07/2026",
                "07/07/2026",
                "Paid"
        ));

        invoiceList.add(new Invoice(
                "INV002",
                "Karim",
                "ORD102",
                4200,
                "03/07/2026",
                "10/07/2026",
                "Unpaid"
        ));

        invoiceList.add(new Invoice(
                "INV003",
                "Sakib",
                "ORD103",
                1800,
                "05/07/2026",
                "12/07/2026",
                "Overdue"
        ));
    }

    @FXML
    public void onUpdateStatusButtonClick() {

        Invoice invoice = invoiceTableView.getSelectionModel().getSelectedItem();

        if (invoice == null) {
            showAlert("Please select an invoice.");
            return;
        }

        if (statusComboBox.getValue() == null) {
            showAlert("Please select a status.");
            return;
        }

        invoice.setStatus(statusComboBox.getValue());

        invoiceTableView.refresh();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Invoice status updated successfully.");
        alert.showAndWait();
    }

    @FXML
    public void onClearButtonClick() {

        customerComboBox.setValue(null);
        statusComboBox.setValue(null);
        invoiceList.clear();
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

    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }
}