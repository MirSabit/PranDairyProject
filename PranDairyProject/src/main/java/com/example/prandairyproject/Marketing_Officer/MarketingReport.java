package com.example.prandairyproject.Marketing_Officer;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class MarketingReport {

    private final SimpleStringProperty reportId;
    private final SimpleStringProperty reportType;
    private final SimpleStringProperty reportDate;
    private final SimpleDoubleProperty totalSales;
    private final SimpleStringProperty status;

    public MarketingReport(String reportId,
                           String reportType,
                           String reportDate,
                           double totalSales,
                           String status) {

        this.reportId = new SimpleStringProperty(reportId);
        this.reportType = new SimpleStringProperty(reportType);
        this.reportDate = new SimpleStringProperty(reportDate);
        this.totalSales = new SimpleDoubleProperty(totalSales);
        this.status = new SimpleStringProperty(status);
    }

    public String getReportId() {
        return reportId.get();
    }

    public String getReportType() {
        return reportType.get();
    }

    public String getReportDate() {
        return reportDate.get();
    }

    public double getTotalSales() {
        return totalSales.get();
    }

    public String getStatus() {
        return status.get();
    }
}