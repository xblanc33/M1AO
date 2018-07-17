package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWordProductLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWordProductLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;




public class KeyWordProductLinkMapImpl implements KeyWordProductLinkMap {
    Map<KeyWord,Set<Product>> map;

    public KeyWordProductLinkMapImpl() {
        map = new HashMap<>();
    }

    @Override
	public void putKeyWordProductLink(KeyWordProductLink link) {
        KeyWord keyword = link.getKeyWord();
        Product product = link.getProduct();
        if (map.containsKey(keyword)) {
            map.get(keyword).add(product);
        }
        
        if ( ! map.containsKey(keyword)) {
            Set<Product> products = new HashSet<Product>();
            products.add(product);
            map.put(keyword, products);
        }
	}

	@Override
	public void removeKeyWordProductLink(KeyWordProductLink link) {
        KeyWord keyword = link.getKeyWord();
        Product product = link.getProduct();
		if (map.containsKey(keyword)) {
            map.get(keyword).remove(product);
        }
	}

	@Override
	public Set<Product> findProductFromKeyWord(KeyWord keyword) {
		if (map.containsKey(keyword)) {
            return Set.copyOf(map.get(keyword));
        }
		return new HashSet<Product>();
	}

	@Override
	public Set<KeyWord> getLinkedKeyWords() {
		return Set.copyOf(map.keySet());
	}	

}