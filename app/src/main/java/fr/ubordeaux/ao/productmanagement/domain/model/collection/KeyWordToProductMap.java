package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.type.KeyWord;

public interface KeyWordToProductMap {

    public void attachKeyWordToProduct(KeyWord keyword, Product product);

    public void detachKeyWordToProduct(KeyWord keyword, Product product);

    public Set<Product> findProductFromKeyWord(KeyWord keyword);

    public Set<KeyWord> getKeyWords();

}