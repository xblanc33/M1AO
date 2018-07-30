package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;



public class ProductRepositoryImpl implements ProductRepository {

    private Map<ReferenceId, Product> store;

    public ProductRepositoryImpl() {
		store = new HashMap<>();
    }

	@Override
	public void add(Product product) {
		if (product == null) throw new ProductManagementException("Cannot add null product");
		if (store.get(product.getReference().getId()) != null) throw new ProductManagementException("cannot add product because there is already one");
		
		store.put(product.getReference().getId(), product);
		
	}

	@Override
	public void remove(Product product) {
		ReferenceId referenceId = product.getReference().getId();
		if (store.get(referenceId) == null) throw new ProductManagementException("cannot remove, no such id in the ProductRepository");
		store.remove(referenceId);
	}

	@Override
	public Product findByReferenceById(ReferenceId id) {
		if (! store.containsKey(id)) throw new ProductManagementException("Unknown reference");
		return store.get(id);
	}

	@Override
	public Set<Product> getProduct() {
		Set<Product> result = new HashSet<Product>();
		result.addAll(this.store.values());
        return result;
	}

	@Override
	public int size() {
		return store.size();
	}

}