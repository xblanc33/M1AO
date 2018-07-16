package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.KeyWordToProductMapImpl;

public class KeyWordToProductMapTest {
    KeyWordToProductMap map;
    KeyWordToProductMapImpl mapImpl;

    @Before
    public void createMap() {
        mapImpl = new KeyWordToProductMapImpl();
        map = mapImpl;
    }

    @Test
    public void attachKeyWord() {
        map.attachKeyWordToProduct(new KeyWord("test"), new Product(new ReferenceId(), new Price(2)));
        assertEquals(1, map.findProductFromKeyWord(new KeyWord("test")).size());
    }

}