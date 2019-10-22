package fr.ubordeaux.ao.domain;

import java.util.HashMap;
import java.util.Map;

public class ReferenceFactory {
    private Map<Integer, Reference> createdReferenceMap;

    public ReferenceFactory() {
        createdReferenceMap = new HashMap<>();
    }

    public Reference createReference(int id, AlphabetWord name, String description, Price price) {
        if (createdReferenceMap.containsKey(id)) {
            throw new IllegalArgumentException();
        }
        Reference ref = new Reference(id, name, description, price);
        createdReferenceMap.put(id, ref);
        return ref;
    }
}