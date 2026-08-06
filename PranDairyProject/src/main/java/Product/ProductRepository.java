package Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductRepository {

    private static final ObservableList<Product> PRODUCTS = FXCollections.observableArrayList();

    private ProductRepository() {
    }

    public static ObservableList<Product> getAllProducts() {
        return PRODUCTS;
    }

    public static void addProduct(Product product) {
        PRODUCTS.add(product);
    }
}
