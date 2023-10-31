public class PercentDiscount implements Discount{
    private double discountPercentage;

    public PercentDiscount(double discountPercentage){
        this.discountPercentage = discountPercentage;
    }
    @Override
    public double applyDiscount(CartItem cartItem) {
        double productPricePerKg = cartItem.getProduct().getPricePerKg();
        double discountAmount = (productPricePerKg * discountPercentage)/100;
        return productPricePerKg- discountAmount;
    }
    public String discountToString(){
        return discountPercentage + "% off";
    }
}