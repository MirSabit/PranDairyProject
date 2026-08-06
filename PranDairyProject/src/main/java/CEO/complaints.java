package CEO;

import ComplaintReport.ComplaintReport;
import ComplaintReport.ComplaintReportRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;


public class complaints {

    @FXML
    private TextField complaintIdField;

    @FXML
    private TableView<ComplaintReport> complaintsTable;

    @FXML
    private TableColumn<ComplaintReport, String> reportIdColumn;

    @FXML
    private TableColumn<ComplaintReport, Number> totalComplaintsColumn;

    @FXML
    private TableColumn<ComplaintReport, String> resolvedComplaintsColumn;

    @FXML
    public void initialize() {
        reportIdColumn.setCellValueFactory(new PropertyValueFactory<>("reportId"));
        totalComplaintsColumn.setCellValueFactory(new PropertyValueFactory<>("totalComplaints"));
        resolvedComplaintsColumn.setCellValueFactory(new PropertyValueFactory<>("resolvedComplaints"));
    }

    @FXML
    protected void loadComplaints() {
        String complaintId = complaintIdField.getText();
        complaintsTable.getItems().clear();

        if (complaintId == null || complaintId.isBlank()) {
            return;
        }

        Optional<ComplaintReport> found = ComplaintReportRepository.findByReportId(complaintId);
        if (found.isPresent()) {
            complaintsTable.getItems().add(found.get());
        } else {
            complaintsTable.getItems().add(new ComplaintReport(complaintId, 0, "No complaint report found for this ID."));
        }
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("CEO/CEODashboard.fxml", "Pran Dairy - CEO Dashboard");
    }
}
