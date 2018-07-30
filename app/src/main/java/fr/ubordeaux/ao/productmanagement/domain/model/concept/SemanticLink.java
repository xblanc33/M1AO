package fr.ubordeaux.ao.productmanagement.domain.model.concept;

import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;

public class SemanticLink {
    private KeyWord keyword;
    private Reference reference;

    public SemanticLink(KeyWord keyword, Reference reference) {
        this.setKeyWord(keyword);
        this.setReference(reference);
    }

    private void setKeyWord(KeyWord keyword) {
        if (keyword == null) throw new ProductManagementException("cannot create link with null keyword");
        this.keyword = keyword;
    }

    private void setReference(Reference reference) {
        if (reference == null) throw new ProductManagementException("cannot create link with null product");
        this.reference = reference;
    }

    public KeyWord getKeyWord() {
        return this.keyword;
    }

    public Reference getReference() {
        return this.reference;
    }
    
}