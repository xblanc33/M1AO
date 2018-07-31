package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWordMap;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;


public class KeyWordMapImpl implements KeyWordMap {
    Map<KeyWord, Set<Reference>> map;

    public KeyWordMapImpl() {
        map = new HashMap<>();
    }

    @Override
	public void map(KeyWord keyword, Reference reference) {
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
	public void unmap(KeyWord keyword, Reference reference) {    
        if (map.containsKey(keyword)) {
            map.get(keyword).remove(reference);
        }
    }
    
    @Override
    public Set<Reference> findReferenceByKeyWord(KeyWord keyword) {
		if (map.containsKey(keyword)) {
            Set<Reference> result = new HashSet<Reference>();
            result.addAll(map.get(keyword));
            return result;
        }
		return new HashSet<Reference>();
	}

	@Override
	public Set<KeyWord> getKeyWords() {
        Set<KeyWord> result = new HashSet<KeyWord>();
        result.addAll(map.keySet());
		return result;
	}

}