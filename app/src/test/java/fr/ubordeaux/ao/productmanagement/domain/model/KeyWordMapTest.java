package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWordMap;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.KeyWordMapImpl;



public class KeyWordMapTest {
    KeyWordMap map;

    @Before
    public void createMap() {
        map = new KeyWordMapImpl();
    }

    @Test
    public void putKeyWordProductLink() {
        map.map(new KeyWord("test"), new Reference(new ReferenceId(), "book","super book"));
        assertEquals(1, map.findReferenceByKeyWord(new KeyWord("test")).size());
    }

}