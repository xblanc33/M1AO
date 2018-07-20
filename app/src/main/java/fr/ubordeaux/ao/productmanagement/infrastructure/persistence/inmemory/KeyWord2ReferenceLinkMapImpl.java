package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWord2ReferenceLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord2ReferenceLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;


public class KeyWord2ReferenceLinkMapImpl implements KeyWord2ReferenceLinkMap {
    Map<KeyWord, Set<Reference>> map;

    public KeyWord2ReferenceLinkMapImpl() {
        map = new HashMap<>();
    }

    @Override
	public void putKeyWordProductLink(KeyWord2ReferenceLink link) {
        KeyWord keyword = link.getKeyWord();
        Reference reference = link.getReference();
        if (map.containsKey(keyword)) {
            map.get(keyword).add(reference);
        }
        
        if ( ! map.containsKey(keyword)) {
            Set<Reference> references = new HashSet<Reference>();
            references.add(reference);
            map.put(keyword, references);
        }
	}

	@Override
	public void removeKeyWordProductLink(KeyWord2ReferenceLink link) {
        KeyWord keyword = link.getKeyWord();
        Reference reference = link.getReference();
		if (map.containsKey(keyword)) {
            map.get(keyword).remove(reference);
        }
	}

	@Override
	public Set<Reference> findReferenceFromKeyWord(KeyWord keyword) {
		if (map.containsKey(keyword)) {
            Set<Reference> result = new HashSet<Reference>();
            result.addAll(map.get(keyword));
            return result;
        }
		return new HashSet<Reference>();
	}

	@Override
	public Set<KeyWord> getLinkedKeyWords() {
        Set<KeyWord> result = new HashSet<KeyWord>();
        result.addAll(map.keySet());
		return result;
	}	

}