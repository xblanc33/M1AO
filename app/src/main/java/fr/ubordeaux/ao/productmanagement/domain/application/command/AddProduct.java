package fr.ubordeaux.ao.productmanagement.domain.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public class AddProduct implements Command {
    private Product product;

    public AddProduct(Product product) {
        this.setProduct(product);
    }

    private void setProduct(Product product) {
        if (product == null) throw new ProductManagementException("cannot create command with null product");
        this.product = product;
    }

    @Override
    public void execute() {
        CollectionManager collections = CollectionManager.getInstance();
        collections.getReferenceRepository().findReferenceById(product.getReferenceId());
        collections.getProductRepository().addProduct(product);
    }
}