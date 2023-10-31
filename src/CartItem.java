public class CartItem {
    private Product product;
    private double weight;

    public CartItem(Product product,double weight){
        this.product = product;
        this.weight = weight;
    }
    public Product getProduct(){
        return this.product;
    }
    public double getWeight(){
        return this.weight;
    }
}
