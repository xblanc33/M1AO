package fr.ubordeaux.ao.productmanagement.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.type.CatalogName;

public class AddProductToCatalog implements Command {
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

    @Override
    public void execute() {
        Product storedProduct = CollectionManager.getInstance().getProductRepository().findProductByReferenceById(product.getReferenceId());
        storedProduct.changePrice(product.getPrice());
        Catalog catalog = CollectionManager.getInstance().getRootCatalog().getCatalogByName(catalogName);
        catalog.addProduct(product);
    }
}