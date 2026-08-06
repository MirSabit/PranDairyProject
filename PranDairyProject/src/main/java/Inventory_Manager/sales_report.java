package Inventory_Manager;

import SalesReport.salesreport;
import SalesReport.SalesReportRepository;
import com.example.prandairyproject.SceneManager;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class sales_report {

    @FXML
    private TableView<salesreport> salesReportTable;

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

        salesReportTable.setItems(SalesReportRepository.getAllReports());
    }

    @FXML
    protected void refreshReports() {
        salesReportTable.refresh();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Inventory_Manager/Inventory_Dashboard.fxml", "Pran Dairy - Inventory Manager Dashboard");
    }
}
