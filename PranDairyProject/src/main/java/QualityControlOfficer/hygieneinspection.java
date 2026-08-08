package QualityControlOfficer;

import HygieneInspection.HygieneInspection;
import HygieneInspection.HygieneInspectionRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class hygieneinspection {

    @FXML
    private TextField areaField;

    @FXML
    private TextField complianceScoreField;

    @FXML
    private RadioButton resultAField;

    @FXML
    private RadioButton resultBField;

    @FXML
    private TableView<HygieneInspection> recordTable;

    @FXML
    private TableColumn<HygieneInspection, String> areaColumn;

    @FXML
    private TableColumn<HygieneInspection, String> complianceScoreColumn;

    @FXML
    private TableColumn<HygieneInspection, String> resultColumn;

    @FXML
    public void initialize() {
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        complianceScoreColumn.setCellValueFactory(new PropertyValueFactory<>("complianceScore"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        recordTable.setItems(HygieneInspectionRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String area = areaField.getText();

        if (area == null || area.isBlank()) {
            return;
        }

        String result = resultAField.isSelected() ? "Compliant" : "Non-Compliant";
        HygieneInspectionRepository.addRecord(new HygieneInspection(areaField.getText(), complianceScoreField.getText(), result));

        areaField.clear();
        complianceScoreField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("QualityControlOfficer/QualityControlOfficerDashboard.fxml", "Pran Dairy - QualityControlOfficer Dashboard");
    }
}
