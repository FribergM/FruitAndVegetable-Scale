//Name: Måns Friberg
//Email: mans.friberg@iths.se

public class Product {
    private String name;
    private String productGroup;
    private String productCategory;
    private double pricePerKg;
    private Discount discount;
    private double discountedPrice; // Only used for toString.

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
        if(discount != null){// Only used for toString.
            discountedPrice = discount.applyDiscountForPrint(this);
        }
    }

    public String getName(){
        return this.name;
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
            return name+','+productGroup+','+productCategory+','+pricePerKg+','+discount.discountPropertiesToString();
        }

    }
}
