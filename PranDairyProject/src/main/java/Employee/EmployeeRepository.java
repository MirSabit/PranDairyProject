package Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmployeeRepository {

    private static final ObservableList<Employee> EMPLOYEES = FXCollections.observableArrayList();

    private EmployeeRepository() {
    }

    public static ObservableList<Employee> getAllEmployees() {
        return EMPLOYEES;
    }

    public static void addEmployee(Employee employee) {
        EMPLOYEES.add(employee);
    }
}
