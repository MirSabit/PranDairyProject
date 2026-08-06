package Delivery;

public class Delivery {

    private final String deliveryId;
    private final String quantity;
    private final String deliveryDate;
    private final String vehicleDriverId;

    public Delivery(String deliveryId, String quantity, String deliveryDate, String vehicleDriverId) {
        this.deliveryId = deliveryId;
        this.quantity = quantity;
        this.deliveryDate = deliveryDate;
        this.vehicleDriverId = vehicleDriverId;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getVehicleDriverId() {
        return vehicleDriverId;
    }
}
