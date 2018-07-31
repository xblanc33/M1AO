package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;


public interface KeyWordMap {
    public void map(KeyWord keyword, Reference reference);
    public void unmap(KeyWord keyword, Reference reference);
    public Set<Reference> findReferenceByKeyWord(KeyWord keyword);
    public Set<KeyWord> getKeyWords();
}