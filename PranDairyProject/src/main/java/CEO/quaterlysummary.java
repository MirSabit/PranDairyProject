package CEO;

import ProfitLossSummary.ProfitLossSummaryRepository;
import com.example.prandairyproject.SceneManager;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class quaterlysummary {

    @FXML
    private TextField periodFilterField;

    @FXML
    private TableView<ProfitLossSummary.ProfitLossSummary> summaryTable;

    @FXML
    private TableColumn<ProfitLossSummary.ProfitLossSummary, String> periodColumn;

    @FXML
    private TableColumn<ProfitLossSummary.ProfitLossSummary, Number> totalSalesColumn;

    @FXML
    private TableColumn<ProfitLossSummary.ProfitLossSummary, Number> totalCostColumn;

    @FXML
    private TableColumn<ProfitLossSummary.ProfitLossSummary, Number> profitColumn;

    private FilteredList<ProfitLossSummary.ProfitLossSummary> filteredSummaries;

    @FXML
    public void initialize() {
        periodColumn.setCellValueFactory(new PropertyValueFactory<>("period"));
        totalSalesColumn.setCellValueFactory(new PropertyValueFactory<>("totalSales"));
        totalCostColumn.setCellValueFactory(new PropertyValueFactory<>("totalCost"));
        profitColumn.setCellValueFactory(new PropertyValueFactory<>("profit"));

        filteredSummaries = new FilteredList<>(ProfitLossSummaryRepository.getAllSummaries(), s -> true);
        summaryTable.setItems(filteredSummaries);
    }

    @FXML
    protected void filterByPeriod() {
        String filter = periodFilterField.getText();
        if (filter == null || filter.isBlank()) {
            filteredSummaries.setPredicate(s -> true);
            return;
        }
        filteredSummaries.setPredicate(s -> s.getPeriod() != null
                && s.getPeriod().toLowerCase().contains(filter.toLowerCase()));
    }

    @FXML
    protected void showAll() {
        periodFilterField.clear();
        filteredSummaries.setPredicate(s -> true);
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("CEO/CEODashboard.fxml", "Pran Dairy - CEO Dashboard");
    }
}
