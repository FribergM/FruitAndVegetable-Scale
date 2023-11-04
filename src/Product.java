/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/FruitAndVegetable-Scale
 */
public class Product {
    private String name;
    private String productGroup;
    private String productCategory;
    private double pricePerKg;
    private Discount discount;
    private double discountedPrice;

    public Product(String name, String productGroup, String productCategory, double pricePerKg){
        this.name = name;
        this.productGroup = productGroup;
        this.productCategory = productCategory;
        this.pricePerKg = pricePerKg;
    }
    public Product(String name, String productGroup, String productCategory, double pricePerKg, Discount discount){
        this.name = name;
        this.productGroup = productGroup;
        this.productCategory = productCategory;
        this.pricePerKg = pricePerKg;
        this.discount = discount;
        updateDiscountedPrice();
    }
    public void updateDiscountedPrice(){
        if(discount != null){
            discountedPrice = discount.applyDiscountForPrint(this);
        }
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
    public Discount getDiscount(){
        return this.discount;
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
    public void setDiscount(Discount discount){
        this.discount = discount;
    }

    @Override
    public String toString() {
        if(discount == null){
            return String.format("%-20s| %-13s| %-17s| %7.2fkr/kg | %-25s| %13s",
                    name,productGroup,productCategory, pricePerKg,"","");
        }else{
            return String.format("%-20s| %-13s| %-17s| %7.2fkr/kg | %-25s| *%7.2fkr/kg",
                    name,productGroup,productCategory, pricePerKg,discount,discountedPrice);
        }

    }
    public String saveToFileFormat(){ //Used for saving to product file
        if(discount == null){
            return name+','+productGroup+','+productCategory+','+pricePerKg+','+"null";
        }else{
            return name+','+productGroup+','+productCategory+','+pricePerKg+','+discount.discountTypeString();
        }

    }
}
