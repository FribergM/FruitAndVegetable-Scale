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

public class FileManagement {
    private static ProductManagement productManagement = new ProductManagement();
    private static AdminManagement adminManagement = new AdminManagement();

    public static final String productsFilePath = "Products\\";

    public static void saveProductsToTextFiles(String filePath){

        for(String category : ProductManagement.productCategory){
            clearFile(filePath+category); //clears out matching productCategory file
            for(Product product : productManagement.getProductList()){
                if(product.getProductCategory().equalsIgnoreCase(category)){

                    try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath+category+".txt",true))){
                        writer.write(product.toStringNonFormat()+"\n");
                    }catch(IOException e){
                        System.out.println("IO EXCEPTION: saveProductsToTextFiles");
                    }
                }
            }
        }

    }
    public static void saveAdminsToTextFiles(String fileName){
        clearFile(fileName);
        for(Admin a : adminManagement.getAdminList()){
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName+".txt",true))){
                writer.write(a.toString()+"\n");
            }catch(IOException e){
                System.out.println("IO EXCEPTION: saveAdminsToTextFiles");
            }
        }
    }
    private static void clearFile(String fileName){

        try(FileWriter clearFile = new FileWriter(fileName+".txt")){
            // overwrites the file with nothing.
        } catch(IOException e){
            System.out.println("IO EXCEPTION: clearFile");
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
                    productManagement.addProductToList(newProduct);

                }
            }catch(IOException e){
                System.out.println("IO EXCEPTION: initializeProductsFromFiles");
            }
        }
    }
    public static void initializeAdminAccountsFromFiles(){

        try(BufferedReader reader = new BufferedReader(new FileReader("AdminLogin.txt"))){
            String line;
            while((line = reader.readLine()) != null){
                String[] part = line.split(",");
                String adminName = part[0];
                String adminUsername = part[1];
                String adminPassword = part[2];

                Admin newAdmin = new Admin(adminName,adminUsername,adminPassword);
                adminManagement.addAdminToList(newAdmin);
            }
        }catch(IOException e){
            System.out.println("IO EXCEPTION: initializeAdminAccountFromFiles");
        }
    }
}
