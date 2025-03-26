package src;

public class Cart {
    public static void showCart() {
        // These come from the real cart later
        String[] itemNames = {"Textbook", "Desk Lamp", "Coffee Mug"};
        double[] prices = {45.99, 22.50, 12.75};
        
        System.out.println("\n--- YOUR CART ---");
        
        // Show empty cart if no items
        if (itemNames.length == 0) {
            System.out.println("(Your cart is empty)");
        } 
        // Otherwise list items
        else {
            double total = 0;
            for (int i = 0; i < itemNames.length; i++) {
                System.out.printf("%d. %s - $%.2f%n", 
                    i+1, itemNames[i], prices[i]);
                total += prices[i];
            }
            System.out.printf("TOTAL: $%.2f%n", total);
        }
        
        // Basic menu
        System.out.println("\n1. Checkout");
        System.out.println("2. Remove item");
        System.out.println("3. Back to menu");
        System.out.print("Choose: ");
    }

    // Just for testing - can remove later
    public static void main(String[] args) {
        showCart();
    }
}