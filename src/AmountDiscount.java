public class AmountDiscount implements Discount{
    private double amount;

    public AmountDiscount(double amount){
        this.amount = amount;
    }
    @Override
    public double applyDiscount(CartItem cartItem) {
        double productPricePerKg = cartItem.getProduct().getPricePerKg();
        return productPricePerKg - amount;
    }
    public String discountToString(){
        return amount + "kr off";
    }
}