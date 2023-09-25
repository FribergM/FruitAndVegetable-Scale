import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */

public class Main {

    public static Scanner input = new Scanner(System.in);
    public static boolean menuLoop = true;

    public static String[] categories;
    public static ArrayList<Product>[] productList = new ArrayList[11];



    public static void main(String[] args) {
        System.out.println("Welcome to the Fruit & Vegetable Scale!");
        initializeProducts();
        menu();

    }

    private static void initializeProducts() {

        categories = new String[]{
            "Citrus Fruits",
            "Apples",
            "Stone Fruits",
            "Root Vegetables",
            "Onions",
            "Mushrooms",
            "Peppers",
            "Cole Crops",
            "Other",
            "Discounted Products"
        };

        //TODO Fix price

        for(int i = 0;i< productList.length;i++){
            productList[i] = new ArrayList<Product>();
        }

        productList[0].add(new Product("Lemon", categories[0],42.54));
        productList[0].add(new Product("Lime", categories[0],42.54));
        productList[0].add(new Product("Orange", categories[0],42.54,true,5.5));
        productList[0].add(new Product("Satsuma", categories[0],42.54));
        productList[0].add(new Product("Grapefruit", categories[0],42.54));
        productList[0].add(new Product("Clementine", categories[0],42.54));

        productList[1].add(new Product("Granny Smith", categories[1],42.54));
        productList[1].add(new Product("Pink Lady", categories[1],42.54));
        productList[1].add(new Product("Golden Delicious", categories[1],42.54));
        productList[1].add(new Product("Royal Gala", categories[1],42.54));

        productList[2].add(new Product("Peach", categories[2],42.54));
        productList[2].add(new Product("Nectarine", categories[2],42.54));
        productList[2].add(new Product("Apricot", categories[2],42.54));
        productList[2].add(new Product("Plum", categories[2],42.54));

        productList[3].add(new Product("Banana", categories[3],42.54));
        productList[3].add(new Product("Banana ECO", categories[3],42.54));
        productList[3].add(new Product("Watermelon", categories[3],42.54));
        productList[3].add(new Product("Cantaloupe", categories[3],42.54));
        productList[3].add(new Product("Honey Melon", categories[3],42.54));
        productList[3].add(new Product("Pear", categories[3],42.54));

        productList[4].add(new Product("Carrot", categories[4],42.54));
        productList[4].add(new Product("Parsnip", categories[4],42.54));
        productList[4].add(new Product("Potato", categories[4],42.54));
        productList[4].add(new Product("Sweet Potato", categories[4],42.54));
        productList[4].add(new Product("Horseradish", categories[4],42.54));
        productList[4].add(new Product("Beetroot", categories[4],42.54));
        productList[4].add(new Product("Swedish Turnip", categories[4],42.54));

        productList[5].add(new Product("Yellow Onion", categories[5],42.54));
        productList[5].add(new Product("Red Onion", categories[4],42.54));
        productList[5].add(new Product("White Onion", categories[4],42.54));
        productList[5].add(new Product("Garlic", categories[4],42.54));
        productList[5].add(new Product("Shallot", categories[4],42.54));
        productList[5].add(new Product("Leek", categories[4],42.54));
        productList[5].add(new Product("Green Onion", categories[4],42.54));

        productList[6].add(new Product("Chenterelle", categories[5],42.54));
        productList[6].add(new Product("Champignon", categories[5],42.54));
        productList[6].add(new Product("Porcini", categories[5],42.54));
        productList[6].add(new Product("Portabello", categories[5],42.54));
        productList[6].add(new Product("Shiitake", categories[5],42.54));

        productList[7].add(new Product("Red Bell Pepper", categories[6],42.54));
        productList[7].add(new Product("Yellow Bell Pepper", categories[6],42.54));
        productList[7].add(new Product("Green Bell Pepper", categories[6],42.54));
        productList[7].add(new Product("Red Chili", categories[6],42.54));
        productList[7].add(new Product("Japaleno", categories[6],42.54));
        productList[7].add(new Product("Habanero", categories[6],42.54));

        productList[8].add(new Product("Brussels Sprouts", categories[7],42.54));
        productList[8].add(new Product("Broccoli", categories[7],42.54));
        productList[8].add(new Product("Turnip", categories[7],42.54));
        productList[8].add(new Product("Cauliflower", categories[7],42.54));
        productList[8].add(new Product("Cabbage", categories[7],42.54));
        productList[8].add(new Product("Red Cabbage", categories[7],42.54));
        productList[8].add(new Product("Kale", categories[7],42.54));

        productList[9].add(new Product("Ginger", categories[8],42.54));
        productList[9].add(new Product("Cucumber", categories[8],42.54));
        productList[9].add(new Product("Tomato", categories[8],42.54));
        productList[9].add(new Product("Asparagus", categories[8],42.54));
        productList[9].add(new Product("Radish", categories[8],42.54));

        //Creates a category for all discounted products
        for(int i=0;i< categories.length;i++){
            for(Product p : productList[i]){
                if(p.getDiscount()){
                    productList[10].add(p);
                }
            }
        }

        /*
         * Citrus Fruit: Lemon, Lime, Orange, Satsuma, Grapefruit, Clementine
         * Apples: Granny Smith, Pink Lady, Golden Delicious, Royal Gala
         * Stone Fruit: Peach, Nectarine, Apricot, Plum
         * Other Fruit: Banana, Banana EKO, Watermelon, Cantaloupe, Honey melon, Pear
         * Roots: Carrot, Parsnip, Potato, Sweet potato, Horseradish, Beetroot, Swedish Turnip
         * Onions: Yellow Onion, White Onion, Red Onion, Garlic, Shallot, Leek, Green onion
         * Mushrooms: Chanterelle, Champignon, Porcini, Portabello, Shiitake
         * Peppers: Red/Green/yellow Bell pepper, Red Chili, Jalapeño, Habanero
         * Cole Crops: Brussels Sprouts, Broccoli, Turnip, Cauliflower, Cabbage, Red Cabbage, Kale
         * Other Vegetables: Ginger, Cucumber, Tomato, Asparagus, Radish
         */
    }

    public static void menu(){
        while (menuLoop){
            System.out.println("""
                    
                    Please choose a menu option!
                    ----------------------------
                    1. Search for product
                    2. Navigate to product
                    3. Add a product
                    4. Remove a product
                    5. Update a product
                    0. Exit program""");

            try {
                System.out.print("\nYour choice: ");
                int menuChoice = input.nextInt();
                input.nextLine();

                switch(menuChoice){
                    case 1 -> searchProduct();
                    case 2 -> navigateToProduct();
                    case 3 -> addProduct();
                    case 4 -> removeProduct();
                    case 5 -> updateProduct();
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

        //TODO Prints everything. Remove later.
        for(int i=0;i<productList.length;i++){
            for(Product p : productList[i]){
                System.out.println(p.toString());
            }
            System.out.println();
        }

    }
    public static void navigateToProduct(){
        System.out.println("\nNavigating to product");
        returnToMenu();
    }
    public static void addProduct(){
        System.out.println("\nAdding product");
        returnToMenu();
    }
    public static void removeProduct(){
        System.out.println("\nRemoving product");
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