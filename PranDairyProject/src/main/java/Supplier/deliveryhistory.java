package Supplier;

import DeliveryHistory.DeliveryHistory;
import DeliveryHistory.DeliveryHistoryRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class deliveryhistory {

    @FXML
    private TextField deliveryIdField;

    @FXML
    private TextField deliveryDateField;

    @FXML
    private TextField quantityField;

    @FXML
    private RadioButton resultAField;

    @FXML
    private RadioButton resultBField;

    @FXML
    private TableView<DeliveryHistory> recordTable;

    @FXML
    private TableColumn<DeliveryHistory, String> deliveryIdColumn;

    @FXML
    private TableColumn<DeliveryHistory, String> deliveryDateColumn;

    @FXML
    private TableColumn<DeliveryHistory, String> quantityColumn;

    @FXML
    private TableColumn<DeliveryHistory, String> resultColumn;

    @FXML
    public void initialize() {
        deliveryIdColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryId"));
        deliveryDateColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        recordTable.setItems(DeliveryHistoryRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String deliveryId = deliveryIdField.getText();

        if (deliveryId == null || deliveryId.isBlank()) {
            return;
        }

        String result = resultAField.isSelected() ? "Approved" : "Rejected";
        DeliveryHistoryRepository.addRecord(new DeliveryHistory(deliveryIdField.getText(), deliveryDateField.getText(), quantityField.getText(), result));

        deliveryIdField.clear();
        deliveryDateField.clear();
        quantityField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Supplier/SupplierDashboard.fxml", "Pran Dairy - Supplier Dashboard");
    }
}
