package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.SemanticLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.SemanticLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;


public class SemanticLinkMapImpl implements SemanticLinkMap {
    Map<KeyWord, Set<Reference>> map;

    public SemanticLinkMapImpl() {
        map = new HashMap<>();
    }

    @Override
	public void putKeyWordProductLink(SemanticLink link) {
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
	public void removeKeyWordProductLink(SemanticLink link) {
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