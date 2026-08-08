package CEO;

import SalesReport.salesreport;
import SalesReport.SalesReportRepository;
import com.example.prandairyproject.SceneManager;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class weeklysalesgrowth {

    @FXML
    private TableView<salesreport> salesGrowthTable;

    @FXML
    private TableColumn<salesreport, Number> reportIdColumn;

    @FXML
    private TableColumn<salesreport, String> timeColumn;

    @FXML
    private TableColumn<salesreport, String> categoryColumn;

    @FXML
    private TableColumn<salesreport, String> totalSalesColumn;

    @FXML
    private TableColumn<salesreport, String> growthRateColumn;

    @FXML
    public void initialize() {
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportID"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        totalSalesColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().totalsale()));
        growthRateColumn.setCellValueFactory(data -> new ReadOnlyStringWrapper(data.getValue().growthrate()));

        salesGrowthTable.setItems(SalesReportRepository.getAllReports());
    }

    @FXML
    protected void refresh() {
        salesGrowthTable.refresh();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("CEO/CEODashboard.fxml", "Pran Dairy - CEO Dashboard");
    }
}
