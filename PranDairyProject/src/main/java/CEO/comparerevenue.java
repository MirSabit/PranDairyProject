package CEO;

import SalesReport.salesreport;
import SalesReport.SalesReportRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.stream.Collectors;


public class comparerevenue {

    @FXML
    private TextField category1Field;

    @FXML
    private TextField category2Field;

    @FXML
    private TableView<ComparisonRow> comparisonTable;

    @FXML
    private TableColumn<ComparisonRow, String> product1Column;

    @FXML
    private TableColumn<ComparisonRow, String> product2Column;

    @FXML
    public void initialize() {
        product1Column.setCellValueFactory(new PropertyValueFactory<>("category1Summary"));
        product2Column.setCellValueFactory(new PropertyValueFactory<>("category2Summary"));
    }

    @FXML
    protected void compareRevenue() {
        String category1 = category1Field.getText();
        String category2 = category2Field.getText();

        List<String> summaries1 = summariesFor(category1);
        List<String> summaries2 = summariesFor(category2);

        comparisonTable.getItems().clear();

        int rows = Math.max(summaries1.size(), summaries2.size());
        if (rows == 0) {
            comparisonTable.getItems().add(new ComparisonRow(
                    "No sales reports found for \"" + category1 + "\"",
                    "No sales reports found for \"" + category2 + "\""));
            return;
        }

        for (int i = 0; i < rows; i++) {
            String left = i < summaries1.size() ? summaries1.get(i) : "-";
            String right = i < summaries2.size() ? summaries2.get(i) : "-";
            comparisonTable.getItems().add(new ComparisonRow(left, right));
        }
    }

    private List<String> summariesFor(String category) {
        if (category == null || category.isBlank()) {
            return List.of();
        }
        List<salesreport> matches = SalesReportRepository.getAllReports().stream()
                .filter(r -> r.getCategory() != null && r.getCategory().equalsIgnoreCase(category.trim()))
                .collect(Collectors.toList());

        return matches.stream()
                .map(r -> r.getTime() + " - " + r.totalsale() + " (" + r.growthrate() + ")")
                .collect(Collectors.toList());
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("CEO/CEODashboard.fxml", "Pran Dairy - CEO Dashboard");
    }

    public static class ComparisonRow {
        private final String category1Summary;
        private final String category2Summary;

        public ComparisonRow(String category1Summary, String category2Summary) {
            this.category1Summary = category1Summary;
            this.category2Summary = category2Summary;
        }

        public String getCategory1Summary() {
            return category1Summary;
        }

        public String getCategory2Summary() {
            return category2Summary;
        }
    }
}
