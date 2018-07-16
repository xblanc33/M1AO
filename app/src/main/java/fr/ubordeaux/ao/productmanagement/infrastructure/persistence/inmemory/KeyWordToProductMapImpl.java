package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.KeyWordToProductMap;
import fr.ubordeaux.ao.productmanagement.domain.model.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.ProductManagementException;

public class KeyWordToProductMapImpl implements KeyWordToProductMap {
    Map<KeyWord,Set<Product>> map;

    public KeyWordToProductMapImpl() {
        map = new HashMap<>();
    }

	@Override
	public void attachKeyWordToProduct(KeyWord keyword, Product product) {
        if (keyword == null) throw new ProductManagementException("can't attach null keyword to product");
        if (product == null) throw new ProductManagementException("can't attach keyword to null");

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
	public void detachKeyWordToProduct(KeyWord keyword, Product product) {
        if (keyword == null) throw new ProductManagementException("can't detach null keyword");
        if (product == null) throw new ProductManagementException("can't detach null product");

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
	public Set<KeyWord> getKeyWords() {
		return Set.copyOf(map.keySet());
	}

}