import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */

public class Main {

    public static boolean menuLoop = true;
    public static Scanner input = new Scanner(System.in);

    public static String[] categories;
    public static ArrayList<Product>[] productList;



    public static void main(String[] args) {
        initializeCategories();
        menu();

    }

    private static void initializeCategories() {
        categories = new String[]{"""
            Citrus Fruit
            Apples
            Stone Fruit
            Other Fruit
            Root Vegetables
            Onions
            Mushrooms
            Peppers
            Cole Crops
            Discounted Products"""
        };

        //TODO Initialize Arraylist with data.

        for (String s: categories) {
            System.out.println(s);
        }


        /*
         * Citrus Fruit: Lemon, Lime, Orange, Satsuma, Grapefruit, Clementine
         * Apples: Granny Smith, Pink Lady, Golden Delicious, Royal Gala
         * Stone Fruit: Peach, Nectarine, Apricot, Plum
         * Roots: Carrot, Parsnip, Potato, Sweet potato, Horseradish, Beetroot, Swedish Turnip
         * Onions: Yellow Onion, White Onion, Red Onion, Garlic, Shallot, Leek, Green onion
         * Mushrooms: Chanterelle, Champignon, Porcini, Portabello, Shiitake
         * Peppers: Red/Green/yellow Bell pepper, Red Chili, Jalapeño, Habanero
         * Cole Crops: Brussels Sprouts, Broccoli, Turnip, Cauliflower, Cabbage, Red Cabbage, Kale
         * Other: Banana, Banana EKO, Watermelon, Cantaloupe, Honey melon, Pear, Ginger, Cucumber, Tomato, Asparagus, Radish
         */
    }

    public static void menu(){
        while (menuLoop){
            System.out.println("""
                    
                    1. Search for product
                    2. Navigate to product
                    3. Add a product
                    4. Update a product
                    0. Exit program""");

            try {
                System.out.print("\nYour option: ");
                int menuChoice = input.nextInt();
                input.nextLine();

                switch(menuChoice){
                    case 1 -> searchProduct();
                    case 2 -> navigateToProduct();
                    case 3 -> addProduct();
                    case 4 -> updateProduct();
                    case 0 -> {
                        System.out.println("\nExiting program");
                        menuLoop = false;
                    }
                    default -> System.out.println("\nInvalid input. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }

        }
    }

    public static void searchProduct(){
        System.out.println("\nSearching for product");
        returnToMenu();
    }
    public static void navigateToProduct(){
        System.out.println("\nNavigating to product");
        returnToMenu();
    }
    public static void addProduct(){
        System.out.println("\nAdding product");
        returnToMenu();
    }
    public static void updateProduct(){
        System.out.println("\nUpdating product");
        returnToMenu();
    }
    public static void returnToMenu(){
        //TODO Figure out if you need this..
        /*
        System.out.println("\nWould you like to return to menu? Yes/No");
        String returnMenu = input.nextLine();
        if(returnMenu.equalsIgnoreCase("yes")){

        }else if(returnMenu.equalsIgnoreCase("no")){
            System.out.println("\nExiting program");
            menuLoop = false;
        }else{
            System.out.println("I didn't understand that");
        }
        */
    }
}