package QualityControlOfficer;

import QualityReport.QualityReport;
import QualityReport.QualityReportRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class qualityreport {

    @FXML
    private TextField reportPeriodField;

    @FXML
    private TextField totalInspectedField;

    @FXML
    private TextField totalApprovedField;

    @FXML
    private TextField totalRejectedField;

    @FXML
    private TableView<QualityReport> recordTable;

    @FXML
    private TableColumn<QualityReport, String> reportPeriodColumn;

    @FXML
    private TableColumn<QualityReport, String> totalInspectedColumn;

    @FXML
    private TableColumn<QualityReport, String> totalApprovedColumn;

    @FXML
    private TableColumn<QualityReport, String> totalRejectedColumn;

    @FXML
    public void initialize() {
        reportPeriodColumn.setCellValueFactory(new PropertyValueFactory<>("reportPeriod"));
        totalInspectedColumn.setCellValueFactory(new PropertyValueFactory<>("totalInspected"));
        totalApprovedColumn.setCellValueFactory(new PropertyValueFactory<>("totalApproved"));
        totalRejectedColumn.setCellValueFactory(new PropertyValueFactory<>("totalRejected"));
        recordTable.setItems(QualityReportRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String reportPeriod = reportPeriodField.getText();

        if (reportPeriod == null || reportPeriod.isBlank()) {
            return;
        }

        QualityReportRepository.addRecord(new QualityReport(reportPeriodField.getText(), totalInspectedField.getText(), totalApprovedField.getText(), totalRejectedField.getText()));

        reportPeriodField.clear();
        totalInspectedField.clear();
        totalApprovedField.clear();
        totalRejectedField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("QualityControlOfficer/QualityControlOfficerDashboard.fxml", "Pran Dairy - QualityControlOfficer Dashboard");
    }
}
