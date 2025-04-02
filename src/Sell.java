package src;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles item selling functionality
 */
public class Sell {

    /**
     * Displays sell menu and handles user choices
     */
    public static void showSellMenu(Scanner scanner, User currentUser, ArrayList<Item> itemsForSale) {
        while(true) {
            System.out.println("\n--- SELL MENU ---");
            System.out.println("1. View My Items");
            System.out.println("2. Add New Item");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch(choice) {
                case "1":
                    viewMyItems(currentUser, itemsForSale);
                    break;
                case "2":
                    addNewItem(scanner, currentUser, itemsForSale);
                    break;
                case "3":
                    return; // Exit to main menu
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    /**
     * Displays current user's items for sale
     */
    private static void viewMyItems(User currentUser, ArrayList<Item> itemsForSale) {
        System.out.println("\nYour Current Listings:");
        boolean hasItems = false;

        for(Item item : itemsForSale) {
            if(item.getSeller().equals(currentUser)) {
                System.out.printf("- %s (%s) - $%.2f%n", 
                    item.getName(), item.getCategory(), item.getPrice());
                hasItems = true;
            }
        }

        if(!hasItems) {
            System.out.println("You have no items for sale.");
        }
    }

    /**
     * Handles adding a new item for sale
     */
    private static void addNewItem(Scanner scanner, User currentUser, ArrayList<Item> itemsForSale) {
        System.out.print("\nEnter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        double price = 0;
        while(true) {
            try {
                System.out.print("Enter price: ");
                price = Double.parseDouble(scanner.nextLine());
                if(price <= 0) throw new NumberFormatException();
                break;
            } catch(NumberFormatException e) {
                System.out.println("Invalid price! Must be positive number.");
            }
        }

        Item newItem = new Item(name, category, price, currentUser);
        itemsForSale.add(newItem);
        System.out.println("Item added successfully!");
    }
}