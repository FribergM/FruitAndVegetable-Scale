/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */
public class Product {
    private String name;
    private String type;
    private int price;
    private boolean discount;
    private int discountAmount;

    public Product(String name){
        this.name = name;
    }

    public Product(String name, String type){
        this.name = name;
        this.type = type;
    }

    public Product(String name, String type, int price){
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Product(String name, String type, int price, boolean discount,int discountAmount){
        this.name = name;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.discountAmount = discountAmount;
    }

    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    public int getPrice(){
        return this.price;
    }
    public boolean getDiscount(){
        return this.discount;
    }
    public int getDiscountAmount(){
        return this.discountAmount;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setPrice(int price){
        this.price = price;
    }
    public void setDiscount(boolean discount){
        this.discount = discount;
    }
    public void setDiscountAmount(int discountAmount){
        this.discountAmount = discountAmount;
    }

}
