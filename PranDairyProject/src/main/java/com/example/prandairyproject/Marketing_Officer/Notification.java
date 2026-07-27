package com.example.prandairyproject.Marketing_Officer;

import javafx.beans.property.SimpleStringProperty;

public class Notification {

    private final SimpleStringProperty notificationId;
    private final SimpleStringProperty title;
    private final SimpleStringProperty recipient;
    private final SimpleStringProperty sendDate;
    private final SimpleStringProperty status;

    public Notification(String notificationId,
                        String title,
                        String recipient,
                        String sendDate,
                        String status) {

        this.notificationId = new SimpleStringProperty(notificationId);
        this.title = new SimpleStringProperty(title);
        this.recipient = new SimpleStringProperty(recipient);
        this.sendDate = new SimpleStringProperty(sendDate);
        this.status = new SimpleStringProperty(status);
    }

    public String getNotificationId() {
        return notificationId.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getRecipient() {
        return recipient.get();
    }

    public String getSendDate() {
        return sendDate.get();
    }

    public String getStatus() {
        return status.get();
    }
}