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

public class PaymentRecordController {

    @FXML
    private DatePicker fromDatePicker;

    @FXML
    private DatePicker toDatePicker;

    @FXML
    private ComboBox<String> paymentMethodComboBox;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private TableView<PaymentRecord> paymentTableView;

    @FXML
    private TableColumn<PaymentRecord, String> transactionIdColumn;

    @FXML
    private TableColumn<PaymentRecord, String> customerIdColumn;

    @FXML
    private TableColumn<PaymentRecord, String> orderIdColumn;

    @FXML
    private TableColumn<PaymentRecord, Double> amountColumn;

    @FXML
    private TableColumn<PaymentRecord, String> paymentMethodColumn;

    @FXML
    private TableColumn<PaymentRecord, String> paymentDateColumn;

    @FXML
    private TableColumn<PaymentRecord, String> statusColumn;

    private final ObservableList<PaymentRecord> paymentList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        paymentMethodComboBox.getItems().addAll(
                "bKash",
                "Nagad",
                "Card",
                "COD"
        );

        statusComboBox.getItems().addAll(
                "Paid",
                "Pending",
                "Failed"
        );

        transactionIdColumn.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        paymentList.add(new PaymentRecord(
                "TRX001",
                "CUS101",
                "ORD1001",
                2500,
                "bKash",
                "2026-07-25",
                "Paid"));

        paymentList.add(new PaymentRecord(
                "TRX002",
                "CUS102",
                "ORD1002",
                1800,
                "Card",
                "2026-07-26",
                "Pending"));

        paymentList.add(new PaymentRecord(
                "TRX003",
                "CUS103",
                "ORD1003",
                3200,
                "Nagad",
                "2026-07-27",
                "Failed"));

        paymentTableView.setItems(paymentList);
    }

    @FXML
    public void onSearchButtonClick() {

        paymentTableView.setItems(paymentList);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Search");
        alert.setHeaderText(null);
        alert.setContentText("Payment records loaded successfully.");
        alert.showAndWait();
    }

    @FXML
    public void onVerifyButtonClick() {

        PaymentRecord selected = paymentTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Please select a payment record.");
            alert.showAndWait();

            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Payment " + selected.getTransactionId() + " verified successfully.");
        alert.showAndWait();
    }

    @FXML
    public void onFlagButtonClick() {

        PaymentRecord selected = paymentTableView.getSelectionModel().getSelectedItem();

        if (selected == null) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Please select a payment record.");
            alert.showAndWait();

            return;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Payment " + selected.getTransactionId() + " flagged for review.");
        alert.showAndWait();
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
}