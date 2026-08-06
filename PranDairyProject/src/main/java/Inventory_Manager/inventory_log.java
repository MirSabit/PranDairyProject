package Inventory_Manager;

import InventoryLog.InventoryLog;
import InventoryLog.InventoryLogRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class inventory_log {

    @FXML
    private TableView<InventoryLog> logTable;

    @FXML
    private TableColumn<InventoryLog, String> itemIdColumn;

    @FXML
    private TableColumn<InventoryLog, String> dateColumn;

    @FXML
    private TableColumn<InventoryLog, String> quantityChangedColumn;

    @FXML
    private TableColumn<InventoryLog, String> reasonColumn;

    @FXML
    public void initialize() {
        itemIdColumn.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        quantityChangedColumn.setCellValueFactory(new PropertyValueFactory<>("quantityChanged"));
        reasonColumn.setCellValueFactory(new PropertyValueFactory<>("reason"));

        logTable.setItems(InventoryLogRepository.getLog());
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Inventory_Manager/Inventory_Dashboard.fxml", "Pran Dairy - Inventory Manager Dashboard");
    }
}
