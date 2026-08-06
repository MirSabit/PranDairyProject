package Employee;


public class Employee {

    private String employeeId;
    private String name;
    private String position;
    private String department;
    private String status;

    public Employee(String employeeId, String name, String position, String department, String status) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.department = department;
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
