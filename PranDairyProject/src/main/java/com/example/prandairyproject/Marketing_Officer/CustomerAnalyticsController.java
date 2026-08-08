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

public class CustomerAnalyticsController {

    @FXML
    private ComboBox<String> customerTypeComboBox;

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TableView<CustomerAnalytics> analyticsTableView;

    @FXML
    private TableColumn<CustomerAnalytics,String> customerIdColumn;

    @FXML
    private TableColumn<CustomerAnalytics,String> customerNameColumn;

    @FXML
    private TableColumn<CustomerAnalytics,Integer> purchaseColumn;

    @FXML
    private TableColumn<CustomerAnalytics,Double> spentColumn;

    @FXML
    private TableColumn<CustomerAnalytics,String> statusColumn;

    private final ObservableList<CustomerAnalytics> analyticsList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize(){

        customerTypeComboBox.getItems().addAll(
                "Retail",
                "Wholesale",
                "Corporate"
        );

        reportTypeComboBox.getItems().addAll(
                "Daily",
                "Weekly",
                "Monthly",
                "Yearly"
        );

        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        purchaseColumn.setCellValueFactory(new PropertyValueFactory<>("purchases"));
        spentColumn.setCellValueFactory(new PropertyValueFactory<>("totalSpent"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        analyticsTableView.setItems(analyticsList);
    }

    @FXML
    public void onGenerateButtonClick(){

        analyticsList.clear();

        analyticsList.add(new CustomerAnalytics("C001","Rahim",15,25000,"Active"));
        analyticsList.add(new CustomerAnalytics("C002","Karim",8,12000,"Active"));
        analyticsList.add(new CustomerAnalytics("C003","Nabil",3,5000,"Inactive"));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Customer Analytics Generated Successfully.");
        alert.showAndWait();
    }

    @FXML
    public void onExportButtonClick(){

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Report Exported Successfully.");
        alert.showAndWait();
    }

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException{

        Parent root = FXMLLoader.load(getClass().getResource("MarketingOfficerDashboard.fxml"));

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Marketing Officer Dashboard");
        stage.show();
    }

}