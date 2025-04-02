package src;

import java.util.ArrayList;
import java.util.Scanner;






public class Main {

    Scanner sc = new Scanner(System.in);

    ArrayList<Item> itemsForSale = new ArrayList<>();

    User currentUser;

    public void Username(){

        System.out.println("Please enter your username and password");

        int fail = 0;

        String currentuser = sc.next();

        String username = "alex.thimineur@quinnipiac.edu";

        String pass = sc.next();

        String password = "Alex";

        if(currentuser.equals(username) && pass.equals(password)){
         System.out.println("Log in success!");
         currentUser = new User("Alex", "Thimineur", "alex.thimineur@quinnipiac.edu");
       
        this.Menu();
        }
          
       else{

        while (fail != 3) {   
        
            if(currentuser.equals(username) && pass.equals(password)){
                System.out.println("Log in success!");
                currentUser = new User("Alex", "Thimineur", "alex.thimineur@quinnipiac.edu");
                 this.Menu();
                break;
            }
                   
                    
                    else{

                        System.out.println("Log in not successful, try again.");
                        fail++;
                        currentuser = sc.next();
                        pass = sc.next();  
                    }
            
                    if(fail == 3){
            
                        System.out.println("You have been locked out due to suspicious activity and forced to leave the application");
                        break;
                            }
                          }

                        }  

                    }


                    public void Menu() {
                        while (true) {
                            System.out.println("\nWhich option would you like to choose?");
                                System.out.println("Type B for Buy. Type S for Sell. Type C for Cart. Type L for Logout.");
                                System.out.print("Enter your choice: ");
                    
                                String choice = sc.next().toUpperCase();
                    
                                if (choice.equals("B")) {
                                    Buy buy = new Buy();
                                    buy.Items();
                                } else if (choice.equals("S")) {
                                    Sell.showSellMenu(sc, currentUser, itemsForSale);
                                } else if (choice.equals("C")) {
                                    Cart c = new Cart();
                                    c.showCart();
                                } else if (choice.equals("L")) {
                                    Logout.handleLogout(); // Exits the program
                                } else {
                                    System.out.println("Invalid option. Please try again.");
                                }
                            }
                        }     
                                
                                
     public static void main(String[] args) {
        
        System.out.println("\n #     #                                                                                            ######                     #                  ### \n #  #  # ###### #       ####   ####  #    # ######    #####  ####     ##### #    # ######     ####  #     #   ##   #   #      # #   #####  #####  ### \n #  #  # #      #      #    # #    # ##  ## #           #   #    #      #   #    # #         #    # #     #  #  #   # #      #   #  #    # #    # ### \n #  #  # #####  #      #      #    # # ## # #####       #   #    #      #   ###### #####     #    # ######  #    #   #      #     # #    # #    #  #  \n #  #  # #      #      #      #    # #    # #           #   #    #      #   #    # #         #  # # #     # ######   #      ####### #####  #####      \n #  #  # #      #      #    # #    # #    # #           #   #    #      #   #    # #         #   #  #     # #    #   #      #     # #      #      ### \n  ## ##  ###### ######  ####   ####  #    # ######      #    ####       #   #    # ######     ### # ######  #    #   #      #     # #      #      ### \n                                                                                                                                                      \n   \n ");

        Main obj = new Main();

        obj.Username();
        
    } 
}
