import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Name: Måns Friberg
 * Email: mans.friberg@iths.se
 * GitHub: https://github.com/FribergM/Labb1
 */

public class ProductFiles {

    public static final String productsFilePath = "products\\";
    private static ProductManagement productManagement = new ProductManagement();

    public static void createNewTextFile(String fileName){

        try{
            File file = new File(productsFilePath+fileName+".txt");
            file.createNewFile();

        }catch(IOException e){
            System.out.println("IO EXCEPTION");
        }


    }
    public static void saveProductsToTextFiles(){

        for(String category : ProductManagement.productCategory){
            clearFile(productsFilePath+category); //clears out matching productCategory file
            for(Product product : productManagement.getProductList()){
                if(product.getProductCategory().equalsIgnoreCase(category)){

                    File file = new File(productsFilePath+category+".txt");
                    try(BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))){
                        writer.write(product.toStringNonFormat()+"\n");
                    }catch(IOException e){
                        System.out.println("IO EXCEPTION");
                    }
                }
            }
        }

    }
    private static void clearFile(String fileName){

        try(FileWriter clearFile = new FileWriter(fileName+".txt")){
            // overwrites the file with nothing.
        } catch(IOException e){
            System.out.println("IO EXCEPTION");
        }
    }
    public static void initializeProductsFromFiles(){

        for(String category : ProductManagement.productCategory){
            try(BufferedReader reader = new BufferedReader(new FileReader(productsFilePath+category+".txt"))){
                String line;
                while((line = reader.readLine()) != null){
                    String[] part = line.split(",");
                    String productName = part[0];
                    String productGroup = part[1];
                    String productCategory = part[2];
                    double pricePerKg = Double.parseDouble(part[3]);

                    Product newProduct = new Product(productName,productGroup, productCategory,pricePerKg);
                    productManagement.initAddToList(newProduct);

                }
            }catch(IOException e){
                System.out.println("IO EXCEPTION");
            }
        }
    }
}
