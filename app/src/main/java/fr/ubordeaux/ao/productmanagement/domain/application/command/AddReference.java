package fr.ubordeaux.ao.productmanagement.domain.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public class AddReference {
    private Reference reference;

    public AddReference(Reference reference) {
        this.setReference(reference);
    }

    private void setReference(Reference reference) {
        if (reference == null) throw new ProductManagementException("cannot create command with null reference");
        this.reference = reference;
    }

    public void execute(ReferenceRepository referenceRepository) {
        referenceRepository.addReference(reference);
    }

}