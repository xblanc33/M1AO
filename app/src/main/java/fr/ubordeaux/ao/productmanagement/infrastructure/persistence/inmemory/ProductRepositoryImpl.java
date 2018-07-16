package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.Map;

import fr.ubordeaux.ao.productmanagement.domain.model.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.ReferenceId;
import fr.ubordeaux.ao.productmanagement.domain.model.ProductManagementException;

public class ProductRepositoryImpl implements ProductRepository {

    private Map<ReferenceId, Product> store;

    public ProductRepositoryImpl() {
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
	public Product findProductByReferenceById(ReferenceId id) {
		if (! store.containsKey(id)) throw new ProductManagementException("Unknown reference");
		return store.get(id);
	}

	@Override
	public int size() {
		return store.size();
	}

}