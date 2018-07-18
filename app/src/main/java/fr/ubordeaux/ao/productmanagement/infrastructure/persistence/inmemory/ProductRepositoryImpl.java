package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.model.type.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;



public class ProductRepositoryImpl implements ProductRepository {

    private Map<ReferenceId, Product> store;

    public ProductRepositoryImpl() {
		store = new HashMap<>();
    }

	@Override
	public void addProduct(Product product) {
		ReferenceId referenceId = product.getReferenceId();
		Price price = product.getPrice();
		if (store.get(referenceId) != null) throw new ProductManagementException("Cannot add product because there is already one");
		
		store.put(referenceId, new Product(referenceId, price));
		
	}

	@Override
	public void removeProduct(Product product) {
		ReferenceId referenceId = product.getReferenceId();
		Price price = product.getPrice();
		if (store.get(referenceId) == null) throw new ProductManagementException("cannot remove, no such id in the ProductRepository");
		store.remove(referenceId);
	}

	@Override
	public Product findProductByReferenceById(ReferenceId id) {
		if (! store.containsKey(id)) throw new ProductManagementException("Unknown reference");
		return store.get(id);
	}

	@Override
	public Set<Product> getProduct(int from, int to) {
		int i = 0;
        Set<Product> result = new HashSet<Product>();
        for (Product product : store.values()) {
            if ((i >= from) && (i < to)) {
                result.add(product);
            }
            i++;
        }
        return result;
	}

	@Override
	public int size() {
		return store.size();
	}

}