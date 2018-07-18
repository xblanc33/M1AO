package fr.ubordeaux.ao.productmanagement.domain.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord2ReferenceLink;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public class LinkKeyWordToReference implements Command {
    private KeyWord2ReferenceLink link;

    public LinkKeyWordToReference(KeyWord2ReferenceLink link) {
        this.setLink(link);
    }

    private void setLink(KeyWord2ReferenceLink link) {
        if (link == null) throw new ProductManagementException("Cannot create command with null as link");
        this.link = link;
    }

    @Override
    public void execute() {
        CollectionManager.getInstance().getReferenceRepository().findReferenceById(link.getReference().getId());
        CollectionManager.getInstance().getLinkMap().putKeyWordProductLink(link);
    }
}