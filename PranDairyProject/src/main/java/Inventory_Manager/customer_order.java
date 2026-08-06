package Inventory_Manager;

import CustomerOrder.CustomerOrder;
import CustomerOrder.CustomerOrderRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class customer_order {

    @FXML
    private TableView<CustomerOrder> orderTable;

    @FXML
    private TableColumn<CustomerOrder, String> customerIdColumn;

    @FXML
    private TableColumn<CustomerOrder, String> customerNameColumn;

    @FXML
    private TableColumn<CustomerOrder, String> productNameColumn;

    @FXML
    private TableColumn<CustomerOrder, String> productIdColumn;

    @FXML
    private TableColumn<CustomerOrder, String> totalColumn;

    @FXML
    public void initialize() {
        customerIdColumn.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        orderTable.setItems(CustomerOrderRepository.getAllOrders());
    }

    /**
     * Kept named "displayorders" to match the onAction already wired in
     * Customer_Order.fxml. Just re-points the table at the shared
     * repository - no data is generated here.
     */
    @FXML
    protected void displayorders() {
        orderTable.setItems(CustomerOrderRepository.getAllOrders());
        orderTable.refresh();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Inventory_Manager/Inventory_Dashboard.fxml", "Pran Dairy - Inventory Manager Dashboard");
    }
}
