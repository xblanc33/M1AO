package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;


public interface SemanticLinkMap {
    public void addSemanticLink(KeyWord keyword, Reference reference);
    public void removeSemanticLink(KeyWord keyword, Reference reference);
    public Set<Reference> findReferenceByKeyWord(KeyWord keyword);
    public Set<KeyWord> getKeyWords();
}