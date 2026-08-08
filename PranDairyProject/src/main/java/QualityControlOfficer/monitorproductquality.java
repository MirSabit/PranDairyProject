package QualityControlOfficer;

import ProductQualityCheck.ProductQualityCheck;
import ProductQualityCheck.ProductQualityCheckRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class monitorproductquality {

    @FXML
    private TextField productBatchIdField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField sealIntegrityField;

    @FXML
    private TextField labelAccuracyField;

    @FXML
    private RadioButton resultAField;

    @FXML
    private RadioButton resultBField;

    @FXML
    private TableView<ProductQualityCheck> recordTable;

    @FXML
    private TableColumn<ProductQualityCheck, String> productBatchIdColumn;

    @FXML
    private TableColumn<ProductQualityCheck, String> productNameColumn;

    @FXML
    private TableColumn<ProductQualityCheck, String> sealIntegrityColumn;

    @FXML
    private TableColumn<ProductQualityCheck, String> labelAccuracyColumn;

    @FXML
    private TableColumn<ProductQualityCheck, String> resultColumn;

    @FXML
    public void initialize() {
        productBatchIdColumn.setCellValueFactory(new PropertyValueFactory<>("productBatchId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        sealIntegrityColumn.setCellValueFactory(new PropertyValueFactory<>("sealIntegrity"));
        labelAccuracyColumn.setCellValueFactory(new PropertyValueFactory<>("labelAccuracy"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        recordTable.setItems(ProductQualityCheckRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String productBatchId = productBatchIdField.getText();

        if (productBatchId == null || productBatchId.isBlank()) {
            return;
        }

        String result = resultAField.isSelected() ? "Approved" : "Held";
        ProductQualityCheckRepository.addRecord(new ProductQualityCheck(productBatchIdField.getText(), productNameField.getText(), sealIntegrityField.getText(), labelAccuracyField.getText(), result));

        productBatchIdField.clear();
        productNameField.clear();
        sealIntegrityField.clear();
        labelAccuracyField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("QualityControlOfficer/QualityControlOfficerDashboard.fxml", "Pran Dairy - QualityControlOfficer Dashboard");
    }
}
