package fr.ubordeaux.ao.productmanagement.domain.application;

import fr.ubordeaux.ao.productmanagement.domain.model.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.ReferenceId;

public class CreateProductCommand {
    ReferenceId referenceId;
    Price price;

    public CreateProductCommand(ReferenceId referenceId, Price price) {
        this.referenceId = referenceId;
        this.price = price;
    }

    public ReferenceId getReferenceId() {
        return this.referenceId;
    }

    public Price getPrice() {
        return this.price;
    }
}