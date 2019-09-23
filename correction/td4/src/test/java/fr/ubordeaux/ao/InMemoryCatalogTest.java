package fr.ubordeaux.ao.referencemanagement.domain.model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.type.Price;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;

public class InMemoryCatalogTest {
    private Catalog rootCatalog;
    private Catalog subCatalog;

    @Before
    public void createCatalog() {
        rootCatalog = new CatalogImpl("root");
        subCatalog = new CatalogImpl("sub");
        rootCatalog.addSubCatalog(subCatalog);
    }

    @Test
    public void testAddReferenceInCatalog() { 
        //final int MAX = 150000000;//150 Millions
        final int MAX = 50000;
        for (int i=0 ; i < MAX ; i++) {
            Reference reference = new Reference("#"+i, "test", "test", new Price(2000));
            rootCatalog.add(reference);
        }
        assertEquals(MAX, rootCatalog.size());
    }

    @Test
    public void testSubCatalog() {
        final int MAX = 50000;
        for (int i=0 ; i < MAX ; i++) {
            Reference reference = new Reference("#"+i, "test", "test", new Price(2000));
            rootCatalog.add(reference);
        }
        
        for (int i=0 ; i < MAX ; i++) {
            Reference reference = new Reference("#"+i, "test", "test", new Price(2000));
            subCatalog.add(reference);
        }

        assertEquals(MAX, subCatalog.getAllReferences().size());
        //assertEquals(2*MAX, rootCatalog.getAllReferences().size());
        assertEquals(MAX, rootCatalog.getOwnReferences().size());
    }

}