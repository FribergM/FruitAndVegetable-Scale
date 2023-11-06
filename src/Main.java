import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/FruitAndVegetable-Scale
 */

public class Main {
    public static Scanner input = new Scanner(System.in);
    private static ProductManagement productManagement = new ProductManagement();
    private static AdminManagement adminManagement = new AdminManagement();
    private static ShoppingCart shoppingCart = new ShoppingCart();

    public static boolean isAdmin = false;

    public static void main(String[] args) {
        greetingMessage();

        productManagement.initializeProducts();
        FileManagement.initializeAdminAccountsFromFiles();

        menu();

    }
    public static void greetingMessage(){
        System.out.println("\nWelcome to the Fruit & Vegetable Scale!");
    }

    private static void menu(){

        int menuChoice = -1;
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

            try {
                System.out.print("Your choice: ");

                menuChoice = input.nextInt(); input.nextLine();

                switch(menuChoice){
                    case 1 -> productManagement.searchForProduct();
                    case 2 -> shoppingCart.shoppingCartMenu();
                    case 3 -> productManagement.showAllProducts();
                    case 4 -> AdminManagement.adminLogin();
                    case 0 -> System.out.println("\nExiting program...");

                    default -> System.out.println("\nThat option does not exist. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }

        }while(menuChoice !=0);
    }

    public static void adminMenu(){
        int menuChoice = -1;
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

            try {
                System.out.print("Your choice: ");
                menuChoice = input.nextInt(); input.nextLine();

                switch(menuChoice){
                    case 1 -> productManagement.addNewProduct();
                    case 2 -> productManagement.removeProduct();
                    case 3 -> productManagement.showAllProducts();
                    case 4 -> productManagement.searchForProduct();
                    case 5 -> productManagement.updateDiscount();
                    case 6 -> productManagement.removeDiscount();
                    case 7 -> adminManagement.addNewAdmin();
                    case 0 -> {
                        System.out.println("\nLogging out..."+Utility.RESET_COLOR);
                        isAdmin = false;
                        return;
                    }
                    default -> System.out.println("\nThat option does not exist. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }

        }while(menuChoice !=0);
    }

}