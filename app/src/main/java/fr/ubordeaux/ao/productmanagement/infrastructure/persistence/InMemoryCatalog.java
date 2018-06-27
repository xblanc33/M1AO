package fr.ubordeaux.ao.productmanagement.infrastructure.persistence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.model.ReferenceId;

public class InMemoryCatalog implements Catalog {
    private String name;
    private HashMap<ReferenceId, Product> store;
    private HashMap<String, Catalog> subCatalogs;
    private Catalog parentCatalog = null;
    

    public InMemoryCatalog(String name) {
        store = new HashMap<>();
        this.setName(name);
        store = new HashMap<>();
        subCatalogs = new HashMap<>();
    }

    public InMemoryCatalog(String name, Catalog parent) {
        this(name);
        this.setParentCatalog(parent);
    }

    private void setName(String name) {
        if (this.parentCatalog != null) {
            Set<String> sibblingCatalogs = this.parentCatalog.getSubCatalogNames();
            sibblingCatalogs.forEach( sibblingName -> {
                if (sibblingName.compareTo(name)==0) throw new ProductManagementException("category name already exists");
            } );
        }
        this.name = name;
    }

    private void setParentCatalog(Catalog catalog) {
        this.parentCatalog = catalog;
    }

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Set<String> getSubCatalogNames() {
		return subCatalogs.keySet();
    }
    
    @Override
    public Optional<Catalog> getSubCatalogByName(String name) {
	    return Optional.ofNullable(subCatalogs.get(name));
    }

	@Override
	public Optional<Catalog> getParentCatalog() {
		return Optional.ofNullable(this.parentCatalog);
	}

	@Override
	public void addProduct(ReferenceId referenceId, Price price) {
        if (referenceId == null) throw new ProductManagementException("cannot add product to category when id is null");
        if (price == null) throw new ProductManagementException("cannot add product to category when price is null");
        if (store.get(referenceId) != null) throw new ProductManagementException("cannot add product to category when id already exists");

        store.put(referenceId, new Product(referenceId, price));
	}

	@Override
	public int ownSize() {
		return store.size();
    }
    
    @Override
	public int allSize() {
        int size = this.ownSize();
		subCatalogs.values().forEach(catalog -> {
            size += catalog.allSize();
        });;
        return size;
	}

	@Override
	public Set<ReferenceId> getOwnReferenceIds(int from, int to) {
        Set<ReferenceId> result = new HashSet<>();
        Iterator<Product> referenceIdIterator = store.values().iterator();
        int index = 0;
        while ((index < to) && referenceIdIterator.hasNext()) {
            ReferenceId referenceId = referenceIdIterator.next().getReferenceId();
            if (index >= from) {
                result.add(referenceId);
            }
            index++;
        }
		return result;
	}

	@Override
	public Set<ReferenceId> getAllReferenceIds(int from, int to) {
        Set<ReferenceId> result = this.getOwnReferenceIds(from, to);
        subCatalogs.values().forEach(catalog -> {
            result.addAll(catalog.getAllReferenceIds(from, to));
        });
        return result;
    }
}