package fr.ubordeaux.ao.productmanagement.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;

public class AddSemanticLink implements Command {
    private KeyWord keyword;
    private Reference reference;

    public AddSemanticLink(KeyWord keyword, Reference reference) {
        this.setKeyWord(keyword);
        this.setReference(reference);
    }

    private void setKeyWord(KeyWord keyword) {
        if (keyword == null) throw new ProductManagementException("Cannot create command with null as keyword");
        this.keyword = keyword;
    }

    private void setReference(Reference reference) {
        if (reference == null) throw new ProductManagementException("Cannot create command with null as reference");
        this.reference = reference;
    }

    @Override
    public void execute() {
        Reference foundReference = CollectionManager.getInstance().getReferenceRepository().findById(reference.getId());
        if (foundReference == null) throw new ProductManagementException("Cannot link reference, it does not exist in ReferenceRepository");
        
        CollectionManager.getInstance().getLinkMap().addSemanticLink(keyword, reference);
    }
}