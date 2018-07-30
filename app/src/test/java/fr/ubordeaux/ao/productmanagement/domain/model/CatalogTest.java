package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.type.Price;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.CatalogImpl;

public class CatalogTest {
    Catalog catalog;

    @Before
    public void createCatalog() {
        catalog = new CatalogImpl(new CatalogName("root"));
    }

    @Test
    public void testAddProductInCatalog() { 
        //final int MAX = 150000000;//150 Millions
        final int MAX = 50000;
        for (int i=0 ; i < MAX ; i++) {
            catalog.addProduct(new Product(new ReferenceId(), new Price(2)));
        }
        assertEquals(MAX, catalog.ownSize());
    }

    @Test
    public void testSubCatalog() {
        final int MAX = 50000;
        for (int i=0 ; i < MAX ; i++) {
            catalog.addProduct(new Product(new ReferenceId(), new Price(2)));
        }
        
        Catalog sub = catalog.createSubCatalog(new CatalogName("sub"));
        for (int i=0 ; i < MAX ; i++) {
            sub.addProduct(new Product(new ReferenceId(), new Price(2)));
        }

        assertEquals(MAX, sub.allSize());
        assertEquals(2*MAX, catalog.allSize());
    }

    @Test
    public void getOneHundredOwnProducts() {
        final int MAX = 1000;
        for (int i=0 ; i < MAX ; i++) {
            catalog.addProduct(new Product(new ReferenceId(), new Price(i)));
        }
        Set<Product> products = catalog.getOwnProducts(10, 110);
        assertEquals(100, products.size());
    }

    @Test
    public void getOneHundredAllProducts() {
        final int MAX = 60;
        for (int i=0 ; i < MAX ; i++) {
            catalog.addProduct(new Product(new ReferenceId(), new Price(2)));
        }
        
        Catalog sub = catalog.createSubCatalog(new CatalogName("sub"));
        for (int i=0 ; i < MAX ; i++) {
            sub.addProduct(new Product(new ReferenceId(), new Price(2)));
        }
        Set<Product> products = catalog.getAllProducts(10, 110);
        assertEquals(100, products.size());
    }

    @Test
    public void findCatalogByName() {
        Catalog src = catalog.createSubCatalog(new CatalogName("src"));
        Catalog test = catalog.createSubCatalog(new CatalogName("test"));
        Catalog java = src.createSubCatalog(new CatalogName("java"));
        Catalog java_ = catalog.getCatalogByName(new CatalogName("java"));
        assertEquals(java, java_);
    }
}