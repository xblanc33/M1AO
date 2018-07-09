package fr.ubordeaux.ao.productmanagement.domain.application;

import fr.ubordeaux.ao.productmanagement.domain.model.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.ReferenceId;

public interface CommandFactory {

    public void createReference(ReferenceId id, String name, String description);

    public void createProduct(ReferenceId id, Price price);

    public void createRootCatalog(CatalogName name);

    public void createSubCatalog(CatalogName name, CatalogName parent);

    public void addProductToCatalog(Product product, CatalogName catalogName);

    public void attachKeyWordToProduct(KeyWord keyword, Product product);

}