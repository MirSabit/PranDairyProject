package Product;

public class Product {

    private String productId;
    private String productName;
    private String category;
    private String description;

    public Product(String productId, String productName, String category, String description) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.description = description;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }
}
