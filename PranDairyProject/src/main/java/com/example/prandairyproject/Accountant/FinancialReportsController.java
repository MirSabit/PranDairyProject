package com.example.prandairyproject.Accountant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class FinancialReportsController {

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private ComboBox<String> periodComboBox;

    @FXML
    private TableView<FinancialReport> financialReportTableView;

    @FXML
    private TableColumn<FinancialReport, String> reportTypeColumn;

    @FXML
    private TableColumn<FinancialReport, String> periodColumn;

    @FXML
    private TableColumn<FinancialReport, Double> revenueColumn;

    @FXML
    private TableColumn<FinancialReport, Double> expensesColumn;

    @FXML
    private TableColumn<FinancialReport, Double> grossProfitColumn;

    @FXML
    private TableColumn<FinancialReport, Double> netProfitColumn;

    @FXML
    private TableColumn<FinancialReport, Double> profitMarginColumn;

    private final ObservableList<FinancialReport> reportList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        reportTypeComboBox.getItems().addAll(
                "Income",
                "Expense",
                "Profit & Loss",
                "Full Report"
        );

        periodComboBox.getItems().addAll(
                "Monthly",
                "Quarterly",
                "Yearly",
                "Custom"
        );

        reportTypeColumn.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        periodColumn.setCellValueFactory(new PropertyValueFactory<>("period"));
        revenueColumn.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        expensesColumn.setCellValueFactory(new PropertyValueFactory<>("expenses"));
        grossProfitColumn.setCellValueFactory(new PropertyValueFactory<>("grossProfit"));
        netProfitColumn.setCellValueFactory(new PropertyValueFactory<>("netProfit"));
        profitMarginColumn.setCellValueFactory(new PropertyValueFactory<>("profitMargin"));

        financialReportTableView.setItems(reportList);
    }

    @FXML
    public void onGenerateButtonClick() {

        if (reportTypeComboBox.getValue() == null ||
                periodComboBox.getValue() == null) {

            showAlert("Please select Report Type and Period.");

            return;
        }

        reportList.clear();

        double revenue = 1200000;
        double expenses = 780000;
        double grossProfit = revenue - expenses;
        double netProfit = grossProfit - 50000;
        double profitMargin = (netProfit / revenue) * 100;

        reportList.add(new FinancialReport(
                reportTypeComboBox.getValue(),
                periodComboBox.getValue(),
                revenue,
                expenses,
                grossProfit,
                netProfit,
                profitMargin
        ));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Financial Report Generated Successfully.");
        alert.showAndWait();
    }

    @FXML
    public void onExportPdfButtonClick() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);

        alert.setContentText("Report exported as PDF successfully.");

        alert.showAndWait();
    }

    @FXML
    public void onExportExcelButtonClick() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(null);

        alert.setContentText("Report exported as Excel successfully.");

        alert.showAndWait();
    }

    @FXML
    public void onClearButtonClick() {

        reportTypeComboBox.setValue(null);

        periodComboBox.setValue(null);

        reportList.clear();
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

    private void showAlert(String message) {

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setHeaderText(null);

        alert.setContentText(message);

        alert.showAndWait();
    }

}