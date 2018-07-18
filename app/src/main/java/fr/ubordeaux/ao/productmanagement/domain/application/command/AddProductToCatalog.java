package fr.ubordeaux.ao.productmanagement.domain.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;

public class AddProductToCatalog {
    private Product product;
    private CatalogName catalogName;

    public AddProductToCatalog(Product product, CatalogName catalogName) {
        this.setProduct(product);
        this.setCatalogName(catalogName);
    }

    private void setProduct(Product product) {
        if (product == null) throw new ProductManagementException("Product (AddProductToCatalog) cannot be null");
        this.product = product;
    }

    private void setCatalogName(CatalogName catalogName) {
        if (catalogName == null) throw new ProductManagementException("Name of Catalog (AddProductToCatalog) cannot be null");
        this.catalogName = catalogName;
    }

    public void execute(Catalog rootCatalog) {
        //TODO Check that the product is in the product repository
        Catalog catalog = rootCatalog.getCatalogByName(catalogName);
        catalog.addProduct(product);
    }
}