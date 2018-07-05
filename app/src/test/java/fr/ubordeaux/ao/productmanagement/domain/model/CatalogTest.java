package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.InMemoryCatalog;

public class CatalogTest {
    Catalog catalog;

    @Before
    public void createCatalog() {
        catalog = new InMemoryCatalog("all");
    }

    @Test
    public void testAddProductInCatalog() { 
        //final int MAX = 150000000;//150 Millions
        final int MAX = 50000;
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            catalog.addProduct(referenceId, new Price(2));
        }
        assertEquals(MAX, catalog.ownSize());
    }

    @Test
    public void testSubCatalog() {
        final int MAX = 50000;
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            catalog.addProduct(referenceId, new Price(2));
        }
        
        Catalog sub = new InMemoryCatalog("sub", catalog);
        catalog.addSubCatalog(sub);
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            sub.addProduct(referenceId, new Price(2));
        }

        assertEquals(MAX, sub.allSize());
        assertEquals(2*MAX, catalog.allSize());
    }

    @Test
    public void getOneHundredOwnProducts() {
        final int MAX = 1000;
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            catalog.addProduct(referenceId, new Price(i));
        }
        Set<Product> products = catalog.getOwnProducts(10, 110);
        assertEquals(100, products.size());
    }

    @Test
    public void getOneHundredAllProducts() {
        final int MAX = 60;
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            catalog.addProduct(referenceId, new Price(2));
        }
        
        Catalog sub = new InMemoryCatalog("sub", catalog);
        catalog.addSubCatalog(sub);
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            sub.addProduct(referenceId, new Price(2));
        }
        Set<Product> products = catalog.getAllProducts(10, 110);
        assertEquals(100, products.size());
    }

}