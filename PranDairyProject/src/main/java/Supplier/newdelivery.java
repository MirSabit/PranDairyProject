package Supplier;

import Delivery.Delivery;
import Delivery.DeliveryRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class newdelivery {

    @FXML
    private TextField deliveryIdField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField deliveryDateField;

    @FXML
    private TextField vehicleDriverIdField;

    @FXML
    private TableView<Delivery> recordTable;

    @FXML
    private TableColumn<Delivery, String> deliveryIdColumn;

    @FXML
    private TableColumn<Delivery, String> quantityColumn;

    @FXML
    private TableColumn<Delivery, String> deliveryDateColumn;

    @FXML
    private TableColumn<Delivery, String> vehicleDriverIdColumn;

    @FXML
    public void initialize() {
        deliveryIdColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryId"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        deliveryDateColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        vehicleDriverIdColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleDriverId"));
        recordTable.setItems(DeliveryRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String deliveryId = deliveryIdField.getText();

        if (deliveryId == null || deliveryId.isBlank()) {
            return;
        }

        DeliveryRepository.addRecord(new Delivery(deliveryIdField.getText(), quantityField.getText(), deliveryDateField.getText(), vehicleDriverIdField.getText()));

        deliveryIdField.clear();
        quantityField.clear();
        deliveryDateField.clear();
        vehicleDriverIdField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Supplier/SupplierDashboard.fxml", "Pran Dairy - Supplier Dashboard");
    }
}
