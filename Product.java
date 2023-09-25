/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */
public class Product {
    private String name;
    private String productGroup;
    private double price;
    private boolean discount;
    private double discountAmount;

    public Product(String name){
        this.name = name;
    }

    public Product(String name, String productGroup){
        this.name = name;
        this.productGroup = productGroup;
    }

    public Product(String name, String productGroup, double price){
        this.name = name;
        this.productGroup = productGroup;
        this.price = price;
    }

    public Product(String name, String productGroup, double price, boolean discount, double discountAmount){
        this.name = name;
        this.productGroup = productGroup;
        this.price = price;
        this.discount = discount;
        this.discountAmount = discountAmount;
    }

    public String getName(){
        return this.name;
    }
    public String getProductGroup(){
        return this.productGroup;
    }
    public double getPrice(){
        return this.price;
    }
    public boolean getDiscount(){
        return this.discount;
    }
    public double getDiscountAmount(){
        return this.discountAmount;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setProductGroup(String productGroup){
        this.productGroup = productGroup;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setDiscount(boolean discount){
        this.discount = discount;
    }
    public void setDiscountAmount(double discountAmount){
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        //TODO Make this look nice.
        if(discount){
            return "Product{" +
                    "name='" + name + '\'' +
                    ", productGroup='" + productGroup + '\'' +
                    ", price=" + price + "kr/kg"+
                    ", discount=" + discount +
                    ", discountAmount=" + discountAmount +
                    '}';
        }else{
            return name + ", ProductGroup: '" + productGroup + '\'' +
                    ", Price: " + price + "kr/kg"+
                    '}';
        }

    }
}
