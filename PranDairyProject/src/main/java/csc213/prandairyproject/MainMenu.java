package com.example.prandairyproject;

import javafx.fxml.FXML;

public class MainMenu {

    @FXML
    protected void openQualityControlOfficer() {
        SceneManager.switchScene("QualityControlOfficer/QualityControlOfficerDashboard.fxml", "Pran Dairy - Quality Control Officer Dashboard");
    }

    @FXML
    protected void openSupplier() {
        SceneManager.switchScene("Supplier/SupplierDashboard.fxml", "Pran Dairy - Supplier Dashboard");
    }
}
