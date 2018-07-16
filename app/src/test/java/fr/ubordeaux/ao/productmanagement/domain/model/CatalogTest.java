package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.InMemoryCatalog;

public class CatalogTest {
    Catalog catalog;
    InMemoryCatalog catalogImpl;

    @Before
    public void createCatalog() {
        catalogImpl = new InMemoryCatalog(new CatalogName("root"));
        catalog = catalogImpl;
    }

    @Test
    public void testAddProductInCatalog() { 
        //final int MAX = 150000000;//150 Millions
        final int MAX = 50000;
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            catalogImpl.addProduct(referenceId, new Price(2));
        }
        assertEquals(MAX, catalog.ownSize());
    }

    @Test
    public void testSubCatalog() {
        final int MAX = 50000;
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            catalogImpl.addProduct(referenceId, new Price(2));
        }
        
        InMemoryCatalog subImpl = new InMemoryCatalog(new CatalogName("sub"));
        Catalog sub = subImpl;
        catalogImpl.addSubCatalog(sub);
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            subImpl.addProduct(referenceId, new Price(2));
        }

        assertEquals(MAX, sub.allSize());
        assertEquals(2*MAX, catalog.allSize());
    }

    @Test
    public void getOneHundredOwnProducts() {
        final int MAX = 1000;
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            catalogImpl.addProduct(referenceId, new Price(i));
        }
        Set<Product> products = catalog.getOwnProducts(10, 110);
        assertEquals(100, products.size());
    }

    @Test
    public void getOneHundredAllProducts() {
        final int MAX = 60;
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            catalogImpl.addProduct(referenceId, new Price(2));
        }
        
        InMemoryCatalog subImpl = new InMemoryCatalog(new CatalogName("sub"));
        Catalog sub = subImpl;
        catalogImpl.addSubCatalog(sub);
        for (int i=0 ; i < MAX ; i++) {
            ReferenceId referenceId = new ReferenceId();
            subImpl.addProduct(referenceId, new Price(2));
        }
        Set<Product> products = catalog.getAllProducts(10, 110);
        assertEquals(100, products.size());
    }

}