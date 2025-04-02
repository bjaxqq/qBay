package src;

import java.util.ArrayList;

/**
 * Handles shopping cart functionality
 */
public class Cart {
    private static ArrayList<Item> cartItems = new ArrayList<>();

    /**
     * Adds an item to the cart
     * @param item The item to add
     */
    public static void addToCart(Item item) {
        if(item != null) {
            cartItems.add(item);
        }
    }

    /**
     * @return List of items in cart
     */
    public static ArrayList<Item> getCartItems() {
        return cartItems;
    }

    /**
     * Displays cart contents and handles cart operations
     */
    public static void showCart() {
        System.out.println("\n--- YOUR CART ---");
        
        if(cartItems.isEmpty()) {
            System.out.println("(Your cart is empty)");
        } 
        else {
            double total = 0;
            for(int i = 0; i < cartItems.size(); i++) {
                Item item = cartItems.get(i);
                System.out.printf("%d. %s - $%.2f%n", 
                    i+1, item.getName(), item.getPrice());
                total += item.getPrice();
            }
            System.out.printf("TOTAL: $%.2f%n", total);
        }
        
        System.out.println("\n1. Checkout");
        System.out.println("2. Remove item");
        System.out.println("3. Back to menu");
        System.out.print("Choose: ");
    }

    /**
     * Completes purchase and clears cart
     */
    public static void checkout() {
        if(!cartItems.isEmpty()) {
            System.out.println("\nPurchase complete! Items will be shipped.");
            cartItems.clear();
        } else {
            System.out.println("\nYour cart is empty!");
        }
    }

    /**
     * Removes specified item from cart
     * @param index The index of item to remove
     */
    public static void removeItem(int index) {
        if(index >= 0 && index < cartItems.size()) {
            Item removed = cartItems.remove(index);
            System.out.println(removed.getName() + " removed from cart.");
        } else {
            System.out.println("Invalid item number.");
        }
    }
}