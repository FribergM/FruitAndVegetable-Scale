import java.util.InputMismatchException;

public class Utility {

    public static final String PURPLE = "\033[0;35m";
    public static final String RESETCOLOR = "\033[0m";

    public static String capitalizeWordsOfString(String string){
        if(string.contains(" ")){

            String[] part = string.split(" +");
            for(int i=0;i<part.length;i++){
                part[i]= part[i].toUpperCase().charAt(0)+part[i].substring(1).toLowerCase();
            }

            String capitalizedString ="";

            for (String s : part) {
                capitalizedString = capitalizedString + s + " ";
            }
            capitalizedString = capitalizedString.substring(0, capitalizedString.length()-1);

            return capitalizedString;

        }else if(string.length()>=2){
            return string.toUpperCase().charAt(0)+string.substring(1).toLowerCase();
        }else{
            return string.toUpperCase();
        }
    }
    public static int checkIfValidIntInput(String choice, int minValue, int maxValue){

        int userChoice=-1; // Set to -1 to not accidentally return to menu if catch() is reached.

        try{
            System.out.print("Your choice: ");
            userChoice = Main.input.nextInt(); Main.input.nextLine();

            if(returnToMenu(userChoice)){
                return 0;
            }

            if(userChoice <minValue || userChoice >maxValue){
                System.out.println("\nThat "+choice+" does not exist. Try again.");
            }

        }catch(InputMismatchException e){
            System.out.println("\nInvalid input. Try again.");
            Main.input.nextLine();
        }
        return userChoice;
    }
    public static double checkIfValidDoubleInput(){
        double value = -1;
        String valueString = Main.input.nextLine();
        valueString = valueString.replace(',','.');

        String regexPattern = "\\d+\\.?\\d*"; // = (1 or more digits)+(1 or 0 '.')+(0 or more digits)
        if(valueString.isBlank()){
            System.out.println("\nField cannot be left blank. Try again.");
            return value;
        }else if(!valueString.matches(regexPattern)){
            System.out.println("\nInvalid input! Try again");
        }else{
            value = Double.parseDouble(valueString);

            if(returnToMenu(value)){
                return 0.0;
            }

            if(value<0.0){
                System.out.println("\nA negative value is not allowed. Try again");
            }

            return value;
        }
        return value;
    }
    public static boolean checkIfValidString(String userInput){
        if(!userInput.matches("[A-ZÅÄÖa-zåäö0 ]+") || userInput.contains("0") && userInput.length() > 1){ // Checks to make sure String only consist of valid letters.
            System.out.println("\nInvalid input. Please only use letters. Try again.");
            return false;
        }else if(userInput.isBlank()){
            System.out.println("\nInvalid input. Field cannot be left blank. Try again.");
            return false;
        }
        return true;
    }
    public static boolean checkIfValidAdminDetails(String userInput){
        if(!userInput.matches("[A-ZÅÄÖa-zåäö0-9]+")){ // Checks to make sure String only consist of valid letters.
            System.out.println("\nInvalid input. Please only use letters. Try again.");
            return false;
        }else if(userInput.isBlank()){
            System.out.println("\nInvalid input. Field cannot be left blank. Try again.");
            return false;
        }
        return true;
    }

    public static boolean returnToMenu(String userInput){
        if(userInput.equals("0")){
            ProductManagement.tempProductList.clear();
            return true;
        }
        return false;
    }
    public static boolean returnToMenu(int userInput){
        if(userInput == 0){
            ProductManagement.tempProductList.clear();
            return true;
        }
        return false;
    }
    public static boolean returnToMenu(double userInput){
        if(userInput == 0.0){
            ProductManagement.tempProductList.clear();
            return true;
        }
        return false;
    }
    public static boolean returnToMenu(Product userInput){
        if(userInput == null){
            ProductManagement.tempProductList.clear();
            return true;
        }
        return false;
    }
}
