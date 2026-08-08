package CEO;

import FinancialReport.FinancialReport;
import FinancialReport.FinancialReportRepository;
import com.example.prandairyproject.SceneManager;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class finance {

    @FXML
    private TextField quarterFilterField;

    @FXML
    private TableView<FinancialReport> financeTable;

    @FXML
    private TableColumn<FinancialReport, Number> reportIdColumn;

    @FXML
    private TableColumn<FinancialReport, String> quarterColumn;

    @FXML
    private TableColumn<FinancialReport, Number> revenueColumn;

    @FXML
    private TableColumn<FinancialReport, Number> expensesColumn;

    @FXML
    private TableColumn<FinancialReport, Number> profitColumn;

    @FXML
    private TableColumn<FinancialReport, Number> lossColumn;

    @FXML
    private TableColumn<FinancialReport, String> growthColumn;

    private FilteredList<FinancialReport> filteredReports;

    @FXML
    public void initialize() {
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportID"));
        quarterColumn.setCellValueFactory(new PropertyValueFactory<>("quarter"));
        revenueColumn.setCellValueFactory(new PropertyValueFactory<>("revenue"));
        expensesColumn.setCellValueFactory(new PropertyValueFactory<>("expenses"));
        profitColumn.setCellValueFactory(new PropertyValueFactory<>("profit"));
        lossColumn.setCellValueFactory(new PropertyValueFactory<>("loss"));
        growthColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().calculateGrowthRate()));

        filteredReports = new FilteredList<>(FinancialReportRepository.getAllReports(), r -> true);
        financeTable.setItems(filteredReports);
    }

    @FXML
    protected void filterByQuarter() {
        String filter = quarterFilterField.getText();
        if (filter == null || filter.isBlank()) {
            filteredReports.setPredicate(r -> true);
            return;
        }
        filteredReports.setPredicate(r -> r.getQuarter() != null
                && r.getQuarter().toLowerCase().contains(filter.toLowerCase()));
    }

    @FXML
    protected void showAll() {
        quarterFilterField.clear();
        filteredReports.setPredicate(r -> true);
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("CEO/CEODashboard.fxml", "Pran Dairy - CEO Dashboard");
    }
}
