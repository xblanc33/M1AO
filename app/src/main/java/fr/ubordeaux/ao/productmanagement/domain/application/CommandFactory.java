package fr.ubordeaux.ao.productmanagement.domain.application;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.type.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.type.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

public interface CommandFactory {

    public void createReference(ReferenceId id, String name, String description);

    public void createProduct(ReferenceId id, Price price);

    public void createRootCatalog(CatalogName name);

    public void createSubCatalog(CatalogName name, CatalogName parent);

    public void addProductToCatalog(Product product, CatalogName catalogName);

    public void attachKeyWordToProduct(KeyWord keyword, Product product);

}