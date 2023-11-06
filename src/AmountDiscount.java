//Name: Måns Friberg
//Email: mans.friberg@iths.se

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
    @Override
    public double applyDiscountForPrint(Product product) {
        return product.getPricePerKg() - amount;
    }
    @Override
    public String toString(){
        return (amount + "kr off").replace('.',',');
    }
    @Override
    public String discountTypeString(){ //Used for saving to product file
        return "Amount%"+amount;
    }
}