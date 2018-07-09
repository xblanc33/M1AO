package fr.ubordeaux.ao.productmanagement.infrastructure.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.application.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.model.ReferenceId;

public class InMemoryCatalog implements Catalog {
    private CatalogName name;
    private Map<ReferenceId, Product> store;
    private Map<String, Catalog> subCatalogs;
    private Catalog parentCatalog = null;
    

    public InMemoryCatalog(String name) {
        store = new HashMap<>();
        this.setName(name);
        store = new HashMap<>();
        subCatalogs = new HashMap<>();
    }

    public InMemoryCatalog(CatalogName name, Catalog parent) {
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
    public void addSubCatalog(Catalog sub) {
        if (this.getSubCatalogNames().contains(sub.getName())) throw new ProductManagementException("cannot add subcatalog as name already exists");
        subCatalogs.put(sub.getName(), sub);
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
        Collection<Catalog> subCatalogs = this.subCatalogs.values();
        for (Catalog catalog : subCatalogs) {
            size = size + catalog.allSize();
        }
        return size;
	}

	@Override
	public Set<Product> getOwnProducts(int from, int to) {
        Set<Product> result = new HashSet<>();
        Iterator<Product> productIterator = store.values().iterator();
        int index = 0;
        while ((index < to) && productIterator.hasNext()) {
            Product product = productIterator.next();
            if (index >= from) {
                result.add(product);
            }
            index++;
        }
		return result;
	}

	@Override
	public Set<Product> getAllProducts(int from, int to) {
        Set<Product> result = this.getOwnProducts(from, to);
        subCatalogs.values().forEach(subCatalog -> {
            result.addAll(subCatalog.getAllProducts(from, to));
        });
        return result;
    }

	@Override
	public CatalogName getName() {
		return null;
	}

	@Override
	public Set<Catalog> getSubCatalogs() {
		return null;
	}

	@Override
	public Catalog getParentCatalog() {
		return null;
	}
}