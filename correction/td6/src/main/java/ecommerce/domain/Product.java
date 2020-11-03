package ecommerce.domain;

import java.util.Objects;

public class Product {
    private int referenceNumber;
    private String name;
    private int price;

    public Product(int referenceNumber, String name, int price) {
        this.referenceNumber = referenceNumber;
        this.name = name;
        this.price = price;
    }

    public int getReferenceNumber() {
        return this.referenceNumber;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Product)) return false;
        Product otherProduct = (Product) other;
        boolean sameReferenceNumber = this.referenceNumber == otherProduct.getReferenceNumber();
        boolean sameName = this.name == otherProduct.getName();
        boolean samePrice = this.price == otherProduct.getPrice();
        return  sameReferenceNumber && sameName && samePrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(referenceNumber, name, price);
    }
}