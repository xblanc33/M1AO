package fr.ubordeaux.ao.domain;

public class CommandLine {
    private Reference reference;
    private int quantity;

    public CommandLine(Reference reference, int quantity) {
        if (reference == null) {
            throw new IllegalArgumentException();
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException();
        }
        this.reference = reference;
        this.quantity = quantity;
    }

    public Reference getReference() {
        return this.reference;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Price price() {
        return new Price(this.quantity * reference.getPrice().getValue());
    }

    public void changeQuantity(int newQuantity) {
        if (newQuantity <= 0) {
            throw new IllegalArgumentException();
        }
        this.quantity = newQuantity;
    }

    
}