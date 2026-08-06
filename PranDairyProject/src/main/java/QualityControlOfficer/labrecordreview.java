package QualityControlOfficer;

import LabRecord.LabRecord;
import LabRecord.LabRecordRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class labrecordreview {

    @FXML
    private TextField testIdField;

    @FXML
    private TextField batchIdField;

    @FXML
    private TextField testTypeField;

    @FXML
    private RadioButton resultAField;

    @FXML
    private RadioButton resultBField;

    @FXML
    private TableView<LabRecord> recordTable;

    @FXML
    private TableColumn<LabRecord, String> testIdColumn;

    @FXML
    private TableColumn<LabRecord, String> batchIdColumn;

    @FXML
    private TableColumn<LabRecord, String> testTypeColumn;

    @FXML
    private TableColumn<LabRecord, String> resultColumn;

    @FXML
    public void initialize() {
        testIdColumn.setCellValueFactory(new PropertyValueFactory<>("testId"));
        batchIdColumn.setCellValueFactory(new PropertyValueFactory<>("batchId"));
        testTypeColumn.setCellValueFactory(new PropertyValueFactory<>("testType"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        recordTable.setItems(LabRecordRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String testId = testIdField.getText();

        if (testId == null || testId.isBlank()) {
            return;
        }

        String result = resultAField.isSelected() ? "Pass" : "Fail";
        LabRecordRepository.addRecord(new LabRecord(testIdField.getText(), batchIdField.getText(), testTypeField.getText(), result));

        testIdField.clear();
        batchIdField.clear();
        testTypeField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("QualityControlOfficer/QualityControlOfficerDashboard.fxml", "Pran Dairy - QualityControlOfficer Dashboard");
    }
}
