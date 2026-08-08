package com.example.prandairyproject.Accountant;

public class Budget {

    private String month;
    private double rawMaterials;
    private double equipment;
    private double utilities;
    private double salary;
    private double transport;
    private double marketing;
    private double total;

    public Budget(String month,
                  double rawMaterials,
                  double equipment,
                  double utilities,
                  double salary,
                  double transport,
                  double marketing,
                  double total) {

        this.month = month;
        this.rawMaterials = rawMaterials;
        this.equipment = equipment;
        this.utilities = utilities;
        this.salary = salary;
        this.transport = transport;
        this.marketing = marketing;
        this.total = total;
    }

    public String getMonth() {
        return month;
    }

    public double getRawMaterials() {
        return rawMaterials;
    }

    public double getEquipment() {
        return equipment;
    }

    public double getUtilities() {
        return utilities;
    }

    public double getSalary() {
        return salary;
    }

    public double getTransport() {
        return transport;
    }

    public double getMarketing() {
        return marketing;
    }

    public double getTotal() {
        return total;
    }
}