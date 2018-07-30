package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.type.CatalogName;



public class CatalogImpl implements Catalog {
    private CatalogName name;
    private Map<Reference, Product> store;
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
	public Set<Product> getOwnProducts() {
        Set<Product> result = new HashSet<>();
        result.addAll(this.store.values());
		return result;
	}

	@Override
	public Set<Product> getAllProducts() {
        Set<Product> result = this.getOwnProducts();
        subCatalogs.values().forEach(subCatalog -> {
            result.addAll(subCatalog.getAllProducts());
        });
        return result;
    }

	@Override
	public Set<Catalog> getSubCatalog() {
        Set<Catalog> result = new HashSet<Catalog>();
        result.addAll(this.subCatalogs.values());
        return result;
    }

    @Override
    public Catalog getCatalogByName(CatalogName catalogName) {
        if (this.getName().equals(catalogName)) return this;

        for (Catalog sub : subCatalogs.values()) {
            try {
                Catalog catalog = sub.getCatalogByName(catalogName);
                return catalog;
            } catch (ProductManagementException ex) {

            }
        }
        throw new ProductManagementException("can't find catalog with such a name");
    }
    
    @Override
    public Catalog createSubCatalog(CatalogName subName) {
        for (Catalog subCatalog : this.getSubCatalog()) {
            if (subCatalog.getName().equals(subName)) throw new ProductManagementException("cannot add sub catalog with same name");
        }
        Catalog subCatalog = new CatalogImpl(subName);
        this.subCatalogs.put(subName, subCatalog);
        return subCatalog;
    }
    
    @Override
	public void addProduct(Product product) {
        if (product == null) throw new ProductManagementException("cannot add null product to catalog");
        store.put(product.getReference(), product);
	}

}