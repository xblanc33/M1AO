package fr.ubordeaux.ao.productmanagement.domain.model.concept;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;

public interface Catalog {
    public CatalogName getName();

    public Set<Catalog> getSubCatalogs();

    public void addSubCatalog(Catalog subCatalog);

    public int ownSize();

    public int allSize();

    public Set<Product> getOwnProducts(int from, int to);

    public Set<Product> getAllProducts(int from, int to);

    public void addProduct(Product product);

}