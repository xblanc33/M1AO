package fr.ubordeaux.ao.productmanagement.domain.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public class AddProduct {
    private Product product;

    public AddProduct(Product product) {
        this.setProduct(product);
    }

    private void setProduct(Product product) {
        if (product == null) throw new ProductManagementException("cannot create command with null product");
        this.product = product;
    }

    public void execute(ProductRepository productRepository) {
        //TODO check that the ReferenceId exists
        productRepository.addProduct(product);
    }
}