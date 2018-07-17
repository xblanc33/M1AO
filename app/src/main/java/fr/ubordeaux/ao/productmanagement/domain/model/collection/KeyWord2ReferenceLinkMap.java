package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord2ReferenceLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;


public interface KeyWord2ReferenceLinkMap {

    public void putKeyWordProductLink(KeyWord2ReferenceLink link);

    public void removeKeyWordProductLink(KeyWord2ReferenceLink link);

    public Set<Reference> findReferenceFromKeyWord(KeyWord keyword);

    public Set<KeyWord> getLinkedKeyWords();

}