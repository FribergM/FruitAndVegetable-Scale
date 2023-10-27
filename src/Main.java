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

    public static void main(String[] args) {
        System.out.println("Welcome to the Fruit & Vegetable Scale!");

        productManagement.initializeProducts();

        menu();

        ProductFiles.saveProductsToTextFiles();
    }

    private static void menu(){
        int menuChoice = -1;
        do{
            System.out.println("""

                Please choose a menu option by number!
                ----------------------------
                | 1. Search for product    |
                | 2. Add a product         |
                | 3. Remove a product      |
                | 4. Show all products     |
                | 0. Exit program          |
                ----------------------------""");

            try {
                System.out.print("Your choice: ");
                menuChoice = input.nextInt(); input.nextLine();

                switch(menuChoice){
                    case 1 -> productManagement.searchForProduct();
                    case 2 -> productManagement.addProduct();
                    case 3 -> productManagement.removeProduct();
                    case 4 -> productManagement.showAllProducts();
                    case 0 -> System.out.println("\nExiting program...");

                    default -> System.out.println("\nThat option does not exist. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }

        }while(menuChoice !=0);
    }

}