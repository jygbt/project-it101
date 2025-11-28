package it.project.util;

public class Item {

    private String itemName;
    private String itemPrice;
    private String itemImagePath;

    public  Item(String itemName, String itemPrice, String itemImagePath) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImagePath = itemImagePath;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public double getPrice() {
        return Double.parseDouble(itemPrice);
    }

    public String getItemImagePath() {
        return itemImagePath;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setItemImagePath(String itemImagePath) {
        this.itemImagePath = itemImagePath;
    }
}
