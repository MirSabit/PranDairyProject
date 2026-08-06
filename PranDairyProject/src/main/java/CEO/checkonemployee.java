package CEO;

import Employee.Employee;
import Employee.EmployeeRepository;
import com.example.prandairyproject.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class checkonemployee {

    @FXML
    private TextField employeeIdField;

    @FXML
    private TextField employeeNameField;

    @FXML
    private TextField positionField;

    @FXML
    private TextField departmentField;

    @FXML
    private TableView<Employee> employeeTable;

    @FXML
    private TableColumn<Employee, String> employeeIdColumn;

    @FXML
    private TableColumn<Employee, String> employeeNameColumn;

    @FXML
    private TableColumn<Employee, String> positionColumn;

    @FXML
    private TableColumn<Employee, String> departmentColumn;

    @FXML
    private TableColumn<Employee, String> statusColumn;

    @FXML
    public void initialize() {
        employeeIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        employeeTable.setItems(EmployeeRepository.getAllEmployees());
    }

    @FXML
    protected void loadEmployeeInfo() {
        String employeeId = employeeIdField.getText();

        if (employeeId == null || employeeId.isBlank()) {
            return;
        }

        EmployeeRepository.addEmployee(new Employee(
                employeeId,
                emptyToDash(employeeNameField.getText()),
                emptyToDash(positionField.getText()),
                emptyToDash(departmentField.getText()),
                "Active"));

        employeeIdField.clear();
        employeeNameField.clear();
        positionField.clear();
        departmentField.clear();
    }

    private String emptyToDash(String value) {
        return (value == null || value.isBlank()) ? "-" : value;
    }

    @FXML
    protected void goBack() {
        SceneManager.switchScene("CEO/CEODashboard.fxml", "Pran Dairy - CEO Dashboard");
    }
}
