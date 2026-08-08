package Supplier;

import BatchRegistration.BatchRegistration;
import BatchRegistration.BatchRegistrationRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class registerbatch {

    @FXML
    private TextField batchIdField;

    @FXML
    private TextField productTypeField;

    @FXML
    private TextField estimatedQuantityField;

    @FXML
    private TextField sourceLocationField;

    @FXML
    private TableView<BatchRegistration> recordTable;

    @FXML
    private TableColumn<BatchRegistration, String> batchIdColumn;

    @FXML
    private TableColumn<BatchRegistration, String> productTypeColumn;

    @FXML
    private TableColumn<BatchRegistration, String> estimatedQuantityColumn;

    @FXML
    private TableColumn<BatchRegistration, String> sourceLocationColumn;

    @FXML
    public void initialize() {
        batchIdColumn.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        productTypeColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
        estimatedQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedQuantity"));
        sourceLocationColumn.setCellValueFactory(new PropertyValueFactory<>("sourceLocation"));
        recordTable.setItems(BatchRegistrationRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String batchId = batchIdField.getText();

        if (batchId == null || batchId.isBlank()) {
            return;
        }

        BatchRegistrationRepository.addRecord(new BatchRegistration(batchIdField.getText(), productTypeField.getText(), estimatedQuantityField.getText(), sourceLocationField.getText()));

        batchIdField.clear();
        productTypeField.clear();
        estimatedQuantityField.clear();
        sourceLocationField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Supplier/SupplierDashboard.fxml", "Pran Dairy - Supplier Dashboard");
    }
}
