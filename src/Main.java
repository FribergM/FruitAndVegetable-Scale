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

    public static String[] productGroup;
    public static String[] categories;
    public static ArrayList<Product>[] productList = new ArrayList[10];

    public static void main(String[] args) {
        System.out.println("Welcome to the Fruit & Vegetable Scale!");
        initializeProducts();
        menu();

    }

    private static void initializeProducts() {

        productGroup = new String[]{"Fruit","Vegetables"};

        categories = new String[]{
            "Citrus Fruit",
            "Apples",
            "Stone Fruit",
            "Other Fruit",
            "Root Vegetables",
            "Onions",
            "Mushrooms",
            "Peppers",
            "Cole Crops",
            "Other Vegetables",
            "Discounted Products"
        };

        //TODO Fix price

        for(int i = 0;i< productList.length;i++){
            productList[i] = new ArrayList<Product>();
        }

        productList[0].add(new Product("Lemon", categories[0],42.54));
        productList[0].add(new Product("Lime", categories[0],42.54));
        productList[0].add(new Product("Orange", categories[0],42.54));
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
        productList[4].add(new Product("Potato", categories[4],142.54));
        productList[4].add(new Product("Sweet Potato", categories[4],142.54));
        productList[4].add(new Product("Horseradish", categories[4],142.54));
        productList[4].add(new Product("Beetroot", categories[4],142.54));
        productList[4].add(new Product("Swedish Turnip", categories[4],42.54));

        productList[5].add(new Product("Yellow Onion", categories[5],42.54));
        productList[5].add(new Product("Red Onion", categories[5],42.54));
        productList[5].add(new Product("White Onion", categories[5],42.54));
        productList[5].add(new Product("Garlic", categories[5],42.54));
        productList[5].add(new Product("Shallot", categories[5],42.54));
        productList[5].add(new Product("Leek", categories[5],42.54));
        productList[5].add(new Product("Green Onion", categories[5],42.54));

        productList[6].add(new Product("Chanterelle", categories[6],42.54));
        productList[6].add(new Product("Champignon", categories[6],42.54));
        productList[6].add(new Product("Porcini", categories[6],42.54));
        productList[6].add(new Product("Portabello", categories[6],42.54));
        productList[6].add(new Product("Shiitake", categories[6],42.54));

        productList[7].add(new Product("Red Bell Pepper", categories[7],42.54));
        productList[7].add(new Product("Yellow Bell Pepper", categories[7],42.54));
        productList[7].add(new Product("Green Bell Pepper", categories[7],42.54));
        productList[7].add(new Product("Red Chili", categories[7],42.54));
        productList[7].add(new Product("Jalapeno", categories[7],42.54));
        productList[7].add(new Product("Habanero", categories[7],42.54));

        productList[8].add(new Product("Brussels Sprouts", categories[8],42.54));
        productList[8].add(new Product("Broccoli", categories[8],42.54));
        productList[8].add(new Product("Turnip", categories[8],42.54));
        productList[8].add(new Product("Cauliflower", categories[8],42.54));
        productList[8].add(new Product("Cabbage", categories[8],42.54));
        productList[8].add(new Product("Red Cabbage", categories[8],42.54));
        productList[8].add(new Product("Kale", categories[8],42.54));

        productList[9].add(new Product("Ginger", categories[9],42.54));
        productList[9].add(new Product("Cucumber", categories[9],42.54));
        productList[9].add(new Product("Tomato", categories[9],42.54));
        productList[9].add(new Product("Asparagus", categories[9],42.54));
        productList[9].add(new Product("Radish", categories[9],42.54));

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
                    6. Print all products
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
                    case 6 -> printAllProducts();
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

        ArrayList<Product> tempProductList = new ArrayList<Product>();

        System.out.print("\nEnter product name: ");
        String productName = input.nextLine().toLowerCase();
        System.out.println();
        for(ArrayList<Product> category : productList){
            for(Product p : category){
                if(p.getName().toLowerCase().contains(productName)|| p.getProductCategory().toLowerCase().contains(productName)){
                    tempProductList.add(p);
                }
            }
        }
        System.out.println("-----------------------------------------------------------------------");
        for(int i=0;i< tempProductList.size();i++){
            System.out.println((i+1)+". "+tempProductList.get(i));
        }
        System.out.println("-----------------------------------------------------------------------");
//        for (Product p : tempProductList){
//            System.out.println(p);
//        }

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
    public static void removeProduct(){
        System.out.println("\nRemoving product");
        returnToMenu();
    }
    public static void updateProduct(){
        System.out.println("\nUpdating product");
        returnToMenu();
    }
    public static void printAllProducts(){
        //TODO Figure out of you need this..
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-20s| %-13s| %-17s| %-12s%n","Product","Group","Category","Price");
        System.out.println("--------------------------------------------------------------------");
        for (ArrayList<Product> category : productList) {
            for (Product p : category) {
                System.out.println(p.toString());
            }
            System.out.println("--------------------------------------------------------------------");
        }
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