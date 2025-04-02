package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Buy {
    
    /**
     * Displays items for sale and handles purchase flow
     */
    public void Items() {
        System.out.println("\nHere are the items for sale. Please select the item you would like by typing the name."); 
        
        // Initialize available items
        String[] list = {"Textbook", "Desk Lamp", "Coffee Mug", "Dorm Chair", "Calculus Notes"};
        System.out.println(Arrays.toString(list));

        Scanner sc = new Scanner(System.in); // Removed try-with-resources

        // Create sample users
        User user1 = new User("Christian", "Duncan", "christianduncan@gmail.com");
        User user2 = new User("Aditi", "Baghel", "asbaghel@gmail.com");
        User user3 = new User("Brian", "O'Neill", "oneillbrian@gmail.com");

        // Create items for sale
        ArrayList<Item> itemsForSale = new ArrayList<>();
        itemsForSale.add(new Item("Textbook", "School Supplies", 45.99, user1));
        itemsForSale.add(new Item("Desk Lamp", "Dorm Items", 22.50, user2));
        itemsForSale.add(new Item("Coffee Mug", "Dorm Items", 12.75, user3));
        itemsForSale.add(new Item("Dorm Chair", "Furniture", 35.00, user1));
        itemsForSale.add(new Item("Calculus Notes", "School Supplies", 8.99, user3));

        String option = sc.nextLine().toUpperCase();
        String option2 = null;
        final String INFO = "INFO";
        
        if(option.equals("TEXTBOOK") || option.equals("DESK LAMP") || 
           option.equals("COFFEE MUG") || option.equals("DORM CHAIR") || 
           option.equals("CALCULUS NOTES")) {
            
            System.out.println("\nType C to add the item to cart");
            System.out.println("Or type Info for more details");
            option2 = sc.nextLine().toUpperCase();
        }
        
        if(option2 != null && option2.equals("C")) {
            // Add selected item to cart
            Cart.addToCart(findItemByName(itemsForSale, option));
            System.out.println(option + " added to cart!");
        }
        else if(option2 != null && option2.equals(INFO)) {
            displayItemInfo(itemsForSale, option);
        }
    }

    /**
     * Helper method to find item by name
     */
    private Item findItemByName(ArrayList<Item> items, String name) {
        for(Item item : items) {
            if(item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Displays detailed information about an item
     */
    private void displayItemInfo(ArrayList<Item> items, String itemName) {
        Item item = findItemByName(items, itemName);
        if(item != null) {
            System.out.println("\n--- ITEM DETAILS ---");
            System.out.println("Name: " + item.getName());
            System.out.println("Category: " + item.getCategory());
            System.out.println("Price: $" + String.format("%.2f", item.getPrice()));
            System.out.println("Seller: " + item.getSeller().getFullName() + 
                              ", " + item.getSeller().getEmail());
        }
    }
}