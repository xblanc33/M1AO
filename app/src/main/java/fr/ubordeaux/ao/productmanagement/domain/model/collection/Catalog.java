package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;

public interface Catalog {
    public CatalogName getName();
    public Set<Catalog> getSubCatalog();
    public Catalog getCatalogByName(CatalogName catalogName);
    public Catalog createSubCatalog(CatalogName subCatalogName);
    public int ownSize();
    public int allSize();
    public Set<Product> getOwnProducts();
    public Set<Product> getAllProducts();
    public void addProduct(Product product);

}