package fr.ubordeaux.ao.domain;

public class CommandLineDTO {
    private Reference reference;//id in basket
    private int quantity;

    public CommandLineDTO(Reference reference, int quantity) {
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
}