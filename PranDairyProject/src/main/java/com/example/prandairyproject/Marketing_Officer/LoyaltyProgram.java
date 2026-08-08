package com.example.prandairyproject.Marketing_Officer;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class LoyaltyProgram {

    private final SimpleStringProperty programId;
    private final SimpleStringProperty programName;
    private final SimpleStringProperty programType;
    private final SimpleDoubleProperty discount;
    private final SimpleIntegerProperty points;

    public LoyaltyProgram(String programId,
                          String programName,
                          String programType,
                          double discount,
                          int points) {

        this.programId = new SimpleStringProperty(programId);
        this.programName = new SimpleStringProperty(programName);
        this.programType = new SimpleStringProperty(programType);
        this.discount = new SimpleDoubleProperty(discount);
        this.points = new SimpleIntegerProperty(points);
    }

    public String getProgramId() {
        return programId.get();
    }

    public String getProgramName() {
        return programName.get();
    }

    public String getProgramType() {
        return programType.get();
    }

    public double getDiscount() {
        return discount.get();
    }

    public int getPoints() {
        return points.get();
    }
}