package ecommerce.domain;

import java.util.Objects;

public class CommandLine {
    private int id;
    private Product product;
    private int quantity;

    public CommandLine(int id, Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("cannot create command line with 0 or negative quantity");
        }
        if (product == null) {
            throw new IllegalArgumentException("cannot create command line with null product");
        }

        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return this.id;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void changeQuantity(int newQuantity) {
        if (newQuantity <= 0) {
            throw new IllegalArgumentException("cannot changeQuantity with 0 or negative quantity");
        }
        this.quantity = newQuantity;
    }

    public void addQuantity(int quantityToAdd) {
        if (quantityToAdd <= 0) {
            throw new IllegalArgumentException("cannot addQuantity with 0 or less quantity");
        }
        this.quantity = this.quantity + quantityToAdd;
    }

    public void removeQuantity(int quantityToRemove) {
        if (quantityToRemove <= 0) {
            throw new IllegalArgumentException("cannot removeQuantity with 0 or less quantity");
        }
        this.quantity = this.quantity - quantityToRemove;
    }

    public int getPrice() {
        return this.quantity * this.product.getPrice();
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof CommandLine)) return false;
        CommandLine otherCommandLine = (CommandLine) other;
        return  this.id == otherCommandLine.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}