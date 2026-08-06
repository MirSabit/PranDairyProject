package Supplier;

import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;

public class SupplierDashboard {

    @FXML
    protected void openNewdelivery() {
        SceneManager.switchScene("Supplier/NewDelivery.fxml", "Pran Dairy - New Delivery");
    }

    @FXML
    protected void openPaymentstatus() {
        SceneManager.switchScene("Supplier/PaymentStatus.fxml", "Pran Dairy - Payment Status");
    }

    @FXML
    protected void openUpdatesupplyinfo() {
        SceneManager.switchScene("Supplier/UpdateSupplyInfo.fxml", "Pran Dairy - Update Supply Info");
    }

    @FXML
    protected void openDeliveryhistory() {
        SceneManager.switchScene("Supplier/DeliveryHistory.fxml", "Pran Dairy - Delivery History");
    }

    @FXML
    protected void openRegisterbatch() {
        SceneManager.switchScene("Supplier/RegisterBatch.fxml", "Pran Dairy - Register Batch");
    }

    @FXML
    protected void openScheduledelivery() {
        SceneManager.switchScene("Supplier/ScheduleDelivery.fxml", "Pran Dairy - Schedule Delivery");
    }

    @FXML
    protected void openFeedbackresponse() {
        SceneManager.switchScene("Supplier/FeedbackResponse.fxml", "Pran Dairy - Feedback Response");
    }

    @FXML
    protected void openPerformancereport() {
        SceneManager.switchScene("Supplier/PerformanceReport.fxml", "Pran Dairy - Performance Report");
    }

    @FXML
    protected void handleLogout() {
        SceneManager.switchScene("MainMenu.fxml", "Pran Dairy");
    }
}
