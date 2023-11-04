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
    @Override
    public double applyDiscountForPrint(Product product) {
        double discountAmount = (product.getPricePerKg() * discountPercentage)/100;
        return product.getPricePerKg()- discountAmount;
    }
    @Override
    public String toString(){
        return (discountPercentage + "% off").replace('.',',');
//                discountPercentage + "% off";
    }
    @Override
    public String discountTypeString(){ //Used for saving to product file
        return "Percent%"+discountPercentage;
    }
}