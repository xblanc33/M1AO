package fr.ubordeaux.ao.referencemanagement.application.command;

import fr.ubordeaux.ao.referencemanagement.domain.model.CollectionManager;
import fr.ubordeaux.ao.referencemanagement.domain.model.Reference;
import fr.ubordeaux.ao.referencemanagement.domain.exception.ReferenceManagementException;

public class AddReference implements Command {
    private Reference reference;

    public AddReference(Reference reference) {
        this.setReference(reference);
    }

    private void setReference(Reference reference) {
        if (reference == null) throw new ReferenceManagementException("cannot create command with null reference");
        this.reference = reference;
    }

    public void execute() {
        CollectionManager.getInstance().getRootCatalog().add(reference);
    }

}