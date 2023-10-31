import java.util.ArrayList;

public class ShoppingCart {
    private static ArrayList<CartItem> shoppingCart = new ArrayList<>();

    public static ArrayList<CartItem> getShoppingCart(){
        return shoppingCart;
    }
    public void addToShoppingCart(CartItem newCartItem){
        shoppingCart.add(newCartItem);
    }
}
