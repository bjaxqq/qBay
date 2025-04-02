package src;

/**
 * Represents an item available for purchase/sale
 */
public class Item {
    private String name;
    private String category;
    private double price;
    private User seller;

    public Item(String name, String category, double price, User seller) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.seller = seller;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public User getSeller() {
        return seller;
    }
}