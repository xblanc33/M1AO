package fr.ubordeaux.ao.productmanagement.domain.application;

import fr.ubordeaux.ao.productmanagement.domain.model.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.ProductManagementException;

public class AddProductToCatalogCommand {
    private Product product;
    private CatalogName catalogName;
    

    public AddProductToCatalogCommand(Product product, CatalogName catalogName) {
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