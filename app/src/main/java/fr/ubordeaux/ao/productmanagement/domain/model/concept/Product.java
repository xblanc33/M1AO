package fr.ubordeaux.ao.productmanagement.domain.model.concept;

import fr.ubordeaux.ao.productmanagement.domain.type.Price;

public class Product {
    private Price price;
    private Reference reference;

    public Product(Reference reference, Price price) {
        this.setReference(reference);
        this.setPrice(price);
    }

    private void setReference(Reference reference) {
        this.reference = reference;
    }

    private void setPrice(Price price) {
        this.price = price;
    }

    public void changePrice(Price newPrice) {
        this.setPrice(newPrice);
    }

    public Reference getReference() {
        return this.reference;
    }

    public Price getPrice() {
        return this.price;
    }
}