package Supplier;

import SupplyInfo.SupplyInfo;
import SupplyInfo.SupplyInfoRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class updatesupplyinfo {

    @FXML
    private TextField recordIdField;

    @FXML
    private TextField productTypeField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField contactNumberField;

    @FXML
    private TableView<SupplyInfo> recordTable;

    @FXML
    private TableColumn<SupplyInfo, String> recordIdColumn;

    @FXML
    private TableColumn<SupplyInfo, String> productTypeColumn;

    @FXML
    private TableColumn<SupplyInfo, String> priceColumn;

    @FXML
    private TableColumn<SupplyInfo, String> contactNumberColumn;

    @FXML
    public void initialize() {
        recordIdColumn.setCellValueFactory(new PropertyValueFactory<>("recordId"));
        productTypeColumn.setCellValueFactory(new PropertyValueFactory<>("productType"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        contactNumberColumn.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        recordTable.setItems(SupplyInfoRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String recordId = recordIdField.getText();

        if (recordId == null || recordId.isBlank()) {
            return;
        }

        SupplyInfoRepository.addRecord(new SupplyInfo(recordIdField.getText(), productTypeField.getText(), priceField.getText(), contactNumberField.getText()));

        recordIdField.clear();
        productTypeField.clear();
        priceField.clear();
        contactNumberField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Supplier/SupplierDashboard.fxml", "Pran Dairy - Supplier Dashboard");
    }
}
