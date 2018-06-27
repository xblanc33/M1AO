package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriceTest {

    @Test
    public void createPrice() {
        Price price = new Price(1.3);
        assertEquals(1.3,price.getPrice(),0);
        price = new Price(3);
        assertEquals(3, price.getPrice(),0);
        price = new Price(3.00);
        assertEquals(3, price.getPrice(),0);
        try {
            Price price2 = new Price(1.345);
            assertTrue(false);
        } catch (ProductManagementException ex) {
            assertTrue(true);
        }

    }

}