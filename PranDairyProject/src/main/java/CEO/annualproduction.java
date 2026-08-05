package CEO;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

public class annualproduction {

    private int itemID;
    private int year;
    private String item_category;
    private int item_target;


    public int getItemID() {
        return itemID;
    }

    public int getYear() {
        return year;
    }

    public String getItem_category() {
        return item_category;
    }

    public int getItem_target() {
        return item_target;
    }

    public void setItem_category(String item_category) {
        this.item_category = item_category;
    }

    public annualproduction(int itemID, int year, String item_category, int item_target) {
        this.itemID = itemID;
        this.year = year;
        this.item_category = item_category;
        this.item_target = item_target;
    }

    @Override
    public String toString() {
        return "annualproduction{" +
                "year=" + year +
                ", itemID=" + itemID +
                ", item_category='" + item_category + '\'' +
                ", item_target=" + item_target +
                '}';
    }
}
