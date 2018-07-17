package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;



public class CatalogImpl implements Catalog {
    private CatalogName name;
    private Map<ReferenceId, Product> store;
    private Map<CatalogName, Catalog> subCatalogs;    

    public CatalogImpl(CatalogName name) {
        this.setName(name);
        store = new HashMap<>();
        subCatalogs = new HashMap<>();
    }

    @Override
	public CatalogName getName() {
		return this.name;
    }
    
    private void setName(CatalogName name) {
        this.name = name;
    }

    @Override
	public int ownSize() {
		return store.size();
    }
    
    @Override
	public int allSize() {
        int size = this.ownSize();
        for (Catalog catalog : this.subCatalogs.values()) {
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
	public Set<Catalog> getSubCatalogs() {
        return Set.copyOf(this.subCatalogs.values());
    }
    
    @Override
    public void addSubCatalog(Catalog sub) {
        for (Catalog subCatalog : this.getSubCatalogs()) {
            if (subCatalog.getName().equals(sub.getName())) throw new ProductManagementException("cannot add sub catalog with same name");
        }
        this.subCatalogs.put(sub.getName(), sub);
    }
    
    @Override
	public void addProduct(Product product) {
        if (product == null) throw new ProductManagementException("cannot add null product to catalog");
        
        store.put(product.getReferenceId(), product);
	}

}