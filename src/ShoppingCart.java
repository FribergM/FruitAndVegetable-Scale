import java.util.ArrayList;
import java.util.InputMismatchException;

public class ShoppingCart {
    private static ArrayList<CartItem> shoppingCart = new ArrayList<>();

    public void addToShoppingCart(CartItem newCartItem){
        String productName = newCartItem.getProduct().getName();
        double productWeight = newCartItem.getWeight();

        System.out.println(('\n'+productName+'('+productWeight+"kg) added to shopping cart!").replace('.',','));
        shoppingCart.add(newCartItem);
    }
    public void printAllCartItems(){

        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("| %-24s| %-20s| %-25s| %-11s |%n","Product","Weight * Kr/Kg","Available Discount","Price");
        System.out.println("------------------------------------------------------------------------------------------");
        for(int i=0;i<shoppingCart.size();i++){
            System.out.printf("| %-3s %s |%n",(i+1)+".",shoppingCart.get(i));
        }
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("| Total price: %-37s%36s |%n",getCheckoutPrice(),Utility.date.format(Utility.currentDate));
        System.out.println("------------------------------------------------------------------------------------------");


    }
    private String getCheckoutPrice(){
        double checkoutPrice=0;

        for(CartItem cartItem : shoppingCart){
            checkoutPrice += cartItem.getCartItemPrice();
        }
        return String.format("%.2f",checkoutPrice)+"kr";
    }
    public void shoppingCartMenu(){
        int menuChoice = -1;
        do{
            if(shoppingCart.isEmpty()){
                System.out.println("\nShopping cart is empty!");
                return;
            }
            System.out.println("\nSHOPPING CART");
            printAllCartItems();
            System.out.println("""
                
                Please choose a menu option by number!
                ----------------------------
                | 1. Checkout              |
                | 2. Remove a cart item    |
                | 0. Return to menu        |
                ----------------------------""");

            try {
                System.out.print("Your choice: ");

                menuChoice = Main.input.nextInt(); Main.input.nextLine();

                switch(menuChoice){
                    case 1 -> printReceipt();
                    case 2 -> removeCartItem();
                    case 0 -> System.out.println("\nReturning to menu...");
                    default -> System.out.println("\nThat option does not exist. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Try again.");
                Main.input.nextLine();
            }

        }while(menuChoice<0 || menuChoice>1);
    }
    private void printReceipt(){
        System.out.println("\nRECEIPT");
        printAllCartItems();
        System.out.println("\nReceipt printed. Have a nice day!");
        shoppingCart.clear();
    }
    private void removeCartItem(){
        int chosenCartItem;
        do{
            System.out.println("\nEnter the number of item you wish to remove. \"0\" to return to menu.");
            printAllCartItems();

            chosenCartItem = Utility.checkIfValidIntInput("cart item",1,shoppingCart.size());

        }while(chosenCartItem<0 || chosenCartItem>shoppingCart.size());

        if(Utility.returnToMenu(chosenCartItem) || !Utility.confirmRemoval("cart item")){
            System.out.println("\nReturning to menu...");
            return;
        }
        String productName = shoppingCart.get(chosenCartItem-1).getProduct().getName();
        System.out.println("\n"+productName+" has been removed from shopping cart!");
        shoppingCart.remove(chosenCartItem-1);
    }

}
