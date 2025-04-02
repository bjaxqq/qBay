package src;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main application class handling login and menu navigation
 */
public class Main {
    private Scanner sc;
    private ArrayList<Item> itemsForSale;
    private User currentUser;

    public Main() {
        this.sc = new Scanner(System.in);
        this.itemsForSale = new ArrayList<>();
    }

    /**
     * Handles user login process
     */
    public void Username() {
        System.out.println("Please enter your username and password");
        int fail = 0;

        while(fail < 3) {
            System.out.print("Username: ");
            String username = sc.nextLine();
            
            System.out.print("Password: ");
            String password = sc.nextLine();

            if(validateLogin(username, password)) {
                System.out.println("Log in success!");
                this.Menu();
                return;
            } else {
                fail++;
                if(fail < 3) {
                    System.out.println("Log in not successful, try again.");
                }
            }
        }

        System.out.println("You have been locked out due to suspicious activity");
        System.exit(0);
    }

    /**
     * Validates user credentials
     */
    private boolean validateLogin(String username, String password) {
        // Hardcoded valid credentials
        if(username.equals("alex.thimineur@quinnipiac.edu") && password.equals("Alex")) {
            currentUser = new User("Alex", "Thimineur", "alex.thimineur@quinnipiac.edu");
            return true;
        }
        if(username.equals("test2@quinnipiac.edu") && password.equals("pass2")) {
            currentUser = new User("Test", "User2", "test2@quinnipiac.edu");
            return true;
        }
        return false;
    }

    /**
     * Displays main menu and handles user selection
     */
    public void Menu() {
        while(true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("B - Buy");
            System.out.println("S - Sell");
            System.out.println("C - Cart");
            System.out.println("L - Logout");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().toUpperCase();

            switch(choice) {
                case "B":
                    new Buy().Items();
                    break;
                case "S":
                    Sell.showSellMenu(sc, currentUser, itemsForSale);
                    break;
                case "C":
                    handleCartMenu();
                    break;
                case "L":
                    Logout.handleLogout();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Handles cart menu operations
     */
    private void handleCartMenu() {
        Cart.showCart();
        if(!Cart.getCartItems().isEmpty()) {
            System.out.print("Enter choice: ");
            try {
                int cartChoice = Integer.parseInt(sc.nextLine());
                
                switch(cartChoice) {
                    case 1:
                        Cart.checkout();
                        break;
                    case 2:
                        System.out.print("Enter item number to remove: ");
                        int itemNum = Integer.parseInt(sc.nextLine());
                        Cart.removeItem(itemNum - 1);
                        break;
                    case 3:
                        // Return to main menu
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    public static void main(String[] args) {
        // Display welcome message
        System.out.println("\n #     #                                                                                            ######                     #                  ### \n #  #  # ###### #       ####   ####  #    # ######    #####  ####     ##### #    # ######     ####  #     #   ##   #   #      # #   #####  #####  ### \n #  #  # #      #      #    # #    # ##  ## #           #   #    #      #   #    # #         #    # #     #  #  #   # #      #   #  #    # #    # ### \n #  #  # #####  #      #      #    # # ## # #####       #   #    #      #   ###### #####     #    # ######  #    #   #      #     # #    # #    #  #  \n #  #  # #      #      #      #    # #    # #           #   #    #      #   #    # #         #  # # #     # ######   #      ####### #####  #####      \n #  #  # #      #      #    # #    # #    # #           #   #    #      #   #    # #         #   #  #     # #    #   #      #     # #      #      ### \n  ## ##  ###### ######  ####   ####  #    # ######      #    ####       #   #    # ######     ### # ######  #    #   #      #     # #      #      ### \n                                                                                                                                                      \n   \n ");

        Main obj = new Main();
        obj.Username();
    }
}