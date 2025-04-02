package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Buy {

public void Items(){

    System.out.println("Here are the items for sale. Please select the item you would like by typing the name."); 
    
    String[] list = {"Textbook", "Desk Lamp", "Coffee Mug"};
    System.out.println(Arrays.toString(list));

    Scanner sc = new Scanner(System.in);

    //make 3 item objects for each of the items

    User user1 = new User("Christian", "Duncan", "christianduncan@gmail.com");
    User user2 = new User("Aditi", "Baghel", "asbaghel@gmail.com");
    User user3 = new User("Brian", "O'Neill", "oneillbrian@gmail.com");

    Item item1 = new Item("Textbook", "School Supplies", 45.99, user1);
    Item item2 = new Item("Desk Lamp", "Dorm Items", 22.50, user2);
    Item item3 = new Item("Coffee Mug", "Dorm Items", 12.75, user3);
    ArrayList<Item> itemForSale = new ArrayList<>();

    itemForSale.add(item1);
    itemForSale.add(item2);
    itemForSale.add(item3);

    String option = sc.nextLine().toUpperCase();
    String option2 = null;
    String info = "INFO";
    System.out.println(option);

    if(option.equals("TEXTBOOK") || option.equals("DESK LAMP") || option.equals("COFFEE MUG")){

        System.out.println("Type C if you would like to add the item to cart?");
        System.out.println("Or type Info to find out more information on the item");
        option2 = sc.next().toUpperCase();
       
    }
    
    if(option2.equals("C")){

        Cart cart = new Cart();
        cart.showCart();

    }

    //Item item;

    
    else if(option2.equals(info) && option.equals("TEXTBOOK")){

       System.out.println("Item Name: " + item1.getName());
       System.out.println("Category: " + item1.getCategory());
       System.out.println("Price: " + item1.getPrice());
       System.out.println("Seller: " + item1.getSeller().getFullName() + ", " + item1.getSeller().getEmail());

    }

    else if(option2.equals(info) && option.equals("DESK LAMP")){

        System.out.println("Item Name: " + item2.getName());
        System.out.println("Category: " + item2.getCategory());
        System.out.println("Price: " + item2.getPrice());
        System.out.println("Seller: " + item2.getSeller().getFullName() + ", " + item2.getSeller().getEmail());
    }
    else if(option2.equals(info) && option.equals("COFFEE MUG")){

        System.out.println("Item Name: " + item3.getName());
        System.out.println("Category: " + item3.getCategory());
        System.out.println("Price: " + item3.getPrice());
        System.out.println("Seller: " + item3.getSeller().getFullName() + ", " + item3.getSeller().getEmail());
    }

    
}
public static void main(String[] args){

    Buy obj = new Buy();

    obj.Items();

   
}
}

