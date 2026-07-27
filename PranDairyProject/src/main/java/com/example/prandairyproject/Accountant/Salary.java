package com.example.prandairyproject.Accountant;

public class Salary {

    private String employeeId;
    private String employeeName;
    private String role;
    private double baseSalary;
    private double bonus;
    private double deductions;
    private double netSalary;

    public Salary(String employeeId,
                  String employeeName,
                  String role,
                  double baseSalary,
                  double bonus,
                  double deductions,
                  double netSalary) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.role = role;
        this.baseSalary = baseSalary;
        this.bonus = bonus;
        this.deductions = deductions;
        this.netSalary = netSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getRole() {
        return role;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getBonus() {
        return bonus;
    }

    public double getDeductions() {
        return deductions;
    }

    public double getNetSalary() {
        return netSalary;
    }
}