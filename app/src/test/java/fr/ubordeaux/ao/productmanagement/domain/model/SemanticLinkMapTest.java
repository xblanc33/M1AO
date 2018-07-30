package fr.ubordeaux.ao.productmanagement.domain.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.SemanticLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.SemanticLinkMapImpl;


public class SemanticLinkMapTest {
    SemanticLinkMap map;

    @Before
    public void createMap() {
        map = new SemanticLinkMapImpl();
    }

    @Test
    public void putKeyWordProductLink() {
        map.addSemanticLink(new KeyWord("test"), new Reference(new ReferenceId(), "book","super book"));
        assertEquals(1, map.findReferenceByKeyWord(new KeyWord("test")).size());
    }

}