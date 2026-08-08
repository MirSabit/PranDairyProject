package CEO;

import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;

public class ceodashboard {

    @FXML
    protected void openWeeklySalesGrowth() {
        SceneManager.switchScene("CEO/WeeklySalesGrowth.fxml", "Pran Dairy - Weekly Sales Growth");
    }

    @FXML
    protected void openQuaterlySummary() {
        SceneManager.switchScene("CEO/QuaterlySummary.fxml", "Pran Dairy - Quaterly Summary");
    }

    @FXML
    protected void openAnnualProduction() {
        SceneManager.switchScene("CEO/AnnualProduction.fxml", "Pran Dairy - Annual Production Target");
    }

    @FXML
    protected void openCompareRevenue() {
        SceneManager.switchScene("CEO/CompareRevenue.fxml", "Pran Dairy - Compare Product Revenue");
    }

    @FXML
    protected void openSupplierContract() {
        SceneManager.switchScene("CEO/SupplierContract.fxml", "Pran Dairy - Supplier Contract");
    }

    @FXML
    protected void openCheckOnEmployee() {
        SceneManager.switchScene("CEO/CheckOnEmployee.fxml", "Pran Dairy - Employees");
    }

    @FXML
    protected void openComplaints() {
        SceneManager.switchScene("CEO/Complaints.fxml", "Pran Dairy - Complaints");
    }

    @FXML
    protected void openFinance() {
        SceneManager.switchScene("CEO/Finance.fxml", "Pran Dairy - Finance");
    }

    @FXML
    protected void handleLogout() {
        // TODO: replace with SceneManager.switchScene("<path-to-your-login-fxml>", "title")
        // once your team's login screen is merged in.
        javafx.application.Platform.exit();
    }
}
