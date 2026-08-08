package DeliveryHistory;

public class DeliveryHistory {

    private final String deliveryId;
    private final String deliveryDate;
    private final String quantity;
    private final String result;

    public DeliveryHistory(String deliveryId, String deliveryDate, String quantity, String result) {
        this.deliveryId = deliveryId;
        this.deliveryDate = deliveryDate;
        this.quantity = quantity;
        this.result = result;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getResult() {
        return result;
    }
}
