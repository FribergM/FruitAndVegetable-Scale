//Name: Måns Friberg
//Email: mans.friberg@iths.se

public interface Discount {
    double applyDiscount(CartItem cartItem);
    double applyDiscountForPrint(Product product);
    String discountPropertiesToString(); //Used for saving to product file

}
