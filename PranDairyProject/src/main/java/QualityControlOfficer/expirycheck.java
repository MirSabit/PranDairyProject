package QualityControlOfficer;

import ExpiryCheck.ExpiryCheck;
import ExpiryCheck.ExpiryCheckRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class expirycheck {

    @FXML
    private TextField productNameField;

    @FXML
    private TextField batchIdField;

    @FXML
    private TextField daysRemainingField;

    @FXML
    private RadioButton resultAField;

    @FXML
    private RadioButton resultBField;

    @FXML
    private TableView<ExpiryCheck> recordTable;

    @FXML
    private TableColumn<ExpiryCheck, String> productNameColumn;

    @FXML
    private TableColumn<ExpiryCheck, String> batchIdColumn;

    @FXML
    private TableColumn<ExpiryCheck, String> daysRemainingColumn;

    @FXML
    private TableColumn<ExpiryCheck, String> resultColumn;

    @FXML
    public void initialize() {
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        batchIdColumn.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        daysRemainingColumn.setCellValueFactory(new PropertyValueFactory<>("daysRemaining"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        recordTable.setItems(ExpiryCheckRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String productName = productNameField.getText();

        if (productName == null || productName.isBlank()) {
            return;
        }

        String result = resultAField.isSelected() ? "Discount" : "Remove";
        ExpiryCheckRepository.addRecord(new ExpiryCheck(productNameField.getText(), batchIdField.getText(), daysRemainingField.getText(), result));

        productNameField.clear();
        batchIdField.clear();
        daysRemainingField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("QualityControlOfficer/QualityControlOfficerDashboard.fxml", "Pran Dairy - QualityControlOfficer Dashboard");
    }
}
