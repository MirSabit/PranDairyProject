package com.example.prandairyproject.Marketing_Officer;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class PromotionalOffer {

    private final SimpleStringProperty offerId;
    private final SimpleStringProperty offerName;
    private final SimpleStringProperty offerType;
    private final SimpleDoubleProperty discount;
    private final SimpleStringProperty status;

    public PromotionalOffer(String offerId,
                            String offerName,
                            String offerType,
                            double discount,
                            String status) {

        this.offerId = new SimpleStringProperty(offerId);
        this.offerName = new SimpleStringProperty(offerName);
        this.offerType = new SimpleStringProperty(offerType);
        this.discount = new SimpleDoubleProperty(discount);
        this.status = new SimpleStringProperty(status);
    }

    public String getOfferId() {
        return offerId.get();
    }

    public String getOfferName() {
        return offerName.get();
    }

    public String getOfferType() {
        return offerType.get();
    }

    public double getDiscount() {
        return discount.get();
    }

    public String getStatus() {
        return status.get();
    }
}