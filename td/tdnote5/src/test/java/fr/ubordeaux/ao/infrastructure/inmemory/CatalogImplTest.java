package fr.ubordeaux.ao.infrastructure.inmemory;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.type.Price;

public class CatalogImplTest {

    @Test
    public void shouldPreserveIntegrity() {
        Catalog cat = new CatalogImpl(
            new CatalogName("catalog")
        );

        Reference ref = new Reference("id1", "chair", "Expensive wooden chair", new Price(1000));

        cat.add(ref);

        cat.getReferences().clear();

        assertEquals(1,cat.getReferences().size());
        assertTrue(cat.getReferences().contains(ref));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldNotHaveSubCatalogsWithSameName() {
        Catalog cat = new CatalogImpl(
            new CatalogName("catalog")
        );

        cat.createSubCatalog(
            new CatalogName("subcatalog")
        );
        cat.createSubCatalog(
            new CatalogName("subcatalog")
        );
    }

}
