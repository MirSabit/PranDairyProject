package Inventory_Manager;

import ReturnOrder.ReturnOrder;
import ReturnOrder.ReturnOrderRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class return_order {

    @FXML
    private TableView<ReturnOrder> returnTable;

    @FXML
    private TableColumn<ReturnOrder, String> productIdColumn;

    @FXML
    private TableColumn<ReturnOrder, String> productNameColumn;

    @FXML
    private TableColumn<ReturnOrder, String> dateOfPurchaseColumn;

    @FXML
    private TableColumn<ReturnOrder, String> causeForReturnColumn;

    @FXML
    private TableColumn<ReturnOrder, String> addressColumn;

    @FXML
    public void initialize() {
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        dateOfPurchaseColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfPurchase"));
        causeForReturnColumn.setCellValueFactory(new PropertyValueFactory<>("causeForReturn"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        returnTable.setItems(ReturnOrderRepository.getAllReturns());
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Inventory_Manager/Inventory_Dashboard.fxml", "Pran Dairy - Inventory Manager Dashboard");
    }
}
