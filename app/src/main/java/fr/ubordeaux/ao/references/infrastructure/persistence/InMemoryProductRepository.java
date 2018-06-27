package fr.ubordeaux.ao.references.infrastructure.persistence;

import java.util.HashMap;

import fr.ubordeaux.ao.references.domain.model.Product;
import fr.ubordeaux.ao.references.domain.model.ProductRepository;
import fr.ubordeaux.ao.references.domain.model.ReferenceId;
import fr.ubordeaux.ao.references.domain.model.ReferencesException;

public class InMemoryProductRepository implements ProductRepository {

    private HashMap<ReferenceId, Product> store;

    public InMemoryProductRepository() {

    }

	@Override
	public void addProduct(ReferenceId referenceId, double price) {
        if (referenceId == null) throw new ReferencesException("Cannot add product with null as Reference id");
        
		
	}

	@Override
	public void removeProduct(ReferenceId referenceId) {
		
	}

	@Override
	public Product findProductByReferenceById(ReferenceId id) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

}