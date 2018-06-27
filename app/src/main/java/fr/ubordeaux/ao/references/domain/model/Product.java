package fr.ubordeaux.ao.references.domain.model;

public class Product {
    private Price price;
    private ReferenceId referenceId;

    public Product(ReferenceId referenceId, Price price) {
        this.setReferenceId(referenceId);
        this.setPrice(price);
    }

    private void setReferenceId(ReferenceId referenceId) {
        this.referenceId = referenceId;
    }

    private void setPrice(Price price) {
        this.price = price;
    }

    public void changePrice(Price newPrice) {
        this.setPrice(newPrice);
    }

    public ReferenceId getReferenceId() {
        return this.referenceId;
    }

    public Price getPrice() {
        return this.price;
    }
}