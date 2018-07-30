package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.type.Price;

public class PriceTest {

    @Test
    public void createPrice() {
        Price price = new Price(13);
        assertEquals(13,price.getPrice(),0);
        try {
            Price price2 = new Price(-1);
            assertTrue(false);
        } catch (ProductManagementException ex) {
            assertTrue(true);
        }

    }

}