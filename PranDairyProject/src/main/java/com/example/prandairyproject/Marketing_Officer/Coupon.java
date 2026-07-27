package com.example.prandairyproject.Marketing_Officer;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Coupon {

    private final SimpleStringProperty couponId;
    private final SimpleStringProperty couponCode;
    private final SimpleStringProperty couponType;
    private final SimpleDoubleProperty discount;
    private final SimpleStringProperty status;

    public Coupon(String couponId,
                  String couponCode,
                  String couponType,
                  double discount,
                  String status) {

        this.couponId = new SimpleStringProperty(couponId);
        this.couponCode = new SimpleStringProperty(couponCode);
        this.couponType = new SimpleStringProperty(couponType);
        this.discount = new SimpleDoubleProperty(discount);
        this.status = new SimpleStringProperty(status);
    }

    public String getCouponId() {
        return couponId.get();
    }

    public String getCouponCode() {
        return couponCode.get();
    }

    public String getCouponType() {
        return couponType.get();
    }

    public double getDiscount() {
        return discount.get();
    }

    public String getStatus() {
        return status.get();
    }
}