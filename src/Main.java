package src;

import java.util.Scanner;

public class Main {

    Scanner sc = new Scanner(System.in);

    public void Username(){

        System.out.println("Please enter your username and password");

        int fail = 0;

        String currentuser = sc.next();

        String username = "alex.thimineur@quinnipiac.edu";

        String pass = sc.next();

        String password = "Alex";

        if(currentuser.equals(username) && pass.equals(password)){

        System.out.println("Log in success!");
        this.Menu();

        }
          
       else{

        while (fail != 3) {   
        
            if(currentuser.equals(username) && pass.equals(password)){

                System.out.println("Log in success!");
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
        
 
        public void Menu(){

            System.out.println("Which option would you like to choose? Type B for Buy. Type S for Sell. Type C for Cart. Type L for Logout.");

            String choice = sc.next().toUpperCase();
            String B = "B";
            String S = "S";
            String C = "C";
            String L = "L";

        if(choice.equals(B)){


        }

        if (choice.equals(S)) {
            
           // Sell s = new Sell();

            //Scanner scanner;
            //User currentuser = new User();
            //ArrayList<List> = itemsForSale;


            //s.Sell(scanner, currentuser, itemsForSale);
        }

        if (choice.equals(C)) {
            
            Cart c = new Cart();
            c.showCart();
        }

        if (choice.equals(L)){

        }
            
        }

        
         
    public static void main(String[] args) {
        
        System.out.println("\n #     #                                                                                            ######                     #                  ### \n #  #  # ###### #       ####   ####  #    # ######    #####  ####     ##### #    # ######     ####  #     #   ##   #   #      # #   #####  #####  ### \n #  #  # #      #      #    # #    # ##  ## #           #   #    #      #   #    # #         #    # #     #  #  #   # #      #   #  #    # #    # ### \n #  #  # #####  #      #      #    # # ## # #####       #   #    #      #   ###### #####     #    # ######  #    #   #      #     # #    # #    #  #  \n #  #  # #      #      #      #    # #    # #           #   #    #      #   #    # #         #  # # #     # ######   #      ####### #####  #####      \n #  #  # #      #      #    # #    # #    # #           #   #    #      #   #    # #         #   #  #     # #    #   #      #     # #      #      ### \n  ## ##  ###### ######  ####   ####  #    # ######      #    ####       #   #    # ######     ### # ######  #    #   #      #     # #      #      ### \n                                                                                                                                                      \n   \n ");

        Main obj = new Main();

        obj.Username();
        
    } 
}
