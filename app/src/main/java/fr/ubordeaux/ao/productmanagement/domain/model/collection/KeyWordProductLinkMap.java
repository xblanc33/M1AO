package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWordProductLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;


public interface KeyWordProductLinkMap {

    public void putKeyWordProductLink(KeyWordProductLink link);

    public void removeKeyWordProductLink(KeyWordProductLink link);

    public Set<Product> findProductFromKeyWord(KeyWord keyword);

    public Set<KeyWord> getLinkedKeyWords();

}