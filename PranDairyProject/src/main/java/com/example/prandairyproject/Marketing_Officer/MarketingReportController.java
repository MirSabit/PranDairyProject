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

public class MarketingReportController {

    @FXML
    private ComboBox<String> reportTypeComboBox;

    @FXML
    private DatePicker reportDatePicker;

    @FXML
    private TableView<MarketingReport> reportTableView;

    @FXML
    private TableColumn<MarketingReport,String> reportIdColumn;

    @FXML
    private TableColumn<MarketingReport,String> reportTypeColumn;

    @FXML
    private TableColumn<MarketingReport,String> reportDateColumn;

    @FXML
    private TableColumn<MarketingReport,Double> salesColumn;

    @FXML
    private TableColumn<MarketingReport,String> statusColumn;

    private final ObservableList<MarketingReport> reportList =
            FXCollections.observableArrayList();

    @FXML
    public void initialize(){

        reportTypeComboBox.getItems().addAll(
                "Daily",
                "Weekly",
                "Monthly",
                "Yearly"
        );

        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        reportTypeColumn.setCellValueFactory(new PropertyValueFactory<>("reportType"));
        reportDateColumn.setCellValueFactory(new PropertyValueFactory<>("reportDate"));
        salesColumn.setCellValueFactory(new PropertyValueFactory<>("totalSales"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        reportTableView.setItems(reportList);
    }

    @FXML
    public void onGenerateButtonClick(){

        if(reportTypeComboBox.getValue()==null || reportDatePicker.getValue()==null){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please select report type and date.");
            alert.showAndWait();
            return;
        }

        reportList.clear();

        reportList.add(new MarketingReport(
                "MR-001",
                reportTypeComboBox.getValue(),
                reportDatePicker.getValue().toString(),
                50000,
                "Generated"
        ));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Marketing Report Generated Successfully.");
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
    public void onBackButtonClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(
                getClass().getResource("MarketingOfficerDashboard.fxml"));

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Marketing Officer Dashboard");
        stage.show();
    }

}