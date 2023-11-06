//Name: Måns Friberg
//Email: mans.friberg@iths.se

public class CartItem {
    private Product product;
    private double weight;
    private double cartItemPrice;

    public CartItem(Product product,double weight){
        this.product = product;
        this.weight = weight;
        calculateItemPrice();
    }
    private void calculateItemPrice(){
        cartItemPrice = getDiscountedPrice()*weight;
    }
    public double getOriginalPrice(){
        return product.getPricePerKg();
    }
    public double getDiscountedPrice(){
        if(product.getDiscount() == null){
            return getOriginalPrice();
        }else{
            return product.getDiscount().applyDiscount(this);
        }
    }
    public Product getProduct(){
        return this.product;
    }
    public double getWeight(){
        return this.weight;
    }
    public double getCartItemPrice() {
        return cartItemPrice;
    }
    public void setWeight(double weight){
        this.weight = weight;
        calculateItemPrice();
    }

    @Override
    public String toString() {
        String printPrice = String.format("%.3fKg*%.2fKr/kg",weight,getDiscountedPrice());

        if(product.getDiscount() == null){
            return String.format("%-20s| %-20s| %-25s| %9.2fkr",
                    product.getName(),printPrice,"",cartItemPrice);
        }else{
            return String.format("%-20s| %-20s| %-25s| %9.2fkr",
                    product.getName(),printPrice,product.getDiscount(),cartItemPrice);
        }

    }
}
