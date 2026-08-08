package com.example.prandairyproject.Marketing_Officer;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Campaign {

    private final SimpleStringProperty campaignId;
    private final SimpleStringProperty campaignName;
    private final SimpleStringProperty campaignType;
    private final SimpleStringProperty targetGroup;
    private final SimpleDoubleProperty budget;
    private final SimpleStringProperty status;

    public Campaign(String campaignId,
                    String campaignName,
                    String campaignType,
                    String targetGroup,
                    double budget,
                    String status) {

        this.campaignId = new SimpleStringProperty(campaignId);
        this.campaignName = new SimpleStringProperty(campaignName);
        this.campaignType = new SimpleStringProperty(campaignType);
        this.targetGroup = new SimpleStringProperty(targetGroup);
        this.budget = new SimpleDoubleProperty(budget);
        this.status = new SimpleStringProperty(status);
    }

    public String getCampaignId() {
        return campaignId.get();
    }

    public String getCampaignName() {
        return campaignName.get();
    }

    public String getCampaignType() {
        return campaignType.get();
    }

    public String getTargetGroup() {
        return targetGroup.get();
    }

    public double getBudget() {
        return budget.get();
    }

    public String getStatus() {
        return status.get();
    }
}