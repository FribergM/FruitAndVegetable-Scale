import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */

public class Main {
    public static Scanner input = new Scanner(System.in);

    private static ProductManagement productManagement = new ProductManagement();
    private static AdminManagement adminManagement = new AdminManagement();

    public static void main(String[] args) {
        System.out.println("Welcome to the Fruit & Vegetable Scale!");

        productManagement.initializeProducts();
        FileManagement.initializeAdminAccountsFromFiles();

        menu();

    }

    private static void menu(){

        int menuChoice = -1;
        do{
            System.out.println("""

                Please choose a menu option by number!
                
                MAIN MENU
                ----------------------------
                | 1. Search for product    |
                | 2. Show all products     |
                | 3. Login as Admin        |
                | 0. Exit program          |
                ----------------------------""");

            try {
                System.out.print("Your choice: ");

                menuChoice = input.nextInt(); input.nextLine();

                switch(menuChoice){
                    case 1 -> productManagement.searchForProduct();
                    case 2 -> productManagement.showAllProducts();
                    case 3 -> AdminManagement.adminLogin();
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
                | 1. Search for product    |
                | 2. Show all products     |
                | 3. Add a product         |
                | 4. Remove a product      |
                | 5. Register new admin    |
                | 0. Log out               |
                ----------------------------""");

            try {
                System.out.print("Your choice: ");
                menuChoice = input.nextInt(); input.nextLine();

                switch(menuChoice){
                    case 1 -> productManagement.searchForProduct();
                    case 2 -> productManagement.showAllProducts();
                    case 3 -> productManagement.addNewProduct();
                    case 4 -> productManagement.removeProduct();
                    case 5 -> adminManagement.addNewAdmin();
                    case 0 -> {
                        System.out.println("\nLogging out..."+Utility.RESETCOLOR);
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