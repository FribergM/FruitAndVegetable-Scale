import java.util.ArrayList;

public class AdminManagement {
    private ArrayList<Admin> adminList = new ArrayList<>();

    public void addNewAdmin(){
        String adminName;
        String adminUsername="USERNAME";
        String adminPassword="PASSWORD";


        adminName = createAdminName();
        if(Utility.returnToMenu(adminName)){
            System.out.println("\nReturning to main...");
            return;
        }
        adminName = Utility.capitalizeWordsOfString(adminName);

        adminUsername = createAdminCredentials(adminUsername);
        if(Utility.returnToMenu(adminName)){
            System.out.println("\nReturning to main...");
            return;
        }

        adminPassword = createAdminCredentials(adminPassword);
        if(Utility.returnToMenu(adminName)){
            System.out.println("\nReturning to main...");
            return;
        }

        adminList.add(new Admin(adminName,adminUsername,adminPassword));
        System.out.println("\nAdmin account created!");
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
            Utility.capitalizeWordsOfString(credentialType);
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
    public ArrayList<Admin> getAdminList(){
        return this.adminList;
    }
}
