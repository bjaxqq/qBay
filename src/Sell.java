package src;
import java.util.ArrayList;
import java.util.Scanner;

public class Sell {

    // Entry point for the Sell menu
    public static void showSellMenu(Scanner scanner, User currentUser, ArrayList<Item> itemsForSale) {
        while (true) {
            // Display sell menu options
            System.out.println("\nSell Menu:\n1. View My Items\n2. Add New Item\n3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                //  View Current Items for Sale 
                case "1":
                    System.out.println("\nYour Current Listings:");
                    boolean hasItems = false;

                    // Loop through all items for sale and display only the current user's items
                    for (Item item : itemsForSale) {
                        if (item.getSeller().equals(currentUser)) {
                            System.out.println("- " + item.getName() + " (" + item.getCategory() + ") - $" + String.format("%.2f", item.getPrice()));
                            hasItems = true;
                        }
                    }

                    // If user has no items listed
                    if (!hasItems) {
                        System.out.println("You have no items for sale.");
                    }
                    break;

                //  Add a New Item for Sale 
                case "2":
                    // Prompt user to enter item details
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    // Create a new item and add to the global list
                    Item newItem = new Item(name, category, price, currentUser);
                    itemsForSale.add(newItem);

                    System.out.println("Item added successfully!");
                    break;

                // Option to Go Back to Main Menu 
                case "3":
                    // Exit the sell menu
                    return;

                // Handle invalid inputs
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
