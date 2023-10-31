public interface Discount {
    double applyDiscount(CartItem cartItem);

    String discountToString();
}
