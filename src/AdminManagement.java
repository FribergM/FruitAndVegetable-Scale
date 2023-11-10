import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

//Name: Måns Friberg
//Email: mans.friberg@iths.se

public class AdminManagement {
    private static ArrayList<Admin> adminList = new ArrayList<>();

    public static void adminLogin(){
        Scanner input = new Scanner(System.in);

        boolean isValidCredentials = false;

        do{

            System.out.println("\nADMIN LOGIN\n\nEnter login credentials. \"0\" to return to main menu.");

            System.out.print("\nUsername: ");
            String username = input.nextLine().trim();
            if(Utility.returnToMenu(username)){
                System.out.println("\nReturning to menu.");
                return;
            }

            Console console = System.console();

            String password;
            if(console != null){
                System.out.print("Password: ");
                password = new String(console.readPassword()).trim();
            }else{
                System.out.println("\nWARNING: If you want to hide your password, run the program from Terminal. (Check README.md))");
                System.out.print("Password: ");
                password = input.nextLine().trim();
            }
            if(Utility.returnToMenu(password)){
                System.out.println("\nReturning to menu.");
                return;
            }

            if(checkLoginDetails(username,password)){
                System.out.println("\nLogin Successful!");
                Main.isAdmin = true;
                isValidCredentials = true;

                Main.adminMenu();

            }else{
                System.out.println("\nIncorrect Username/Password. Try again.");
            }

        }while(!isValidCredentials);

    }
    private static boolean checkLoginDetails(String username, String password){

        for(Admin a : adminList){
            if(a.getUsername().equals(username) && a.getPassword().equals(password)){
                return true;
            }
        }
        return false;

    }
    public static void addNewAdmin(){

        String adminUsername="USERNAME";
        String adminPassword="PASSWORD";



        adminUsername = createAdminCredentials(adminUsername);

        if(Utility.returnToMenu(adminUsername)){
            System.out.println("\nReturning to main...");
            return;
        }

        adminPassword = createAdminCredentials(adminPassword);

        if(Utility.returnToMenu(adminPassword)){
            System.out.println("\nReturning to main...");
            return;
        }

        adminList.add(new Admin(adminUsername,adminPassword));
        System.out.println("\nAdmin account: "+adminUsername+" created!");


        FileManagement.saveAdminsToTextFile();

    }
    private static String createAdminCredentials(String credentialType){
        Scanner input = new Scanner(System.in);

        String adminCredential;
        boolean isValidCredential;

        do{

            System.out.println("\nEnter the "+credentialType+" for the admin account. \"0\" to return to main menu.");
            Utility.capitalizeWordsInString(credentialType);
            System.out.print("\n"+credentialType+": ");

            adminCredential = input.nextLine().trim();

            if(credentialType.equalsIgnoreCase("username")){
                isValidCredential = checkIfAdminAlreadyExists(adminCredential);
            }else{
                isValidCredential = true;
            }

            if(isValidCredential){
                isValidCredential = Utility.checkIfValidAdminDetails(adminCredential);
            }

        }while(!isValidCredential);

        if(Utility.returnToMenu(adminCredential)){
            return "0";
        }
        return adminCredential;
    }
    private static boolean checkIfAdminAlreadyExists(String newAdminUsername){
        for(Admin admin : adminList){
            if(admin.getUsername().equalsIgnoreCase(newAdminUsername)){
                System.out.println("An admin with that username already exists. Try again.");
                return false;
            }
        }
        return true;
    }
    public static void addAdminToList(Admin newAdmin){
        adminList.add(newAdmin);
    }
    public static ArrayList<Admin> getAdminList(){
        return adminList;
    }
}
