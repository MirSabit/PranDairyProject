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
import java.time.Year;

public class SalaryProcessingController {

    @FXML
    private ComboBox<String> monthComboBox;

    @FXML
    private ComboBox<Integer> yearComboBox;

    @FXML
    private TableView<Salary> salaryTableView;

    @FXML
    private TableColumn<Salary, String> employeeIdColumn;

    @FXML
    private TableColumn<Salary, String> employeeNameColumn;

    @FXML
    private TableColumn<Salary, String> roleColumn;

    @FXML
    private TableColumn<Salary, Double> baseSalaryColumn;

    @FXML
    private TableColumn<Salary, Double> bonusColumn;

    @FXML
    private TableColumn<Salary, Double> deductionColumn;

    @FXML
    private TableColumn<Salary, Double> netSalaryColumn;

    private final ObservableList<Salary> salaryList =
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

        int currentYear = Year.now().getValue();

        for (int i = currentYear - 2; i <= currentYear + 2; i++) {
            yearComboBox.getItems().add(i);
        }

        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        baseSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        bonusColumn.setCellValueFactory(new PropertyValueFactory<>("bonus"));
        deductionColumn.setCellValueFactory(new PropertyValueFactory<>("deductions"));
        netSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("netSalary"));

        salaryTableView.setItems(salaryList);
    }

    @FXML
    public void onLoadButtonClick() {

        if (monthComboBox.getValue() == null || yearComboBox.getValue() == null) {

            showAlert("Please select Month and Year.");

            return;
        }

        salaryList.clear();

        salaryList.add(new Salary(
                "EMP001",
                "Rahim",
                "Manager",
                50000,
                5000,
                2000,
                53000));

        salaryList.add(new Salary(
                "EMP002",
                "Karim",
                "Sales Officer",
                35000,
                3000,
                1000,
                37000));

        salaryList.add(new Salary(
                "EMP003",
                "Sakib",
                "Accountant",
                45000,
                4000,
                1500,
                47500));

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Salary records loaded successfully.");
        alert.showAndWait();
    }

    @FXML
    public void onProcessButtonClick() {

        if (salaryList.isEmpty()) {

            showAlert("Load salary records first.");

            return;
        }

        double totalPayroll = 0;

        for (Salary salary : salaryList) {
            totalPayroll += salary.getNetSalary();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Salary Processing");

        alert.setHeaderText("Salary Processed Successfully");

        alert.setContentText(
                "Month : " + monthComboBox.getValue() +
                        "\nYear : " + yearComboBox.getValue() +
                        "\n\nTotal Payroll : BDT " + totalPayroll);

        alert.showAndWait();
    }

    @FXML
    public void onClearButtonClick() {

        monthComboBox.setValue(null);

        yearComboBox.setValue(null);

        salaryList.clear();
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