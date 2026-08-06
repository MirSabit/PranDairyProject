package RawMilkInspection;

public class RawMilkInspection {

    private String batchId;
    private String supplierName;
    private String quantity;
    private String fatPercent;
    private String phLevel;
    private String result;

    public RawMilkInspection(String batchId, String supplierName, String quantity, String fatPercent, String phLevel, String result) {
        this.batchId = batchId;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.fatPercent = fatPercent;
        this.phLevel = phLevel;
        this.result = result;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getFatPercent() {
        return fatPercent;
    }

    public String getPhLevel() {
        return phLevel;
    }

    public String getResult() {
        return result;
    }
}
