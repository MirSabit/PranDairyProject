package ProductionTarget;


public class ProductionTarget {

    private String targetID;
    private String category;
    private String year;
    private String targetQuantity;

    public ProductionTarget(String targetID, String category, String year, String targetQuantity) {
        this.targetID = targetID;
        this.category = category;
        this.year = year;
        this.targetQuantity = targetQuantity;
    }

    public String getTargetID() {
        return targetID;
    }

    public String getCategory() {
        return category;
    }

    public String getYear() {
        return year;
    }

    public String getTargetQuantity() {
        return targetQuantity;
    }
}
