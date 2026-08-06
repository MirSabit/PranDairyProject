package InventoryLog;


public class InventoryLog {

    private String itemId;
    private String date;
    private String quantityChanged;
    private String reason;

    public InventoryLog(String itemId, String date, String quantityChanged, String reason) {
        this.itemId = itemId;
        this.date = date;
        this.quantityChanged = quantityChanged;
        this.reason = reason;
    }

    public String getItemId() {
        return itemId;
    }

    public String getDate() {
        return date;
    }

    public String getQuantityChanged() {
        return quantityChanged;
    }

    public String getReason() {
        return reason;
    }
}
