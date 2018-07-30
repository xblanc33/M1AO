package fr.ubordeaux.ao.productmanagement.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;

public class AddReference implements Command {
    private Reference reference;

    public AddReference(Reference reference) {
        this.setReference(reference);
    }

    private void setReference(Reference reference) {
        if (reference == null) throw new ProductManagementException("cannot create command with null reference");
        this.reference = reference;
    }

    public void execute() {
        CollectionManager.getInstance().getReferenceRepository().add(reference);
    }

}