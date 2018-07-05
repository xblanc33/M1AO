package fr.ubordeaux.ao.productmanagement.infrastructure.persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import fr.ubordeaux.ao.productmanagement.domain.model.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.ReferenceId;
import fr.ubordeaux.ao.productmanagement.domain.model.ProductManagementException;

public class InMemoryProductRepository implements ProductRepository {

    private Map<ReferenceId, Product> store;

    public InMemoryProductRepository() {
		store = new HashMap<>();
    }

	@Override
	public void addProduct(ReferenceId referenceId, Price price) {
		if (referenceId == null) throw new ProductManagementException("Cannot add product with null as Reference id");
		if (price == null) throw new ProductManagementException("Cannot add product with null as price");
		if (store.get(referenceId) != null) throw new ProductManagementException("Cannot add product because there is already one");
		
		store.put(referenceId, new Product(referenceId, price));
		
	}

	@Override
	public void removeProduct(ReferenceId referenceId) {
		if (referenceId == null) throw new ProductManagementException("cannot remove null to ProductRepository");
        if (store.get(referenceId) == null) throw new ProductManagementException("cannot remove, no such id in the ProductRepository");
		store.remove(referenceId);
	}

	@Override
	public Optional<Product> findProductByReferenceById(ReferenceId id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public int size() {
		return store.size();
	}

}