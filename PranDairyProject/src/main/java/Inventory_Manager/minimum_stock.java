package Inventory_Manager;

import MinimumStock.MinimumStock;
import MinimumStock.MinimumStockRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;


public class minimum_stock {

    @FXML
    private TextField checkProductIdField;

    @FXML
    private TextField changeProductIdField;

    @FXML
    private TextField changeProductNameField;

    @FXML
    private TextField setMinStockField;

    @FXML
    private TableView<MinimumStock> stockTable;

    @FXML
    private TableColumn<MinimumStock, String> stockColumn;

    @FXML
    public void initialize() {
        stockColumn.setCellValueFactory(data -> {
            MinimumStock record = data.getValue();
            return new javafx.beans.property.ReadOnlyStringWrapper(
                    "Product " + record.getProductId() + " (" + record.getProductName()
                            + ") - Min. Stock: " + record.getMinStockLevel());
        });
    }

    @FXML
    protected void checkMinimumStock() {
        String productId = checkProductIdField.getText();
        stockTable.getItems().clear();

        if (productId == null || productId.isBlank()) {
            return;
        }

        List<MinimumStock> matches = MinimumStockRepository.findByProductId(productId);
        stockTable.getItems().setAll(matches);
    }

    @FXML
    protected void changeMinimumStock() {
        String productId = changeProductIdField.getText();
        String productName = changeProductNameField.getText();
        String minStock = setMinStockField.getText();

        if (productId == null || productId.isBlank() || minStock == null || minStock.isBlank()) {
            return;
        }

        String name = (productName == null || productName.isBlank()) ? "-" : productName;
        MinimumStockRepository.addRecord(new MinimumStock(productId, name, minStock));

        changeProductIdField.clear();
        changeProductNameField.clear();
        setMinStockField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Inventory_Manager/Inventory_Dashboard.fxml", "Pran Dairy - Inventory Manager Dashboard");
    }
}
