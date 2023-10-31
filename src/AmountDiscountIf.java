public class AmountDiscountIf implements Discount{
    private double amount;
    private double minWeightForDiscount;

    public AmountDiscountIf(double amount, double minWeightForDiscount){
        this.amount = amount;
        this.minWeightForDiscount = minWeightForDiscount;
    }
    @Override
    public double applyDiscount(CartItem cartItem) {
        double weight = cartItem.getWeight();
        double productPricePerKg = cartItem.getProduct().getPricePerKg();

        if(weight>=minWeightForDiscount){
            return productPricePerKg - amount;
        }else{
            return productPricePerKg;
        }

    }
    public String discountToString(){
        return amount + "kr off (if > "+minWeightForDiscount+"kg)";
    }
}
