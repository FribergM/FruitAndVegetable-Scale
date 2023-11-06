//Name: Måns Friberg
//Email: mans.friberg@iths.se

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
    @Override
    public double applyDiscountForPrint(Product product) {
        return product.getPricePerKg() - amount;
    }
    @Override
    public String toString(){
        return (amount + "kr off (if >= "+minWeightForDiscount+"kg)").replace('.',',');
    }
    @Override
    public String discountTypeString(){ //Used for saving to product file
        return "AmountIf%"+amount+'%'+minWeightForDiscount;
    }
}
