package Supplier;

import DeliverySchedule.DeliverySchedule;
import DeliverySchedule.DeliveryScheduleRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class scheduledelivery {

    @FXML
    private TextField preferredDateField;

    @FXML
    private TextField timeSlotField;

    @FXML
    private TextField estimatedQuantityField;

    @FXML
    private TableView<DeliverySchedule> recordTable;

    @FXML
    private TableColumn<DeliverySchedule, String> preferredDateColumn;

    @FXML
    private TableColumn<DeliverySchedule, String> timeSlotColumn;

    @FXML
    private TableColumn<DeliverySchedule, String> estimatedQuantityColumn;

    @FXML
    public void initialize() {
        preferredDateColumn.setCellValueFactory(new PropertyValueFactory<>("preferredDate"));
        timeSlotColumn.setCellValueFactory(new PropertyValueFactory<>("timeSlot"));
        estimatedQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("estimatedQuantity"));
        recordTable.setItems(DeliveryScheduleRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String preferredDate = preferredDateField.getText();

        if (preferredDate == null || preferredDate.isBlank()) {
            return;
        }

        DeliveryScheduleRepository.addRecord(new DeliverySchedule(preferredDateField.getText(), timeSlotField.getText(), estimatedQuantityField.getText()));

        preferredDateField.clear();
        timeSlotField.clear();
        estimatedQuantityField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("Supplier/SupplierDashboard.fxml", "Pran Dairy - Supplier Dashboard");
    }
}
