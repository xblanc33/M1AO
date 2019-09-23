package fr.ubordeaux.ao;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.type.Price;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;

public class AcceptationTest {
    private Catalog rootCatalog;

    @Before
    public void createCatalog() {
        rootCatalog = new CatalogImpl("root");
    }

    @Test
    public void testAddReferenceAndFindIt() { 
        Reference reference = new Reference("#1", "test", "test", new Price(2000));
        rootCatalog.add(reference);
        Reference foundReference = rootCatalog.findReferenceById("#1");
        assertEquals(reference.getBasePrice(), foundReference.getBasePrice());
    }

    
}