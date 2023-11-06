import java.util.ArrayList;

//Name: Måns Friberg
//Email: mans.friberg@iths.se

public class ProductManagement {
    public static String[] productGroup;
    public static String[] productCategory;
    private static ShoppingCart shoppingCart = new ShoppingCart();

    private static ArrayList<Product> productList = new ArrayList<Product>();
    public static ArrayList<Product> tempProductList = new ArrayList<Product>();

    public void initializeProducts() {

        productGroup = new String[]{"Fruit", "Vegetables", "Other", "Discounted Products"};

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
        FileManagement.initializeProductsFromFiles();
    }
    public void searchForProduct(){

        int searchChoice;

        do{
            System.out.println("""
                
                PRODUCT SEARCH
                Enter search method by number. "0" to return to main menu.
                
                SEARCH METHODS:
                ----------------------------------
                | 1. Search by name              |
                | 2. Navigate through categories |
                ----------------------------------""");

            searchChoice = Utility.checkIfValidIntInput("menu option",1,2);

            if(Utility.returnToMenu(searchChoice)){// Handles if user inputs "0" to return to menu.
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
    private void searchByName(){

        do {
            System.out.println("\nPRODUCT SEARCH\nEnter the name of the product. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");
            String productName = Main.input.nextLine().toLowerCase();

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

        if(Main.isAdmin){
            registerDiscount(chosenProduct);
        }else{
            createCartItem(chosenProduct);
        }
        tempProductList.clear();
    }
    private void navigateToProduct(){

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
        }else if(userGroupChoice == 3){
            userCategoryChoice = getCategoryChoice(userGroupChoice,1,1);
        }


        if(Utility.returnToMenu(userCategoryChoice)){
            System.out.println("\nReturning to menu...");
            return;
        }

        if(userGroupChoice == 1){
            userCategoryChoice -= 1;// Changes it to match the desired index for productCategory[0/1/2/3]
        }else if(userGroupChoice == 2){
            userCategoryChoice += 3;// Changes it to match the desired index for productCategory[4/5/6/7/8]
        }else if(userGroupChoice == 3){
            userCategoryChoice =9; // Changes it to match the desired index for productCategory[9] (Mushrooms)
        }

        if(userGroupChoice == 4){
            findDiscountedProducts();
        }else{
            for(Product p : productList){
                if (p.getProductCategory().equals(productCategory[userCategoryChoice])) {
                    tempProductList.add(p);
                }
            }
        }


        Product chosenProduct = getChosenProduct();

        if(Utility.returnToMenu(chosenProduct)){
            return;
        }

        if(Main.isAdmin){
            registerDiscount(chosenProduct);
        }else{
            createCartItem(chosenProduct);
        }
        tempProductList.clear();
    }
    private void createCartItem(Product chosenProduct) {

        double productAmount = getProductAmountByWeight(chosenProduct);

        if(Utility.returnToMenu(productAmount)){
            return;
        }

        CartItem newCartItem = new CartItem(chosenProduct,productAmount);
        shoppingCart.addToShoppingCart(newCartItem);
    }

    public void addNewProduct(){
        String productName;
        int group;
        int category;
        double productPrice;

        boolean isValidName;
        do{
            System.out.println("\nPRODUCT REGISTRATION\nEnter the name of the product you wish to register. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");

            productName = Main.input.nextLine().toLowerCase();

            isValidName = checkIfProductExists(productName);

            if(isValidName){
                isValidName = Utility.checkIfValidString(productName);
            }
        }while(!isValidName);

        if(Utility.returnToMenu(productName)){
            System.out.println("\nReturning to main...");
            return;
        }
        productName = Utility.capitalizeWordsInString(productName);

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

        FileManagement.saveProductsToTextFiles(FileManagement.productsFilePath);
    }
    private void registerProductInCategory(Product newProduct){
        String category = newProduct.getProductCategory();
        int lastIndex = -1;

        // Finds corresponding category from the bottom up in the productList.
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
    public void removeProduct(){
        do{
            System.out.println("\nPRODUCT REMOVAL\nEnter the name of the product you wish to remove. \"0\" to return to main menu.");
            System.out.print("\nProduct name: ");
            String productName = Main.input.nextLine().toLowerCase();

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

        if(!Utility.confirmRemoval("this product")){
            System.out.println("\nReturning to menu...");
            return;
        }

        for(Product p : productList){
            if(p.getName().equalsIgnoreCase(chosenProduct.getName())){
                System.out.println("\n"+chosenProduct.getName()+" has been removed!");
                productList.remove(p);
                break;
            }
        }

        FileManagement.saveProductsToTextFiles(FileManagement.productsFilePath);

        tempProductList.clear();
    }
    public void showAllProducts(){
        System.out.println();
        printInfoHeader("showAllProducts");
        for(int i = 0; i< productList.size(); i++){
            System.out.printf("| %s |%n", productList.get(i));
            // Compares to the next product in the list, adding a line if they are no longer of the same category.
            if(i < productList.size()-1 && !productList.get(i).getProductCategory().equalsIgnoreCase(productList.get(i+1).getProductCategory())){
                System.out.println("-------------------------------------------------------------------------------------------------------------------");
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }

    private void registerDiscount(Product chosenProduct){

        int discountChoice = getDiscountType();

        if(Utility.returnToMenu(discountChoice)){
            System.out.println("\nReturning to menu...");
            return;
        }

        // Gets discount value (% or flat amount) + conditional threshold if needed.
        double[] discountValues = getDiscountValues(discountChoice, chosenProduct);

        if(Utility.returnToMenu(discountValues[0])){
            System.out.println("\nReturning to menu...");
            return;
        }
        double discountAmount = discountValues[0];
        double discountWeightThreshold = discountValues[1];

        switch(discountChoice){
            case 1 -> chosenProduct.setDiscount(new PercentDiscount(discountAmount));
            case 2 -> chosenProduct.setDiscount(new AmountDiscount(discountAmount));
            case 3 -> chosenProduct.setDiscount(new PercentDiscountIf(discountAmount,discountWeightThreshold));
            case 4 -> chosenProduct.setDiscount(new AmountDiscountIf(discountAmount,discountWeightThreshold));
            case 0 -> System.out.println("\nReturning to menu...");
            default -> System.out.println("\nThat option does not exist. Try again.");
        }

        chosenProduct.updateDiscountedPrice();
        System.out.println("\n"+chosenProduct.getName()+" is now "+chosenProduct.getDiscount());
        FileManagement.saveProductsToTextFiles(FileManagement.productsFilePath);

    }
    public void updateDiscount(){
        Product productToUpdate = getDiscountedProduct();

        if(Utility.returnToMenu(productToUpdate)){
            return;
        }

        registerDiscount(productToUpdate);

        FileManagement.saveProductsToTextFiles(FileManagement.productsFilePath);
        tempProductList.clear();
    }
    public void removeDiscount(){
        Product productToRemove = getDiscountedProduct();

        if(Utility.returnToMenu(productToRemove) || !Utility.confirmRemoval("discount")){
            return;
        }

        productToRemove.setDiscount(null);

        System.out.println("\nDiscount removed from: "+productToRemove.getName());

        FileManagement.saveProductsToTextFiles(FileManagement.productsFilePath);
        tempProductList.clear();
    }

    private void findDiscountedProducts(){
        for(Product product : productList){
            if(product.getDiscount() != null){
                tempProductList.add(product);
            }
        }

    }
    private boolean checkIfDiscountExists(){
        for(Product p : productList){
            if(p.getDiscount() != null){
                return true;
            }
        }
        return false;
    }
    public double[] getDiscountValues(int discountChoice, Product chosenProduct){
        double[] discountValues = new double[2];
        boolean continueLooping = true;
        do{
            if(discountChoice == 1 || discountChoice == 3){
                System.out.println("\nEnter the discount percentage (1-100) \"0\" to return to menu.");
                System.out.print("Percentage: ");
                discountValues[0] = Utility.checkIfValidDoubleInput();
                if(discountValues[0]<0 || discountValues[0]>100){
                    System.out.println("\nOnly a discount between 0-100% allowed. Try again.");
                }else{
                    continueLooping = false;
                }
            }else{
                double productPrice = chosenProduct.getPricePerKg();
                System.out.println("\nEnter a discount amount (0-"+productPrice+") \"0\" to return to menu.");
                System.out.print("Discount: ");
                discountValues[0] = Utility.checkIfValidDoubleInput();
                if(discountValues[0]<0 || discountValues[0]>productPrice){
                    System.out.println("\nOnly a discount between 0-"+productPrice+" allowed. Try again.");
                }else{
                    continueLooping = false;
                }
            }
        }while(continueLooping);

        if(Utility.returnToMenu(discountValues[0])){
            return discountValues;
        }

        do{
            if(discountChoice == 3 || discountChoice == 4){
                System.out.println("\nEnter the weight threshold for the discount in Kg. \"0\" to return to menu");
                System.out.print("\nWeight: ");
                discountValues[1] = Utility.checkIfValidDoubleInput();

                if(Utility.returnToMenu(discountValues[1])){
                    discountValues[0] = 0.0;
                    return discountValues;
                }
            }
        }while(discountValues[1] == -1);

        return discountValues;
    }
    private int getDiscountType(){
        int discountChoice;

        do{
            System.out.println("""

                Please choose a discount option by number!
                
                DISCOUNT REGISTRATION
                ---------------------------------------
                | 1. % Discount                       |
                | 2. Flat amount discount             |
                | 3. Conditional '% discount'         |
                | 4. Conditional flat amount discount |
                | 0. Return to menu                   |
                ---------------------------------------""");

            discountChoice = Utility.checkIfValidIntInput("discount option",1,4);

            if(Utility.returnToMenu(discountChoice)){
                return 0;
            }

        }while(discountChoice<0 || discountChoice>4);

        return discountChoice;
    }
    public Product getDiscountedProduct(){

        if(checkIfDiscountExists()){
            findDiscountedProducts();

        }else{
            System.out.println("\nNo products are discounted.");
            return null;
        }

        return getChosenProduct();
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
    private int getGroupChoice(){

        int userGroupChoice;
        int showIfDiscountExists;

        if(checkIfDiscountExists()){//Hides "Discounted products" Group choice if none exist.
            showIfDiscountExists = 1;
        }else{
            showIfDiscountExists = 0;
        }

        do{
            System.out.println("\nChoose a product group by number. \"0\" to return to main menu.");

            printProductGroups();

            userGroupChoice = Utility.checkIfValidIntInput("product group",1,3+ showIfDiscountExists);

            if(Utility.returnToMenu(userGroupChoice)){
                return 0;
            }

        }while(userGroupChoice < 1 || userGroupChoice > 3+ showIfDiscountExists);

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

            productChoice = Utility.checkIfValidIntInput("product",1, tempProductList.size());

            if(Utility.returnToMenu(productChoice)){
                System.out.println("\nRetuning to menu...");
                return null;
            }

        }while(productChoice <1 || productChoice > tempProductList.size());

        return tempProductList.get(productChoice-1); // -1 to get the matching index of desired choice.
    }
    private double getProductAmountByWeight(Product chosenProduct){

        double productWeight;

        do{
            System.out.println("\nEnter product weight in kilograms. \"0\" to return to main menu.");

            printChosenProduct(chosenProduct);

            System.out.print("Weight: ");

            productWeight = Utility.checkIfValidDoubleInput();

            if(Utility.returnToMenu(productWeight)){
                System.out.println("\nReturning to menu...");
                return 0.0;
            }

        }while(productWeight<=0);

        return productWeight;

    }

    private void printInfoHeader(String calledFromMethod){

        if(calledFromMethod.equals("printProducts")){
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-24s| %-13s| %-17s| %-13s| %-25s| %-13s |%n","Product","Group","Category","Price","Active Discount","Reduced Price");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------");
        }else{
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-20s| %-13s| %-17s| %-13s| %-25s| %-13s |%n","Product","Group","Category","Price","Active Discount","Reduced Price");
            System.out.println("-------------------------------------------------------------------------------------------------------------------");
        }

    }
    private void printProductGroups(){
        int ignoreLastIfNoDiscount;

        if(checkIfDiscountExists()){//Hides "Discounted products" Group choice if none exist.
            ignoreLastIfNoDiscount = 0;
        }else{
            ignoreLastIfNoDiscount = 1;
        }

        System.out.println("\nGROUPS:");
        System.out.println("----------------------------");
        for(int i=0;i<productGroup.length-ignoreLastIfNoDiscount;i++){
            System.out.printf("| %-3s %-20s |%n",(i+1)+".",productGroup[i]);
        }
        System.out.println("----------------------------");
    }
    private void printProductCategory(int userGroupChoice){
        System.out.println("\nCATEGORIES:");
        System.out.println("-------------------------");
        if(userGroupChoice == 1){
            for(int i=0;i<4;i++){ // Shows all Fruit categories from productCategory[]
                System.out.printf("| %-3s %-17s |%n",(i+1)+".", productCategory[i]);
            }
        }else if(userGroupChoice == 2){
            for(int i = 4; i< productCategory.length-1; i++){ // Shows all Vegetable categories from productCategory[]
                System.out.printf("| %-3s %-17s |%n",(i-3)+".", productCategory[i]);
            }
        }else{
            System.out.printf("| %-3s %-17s |%n",1+".", productCategory[9]);
        }
        System.out.println("-------------------------");
    }
    private void printProducts(){

        System.out.println("\nAVAILABLE PRODUCTS:");
        printInfoHeader("printProducts");

        for(int i = 0; i< tempProductList.size(); i++){
            System.out.printf("| %-3s %s |%n",(i+1)+".", tempProductList.get(i));
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------");
    }
    private void printChosenProduct(Product chosenProduct){

        System.out.println("\nCHOSEN PRODUCT:");
        printInfoHeader("printChosenProduct");

        System.out.printf("| %s |%n", chosenProduct);
        System.out.println("-------------------------------------------------------------------------------------------------------------------");
    }

    public ArrayList<Product> getProductList(){
        return productList;
    }
    public void addProductToList(Product productFromFile){
        productList.add(productFromFile);
    }
}
