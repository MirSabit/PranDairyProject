package Supplier;

import PerformanceReport.PerformanceReport;
import PerformanceReport.PerformanceReportRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class performancereport {

    @FXML
    private TextField reportPeriodField;

    @FXML
    private TextField totalDeliveriesField;

    @FXML
    private TextField onTimeRateField;

    @FXML
    private TableView<PerformanceReport> recordTable;

    @FXML
    private TableColumn<PerformanceReport, String> reportPeriodColumn;

    @FXML
    private TableColumn<PerformanceReport, String> totalDeliveriesColumn;

    @FXML
    private TableColumn<PerformanceReport, String> onTimeRateColumn;

    @FXML
    public void initialize() {
        reportPeriodColumn.setCellValueFactory(new PropertyValueFactory<>("reportPeriod"));
        totalDeliveriesColumn.setCellValueFactory(new PropertyValueFactory<>("totalDeliveries"));
        onTimeRateColumn.setCellValueFactory(new PropertyValueFactory<>("onTimeRate"));
        recordTable.setItems(PerformanceReportRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String reportPeriod = reportPeriodField.getText();

        if (reportPeriod == null || reportPeriod.isBlank()) {
            return;
        }

        PerformanceReportRepository.addRecord(new PerformanceReport(reportPeriodField.getText(), totalDeliveriesField.getText(), onTimeRateField.getText()));

        reportPeriodField.clear();
        totalDeliveriesField.clear();
        onTimeRateField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Supplier/SupplierDashboard.fxml", "Pran Dairy - Supplier Dashboard");
    }
}
