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

        for(int i = 0;i< productList.length;i++){
            productList[i] = new ArrayList<Product>();
        }

        productList[0].add(new Product("Lemon", productGroup[0], productCategory[0],41.55));
        productList[0].add(new Product("Lime", productGroup[0], productCategory[0],79.75));
        productList[0].add(new Product("Orange", productGroup[0], productCategory[0],34.90));
        productList[0].add(new Product("Satsuma", productGroup[0], productCategory[0],34.90));
        productList[0].add(new Product("Grapefruit", productGroup[0], productCategory[0],31.75));
        productList[0].add(new Product("Clementine", productGroup[0], productCategory[0],31.75));

        productList[1].add(new Product("Granny smith apple", productGroup[0], productCategory[1],39.90));
        productList[1].add(new Product("Pink lady apple", productGroup[0], productCategory[1],42.90));
        productList[1].add(new Product("Royal gala apple", productGroup[0], productCategory[1],36.90));

        productList[2].add(new Product("Peach", productGroup[0], productCategory[2],39.90));
        productList[2].add(new Product("Nectarine", productGroup[0], productCategory[2],39.90));
        productList[2].add(new Product("Apricot", productGroup[0], productCategory[2],54.95));
        productList[2].add(new Product("Plum", productGroup[0], productCategory[2],25.95));

        productList[3].add(new Product("Banana", productGroup[0], productCategory[3],23.90));
        productList[3].add(new Product("Banana ECO", productGroup[0], productCategory[3],28.90));
        productList[3].add(new Product("Watermelon", productGroup[0], productCategory[3],24.90));
        productList[3].add(new Product("Cantaloupe", productGroup[0], productCategory[3],49.90));
        productList[3].add(new Product("Honey melon", productGroup[0], productCategory[3],29.90));
        productList[3].add(new Product("Pear", productGroup[0], productCategory[3],36.90));

        productList[4].add(new Product("Carrot", productGroup[1], productCategory[4],15.90));
        productList[4].add(new Product("Parsnip", productGroup[1], productCategory[4],24.90));
        productList[4].add(new Product("Potato", productGroup[1], productCategory[4],15.90));
        productList[4].add(new Product("Sweet potato", productGroup[1], productCategory[4],29.90));
        productList[4].add(new Product("Horseradish", productGroup[1], productCategory[4],129.00));
        productList[4].add(new Product("Beetroot", productGroup[1], productCategory[4],19.90));
        productList[4].add(new Product("Swedish turnip", productGroup[1], productCategory[4],34.90));
        productList[4].add(new Product("Radish", productGroup[1], productCategory[4],39.90));

        productList[5].add(new Product("Yellow onion",productGroup[1], productCategory[5],19.90));
        productList[5].add(new Product("Red onion", productGroup[1], productCategory[5],23.90));
        productList[5].add(new Product("White onion", productGroup[1], productCategory[5],66.33));
        productList[5].add(new Product("Garlic", productGroup[1], productCategory[5],69.90));
        productList[5].add(new Product("Shallot", productGroup[1], productCategory[5],44.90));
        productList[5].add(new Product("Leek", productGroup[1], productCategory[5],29.90));
        productList[5].add(new Product("Green onion", productGroup[1], productCategory[5],19.90));

        productList[6].add(new Product("Chanterelle", productGroup[1], productCategory[6],199.00));
        productList[6].add(new Product("Champignon", productGroup[1], productCategory[6],59.90));
        productList[6].add(new Product("Oyster mushroom", productGroup[1], productCategory[6],169.00));
        productList[6].add(new Product("Portabello", productGroup[1], productCategory[6],99.00));
        productList[6].add(new Product("Shiitake", productGroup[1], productCategory[6],199.00));

        productList[7].add(new Product("Red bell pepper", productGroup[1], productCategory[7],44.90));
        productList[7].add(new Product("Yellow bell pepper", productGroup[1], productCategory[7],44.90));
        productList[7].add(new Product("Green bell pepper", productGroup[1], productCategory[7],44.90));
        productList[7].add(new Product("Red chili", productGroup[1], productCategory[7],209.00));
        productList[7].add(new Product("Jalapeno", productGroup[1], productCategory[7],249.00));
        productList[7].add(new Product("Habanero", productGroup[1], productCategory[7],279.00));

        productList[8].add(new Product("Brussels sprouts", productGroup[1], productCategory[8],39.90));
        productList[8].add(new Product("Broccoli", productGroup[1], productCategory[8],67.90));
        productList[8].add(new Product("Turnip", productGroup[1], productCategory[8],54.90));
        productList[8].add(new Product("Cauliflower", productGroup[1], productCategory[8],29.90));
        productList[8].add(new Product("Cabbage", productGroup[1], productCategory[8],19.90));
        productList[8].add(new Product("Red cabbage", productGroup[1], productCategory[8],24.90));
        productList[8].add(new Product("Kale", productGroup[1], productCategory[8],95.90));

        productList[9].add(new Product("Ginger", productGroup[1], productCategory[9],99.90));
        productList[9].add(new Product("Cucumber", productGroup[1], productCategory[9],56.90));
        productList[9].add(new Product("Tomato", productGroup[1], productCategory[9],39.90));
        productList[9].add(new Product("Cocktail tomato", productGroup[1], productCategory[9],107.60));
        productList[9].add(new Product("Asparagus green", productGroup[1], productCategory[9],219.90));
        productList[9].add(new Product("Asparagus white", productGroup[1], productCategory[9],139.90));


    }
    private static void menu(){
        int menuChoice = -1;
        do{
            System.out.println("""
                
                Please choose a menu option by number!
                ----------------------------
                | 1. Search for product    |
                | 2. Navigate to product   |
                | 3. Add a product         |
                | 4. Remove a product      |
                | 5. Show all products     |
                | 0. Exit program          |
                ----------------------------""");

            try {
                System.out.print("Your choice: ");
                menuChoice = input.nextInt(); input.nextLine();

                switch(menuChoice){
                    case 1 -> searchProduct();
                    case 2 -> navigateToProduct();
                    case 3 -> addProduct();
                    case 4 -> removeProduct();
                    case 5 -> showAllProducts();
                    case 0 -> System.out.println("\nExiting program...");

                    default -> System.out.println("\nThat option does not exist. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }

        }while(menuChoice !=0);
    }

    private static void searchProduct() {

        do {
            System.out.println("\nPRODUCT SEARCH\nEnter the name of the product. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");
            String productName = input.nextLine().toLowerCase();

            if(returnToMenu(productName)) {
                System.out.println("\nReturning to menu...");
                return;
            }

            findMatchingProduct(productName);

        }while(tempProductList.isEmpty());

        Product chosenProduct = getChosenProduct();

        if(returnToMenu(chosenProduct)){
            System.out.println("\nReturning to menu...");
            return;
        }

        calculatePrice(chosenProduct);

        tempProductList.clear();
    }
    private static void navigateToProduct(){

        System.out.print("\nPRODUCT NAVIGATION");

        int userGroupChoice = getGroupChoice();

        if(returnToMenu(userGroupChoice)){
            System.out.println("\nReturning to menu...");
            return;
        }

        int userCategoryChoice = 0;

        if(userGroupChoice == 1){
            userCategoryChoice = getCategoryChoice(userGroupChoice,1,4);
        }else if(userGroupChoice == 2) {
            userCategoryChoice = getCategoryChoice(userGroupChoice, 1, 6);
        }

        if(returnToMenu(userCategoryChoice)){
            System.out.println("\nReturning to menu...");
            return;
        }

        if(userGroupChoice == 1){
            userCategoryChoice -= 1;// Changes it to match the desired index for productList[0/1/2/3]
        }else{
            userCategoryChoice += 3;// Changes it to match the desired index for productList[4/5/6/7/8/9]
        }

        for(Product p : productList[userCategoryChoice]){
            tempProductList.add(p);
        }

        Product chosenProduct = getChosenProduct();

        if(returnToMenu(chosenProduct)){
            System.out.println("\nReturning to menu...");
            return;
        }

        calculatePrice(chosenProduct);

        tempProductList.clear();
    }

    private static void addProduct(){
        String productName;
        int group;
        int category;
        double productPrice;

        boolean isValidName;
        do{
            System.out.println("\nPRODUCT REGISTRATION\nEnter the name of the product you wish to register. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");

            productName = input.nextLine().toLowerCase();

            isValidName = checkIfProductExists(productName);

            if(isValidName){
                isValidName = checkIfValidName(productName);
            }
        }while(!isValidName);

        if(returnToMenu(productName)){
            System.out.println("\nReturning to main...");
            return;
        }
        productName = capitalizeString(productName);

        group = getGroupChoice();

        if(returnToMenu(group)){
            System.out.println("\nReturning to main...");
            return;
        }

        category = 0;
        if(group == 1){
            category = getCategoryChoice(group,1,4);
        }else if(group == 2) {
            category = getCategoryChoice(group, 1, 6);
        }

        if(returnToMenu(category)){
            System.out.println("\nReturning to main...");
            return;
        }

        if(group == 1){
            category -= 1;// Changes it to match the desired index for productList[0/1/2/3]
        }else{
            category += 3;// Changes it to match the desired index for productList[4/5/6/7/8/9]
        }

        do{
            System.out.println("\nEnter price in kr/kg for the product. \"0\" to return to main menu.");

            productPrice = checkIfValidDoubleInput();

            if(returnToMenu(productPrice)){
                System.out.println("\nReturning to main...");
                return;
            }
        }while(productPrice <= 0);

        productList[category].add(new Product(productName,productGroup[group-1], productCategory[category],productPrice));
        System.out.println(productName+" has been registered!");

    }

    private static void removeProduct(){
        do{
            System.out.println("\nPRODUCT REMOVAL\nEnter the name of the product you wish to remove. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");
            String productName = input.nextLine().toLowerCase();

            if (returnToMenu(productName)) {
                System.out.println("\nReturning to menu...");
                return;
            }
            findMatchingProduct(productName);
        }while(tempProductList.isEmpty());

        Product chosenProduct = getChosenProduct();

        if(returnToMenu(chosenProduct)){
            System.out.println("\nReturning to menu...");
            return;
        }

        printChosenProduct(chosenProduct);

        for(int i=0;i<productList.length;i++){ // Removes the chosen product.
            for(int j=0;j<productList[i].size();j++){
                if(productList[i].get(j).getName().equalsIgnoreCase(chosenProduct.getName())){
                    productList[i].remove(j);
                }
            }
        }
        System.out.println("\nChosen product has been removed!");

        tempProductList.clear();
    }
    private static void showAllProducts(){
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("| %-20s| %-13s| %-17s| %-12s |%n","Product","Group","Category","Price");
        System.out.println("------------------------------------------------------------------------");
        for (ArrayList<Product> category : productList) {
            for (Product p : category) {
                System.out.printf("%c %s %c%n",'|',p,'|');
            }
            System.out.println("------------------------------------------------------------------------");
        }
    }

    private static void findMatchingProduct(String productName){

        for(ArrayList<Product> category : productList){ // Adds all products containing the user input into tempProductList.
            for(Product p : category){
                if(p.getName().toLowerCase().contains(productName)){
                    tempProductList.add(p);
                }
            }
        }
        if(tempProductList.isEmpty()){
            System.out.println("\nNo product found. Try again.");
        }
    }
    private static boolean checkIfProductExists(String productName){

        for(ArrayList<Product> list : productList){
            for(Product p : list){
                if(productName.equalsIgnoreCase(p.getName())){
                    System.out.println("\nA product with that name already exists. Try again.");
                    return false;
                }
            }
        }
        return true;
    }

    private static int checkIfValidIntInput(String invalidChoice, int minValue, int maxValue){

        int userChoice=-1; // Set to -1 to not accidentally return to menu if catch() is reached.

        try{
            System.out.print("Your choice: ");
            userChoice = input.nextInt(); input.nextLine();

            if(returnToMenu(userChoice)){
                return 0;
            }

            if(userChoice <minValue || userChoice >maxValue){
                System.out.println("\nThat "+invalidChoice+" does not exist. Try again.");
            }

        }catch(InputMismatchException e){
            System.out.println("\nInvalid input. Try again.");
            input.nextLine();
        }
        return userChoice;
    }
    private static double checkIfValidDoubleInput(){

        double value =-1; // Set to -1 to not accidentally return to menu if catch() is reached.

        try{
            value = input.useLocale(Locale.ENGLISH).nextDouble();

            if(returnToMenu(value)){
                return 0.0;
            }

            if(value<0.0){
                System.out.println("\nA negative value are not allowed. Try again");
            }

        }catch(InputMismatchException e){
            System.out.println("""

                Invalid input!
                Please make sure that:
                You are inputting a number.
                You are using US decimal point. (E.g. "1.5")""");
            input.nextLine();
        }
        return value;
    }

    private static boolean checkIfValidName(String name){
        if(!name.matches("[A-ZÅÄÖa-zåäö0 ]+") || name.contains("0") && name.length() > 1){ // Checks to make sure it's a suitable product name
            System.out.println("\nInvalid name. Please only use letters. Try again.");
            return false;
        }else if(name.isBlank()){
            System.out.println("\nInvalid name. Name cannot be left blank. Try again.");
            return false;
        }
        return true;
    }

    private static int getGroupChoice(){

        int userGroupChoice;

        do{
            System.out.println("\nChoose a product group by number. \"0\" to return to main menu.");

            printProductGroups();

            userGroupChoice = checkIfValidIntInput("product group",1,2);

            if(returnToMenu(userGroupChoice)){
                return 0;
            }

        }while(userGroupChoice < 1 || userGroupChoice > 2);

        return userGroupChoice;
    }
    private static int getCategoryChoice(int userGroupChoice, int firstElement, int lastElement){

        int userCategoryChoice;

        do{
            System.out.println("\nChoose a category by number. \"0\" to return to main menu.");

            printProductCategory(userGroupChoice);

            userCategoryChoice = checkIfValidIntInput("category",firstElement,lastElement);

            if(returnToMenu(userCategoryChoice)){
                return 0;
            }

        }while(userCategoryChoice < firstElement || userCategoryChoice > lastElement);

        return userCategoryChoice;
    }

    private static Product getChosenProduct(){

        int productChoice;

        do{
            System.out.println("\nChoose a product by number. \"0\" to return to main menu.");

            printProducts();

            productChoice = checkIfValidIntInput("category",1, tempProductList.size());

            if(returnToMenu(productChoice)){
                return null;
            }

        }while(productChoice <1 || productChoice > tempProductList.size());

        return tempProductList.get(productChoice-1); // -1 to get the matching index of desired choice.
    }

    private static void printProductGroups(){
        System.out.println("\nGROUPS:\n-------------------------");
        for(int i=0;i<productGroup.length;i++){
            System.out.printf("| %-3s %-17s |%n",(i+1)+".",productGroup[i]);
        }
        System.out.println("-------------------------");
    }
    private static void printProductCategory(int userGroupChoice){
        System.out.println("\nCATEGORIES:");
        System.out.println("-------------------------");
        if(userGroupChoice == 1){
            for(int i=0;i<4;i++){
                System.out.printf("| %-3s %-17s |%n",(i+1)+".", productCategory[i]);
            }
        }else{
            for(int i = 4; i< productCategory.length; i++){
                System.out.printf("| %-3s %-17s |%n",(i-3)+".", productCategory[i]);
            }
        }
        System.out.println("-------------------------");
    }
    private static void printProducts(){

        System.out.println("\nAVAILABLE PRODUCTS:");
        System.out.println("----------------------------------------------------------------------------");
        for(int i = 0; i< tempProductList.size(); i++){
            System.out.printf("| %-3s %s |%n",(i+1)+".", tempProductList.get(i));
        }
        System.out.println("----------------------------------------------------------------------------");
    }
    private static void printChosenProduct(Product chosenProduct){

        System.out.println("\nCHOSEN PRODUCT:\n------------------------------------------------------------------------");
        System.out.printf("| %-3s |%n", chosenProduct);
        System.out.println("------------------------------------------------------------------------");
    }


    private static void calculatePrice(Product chosenProduct){
        double productWeight=0;

        do{
            printChosenProduct(chosenProduct);

            System.out.print("\nEnter product weight in kilograms. \"0\" to return to main menu.\nWeight: ");

            productWeight = checkIfValidDoubleInput();

            if(returnToMenu(productWeight)){
                System.out.println("\nReturning to menu...");
                return;
            }

        }while(productWeight<=0);

        double finalPrice = productWeight*chosenProduct.getPricePerKg();
        System.out.println("\nThe price for "+productWeight+"kg '"+chosenProduct.getName()+"' is: ");
        System.out.printf(Locale.ENGLISH,"%.2fkr%n",finalPrice);

    }
    private static String capitalizeString(String string){
        return string.toUpperCase().charAt(0)+string.substring(1).toLowerCase();
    }
    private static boolean returnToMenu(String userInput){
        if(userInput.equals("0")){
            tempProductList.clear();
            return true;
        }
        return false;
    }
    private static boolean returnToMenu(int userInput){
        if(userInput == 0){
            tempProductList.clear();
            return true;
        }
        return false;
    }
    private static boolean returnToMenu(double userInput){
        if(userInput == 0.0){
            tempProductList.clear();
            return true;
        }
        return false;
    }
    private static boolean returnToMenu(Product userInput){
        if(userInput == null){
            tempProductList.clear();
            return true;
        }
        return false;
    }

}