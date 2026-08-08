package QualityControlOfficer;

import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;

public class QualityControlOfficerDashboard {

    @FXML
    protected void openInspectrawmilk() {
        SceneManager.switchScene("QualityControlOfficer/InspectRawMilk.fxml", "Pran Dairy - Inspect Raw Milk");
    }

    @FXML
    protected void openMonitorproductquality() {
        SceneManager.switchScene("QualityControlOfficer/MonitorProductQuality.fxml", "Pran Dairy - Monitor Product Quality");
    }

    @FXML
    protected void openQualityreport() {
        SceneManager.switchScene("QualityControlOfficer/QualityReport.fxml", "Pran Dairy - Quality Report");
    }

    @FXML
    protected void openComplaintinvestigation() {
        SceneManager.switchScene("QualityControlOfficer/ComplaintInvestigation.fxml", "Pran Dairy - Complaint Investigation");
    }

    @FXML
    protected void openExpirycheck() {
        SceneManager.switchScene("QualityControlOfficer/ExpiryCheck.fxml", "Pran Dairy - Expiry Check");
    }

    @FXML
    protected void openSampleevaluation() {
        SceneManager.switchScene("QualityControlOfficer/SampleEvaluation.fxml", "Pran Dairy - Sample Evaluation");
    }

    @FXML
    protected void openHygieneinspection() {
        SceneManager.switchScene("QualityControlOfficer/HygieneInspection.fxml", "Pran Dairy - Hygiene Inspection");
    }

    @FXML
    protected void openLabrecordreview() {
        SceneManager.switchScene("QualityControlOfficer/LabRecordReview.fxml", "Pran Dairy - Lab Record Review");
    }

    @FXML
    protected void handleLogout() {
        SceneManager.switchScene("MainMenu.fxml", "Pran Dairy");
    }
}
