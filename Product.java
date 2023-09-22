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

    public Product(String name, String type, int price, boolean discount,int discountAmount){
        this.name = name;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.discountAmount = discountAmount;
    }

}
