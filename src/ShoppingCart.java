import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/FruitAndVegetable-Scale
 */

public class ShoppingCart {
    private static ArrayList<CartItem> shoppingCart = new ArrayList<>();

    public void shoppingCartMenu(){
        int menuChoice = -1;
        do{
            if(shoppingCart.isEmpty()){
                System.out.println("\nShopping cart is empty!");
                return;
            }
            System.out.println("\nSHOPPING CART");
            printAllCartItems("shoppingCartMenu");
            System.out.println("""
                
                Please choose a menu option by number!
                ----------------------------
                | 1. Checkout              |
                | 2. Remove a cart item    |
                | 3. Empty out cart        |
                | 0. Return to menu        |
                ----------------------------""");

            try {
                System.out.print("Your choice: ");

                menuChoice = Main.input.nextInt(); Main.input.nextLine();

                switch(menuChoice){
                    case 1 -> printReceipt();
                    case 2 -> removeCartItem();
                    case 3 -> emptyOutCart();
                    case 0 -> {return;}
                    default -> System.out.println("\nThat option does not exist. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Try again.");
                Main.input.nextLine();
            }

        }while(menuChoice<0 || menuChoice>1);
    }
    public void addToShoppingCart(CartItem newCartItem){
        String productName = newCartItem.getProduct().getName();
        double productWeight = newCartItem.getWeight();

        checkIfAlreadyInCart(newCartItem);

        System.out.println(('\n'+productName+'('+productWeight+"kg) added to shopping cart!").replace('.',','));
    }
    private void checkIfAlreadyInCart(CartItem newCartItem){
        boolean alreadyExists = false;
        for(CartItem cartItem : shoppingCart){

            if(cartItem.getProduct().getName().equals(newCartItem.getProduct().getName())){
                alreadyExists = true;
                cartItem.setWeight(cartItem.getWeight() + newCartItem.getWeight());
                break;
            }
        }
        if(!alreadyExists){
            shoppingCart.add(newCartItem);
        }

    }
    private void removeCartItem(){
        int chosenCartItem;
        do{
            System.out.println("\nEnter the number of item you wish to remove. \"0\" to return to menu.");
            printAllCartItems("removeCartItem");

            chosenCartItem = Utility.checkIfValidIntInput("that cart item",1,shoppingCart.size());

        }while(chosenCartItem<0 || chosenCartItem>shoppingCart.size());

        if(Utility.returnToMenu(chosenCartItem)){
            System.out.println("\nReturning to menu...");

        }else if(Utility.confirmRemoval("cart item")){
            String productName = shoppingCart.get(chosenCartItem-1).getProduct().getName();
            System.out.println("\n"+productName+" has been removed from shopping cart!");
            shoppingCart.remove(chosenCartItem-1);
        }
    }
    private void emptyOutCart(){

        if(Utility.confirmRemoval("all cart items")){
            shoppingCart.clear();
        }else{
            System.out.println("\nReturning to menu...");
        }

    }

    private String getCheckoutPrice(){
        double checkoutPrice=0;

        for(CartItem cartItem : shoppingCart){
            checkoutPrice += cartItem.getCartItemPrice();
        }
        return String.format("%.2f",checkoutPrice)+"kr";
    }
    public void printAllCartItems(String calledFromMethod){
        System.out.println(getShoppingCartPrint(calledFromMethod));
    }
    public StringBuilder getShoppingCartPrint(String calledFromMethod){
        StringBuilder printCartContents = new StringBuilder();
        Date currentDate = new Date();
        SimpleDateFormat dateAndTime = new SimpleDateFormat("yyyy.MM.dd '-' HH:mm:ss");

        if(calledFromMethod.equals("removeCartItem")){
            printCartContents.append("------------------------------------------------------------------------------------------\n");
            printCartContents.append(String.format("| %-24s| %-20s| %-25s| %-11s |%n","Product","Weight * Kr/Kg","Available Discount","Price"));
            printCartContents.append("------------------------------------------------------------------------------------------\n");
            for(int i=0;i<shoppingCart.size();i++){
                printCartContents.append(String.format("| %-3s %s |%n",(i+1)+".",shoppingCart.get(i)));
            }
            printCartContents.append("------------------------------------------------------------------------------------------\n");
            printCartContents.append(String.format("| Total price: %-37s%36s |%n",getCheckoutPrice(),dateAndTime.format(currentDate)));
            printCartContents.append("------------------------------------------------------------------------------------------");
        }else{
            printCartContents.append("--------------------------------------------------------------------------------------\n");
            printCartContents.append(String.format("| %-20s| %-20s| %-25s| %-11s |%n","Product","Weight * Kr/Kg","Available Discount","Price"));
            printCartContents.append("--------------------------------------------------------------------------------------\n");
            for(CartItem cartItem : shoppingCart){
                printCartContents.append(String.format("| %s |%n",cartItem));
            }
            printCartContents.append("--------------------------------------------------------------------------------------\n");
            printCartContents.append(String.format("| Total price: %-35s%34s |%n",getCheckoutPrice(),dateAndTime.format(currentDate)));
            printCartContents.append("--------------------------------------------------------------------------------------");
        }


        return printCartContents;
    }
    private void printReceipt(){
        System.out.println("\nRECEIPT");
        printAllCartItems("printReceipt");
        System.out.println("\nReceipt printed. Have a nice day!\n");
        FileManagement.saveReceiptToFile(getShoppingCartPrint("printReceipt"));
        shoppingCart.clear();

        Main.greetingMessage();
    }


}
