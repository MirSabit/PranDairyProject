package Inventory_Manager;

import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;

public class inventory_dashboard {

    @FXML
    protected void openProduct() {
        SceneManager.switchScene("Inventory_Manager/Product.fxml", "Pran Dairy - Add Product");
    }

    @FXML
    protected void openMinimumStock() {
        SceneManager.switchScene("Inventory_Manager/Minimum_Stock.fxml", "Pran Dairy - Minimum Stock");
    }

    @FXML
    protected void openCustomerOrder() {
        SceneManager.switchScene("Inventory_Manager/Customer_Order.fxml", "Pran Dairy - Customer Orders");
    }

    @FXML
    protected void openReturnOrder() {
        SceneManager.switchScene("Inventory_Manager/Return_Order.fxml", "Pran Dairy - Return Orders");
    }

    @FXML
    protected void openInventory() {
        SceneManager.switchScene("Inventory_Manager/Inventory.fxml", "Pran Dairy - Inventory");
    }

    @FXML
    protected void openInventoryLog() {
        SceneManager.switchScene("Inventory_Manager/Inventory_Log.fxml", "Pran Dairy - Inventory Log");
    }

    @FXML
    protected void openSalesReport() {
        SceneManager.switchScene("Inventory_Manager/Sales_Report.fxml", "Pran Dairy - Sales Reports");
    }

    @FXML
    protected void handleLogout() {
        // TODO: replace with SceneManager.switchScene("<path-to-your-login-fxml>", "title")
        // once your team's login screen is merged in.
        javafx.application.Platform.exit();
    }
}
