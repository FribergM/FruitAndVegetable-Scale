import java.io.Console;
import java.util.ArrayList;

/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/FruitAndVegetable-Scale
 */

public class AdminManagement {
    private static ArrayList<Admin> adminList = new ArrayList<>();

    public static void adminLogin(){
        boolean isValidCredentials = false;

        do{

            System.out.println("\nADMIN LOGIN\n\nEnter login credentials. \"0\" to return to main menu.");

            Console console = System.console();

            System.out.print("\nUsername: ");
            String username = Main.input.nextLine();
            if(Utility.returnToMenu(username)){
                System.out.println("\nReturning to menu.");
                return;
            }
            System.out.print("Password: ");
            String password;
            if(console != null){
                char[] passwordChars = console.readPassword();
                password = new String(passwordChars);
            }else{
                password = Main.input.nextLine();
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
    public void addNewAdmin(){
        String adminName;
        String adminUsername="USERNAME";
        String adminPassword="PASSWORD";


        adminName = createAdminName();
        if(Utility.returnToMenu(adminName)){
            System.out.println("\nReturning to main...");
            return;
        }
        adminName = Utility.capitalizeWordsInString(adminName);

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

        adminList.add(new Admin(adminName,adminUsername,adminPassword));
        System.out.println("\nAdmin account: "+adminUsername+" created!");


        FileManagement.saveAdminsToTextFiles("AdminLogin");

    }
    private String createAdminName(){
        String adminName;
        boolean isValidName;

        do{
            System.out.println("\nADMIN REGISTRATION\nEnter the NAME of the admin you wish to register. \"0\" to return to main menu.");
            System.out.print("\nName: ");

            adminName = Main.input.nextLine().toLowerCase();

            isValidName = Utility.checkIfValidString(adminName);

        }while(!isValidName);

        if(Utility.returnToMenu(adminName)){
            return "0";
        }
        return adminName;
    }
    private String createAdminCredentials(String credentialType){
        String adminCredential;
        boolean isValidCredential;

        do{

            System.out.println("\nEnter the "+credentialType+" for the admin account. \"0\" to return to main menu.");
            Utility.capitalizeWordsInString(credentialType);
            System.out.print("\n"+credentialType+": ");

            adminCredential = Main.input.nextLine();

            if(credentialType.equalsIgnoreCase("username")){
                isValidCredential = checkIfAdminExists(adminCredential);
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
    private boolean checkIfAdminExists(String newAdminUsername){
        for(Admin admin : adminList){
            if(admin.getUsername().equalsIgnoreCase(newAdminUsername)){
                System.out.println("An admin with that username already exists. Try again.");
                return false;
            }
        }
        return true;
    }
    public void addAdminToList(Admin newAdmin){
        adminList.add(newAdmin);
    }
    public ArrayList<Admin> getAdminList(){
        return adminList;
    }
}
