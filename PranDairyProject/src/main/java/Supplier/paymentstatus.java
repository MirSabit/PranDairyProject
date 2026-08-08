package Supplier;

import PaymentRecord.PaymentRecord;
import PaymentRecord.PaymentRecordRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class paymentstatus {

    @FXML
    private TextField paymentIdField;

    @FXML
    private TextField amountField;

    @FXML
    private TextField paymentDateField;

    @FXML
    private RadioButton resultAField;

    @FXML
    private RadioButton resultBField;

    @FXML
    private TableView<PaymentRecord> recordTable;

    @FXML
    private TableColumn<PaymentRecord, String> paymentIdColumn;

    @FXML
    private TableColumn<PaymentRecord, String> amountColumn;

    @FXML
    private TableColumn<PaymentRecord, String> paymentDateColumn;

    @FXML
    private TableColumn<PaymentRecord, String> resultColumn;

    @FXML
    public void initialize() {
        paymentIdColumn.setCellValueFactory(new PropertyValueFactory<>("paymentId"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));
        resultColumn.setCellValueFactory(new PropertyValueFactory<>("result"));
        recordTable.setItems(PaymentRecordRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String paymentId = paymentIdField.getText();

        if (paymentId == null || paymentId.isBlank()) {
            return;
        }

        String result = resultAField.isSelected() ? "Paid" : "Pending";
        PaymentRecordRepository.addRecord(new PaymentRecord(paymentIdField.getText(), amountField.getText(), paymentDateField.getText(), result));

        paymentIdField.clear();
        amountField.clear();
        paymentDateField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Supplier/SupplierDashboard.fxml", "Pran Dairy - Supplier Dashboard");
    }
}
