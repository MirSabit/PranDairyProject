package QualityControlOfficer;

import SampleEvaluation.SampleEvaluation;
import SampleEvaluation.SampleEvaluationRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class sampleevaluation {

    @FXML
    private TextField sampleIdField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField tasteScoreField;

    @FXML
    private TextField textureScoreField;

    @FXML
    private RadioButton resultAField;

    @FXML
    private RadioButton resultBField;

    @FXML
    private TableView<SampleEvaluation> recordTable;

    @FXML
    private TableColumn<SampleEvaluation, String> sampleIdColumn;

    @FXML
    private TableColumn<SampleEvaluation, String> productNameColumn;

    @FXML
    private TableColumn<SampleEvaluation, String> tasteScoreColumn;

    @FXML
    private TableColumn<SampleEvaluation, String> textureScoreColumn;

    @FXML
    private TableColumn<SampleEvaluation, String> resultColumn;

    @FXML
    public void initialize() {
        sampleIdColumn.setCellValueFactory(new PropertyValueFactory<>("sampleId"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tasteScoreColumn.setCellValueFactory(new PropertyValueFactory<>("tasteScore"));
        textureScoreColumn.setCellValueFactory(new PropertyValueFactory<>("textureScore"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        recordTable.setItems(SampleEvaluationRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String sampleId = sampleIdField.getText();

        if (sampleId == null || sampleId.isBlank()) {
            return;
        }

        String result = resultAField.isSelected() ? "Approved" : "Rejected";
        SampleEvaluationRepository.addRecord(new SampleEvaluation(sampleIdField.getText(), productNameField.getText(), tasteScoreField.getText(), textureScoreField.getText(), result));

        sampleIdField.clear();
        productNameField.clear();
        tasteScoreField.clear();
        textureScoreField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("QualityControlOfficer/QualityControlOfficerDashboard.fxml", "Pran Dairy - QualityControlOfficer Dashboard");
    }
}
