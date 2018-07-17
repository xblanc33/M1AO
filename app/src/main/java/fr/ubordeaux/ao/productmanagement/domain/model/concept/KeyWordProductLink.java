package fr.ubordeaux.ao.productmanagement.domain.model.concept;

import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public class KeyWordProductLink {
    private KeyWord keyword;
    private Product product;

    public KeyWordProductLink(KeyWord keyword, Product product) {
        this.setKeyWord(keyword);
        this.setProduct(product);
    }

    private void setKeyWord(KeyWord keyword) {
        if (keyword == null) throw new ProductManagementException("cannot create link with null keyword");
        this.keyword = keyword;
    }

    private void setProduct(Product product) {
        if (product == null) throw new ProductManagementException("cannot create link with null product");
        this.product = product;
    }

    public KeyWord getKeyWord() {
        return this.keyword;
    }

    public Product getProduct() {
        return this.product;
    }
    
}