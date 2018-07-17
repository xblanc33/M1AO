package fr.ubordeaux.ao.productmanagement.domain.application;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;


public class AttachKeyWordToProductCommand {
    KeyWord keyword;
    Product product;

    public AttachKeyWordToProductCommand(KeyWord keyword, Product product) {
        this.keyword = keyword;
        this.product = product;
    }

    public KeyWord getKeyWord() {
        return this.keyword;
    }

    public Product getProduct() {
        return this.product;
    }
}