package QualityControlOfficer;

import RawMilkInspection.RawMilkInspection;
import RawMilkInspection.RawMilkInspectionRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class inspectrawmilk {

    @FXML
    private TextField batchIdField;

    @FXML
    private TextField supplierNameField;

    @FXML
    private TextField quantityField;

    @FXML
    private TextField fatPercentField;

    @FXML
    private TextField phLevelField;

    @FXML
    private RadioButton resultAField;

    @FXML
    private RadioButton resultBField;

    @FXML
    private TableView<RawMilkInspection> recordTable;

    @FXML
    private TableColumn<RawMilkInspection, String> batchIdColumn;

    @FXML
    private TableColumn<RawMilkInspection, String> supplierNameColumn;

    @FXML
    private TableColumn<RawMilkInspection, String> quantityColumn;

    @FXML
    private TableColumn<RawMilkInspection, String> fatPercentColumn;

    @FXML
    private TableColumn<RawMilkInspection, String> phLevelColumn;

    @FXML
    private TableColumn<RawMilkInspection, String> resultColumn;

    @FXML
    public void initialize() {
        batchIdColumn.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        supplierNameColumn.setCellValueFactory(new PropertyValueFactory<>("supplierName"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        fatPercentColumn.setCellValueFactory(new PropertyValueFactory<>("fatPercent"));
        phLevelColumn.setCellValueFactory(new PropertyValueFactory<>("phLevel"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        recordTable.setItems(RawMilkInspectionRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String batchId = batchIdField.getText();

        if (batchId == null || batchId.isBlank()) {
            return;
        }

        String result = resultAField.isSelected() ? "Approved" : "Rejected";
        RawMilkInspectionRepository.addRecord(new RawMilkInspection(batchIdField.getText(), supplierNameField.getText(), quantityField.getText(), fatPercentField.getText(), phLevelField.getText(), result));

        batchIdField.clear();
        supplierNameField.clear();
        quantityField.clear();
        fatPercentField.clear();
        phLevelField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("QualityControlOfficer/QualityControlOfficerDashboard.fxml", "Pran Dairy - QualityControlOfficer Dashboard");
    }
}
