package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.SemanticLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;


public interface SemanticLinkMap {
    public void putKeyWordProductLink(SemanticLink link);
    public void removeKeyWordProductLink(SemanticLink link);
    public Set<Reference> findReferenceFromKeyWord(KeyWord keyword);
    public Set<KeyWord> getLinkedKeyWords();
}