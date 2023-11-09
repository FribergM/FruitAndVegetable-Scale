//Name: Måns Friberg
//Email: mans.friberg@iths.se

public class Main {
    private static ProductManagement productManagement = new ProductManagement();
    private static ShoppingCart shoppingCart = new ShoppingCart();

    public static boolean isAdmin = false;

    public static void main(String[] args) { //TODO ADD MORE COMMENTS
        greetingMessage();

        productManagement.initializeProducts();
        FileManagement.initializeAdminAccountsFromFiles();

        menu();

    }
    public static void greetingMessage(){
        System.out.println("\nWelcome to the Fruit & Vegetable Scale!");
    }

    private static void menu(){

        int menuChoice;
        do{
            System.out.println("""
                
                Please choose a menu option by number!
                
                MAIN MENU
                ----------------------------
                | 1. Search for product    |
                | 2. Shopping cart         |
                | 3. Show all products     |
                | 4. Login as Admin        |
                | 0. Exit program          |
                ----------------------------""");

            menuChoice = Utility.checkIfValidIntInput("menu choice",1,4);

            switch(menuChoice){
                case 1 -> productManagement.searchForProduct();
                case 2 -> shoppingCart.shoppingCartMenu();
                case 3 -> productManagement.showAllProducts();
                case 4 -> AdminManagement.adminLogin();
                case 0 -> System.out.println("\nExiting program...");
            }


        }while(menuChoice !=0);
    }

    public static void adminMenu(){
        int menuChoice;
        do{
            System.out.println(Utility.PURPLE+"""
                
                Please choose a menu option by number!
                
                ADMIN MENU
                ----------------------------
                | 1. Add a product         |
                | 2. Remove a product      |
                | 3. Show all products     |
                | 4. Add a discount        |
                | 5. Update a discount     |
                | 6. Remove a discount     |
                | 7. Register new admin    |
                | 0. Log out               |
                ----------------------------""");


            menuChoice = Utility.checkIfValidIntInput("menu choice",1,7);

            switch(menuChoice){
                case 1 -> productManagement.addNewProduct();
                case 2 -> productManagement.removeProduct();
                case 3 -> productManagement.showAllProducts();
                case 4 -> productManagement.searchForProduct();
                case 5 -> productManagement.updateDiscount();
                case 6 -> productManagement.removeDiscount();
                case 7 -> AdminManagement.addNewAdmin();
                case 0 -> {
                    System.out.println("\nLogging out..."+Utility.RESET_COLOR);
                    isAdmin = false;
                    return;
                }
            }

        }while(isAdmin);
    }

}