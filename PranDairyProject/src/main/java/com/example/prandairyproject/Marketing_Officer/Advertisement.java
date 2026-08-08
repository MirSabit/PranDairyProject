package com.example.prandairyproject.Marketing_Officer;

import javafx.beans.property.SimpleStringProperty;

public class Advertisement {

    private final SimpleStringProperty advertisementId;
    private final SimpleStringProperty title;
    private final SimpleStringProperty type;
    private final SimpleStringProperty status;
    private final SimpleStringProperty startDate;
    private final SimpleStringProperty endDate;

    public Advertisement(String advertisementId,
                         String title,
                         String type,
                         String status,
                         String startDate,
                         String endDate) {

        this.advertisementId = new SimpleStringProperty(advertisementId);
        this.title = new SimpleStringProperty(title);
        this.type = new SimpleStringProperty(type);
        this.status = new SimpleStringProperty(status);
        this.startDate = new SimpleStringProperty(startDate);
        this.endDate = new SimpleStringProperty(endDate);
    }

    public String getAdvertisementId() {
        return advertisementId.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getType() {
        return type.get();
    }

    public String getStatus() {
        return status.get();
    }

    public String getStartDate() {
        return startDate.get();
    }

    public String getEndDate() {
        return endDate.get();
    }
}