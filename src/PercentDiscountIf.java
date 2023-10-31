public class PercentDiscountIf implements Discount{
    private double discountPercentage;
    private double minWeightForDiscount;

    public PercentDiscountIf(double discountPercentage, double minWeightForDiscount){
        this.discountPercentage = discountPercentage;
        this.minWeightForDiscount = minWeightForDiscount;
    }
    @Override
    public double applyDiscount(CartItem cartItem) {
        double weight = cartItem.getWeight();
        double productPricePerKg = cartItem.getProduct().getPricePerKg();

        if(weight>=minWeightForDiscount){
            double discountAmount = (productPricePerKg*discountPercentage)/100;
            return productPricePerKg- discountAmount;
        }else{
            return productPricePerKg;
        }

    }
    public String discountToString(){
        return discountPercentage + "% off (if > "+minWeightForDiscount+"kg)";
    }
}