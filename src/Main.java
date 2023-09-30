import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
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
        };

        //TODO Fix price

        for(int i = 0;i< productList.length;i++){
            productList[i] = new ArrayList<Product>();
        }

        productList[0].add(new Product("Lemon", productGroup[0], categories[0],42.54));
        productList[0].add(new Product("Lime", productGroup[0], categories[0],42.54));
        productList[0].add(new Product("Orange", productGroup[0], categories[0],42.54));
        productList[0].add(new Product("Satsuma", productGroup[0], categories[0],42.54));
        productList[0].add(new Product("Grapefruit", productGroup[0], categories[0],42.54));
        productList[0].add(new Product("Clementine", productGroup[0], categories[0],42.54));

        productList[1].add(new Product("Granny Smith Apple", productGroup[0], categories[1],42.54));
        productList[1].add(new Product("Pink Lady Apple", productGroup[0], categories[1],42.54));
        productList[1].add(new Product("Royal Gala Apple", productGroup[0], categories[1],42.54));

        productList[2].add(new Product("Peach", productGroup[0], categories[2],42.54));
        productList[2].add(new Product("Nectarine", productGroup[0], categories[2],42.54));
        productList[2].add(new Product("Apricot", productGroup[0], categories[2],42.54));
        productList[2].add(new Product("Plum", productGroup[0], categories[2],42.54));

        productList[3].add(new Product("Banana", productGroup[0], categories[3],42.54));
        productList[3].add(new Product("Banana ECO", productGroup[0], categories[3],42.54));
        productList[3].add(new Product("Watermelon", productGroup[0], categories[3],42.54));
        productList[3].add(new Product("Cantaloupe", productGroup[0], categories[3],42.54));
        productList[3].add(new Product("Honey Melon", productGroup[0], categories[3],42.54));
        productList[3].add(new Product("Pear", productGroup[0], categories[3],42.54));

        productList[4].add(new Product("Carrot", productGroup[1], categories[4],42.54));
        productList[4].add(new Product("Parsnip", productGroup[1], categories[4],42.54));
        productList[4].add(new Product("Potato", productGroup[1], categories[4],142.54));
        productList[4].add(new Product("Sweet Potato", productGroup[1], categories[4],142.54));
        productList[4].add(new Product("Horseradish", productGroup[1], categories[4],142.54));
        productList[4].add(new Product("Beetroot", productGroup[1], categories[4],142.54));
        productList[4].add(new Product("Swedish Turnip", productGroup[1], categories[4],42.54));

        productList[5].add(new Product("Yellow Onion",productGroup[1], categories[5],42.54));
        productList[5].add(new Product("Red Onion", productGroup[1], categories[5],42.54));
        productList[5].add(new Product("White Onion", productGroup[1], categories[5],42.54));
        productList[5].add(new Product("Garlic", productGroup[1], categories[5],42.54));
        productList[5].add(new Product("Shallot", productGroup[1], categories[5],42.54));
        productList[5].add(new Product("Leek", productGroup[1], categories[5],42.54));
        productList[5].add(new Product("Green Onion", productGroup[1], categories[5],42.54));

        productList[6].add(new Product("Chanterelle", productGroup[1], categories[6],42.54));
        productList[6].add(new Product("Champignon", productGroup[1], categories[6],42.54));
        productList[6].add(new Product("Porcini", productGroup[1], categories[6],42.54));
        productList[6].add(new Product("Portabello", productGroup[1], categories[6],42.54));
        productList[6].add(new Product("Shiitake", productGroup[1], categories[6],42.54));

        productList[7].add(new Product("Red Bell Pepper", productGroup[1], categories[7],42.54));
        productList[7].add(new Product("Yellow Bell Pepper", productGroup[1], categories[7],42.54));
        productList[7].add(new Product("Green Bell Pepper", productGroup[1], categories[7],42.54));
        productList[7].add(new Product("Red Chili", productGroup[1], categories[7],42.54));
        productList[7].add(new Product("Jalapeno", productGroup[1], categories[7],42.54));
        productList[7].add(new Product("Habanero", productGroup[1], categories[7],42.54));

        productList[8].add(new Product("Brussels Sprouts", productGroup[1], categories[8],42.54));
        productList[8].add(new Product("Broccoli", productGroup[1], categories[8],42.54));
        productList[8].add(new Product("Turnip", productGroup[1], categories[8],42.54));
        productList[8].add(new Product("Cauliflower", productGroup[1], categories[8],42.54));
        productList[8].add(new Product("Cabbage", productGroup[1], categories[8],42.54));
        productList[8].add(new Product("Red Cabbage", productGroup[1], categories[8],42.54));
        productList[8].add(new Product("Kale", productGroup[1], categories[8],42.54));

        productList[9].add(new Product("Ginger", productGroup[1], categories[9],42.54));
        productList[9].add(new Product("Cucumber", productGroup[1], categories[9],42.54));
        productList[9].add(new Product("Tomato", productGroup[1], categories[9],42.54));
        productList[9].add(new Product("Asparagus", productGroup[1], categories[9],42.54));
        productList[9].add(new Product("Radish", productGroup[1], categories[9],42.54));

    }

    private static void menu(){
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
                0. Exit program
                ----------------------------""");

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
                        System.out.println("\nExiting program...");
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

    private static void searchProduct(){
        ArrayList<Product> matchingProducts;

        do{
            System.out.println("\nPRODUCT SEARCH\nEnter the name of the product. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");
            String productName = input.nextLine().toLowerCase();

            if(returnToMenu(productName)){
                System.out.println("\nReturning to menu...");
                return;
            }
            matchingProducts = findMatchingProduct(productName);
        }while(matchingProducts.isEmpty());

        int productChoice = chooseMatchingProduct(matchingProducts);

        if(productChoice>0){

            productChoice-=1;
            Product chosenProduct = matchingProducts.get(productChoice);

            System.out.println("\nCHOSEN PRODUCT:\n--------------------------------------------------------------------");
            System.out.println(chosenProduct);
            System.out.println("--------------------------------------------------------------------");

            calculatePrice(chosenProduct);
        }

    }

    private static void navigateToProduct(){
        //TODO Check if you need this arraylist
        ArrayList<Product> matchingProducts;

        int productGroupChoice = 0;

        do{
            System.out.println("\nPRODUCT NAVIGATION\nChoose a product group. \"0\" to return to main menu.");
            System.out.println("\nGROUPS:\n--------------");
            for(int i=0;i<productGroup.length;i++){
                System.out.printf("%-3s %-13s%n",(i+1)+".",productGroup[i]);
            }
            System.out.println("--------------");

            try{
                System.out.print("\nYour choice: ");
                productGroupChoice = input.nextInt();
                input.nextLine();

                if(returnToMenu(productGroupChoice)){
                    System.out.println("\nReturning to menu...");
                    return;
                }

                if(productGroupChoice<1 || productGroupChoice>2){
                    System.out.println("\nThat category does not exist. Try again.");
                }

            }catch(InputMismatchException e){
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();

            }


        }while(productGroupChoice<=0 || productGroupChoice>productGroup.length);

        System.out.println("\nCATEGORIES:");
        System.out.println("--------------------");
        if(productGroupChoice == 1){
            for(int i=0;i<4;i++){
                System.out.printf("%-3s %-17s%n",(i+1)+".",categories[i]);
            }
        }else{
            for(int i=4;i< categories.length;i++){
                System.out.printf("%-3s %-17s%n",(i-3)+".",categories[i]);
            }
        }
        System.out.println("--------------------");



    }
    private static void addProduct(){
        System.out.println("\nAdding product");
    }
    private static void removeProduct(){
        System.out.println("\nRemoving product");
    }
    private static void updateProduct(){
        System.out.println("\nUpdating product");
    }
    private static void printAllProducts(){
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
    private static ArrayList<Product> findMatchingProduct(String productName){
        ArrayList<Product> matchingProducts = new ArrayList<Product>();

        for(ArrayList<Product> category : productList){
            for(Product p : category){
                if(p.getName().equalsIgnoreCase(productName) || p.getName().toLowerCase().contains(productName)){
                    matchingProducts.add(p);
                }
            }
        }
        if(matchingProducts.isEmpty()){
            System.out.println("\nNo product found. Try again.");
        }
        return matchingProducts;
    }
    private static int chooseMatchingProduct(ArrayList<Product> matchingProducts){
        int productChoice=0;

        do{
            printMatchingProduct(matchingProducts);

            try{
                System.out.print("\nEnter number for the desired product. \"0\" to return to main menu.\nYour choice: ");
                productChoice = input.nextInt();
                input.nextLine();

                if(returnToMenu(productChoice)){
                    System.out.println("\nReturning to menu...");
                    return productChoice;
                }

                if(productChoice <1 || productChoice >matchingProducts.size()){
                    System.out.println("\nThat option does not exist. Try again.");
                }

            }catch(InputMismatchException e){
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }

        }while(productChoice <1 || productChoice >matchingProducts.size());

        return productChoice;
    }
    private static void printMatchingProduct(ArrayList<Product> matchingProducts){

        System.out.println("\nPRODUCTS FOUND:");
        System.out.println("------------------------------------------------------------------------");
        for(int i=0;i< matchingProducts.size();i++){
            System.out.printf("%-3s %s%n",(i+1)+".",matchingProducts.get(i));
        }
        System.out.println("------------------------------------------------------------------------");
    }
    private static void calculatePrice(Product chosenProduct){

        double productWeight=0;
        do{
            System.out.print("\nEnter product weight in kilograms. \"0\" to return to main menu.\nWeight: ");
            try{
                productWeight = input.useLocale(Locale.US).nextDouble();
                input.nextLine();
                if(returnToMenu(productWeight)){
                    System.out.println("\nReturning to menu...");
                    return;
                }
            }catch(InputMismatchException e){
                System.out.println("""
                    
                    Invalid input!
                    Please make sure that:
                    You are inputting a number.
                    You are using US decimal point. (E.g. "1.5")""");
                input.nextLine();
            }
        }while(productWeight<=0);

        double finalPrice = productWeight*chosenProduct.getPrice();
        System.out.println("\nThe price for "+productWeight+"kg "+chosenProduct.getName()+" is: ");
        System.out.printf(Locale.ENGLISH,"%.2fkr%n",finalPrice);

    }
    private static boolean returnToMenu(String userInput){
        return userInput.equals("0");
    }
    private static boolean returnToMenu(int userInput){
        return userInput == 0;
    }
    private static boolean returnToMenu(double userInput){
        return userInput == 0.0;
    }


}