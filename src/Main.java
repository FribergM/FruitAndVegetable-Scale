import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
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

        menu();

        ProductFiles.saveProductsToTextFiles(ProductFiles.productsFilePath);
        ProductFiles.saveProductsToTextFiles(ProductFiles.productsFilePathCMD);
    }

    private static void menu(){

        int menuChoice = -1;
        do{
            System.out.println("""

                Please choose a menu option by number!
                
                MAIN MENU:
                ----------------------------
                | 1. Search for product    |
                | 2. Add a product         |
                | 3. Remove a product      |
                | 4. Show all products     |
                | 5. Login as Admin        |
                | 0. Exit program          |
                ----------------------------""");

            try {
                System.out.print("Your choice: ");

                menuChoice = input.nextInt(); input.nextLine();

                switch(menuChoice){
                    case 1 -> productManagement.searchForProduct();
                    case 2 -> productManagement.addNewProduct();
                    case 3 -> productManagement.removeProduct();
                    case 4 -> productManagement.showAllProducts();
                    case 5 -> adminLogin();
                    case 0 -> System.out.println("\nExiting program...");

                    default -> System.out.println("\nThat option does not exist. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Try again.");
                input.nextLine();
            }

        }while(menuChoice !=0);
    }
    private static boolean checkLoginDetails(String username, String password){
        try(BufferedReader reader = new BufferedReader(new FileReader("AdminLogin.txt"))){
            String line;
            while((line = reader.readLine()) != null) {
                String[] part = line.split(",");
                if(username.equals(part[0]) && password.equals(part[1])){
                    return true;
                }
            }
        }catch(IOException e){
            System.out.println("IO EXCEPTION");
        }
        return false;
    }
    private static void adminLogin(){

        System.out.println("ADMIN LOGIN:");

        Console console = System.console();

        System.out.print("Enter username: ");
        String username = input.nextLine();
        if(Utility.returnToMenu(username)){
            System.out.println("\nReturning to main menu.");
            return;
        }
        System.out.print("Enter password: ");
        String password;
        if(console != null){
            char[] passwordChars = console.readPassword();
            password = new String(passwordChars);
        }else{
            password = input.nextLine();
        }
        if(Utility.returnToMenu(password)){
            System.out.println("\nReturning to main menu.");
            return;
        }

        if(checkLoginDetails(username,password)){
            System.out.println("\nLogin Successful!");
            adminMenu();
        }else{
            System.out.println("\nLogin Failed.\nIncorrect Username/Password.");
        }
    }
    private static void adminMenu(){
        int menuChoice = -1;
        do{
            System.out.println(Utility.PURPLE+"""

                Please choose a menu option by number!
                
                ADMIN MENU:
                ----------------------------
                | 1. Search for product    |
                | 2. Add a product         |
                | 3. Remove a product      |
                | 4. Show all products     |
                | 5. Register new admin    |
                | 0. Log out               |
                ----------------------------""");

            try {
                System.out.print("Your choice: ");
                menuChoice = input.nextInt(); input.nextLine();

                switch(menuChoice){
                    case 1 -> productManagement.searchForProduct();
                    case 2 -> productManagement.addNewProduct();
                    case 3 -> productManagement.removeProduct();
                    case 4 -> productManagement.showAllProducts();
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