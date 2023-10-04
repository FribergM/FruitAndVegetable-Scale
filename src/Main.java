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
    public static String[] productCategory;
    public static ArrayList<Product>[] productList = new ArrayList[10];
    public static ArrayList<Product> tempProductList = new ArrayList<Product>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Fruit & Vegetable Scale!");
        initializeProducts();
        menu();
    }

    private static void initializeProducts() {

        productGroup = new String[]{"Fruit","Vegetables"};

        productCategory = new String[]{
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

        productList[0].add(new Product("Lemon", productGroup[0], productCategory[0],42.54));
        productList[0].add(new Product("Lime", productGroup[0], productCategory[0],42.54));
        productList[0].add(new Product("Orange", productGroup[0], productCategory[0],42.54));
        productList[0].add(new Product("Satsuma", productGroup[0], productCategory[0],42.54));
        productList[0].add(new Product("Grapefruit", productGroup[0], productCategory[0],42.54));
        productList[0].add(new Product("Clementine", productGroup[0], productCategory[0],42.54));

        productList[1].add(new Product("Granny Smith Apple", productGroup[0], productCategory[1],42.54));
        productList[1].add(new Product("Pink Lady Apple", productGroup[0], productCategory[1],42.54));
        productList[1].add(new Product("Royal Gala Apple", productGroup[0], productCategory[1],42.54));

        productList[2].add(new Product("Peach", productGroup[0], productCategory[2],42.54));
        productList[2].add(new Product("Nectarine", productGroup[0], productCategory[2],42.54));
        productList[2].add(new Product("Apricot", productGroup[0], productCategory[2],42.54));
        productList[2].add(new Product("Plum", productGroup[0], productCategory[2],42.54));

        productList[3].add(new Product("Banana", productGroup[0], productCategory[3],42.54));
        productList[3].add(new Product("Banana ECO", productGroup[0], productCategory[3],42.54));
        productList[3].add(new Product("Watermelon", productGroup[0], productCategory[3],42.54));
        productList[3].add(new Product("Cantaloupe", productGroup[0], productCategory[3],42.54));
        productList[3].add(new Product("Honey Melon", productGroup[0], productCategory[3],42.54));
        productList[3].add(new Product("Pear", productGroup[0], productCategory[3],42.54));

        productList[4].add(new Product("Carrot", productGroup[1], productCategory[4],42.54));
        productList[4].add(new Product("Parsnip", productGroup[1], productCategory[4],42.54));
        productList[4].add(new Product("Potato", productGroup[1], productCategory[4],142.54));
        productList[4].add(new Product("Sweet Potato", productGroup[1], productCategory[4],142.54));
        productList[4].add(new Product("Horseradish", productGroup[1], productCategory[4],142.54));
        productList[4].add(new Product("Beetroot", productGroup[1], productCategory[4],142.54));
        productList[4].add(new Product("Swedish Turnip", productGroup[1], productCategory[4],42.54));

        productList[5].add(new Product("Yellow Onion",productGroup[1], productCategory[5],42.54));
        productList[5].add(new Product("Red Onion", productGroup[1], productCategory[5],42.54));
        productList[5].add(new Product("White Onion", productGroup[1], productCategory[5],42.54));
        productList[5].add(new Product("Garlic", productGroup[1], productCategory[5],42.54));
        productList[5].add(new Product("Shallot", productGroup[1], productCategory[5],42.54));
        productList[5].add(new Product("Leek", productGroup[1], productCategory[5],42.54));
        productList[5].add(new Product("Green Onion", productGroup[1], productCategory[5],42.54));

        productList[6].add(new Product("Chanterelle", productGroup[1], productCategory[6],42.54));
        productList[6].add(new Product("Champignon", productGroup[1], productCategory[6],42.54));
        productList[6].add(new Product("Porcini", productGroup[1], productCategory[6],42.54));
        productList[6].add(new Product("Portabello", productGroup[1], productCategory[6],42.54));
        productList[6].add(new Product("Shiitake", productGroup[1], productCategory[6],42.54));

        productList[7].add(new Product("Red Bell Pepper", productGroup[1], productCategory[7],42.54));
        productList[7].add(new Product("Yellow Bell Pepper", productGroup[1], productCategory[7],42.54));
        productList[7].add(new Product("Green Bell Pepper", productGroup[1], productCategory[7],42.54));
        productList[7].add(new Product("Red Chili", productGroup[1], productCategory[7],42.54));
        productList[7].add(new Product("Jalapeno", productGroup[1], productCategory[7],42.54));
        productList[7].add(new Product("Habanero", productGroup[1], productCategory[7],42.54));

        productList[8].add(new Product("Brussels Sprouts", productGroup[1], productCategory[8],42.54));
        productList[8].add(new Product("Broccoli", productGroup[1], productCategory[8],42.54));
        productList[8].add(new Product("Turnip", productGroup[1], productCategory[8],42.54));
        productList[8].add(new Product("Cauliflower", productGroup[1], productCategory[8],42.54));
        productList[8].add(new Product("Cabbage", productGroup[1], productCategory[8],42.54));
        productList[8].add(new Product("Red Cabbage", productGroup[1], productCategory[8],42.54));
        productList[8].add(new Product("Kale", productGroup[1], productCategory[8],42.54));

        productList[9].add(new Product("Ginger", productGroup[1], productCategory[9],42.54));
        productList[9].add(new Product("Cucumber", productGroup[1], productCategory[9],42.54));
        productList[9].add(new Product("Tomato", productGroup[1], productCategory[9],42.54));
        productList[9].add(new Product("Asparagus", productGroup[1], productCategory[9],42.54));
        productList[9].add(new Product("Radish", productGroup[1], productCategory[9],42.54));

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
                5. Print all products
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
                    case 5 -> printAllProducts();
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

    private static void searchProduct() {

        do {
            System.out.println("\nPRODUCT SEARCH\nEnter the name of the product. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");
            String productName = input.nextLine().toLowerCase();

            if (returnToMenu(productName)) {
                System.out.println("\nReturning to menu...");
                return;
            }
            findMatchingProduct(productName);
        } while (tempProductList.isEmpty());

        Product chosenProduct = printChosenProduct();

        if(chosenProduct != null){
            calculatePrice(chosenProduct);
        }

        tempProductList.clear();
    }
    private static void navigateToProduct(){

        System.out.print("\nPRODUCT NAVIGATION");

        int userGroupChoice = getGroupChoice();

        if(returnToMenu(userGroupChoice)){
            System.out.println("\nReturning to menu...");
            return;
        }

        if(userGroupChoice == 1){

            int userCategoryChoice = getCategoryChoice(userGroupChoice,1,4);

            if(returnToMenu(userCategoryChoice)){
                System.out.println("\nReturning to menu...");
                return;
            }

            int fruitIndex = userCategoryChoice-1; // Grabs Fruit Objects from productList[0-3]
            for(Product p : productList[fruitIndex]){
                tempProductList.add(p);
            }

        }else if(userGroupChoice == 2){

            int userCategoryChoice = getCategoryChoice(userGroupChoice,1,6);

            if(returnToMenu(userCategoryChoice)){
                System.out.println("\nReturning to menu...");
                return;
            }

            int vegetableIndex = userCategoryChoice+3; // Grabs Vegetable Objects from productList[4-9]
            for(Product p : productList[vegetableIndex]){
                tempProductList.add(p);
            }
        }

        Product chosenProduct = printChosenProduct();

        if(chosenProduct != null){
            calculatePrice(chosenProduct);
        }

        tempProductList.clear();
    }
    private static void addProduct(){
        String productName;
        int group;
        int category;
        double productPrice;
        boolean alreadyExists;

        do{
            System.out.println("\nPRODUCT REGISTRATION\nEnter the name of the product you wish to register. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");

            productName = input.nextLine().toLowerCase();
            alreadyExists = false;

            for(ArrayList<Product> list : productList){ //Checks if product already exists
                for(Product p : list){
                    if(productName.equalsIgnoreCase(p.getName())){
                        System.out.println("\nA product with that name already exists. Try again.");
                        alreadyExists = true;
                        break;
                    }
                }
                if(alreadyExists){
                    break;
                }
            }
        }while(alreadyExists);


        if(returnToMenu(productName)){
            System.out.println("\nReturning to main...");
            return;
        }
        productName = Character.toUpperCase(productName.charAt(0))+productName.substring(1); // Capitalizes name

        group = getGroupChoice();
        if(returnToMenu(group)){
            System.out.println("\nReturning to main...");
            return;
        }

        category = 0;

        if(group == 1){
            category = getCategoryChoice(group,1,4);

            if(returnToMenu(category)){
                System.out.println("\nReturning to main...");
                return;
            }
            group-=1;
            category-=1; // changes it match selected index in productList[]

        }else if(group == 2){
            category = getCategoryChoice(group,1,6);

            if(returnToMenu(category)){
                System.out.println("\nReturning to main...");
                return;
            }
            group-=1;
            category += 3; // changes it match selected index in productList[]
        }

        productPrice = 0;

        do{
            System.out.println("\nEnter price in kr/kg for the product. \"0\" to return to main menu.");

            try{
                productPrice = input.useLocale(Locale.ENGLISH).nextDouble();

                if(returnToMenu(productPrice)){
                    System.out.println("\nReturning to main...");
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
        }while(productPrice <= 0);

        productList[category].add(new Product(productName,productGroup[group], productCategory[category],productPrice));
        System.out.println(productName+" has been registered!");

    }
    private static void removeProduct(){
        do {
            System.out.println("\nPRODUCT REMOVAL\nEnter the name of the product you wish to remove. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");
            String productName = input.nextLine().toLowerCase();

            if (returnToMenu(productName)) {
                System.out.println("\nReturning to menu...");
                return;
            }
            findMatchingProduct(productName);
        } while (tempProductList.isEmpty());

        Product chosenProduct = printChosenProduct();

        if(chosenProduct != null){
            for(int i=0;i<productList.length;i++){
                for(int j=0;j<productList[i].size();j++){
                    if(productList[i].get(j).getName().equalsIgnoreCase(chosenProduct.getName())){
                        productList[i].remove(j);
                    }
                }
            }
            System.out.println("\n"+chosenProduct.getName()+" has been removed!");
        }

        tempProductList.clear();
    }

    private static void findMatchingProduct(String productName){

        for(ArrayList<Product> category : productList){
            for(Product p : category){
                if(p.getName().equalsIgnoreCase(productName) || p.getName().toLowerCase().contains(productName)){
                    tempProductList.add(p);
                }
            }
        }
        if(tempProductList.isEmpty()){
            System.out.println("\nNo product found. Try again.");
        }
    }
    private static int getGroupChoice(){
        int userChoice = 0;

        do{
            System.out.println("\nChoose a product group by number. \"0\" to return to main menu.");

            printProductGroups();

            try{
                System.out.print("\nYour choice: ");
                userChoice = input.nextInt();
                input.nextLine();

                if(returnToMenu(userChoice)){
                    return 0;
                }

                if(userChoice <1 || userChoice >2){
                    System.out.println("\nThat category does not exist. Try again.");
                }

            }catch(InputMismatchException e){
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }
        }while(userChoice < 1 || userChoice > 2);

        return userChoice;
    }
    private static int getCategoryChoice(int userGroupChoice, int firstElement, int lastElement){

        int userCategoryChoice=0;

        do{
            System.out.println("\nChoose a category by number. \"0\" to return to main menu.");

            printProductCategory(userGroupChoice);

            try{
                System.out.print("\nYour choice: ");
                userCategoryChoice = input.nextInt();
                input.nextLine();

                if(returnToMenu(userCategoryChoice)){
                    return 0;
                }

                if(userCategoryChoice < firstElement || userCategoryChoice > lastElement){
                    System.out.println("\nThat category does not exist. Try again.");
                }

            }catch(InputMismatchException e){
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }
        }while(userCategoryChoice < firstElement || userCategoryChoice > lastElement);

        return userCategoryChoice;
    }
    private static int getProductChoice(){
        int productChoice=0;

        do{
            printProducts();

            try{
                System.out.print("\nChoose a product by number. \"0\" to return to main menu.\nYour choice: ");
                productChoice = input.nextInt();
                input.nextLine();

                if(returnToMenu(productChoice)){
                    System.out.println("\nReturning to menu...");
                    return 0;
                }

                if(productChoice <1 || productChoice > tempProductList.size()){
                    System.out.println("\nThat option does not exist. Try again.");
                }

            }catch(InputMismatchException e){
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }

        }while(productChoice <1 || productChoice > tempProductList.size());

        return productChoice;
    }

    private static void printAllProducts(){
        //TODO Figure out of you need this..
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-20s| %-13s| %-17s| %-12s%n","Product","Group","Category","Price");
        System.out.println("--------------------------------------------------------------------");
        for (ArrayList<Product> category : productList) {
            for (Product p : category) {
                System.out.println(p);
            }
            System.out.println("--------------------------------------------------------------------");
        }
    }
    private static void printProductGroups(){
        System.out.println("\nGROUPS:\n----------------------------");
        for(int i=0;i<productGroup.length;i++){
            System.out.printf("%-3s %-13s%n",(i+1)+".",productGroup[i]);
        }
        System.out.println("----------------------------");
    }
    private static void printProductCategory(int userChoice){
        System.out.println("\nCATEGORIES:");
        System.out.println("----------------------------");
        if(userChoice == 1){
            for(int i=0;i<4;i++){
                System.out.printf("%-3s %-17s%n",(i+1)+".", productCategory[i]);
            }
        }else{
            for(int i = 4; i< productCategory.length; i++){
                System.out.printf("%-3s %-17s%n",(i-3)+".", productCategory[i]);
            }
        }

        System.out.println("----------------------------");
    }
    private static void printProducts(){

        System.out.println("\nAVAILABLE PRODUCTS:");
        System.out.println("------------------------------------------------------------------------");
        for(int i = 0; i< tempProductList.size(); i++){
            System.out.printf("%-3s %s%n",(i+1)+".", tempProductList.get(i));
        }
        System.out.println("------------------------------------------------------------------------");
    }
    private static Product printChosenProduct(){

        int productChoice = getProductChoice();

        if(productChoice>0){

            Product chosenProduct = tempProductList.get(productChoice-1);

            System.out.println("\nCHOSEN PRODUCT:\n--------------------------------------------------------------------");
            System.out.println(chosenProduct);
            System.out.println("--------------------------------------------------------------------");
            return chosenProduct;

        }
        return null;
    }

    private static void calculatePrice(Product chosenProduct){

        double productWeight=0;
        do{
            System.out.print("\nEnter product weight in kilograms. \"0\" to return to main menu.\nWeight: ");
            try{
                productWeight = input.useLocale(Locale.ENGLISH).nextDouble();
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