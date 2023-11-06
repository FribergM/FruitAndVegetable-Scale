//Name: Måns Friberg
//Email: mans.friberg@iths.se

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
    @Override
    public double applyDiscountForPrint(Product product) {
        double discountAmount = (product.getPricePerKg()*discountPercentage)/100;
        return product.getPricePerKg()- discountAmount;

    }
    @Override
    public String toString(){
        return (discountPercentage + "% off (if >= "+minWeightForDiscount+"kg)").replace('.',',');
    }
    @Override
    public String discountTypeString(){ //Used for saving to product file
        return "PercentIf%"+discountPercentage+'%'+minWeightForDiscount;
    }
}