/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */
public class Product {
    private String name;
    private String productGroup;
    private String productCategory;
    private double price;

    public Product(String name){
        this.name = name;
    }

    public Product(String name,String productGroup){
        this.name = name;
        this.productGroup = productGroup;
    }

    public Product(String name, String productGroup,String productCategory){
        this.name = name;
        this.productGroup = productGroup;
        this.productCategory = productCategory;
    }
    public Product(String name, String productGroup, String productCategory, double price){
        this.name = name;
        this.productGroup = productGroup;
        this.productCategory = productCategory;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }
    public String getProductGroup(){
        return this.productGroup;
    }
    public String getProductCategory(){
        return this.productCategory;
    }
    public double getPrice(){
        return this.price;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setProductGroup(String productGroup){
        this.productGroup = productGroup;
    }
    public void setProductCategory(String productCategory){
        this.productCategory = productCategory;
    }
    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-20s| %-13s| %-17s| %7.2fkr/kg",name,productGroup,productCategory,price);

    }
}
