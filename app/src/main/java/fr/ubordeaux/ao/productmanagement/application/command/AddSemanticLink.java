package fr.ubordeaux.ao.productmanagement.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.SemanticLink;
import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;

public class AddSemanticLink implements Command {
    private SemanticLink link;

    public AddSemanticLink(SemanticLink link) {
        this.setSemanticLink(link);
    }

    private void setSemanticLink(SemanticLink link) {
        if (link == null) throw new ProductManagementException("Cannot create command with null as link");
        this.link = link;
    }

    @Override
    public void execute() {
        CollectionManager.getInstance().getReferenceRepository().findReferenceById(link.getReference().getId());
        CollectionManager.getInstance().getLinkMap().putKeyWordProductLink(link);
    }
}