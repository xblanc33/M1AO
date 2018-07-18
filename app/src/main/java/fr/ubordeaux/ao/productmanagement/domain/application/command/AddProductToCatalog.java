package fr.ubordeaux.ao.productmanagement.domain.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;

public class AddProductToCatalog {
    private Product product;
    private CatalogName catalogName;
    

    public AddProductToCatalog(Product product, CatalogName catalogName) {
        if (catalogName == null) throw new ProductManagementException("Name of Catalog (AddProductToCatalog) cannot be null");
        if (product == null) throw new ProductManagementException("Product (AddProductToCatalog) cannot be null");
        this.product = product;
        this.catalogName = catalogName;
    }

    public Product  getProduct() {
        return this.product;
    }
    
    public CatalogName getCatalogName() {
        return this.catalogName;
    }
}