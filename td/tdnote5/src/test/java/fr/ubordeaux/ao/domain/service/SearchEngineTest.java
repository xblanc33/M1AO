package fr.ubordeaux.ao.domain.service;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.infrastructure.inmemory.CatalogImpl;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.Price;
import fr.ubordeaux.ao.domain.service.SearchEngine;

public class SearchEngineTest {

    @Test
    public void shouldFindReference() {
        Catalog cat = new CatalogImpl(
            new CatalogName("abc")
        );

        Reference ref = new Reference("id1", "chair", "Yet another chair", new Price(10));

        cat.add(ref);

        SearchEngine se = new SearchEngine(cat);

        assertEquals("chair", se.searchReferenceById("id1").getName());
        assertEquals(null, se.searchReferenceById("id2"));
    }
}
