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

public class CouponController {

    @FXML
    private TextField couponCodeTextField;

    @FXML
    private TextField discountTextField;

    @FXML
    private ComboBox<String> couponTypeComboBox;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TableView<Coupon> couponTableView;

    @FXML
    private TableColumn<Coupon,String> couponIdColumn;

    @FXML
    private TableColumn<Coupon,String> couponCodeColumn;

    @FXML
    private TableColumn<Coupon,String> couponTypeColumn;

    @FXML
    private TableColumn<Coupon,Double> discountColumn;

    @FXML
    private TableColumn<Coupon,String> statusColumn;

    private final ObservableList<Coupon> couponList =
            FXCollections.observableArrayList();

    private int couponCounter = 1;

    @FXML
    public void initialize() {

        couponTypeComboBox.getItems().addAll(
                "Percentage",
                "Fixed Amount"
        );

        statusComboBox.getItems().addAll(
                "Active",
                "Inactive"
        );

        couponIdColumn.setCellValueFactory(new PropertyValueFactory<>("couponId"));
        couponCodeColumn.setCellValueFactory(new PropertyValueFactory<>("couponCode"));
        couponTypeColumn.setCellValueFactory(new PropertyValueFactory<>("couponType"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        couponTableView.setItems(couponList);
    }

    @FXML
    public void onSaveButtonClick() {

        if (couponCodeTextField.getText().isEmpty()
                || discountTextField.getText().isEmpty()
                || couponTypeComboBox.getValue() == null
                || statusComboBox.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all required fields.");
            alert.showAndWait();
            return;
        }

        Coupon coupon = new Coupon(
                "CP-" + couponCounter++,
                couponCodeTextField.getText(),
                couponTypeComboBox.getValue(),
                Double.parseDouble(discountTextField.getText()),
                statusComboBox.getValue()
        );

        couponList.add(coupon);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Coupon Saved Successfully.");
        alert.showAndWait();

        clearFields();
    }

    @FXML
    public void onClearButtonClick() {
        clearFields();
    }

    @FXML
    public void onBackButtonClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MarketingOfficerDashboard.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Marketing Officer Dashboard");
        stage.show();
    }

    private void clearFields() {

        couponCodeTextField.clear();
        discountTextField.clear();

        couponTypeComboBox.setValue(null);
        statusComboBox.setValue(null);

        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
    }
}