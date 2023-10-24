import java.util.Locale;

/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */
public class Product {
    private String name;
    private String productGroup;
    private String productCategory;
    private double pricePerKg;

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
    public Product(String name, String productGroup, String productCategory, double pricePerKg){
        this.name = name;
        this.productGroup = productGroup;
        this.productCategory = productCategory;
        this.pricePerKg = pricePerKg;
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
    public double getPricePerKg(){
        return this.pricePerKg;
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
    public void setPricePerKg(double pricePerKg){
        this.pricePerKg = pricePerKg;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH,"%-20s| %-13s| %-17s| %7.2fkr/kg",name,productGroup,productCategory, pricePerKg);
    }
    public String toStringNonFormat(){
        return name+","+productGroup+","+productCategory+","+pricePerKg;
    }
}
