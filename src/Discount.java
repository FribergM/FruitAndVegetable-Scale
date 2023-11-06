//Name: Måns Friberg
//Email: mans.friberg@iths.se

public interface Discount {
    double applyDiscount(CartItem cartItem);
    double applyDiscountForPrint(Product product);
    String discountTypeString(); //Used for saving to product file

}
