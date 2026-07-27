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

public class PromotionalOfferController {

    @FXML
    private TextField offerNameTextField;

    @FXML
    private ComboBox<String> offerTypeComboBox;

    @FXML
    private TextField discountTextField;

    @FXML
    private ComboBox<String> statusComboBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TableView<PromotionalOffer> offerTableView;

    @FXML
    private TableColumn<PromotionalOffer,String> offerIdColumn;

    @FXML
    private TableColumn<PromotionalOffer,String> offerNameColumn;

    @FXML
    private TableColumn<PromotionalOffer,String> offerTypeColumn;

    @FXML
    private TableColumn<PromotionalOffer,Double> discountColumn;

    @FXML
    private TableColumn<PromotionalOffer,String> statusColumn;

    private final ObservableList<PromotionalOffer> offerList =
            FXCollections.observableArrayList();

    private int offerCounter = 1;

    @FXML
    public void initialize() {

        offerTypeComboBox.getItems().addAll(
                "Seasonal",
                "Festival",
                "Special Discount"
        );

        statusComboBox.getItems().addAll(
                "Active",
                "Inactive"
        );

        offerIdColumn.setCellValueFactory(new PropertyValueFactory<>("offerId"));
        offerNameColumn.setCellValueFactory(new PropertyValueFactory<>("offerName"));
        offerTypeColumn.setCellValueFactory(new PropertyValueFactory<>("offerType"));
        discountColumn.setCellValueFactory(new PropertyValueFactory<>("discount"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        offerTableView.setItems(offerList);
    }

    @FXML
    public void onSaveButtonClick() {

        if (offerNameTextField.getText().isEmpty()
                || offerTypeComboBox.getValue() == null
                || discountTextField.getText().isEmpty()
                || statusComboBox.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all required fields.");
            alert.showAndWait();
            return;
        }

        PromotionalOffer offer = new PromotionalOffer(
                "OF-" + offerCounter++,
                offerNameTextField.getText(),
                offerTypeComboBox.getValue(),
                Double.parseDouble(discountTextField.getText()),
                statusComboBox.getValue()
        );

        offerList.add(offer);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Offer Saved Successfully.");
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
                getClass().getResource("MarketingOfficerDashboard.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.setTitle("Marketing Officer Dashboard");
        stage.show();
    }

    private void clearFields() {

        offerNameTextField.clear();
        discountTextField.clear();

        offerTypeComboBox.setValue(null);
        statusComboBox.setValue(null);

        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
    }
}