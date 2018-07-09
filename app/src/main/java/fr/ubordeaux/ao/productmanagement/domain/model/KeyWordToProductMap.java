package fr.ubordeaux.ao.productmanagement.domain.model;

import java.util.Set;

public interface KeyWordToProductMap {

    public void attachKeyWordToProduct(KeyWord keyword, Product product);

    public void detachKeyWordToProduct(KeyWord keyword, Product product);

    public Set<Product> findProductFromKeyWord(KeyWord keyword);

    public Set<KeyWord> getKeyWords();

}