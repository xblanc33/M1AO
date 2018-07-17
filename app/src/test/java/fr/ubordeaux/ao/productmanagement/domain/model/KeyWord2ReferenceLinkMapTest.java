package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWord2ReferenceLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord2ReferenceLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.type.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.KeyWord2ReferenceLinkMapImpl;


public class KeyWord2ReferenceLinkMapTest {
    KeyWord2ReferenceLinkMap map;

    @Before
    public void createMap() {
        map = new KeyWord2ReferenceLinkMapImpl();
    }

    @Test
    public void putKeyWordProductLink() {
        KeyWord2ReferenceLink link = new KeyWord2ReferenceLink(new KeyWord("test"), new Reference(new ReferenceId(), "book","super book"));
        map.putKeyWordProductLink(link); 
        assertEquals(1, map.findReferenceFromKeyWord(new KeyWord("test")).size());
    }

}