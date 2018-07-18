package fr.ubordeaux.ao.productmanagement.domain.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWord2ReferenceLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord2ReferenceLink;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public class LinkKeyWordToReference {
    private KeyWord2ReferenceLink link;

    public LinkKeyWordToReference(KeyWord2ReferenceLink link) {
        this.setLink(link);
    }

    private void setLink(KeyWord2ReferenceLink link) {
        if (link == null) throw new ProductManagementException("Cannot create command with null as link");
        this.link = link;
    }

    public void execute(KeyWord2ReferenceLinkMap map) {
        //TODO Check that the reference exists in the ReferenceRepository
        map.putKeyWordProductLink(link);
    }
}