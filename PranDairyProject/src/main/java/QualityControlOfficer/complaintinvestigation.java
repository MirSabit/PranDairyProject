package QualityControlOfficer;

import ComplaintInvestigation.ComplaintInvestigation;
import ComplaintInvestigation.ComplaintInvestigationRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class complaintinvestigation {

    @FXML
    private TextField ticketIdField;

    @FXML
    private TextField customerNameField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField rootCauseField;

    @FXML
    private TextField correctiveActionField;

    @FXML
    private TableView<ComplaintInvestigation> recordTable;

    @FXML
    private TableColumn<ComplaintInvestigation, String> ticketIdColumn;

    @FXML
    private TableColumn<ComplaintInvestigation, String> customerNameColumn;

    @FXML
    private TableColumn<ComplaintInvestigation, String> productNameColumn;

    @FXML
    private TableColumn<ComplaintInvestigation, String> rootCauseColumn;

    @FXML
    private TableColumn<ComplaintInvestigation, String> correctiveActionColumn;

    @FXML
    public void initialize() {
        ticketIdColumn.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        rootCauseColumn.setCellValueFactory(new PropertyValueFactory<>("rootCause"));
        correctiveActionColumn.setCellValueFactory(new PropertyValueFactory<>("correctiveAction"));
        recordTable.setItems(ComplaintInvestigationRepository.getAllRecords());
    }

    @FXML
    protected void addRecord() {
        String ticketId = ticketIdField.getText();

        if (ticketId == null || ticketId.isBlank()) {
            return;
        }

        ComplaintInvestigationRepository.addRecord(new ComplaintInvestigation(ticketIdField.getText(), customerNameField.getText(), productNameField.getText(), rootCauseField.getText(), correctiveActionField.getText()));

        ticketIdField.clear();
        customerNameField.clear();
        productNameField.clear();
        rootCauseField.clear();
        correctiveActionField.clear();
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("QualityControlOfficer/QualityControlOfficerDashboard.fxml", "Pran Dairy - QualityControlOfficer Dashboard");
    }
}
