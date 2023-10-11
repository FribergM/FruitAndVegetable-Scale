import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;

    @BeforeEach
    void setUp() {
//        Main.initializeProducts();
    }

    @Test
    void getName() {
        assertEquals("lemon",Main.productList[0].get(0).getName().toLowerCase());
    }

    @Test
    void getProductGroup() {
        assertEquals("Fruit",Main.productGroup[0]);
    }

    @Test
    void getProductCategory() {
        assertEquals("Citrus Fruit",Main.productCategory[0]);
    }

    @Test
    void getPricePerKg() {
    }

    @Test
    void setName() {
    }

    @Test
    void setProductGroup() {
    }

    @Test
    void setProductCategory() {
    }

    @Test
    void setPricePerKg() {
    }

    @Test
    void testToString() {
        assertTrue(Main.productList[0].get(2).toString().equalsIgnoreCase("Orange              | Fruit        | Citrus Fruit     |   34.90kr/kg"));
    }
}