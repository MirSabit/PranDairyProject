package DeliverySchedule;

public class DeliverySchedule {

    private final String preferredDate;
    private final String timeSlot;
    private final String estimatedQuantity;

    public DeliverySchedule(String preferredDate, String timeSlot, String estimatedQuantity) {
        this.preferredDate = preferredDate;
        this.timeSlot = timeSlot;
        this.estimatedQuantity = estimatedQuantity;
    }

    public String getPreferredDate() {
        return preferredDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getEstimatedQuantity() {
        return estimatedQuantity;
    }
}
