import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

//Name: Måns Friberg
//Email: mans.friberg@iths.se

public class FileManagement {
    private static ProductManagement productManagement = new ProductManagement();
    private static AdminManagement adminManagement = new AdminManagement();

    public static final String productsDirectoryPath = "Products\\";

    public static void saveProductsToTextFiles(String filePath){

        createDirectory("Products");

        for(String category : ProductManagement.productCategory){
            clearFile(filePath+category); //clears out matching productCategory file
            for(Product product : productManagement.getProductList()){
                if(product.getProductCategory().equalsIgnoreCase(category)){

                    try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath+category+".txt",true))){
                        writer.write(product.saveToFileFormat()+"\n");
                    }catch(IOException e){
                        System.out.println("IO EXCEPTION: saveProductsToTextFiles");
                    }
                }
            }
        }

    }
    public static void saveAdminsToTextFile(){
        clearFile("AdminLogin");
        for(Admin a : adminManagement.getAdminList()){
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("AdminLogin.txt",true))){
                writer.write(a.toString()+"\n");
            }catch(IOException e){
                System.out.println("IO EXCEPTION: saveAdminsToTextFile");
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
            try(BufferedReader reader = new BufferedReader(new FileReader(productsDirectoryPath +category+".txt"))){
                String line;
                while((line = reader.readLine()) != null){
                    String[] part = line.split(",");
                    String productName = part[0];
                    String productGroup = part[1];
                    String productCategory = part[2];
                    double pricePerKg = Double.parseDouble(part[3]);

                    Discount productDiscount = null;

                    if(part.length>4 && !part[4].equals("null")){
                        String[] discountPart = part[4].split("%");
                        String discountType = discountPart[0];
                        double discountAmount = Double.parseDouble(discountPart[1]);
                        double discountThreshold = 0;
                        if(discountPart.length>2){
                            discountThreshold = Double.parseDouble(discountPart[2]);
                        }

                        switch(discountType){
                            case "Percent" -> productDiscount = new PercentDiscount(discountAmount);
                            case "Amount" -> productDiscount = new AmountDiscount(discountAmount);
                            case "PercentIf" -> productDiscount = new PercentDiscountIf(discountAmount,discountThreshold);
                            case "AmountIf" -> productDiscount = new AmountDiscountIf(discountAmount,discountThreshold);
                        }
                    }

                    productManagement.addProductToList(new Product(productName,productGroup, productCategory,pricePerKg,productDiscount));

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
    public static void saveReceiptToFile(StringBuilder shoppingCartPrint){
        Date currentDate = new Date();
        SimpleDateFormat dateAndTime = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
        String currentTime = dateAndTime.format(currentDate);

        createDirectory("Receipts");

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Receipts\\Receipt_"+currentTime+".txt"))){
            writer.write(shoppingCartPrint.toString());
        }catch(IOException e){
            System.out.println("IO EXCEPTION: saveReceiptsToFile");
        }
    }
    private static void createDirectory(String directoryName){
        File receiptDirectory = new File(directoryName);
        if(!receiptDirectory.exists()){
            receiptDirectory.mkdirs();
        }
    }
}
