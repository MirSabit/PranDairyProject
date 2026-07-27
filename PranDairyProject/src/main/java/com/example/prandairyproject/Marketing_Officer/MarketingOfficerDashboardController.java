package com.example.prandairyproject.Marketing_Officer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class MarketingOfficerDashboardController {

    @FXML
    public void onCampaignButtonClick(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Campaign.fxml"));

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));

        stage.setTitle("Campaign Management");

        stage.show();
    }

    @FXML
    public void onLoyaltyButtonClick() {
        System.out.println("Loyalty Program");
    }

    @FXML
    public void onAnalyticsButtonClick() {
        System.out.println("Customer Analytics");
    }

    @FXML
    public void onAdvertisementButtonClick() {
        System.out.println("Advertisement");
    }

    @FXML
    public void onPromotionalButtonClick() {
        System.out.println("Promotional Offer");
    }

    @FXML
    public void onCouponButtonClick() {
        System.out.println("Coupon");
    }

    @FXML
    public void onNotificationButtonClick() {
        System.out.println("Notification");
    }

    @FXML
    public void onReportButtonClick() {
        System.out.println("Marketing Report");
    }

    @FXML
    public void onLogoutButtonClick() {
        System.out.println("Logout");
    }
}