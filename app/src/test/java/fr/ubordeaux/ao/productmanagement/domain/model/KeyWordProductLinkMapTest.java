package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWordProductLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWordProductLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.type.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.KeyWordProductLinkMapImpl;


public class KeyWordProductLinkMapTest {
    KeyWordProductLinkMap map;

    @Before
    public void createMap() {
        map = new KeyWordProductLinkMapImpl();
    }

    @Test
    public void attachKeyWord() {
        KeyWordProductLink link = new KeyWordProductLink(new KeyWord("test"), new Product(new ReferenceId(), new Price(2)));
        map.putKeyWordProductLink(link); 
        assertEquals(1, map.findProductFromKeyWord(new KeyWord("test")).size());
    }

}