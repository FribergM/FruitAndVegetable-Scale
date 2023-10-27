import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */

public class ProductManagement {
    public static String[] productGroup;
    public static String[] productCategory; //TODO Maybe change to ArrayList
    public static Scanner input = new Scanner(System.in);

    private static ArrayList<Product> productList = new ArrayList<Product>();
    public static ArrayList<Product> tempProductList = new ArrayList<Product>();

    public void initializeProducts() {

        productGroup = new String[]{"Fruit", "Vegetables", "Mushrooms"};

        productCategory = new String[]{
                "Apples",
                "Citrus Fruit",
                "Stone Fruit",
                "Other Fruit",
                "Cole Crops",
                "Onions",
                "Peppers",
                "Root Vegetables",
                "Other Vegetables",
                "Mushrooms",
        };
        ProductFiles.initializeProductsFromFiles();
    }
    public void searchForProduct(){

        int searchChoice;

        do{
            System.out.println("""
                
                PRODUCT SEARCH
                Enter search method by number "0" to return to main menu.
                
                SEARCH METHODS:
                ----------------------------------
                | 1. Search by name              |
                | 2. Navigate through categories |
                ----------------------------------""");

            searchChoice = Utility.checkIfValidIntInput("menu option",1,2);

            if(Utility.returnToMenu(searchChoice)){
                System.out.println("\nReturning to menu...");
                return;
            }

        }while(searchChoice<1 || searchChoice>2);

        switch(searchChoice){
            case 1 -> searchByName();
            case 2 -> navigateToProduct();
            default -> System.out.println("That menu choice does not exist. Try again.");
        }

    }

    public void searchByName(){

        do {
            System.out.println("\nPRODUCT SEARCH\nEnter the name of the product. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");
            String productName = input.nextLine().toLowerCase();

            if(Utility.returnToMenu(productName)) {
                System.out.println("\nReturning to menu...");
                return;
            }

            findMatchingProduct(productName);

        }while(tempProductList.isEmpty());

        Product chosenProduct = getChosenProduct();

        if(Utility.returnToMenu(chosenProduct)){
            return;
        }

        calculatePrice(chosenProduct);

        tempProductList.clear();
    }
    public void navigateToProduct(){

        System.out.print("\nPRODUCT SEARCH");

        int userGroupChoice = getGroupChoice();

        if(Utility.returnToMenu(userGroupChoice)){
            System.out.println("\nReturning to menu...");
            return;
        }

        int userCategoryChoice = -1;

        if(userGroupChoice == 1){
            userCategoryChoice = getCategoryChoice(userGroupChoice,1,4);
        }else if(userGroupChoice == 2) {
            userCategoryChoice = getCategoryChoice(userGroupChoice, 1, 5);
        }

        if(Utility.returnToMenu(userCategoryChoice)){
            System.out.println("\nReturning to menu...");
            return;
        }

        if(userGroupChoice == 1){
            userCategoryChoice -= 1;// Changes it to match the desired index for productCategory[0/1/2/3]
        }else if(userGroupChoice == 2){
            userCategoryChoice += 3;// Changes it to match the desired index for productCategory[4/5/6/7/8]
        }else{
            userCategoryChoice =9; // Changes it to match the desired index for productCategory[9] (Mushrooms)
        }

        for (Product p : productList) {
            if (p.getProductCategory().equals(productCategory[userCategoryChoice])) {
                tempProductList.add(p);
            }
        }

        Product chosenProduct = getChosenProduct();

        if(Utility.returnToMenu(chosenProduct)){
            System.out.println("\nReturning to menu...");
            return;
        }

        calculatePrice(chosenProduct);

        tempProductList.clear();
    }

    public void addProduct(){
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
                isValidName = Utility.checkIfValidString(productName);
            }
        }while(!isValidName);

        if(Utility.returnToMenu(productName)){
            System.out.println("\nReturning to main...");
            return;
        }
        productName = Utility.capitalizeWordsOfString(productName);

        group = getGroupChoice();

        if(Utility.returnToMenu(group)){
            System.out.println("\nReturning to main...");
            return;
        }

        category = -1;
        if(group == 1){
            category = getCategoryChoice(group,1,4);
        }else if(group == 2) {
            category = getCategoryChoice(group, 1, 5);
        }

        if(Utility.returnToMenu(category)){
            System.out.println("\nReturning to main...");
            return;
        }

        if(group == 1){
            category -= 1;// Changes it to match the desired index for productCategory[0/1/2/3]
        }else if(group == 2){
            category += 3;// Changes it to match the desired index for productCategory[4/5/6/7/8]
        }else{
            category =9;// Changes it to match the desired index for productCategory[9]
        }

        do{
            System.out.println("\nEnter price in kr/kg for the product. \"0\" to return to main menu.");

            productPrice = Utility.checkIfValidDoubleInput();

            if(Utility.returnToMenu(productPrice)){
                System.out.println("\nReturning to main...");
                return;
            }
        }while(productPrice <= 0);

        Product newProduct = new Product(productName,productGroup[group-1], productCategory[category],productPrice);
        registerProductInCategory(newProduct);

        System.out.println(productName+" has been registered!");
    }
    private void registerProductInCategory(Product newProduct){
        String category = newProduct.getProductCategory();
        int lastIndex = -1;

        // Finds corresponding category from the bottom up in the list.
        for(int i = productList.size()-1; i>=0; i--){
            if(productList.get(i).getProductCategory().equals(category)){
                lastIndex = i;
                break;
            }
        }

        // Adds product at the bottom of matching category, else put it at the bottom of the entire list
        if(lastIndex != -1){
            productList.add(lastIndex+1,newProduct);
        }else{
            productList.add(newProduct);
        }
    }

    private static void sortProductListAlphabetically(){
        //TODO Maybe make this.
    }

    public void removeProduct(){
        do{
            System.out.println("\nPRODUCT REMOVAL\nEnter the name of the product you wish to remove. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");
            String productName = input.nextLine().toLowerCase();

            if (Utility.returnToMenu(productName)) {
                System.out.println("\nReturning to menu...");
                return;
            }
            findMatchingProduct(productName);
        }while(tempProductList.isEmpty());

        Product chosenProduct = getChosenProduct();

        if(Utility.returnToMenu(chosenProduct)){
            System.out.println("\nReturning to menu...");
            return;
        }

        printChosenProduct(chosenProduct);

        for(Product p : productList){
            if(p.getName().equalsIgnoreCase(chosenProduct.getName())){
                System.out.println("\n"+chosenProduct.getName()+" has been removed!");
                productList.remove(p);
                break;
            }
        }


        tempProductList.clear();
    }
    public void showAllProducts(){
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("| %-20s| %-13s| %-17s| %-12s |%n","Product","Group","Category","Price");
        System.out.println("------------------------------------------------------------------------");

        for(int i = 0; i< productList.size()-1; i++){
            System.out.printf("| %s |%n", productList.get(i));
            if(!productList.get(i).getProductCategory().equalsIgnoreCase(productList.get(i+1).getProductCategory())){
                System.out.println("------------------------------------------------------------------------");
            }
        }
        System.out.println("------------------------------------------------------------------------");
    }

    private void findMatchingProduct(String productName){
        // Adds all products containing the user input into tempProductList.
        for(Product p : productList){
            if(p.getName().toLowerCase().contains(productName)){
                tempProductList.add(p);
            }
        }
        if(tempProductList.isEmpty()){
            System.out.println("\nNo product found. Try again.");
        }
    }
    private boolean checkIfProductExists(String productName){

        for(Product p : productList){
            if(productName.equalsIgnoreCase(p.getName())){
                System.out.println("\nA product with that name already exists. Try again.");
                return false;
            }
        }

        return true;
    }



    private int getGroupChoice(){

        int userGroupChoice;

        do{
            System.out.println("\nChoose a product group by number. \"0\" to return to main menu.");

            printProductGroups();

            userGroupChoice = Utility.checkIfValidIntInput("product group",1,3);

            if(Utility.returnToMenu(userGroupChoice)){
                return 0;
            }

        }while(userGroupChoice < 1 || userGroupChoice > 3);

        return userGroupChoice;
    }
    private int getCategoryChoice(int userGroupChoice, int firstElement, int lastElement){

        int userCategoryChoice;

        do{
            System.out.println("\nChoose a category by number. \"0\" to return to main menu.");

            printProductCategory(userGroupChoice);

            userCategoryChoice = Utility.checkIfValidIntInput("category",firstElement,lastElement);

            if(Utility.returnToMenu(userCategoryChoice)){
                return 0;
            }

        }while(userCategoryChoice < firstElement || userCategoryChoice > lastElement);

        return userCategoryChoice;
    }

    private Product getChosenProduct(){

        int productChoice;

        do{
            System.out.println("\nChoose a product by number. \"0\" to return to main menu.");

            printProducts();

            productChoice = Utility.checkIfValidIntInput("category",1, tempProductList.size());

            if(Utility.returnToMenu(productChoice)){
                return null;
            }

        }while(productChoice <1 || productChoice > tempProductList.size());

        return tempProductList.get(productChoice-1); // -1 to get the matching index of desired choice.
    }

    private void printProductGroups(){
        System.out.println("\nGROUPS:");
        System.out.println("-------------------------");
        for(int i=0;i<productGroup.length;i++){
            System.out.printf("| %-3s %-17s |%n",(i+1)+".",productGroup[i]);
        }
        System.out.println("-------------------------");
    }
    private void printProductCategory(int userGroupChoice){
        System.out.println("\nCATEGORIES:");
        System.out.println("-------------------------");
        if(userGroupChoice == 1){
            for(int i=0;i<4;i++){
                System.out.printf("| %-3s %-17s |%n",(i+1)+".", productCategory[i]);
            }
        }else{
            for(int i = 4; i< productCategory.length-1; i++){
                System.out.printf("| %-3s %-17s |%n",(i-3)+".", productCategory[i]);
            }
        }
        System.out.println("-------------------------");
    }
    private void printProducts(){

        System.out.println("\nAVAILABLE PRODUCTS:");
        System.out.println("----------------------------------------------------------------------------");
        for(int i = 0; i< tempProductList.size(); i++){
            System.out.printf("| %-3s %s |%n",(i+1)+".", tempProductList.get(i));
        }
        System.out.println("----------------------------------------------------------------------------");
    }
    private void printChosenProduct(Product chosenProduct){

        System.out.println("\nCHOSEN PRODUCT:");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("| %-3s |%n", chosenProduct);
        System.out.println("------------------------------------------------------------------------");
    }


    private void calculatePrice(Product chosenProduct){
        double productWeight;

        do{
            printChosenProduct(chosenProduct);

            System.out.print("\nEnter product weight in kilograms. \"0\" to return to main menu.\nWeight: ");

            productWeight = Utility.checkIfValidDoubleInput();

            if(Utility.returnToMenu(productWeight)){
                System.out.println("\nReturning to menu...");
                return;
            }

        }while(productWeight<=0);

        double finalPrice = productWeight*chosenProduct.getPricePerKg();
//        System.out.println("\nThe price for "+productWeight+"kg '"+chosenProduct.getName()+"' is: ");
        System.out.printf(Locale.ENGLISH,"\nThe price for %.2fkg '%s' is: %n",productWeight,chosenProduct.getName());
        System.out.printf(Locale.ENGLISH,"%.2fkr%n",finalPrice);

    }

//    private boolean returnToMenu(String userInput){
//        if(userInput.equals("0")){
//            tempProductList.clear();
//            return true;
//        }
//        return false;
//    }
//    private boolean returnToMenu(int userInput){
//        if(userInput == 0){
//            tempProductList.clear();
//            return true;
//        }
//        return false;
//    }
//    private boolean returnToMenu(double userInput){
//        if(userInput == 0.0){
//            tempProductList.clear();
//            return true;
//        }
//        return false;
//    }
//    private boolean returnToMenu(Product userInput){
//        if(userInput == null){
//            tempProductList.clear();
//            return true;
//        }
//        return false;
//    }

    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void initAddToList(Product productFromFile){
        productList.add(productFromFile);
    }
}
