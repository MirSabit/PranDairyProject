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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class FinancialDashboardController {

    @FXML
    private Label revenueLabel;

    @FXML
    private Label expensesLabel;

    @FXML
    private Label netProfitLabel;

    @FXML
    private Label budgetUsedLabel;

    @FXML
    private Label pendingInvoicesLabel;

    @FXML
    private Label unpaidSupplierLabel;

    @FXML
    private TableView<FinancialDashboard> dashboardTableView;

    @FXML
    private TableColumn<FinancialDashboard, String> categoryColumn;

    @FXML
    private TableColumn<FinancialDashboard, Double> amountColumn;

    private final ObservableList<FinancialDashboard> dashboardList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        dashboardTableView.setItems(dashboardList);

        loadDashboard();
    }

    private void loadDashboard() {

        double revenue = 1200000;
        double expenses = 780000;
        double netProfit = revenue - expenses;
        double budgetUsed = 650000;
        int pendingInvoices = 15;
        int unpaidSuppliers = 7;

        revenueLabel.setText("BDT " + revenue);
        expensesLabel.setText("BDT " + expenses);
        netProfitLabel.setText("BDT " + netProfit);
        budgetUsedLabel.setText("BDT " + budgetUsed);
        pendingInvoicesLabel.setText(String.valueOf(pendingInvoices));
        unpaidSupplierLabel.setText(String.valueOf(unpaidSuppliers));

        dashboardList.clear();

        dashboardList.add(new FinancialDashboard("Revenue", revenue));
        dashboardList.add(new FinancialDashboard("Expenses", expenses));
        dashboardList.add(new FinancialDashboard("Net Profit", netProfit));
        dashboardList.add(new FinancialDashboard("Budget Used", budgetUsed));
    }

    @FXML
    public void onRefreshButtonClick() {

        loadDashboard();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Dashboard refreshed successfully.");
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