package fr.ubordeaux.ao.productmanagement.domain.application;

import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;

public class CreateCatalogCommand {
    private CatalogName name;
    private CatalogName parentName;
    
    public CreateCatalogCommand(CatalogName name) {
        this.name = name;
        
    }

    public CreateCatalogCommand(CatalogName name, CatalogName parentName) {
        this(name);
        this.parentName = parentName;
    }

    public CatalogName getName() {
        return this.name;
    }

    public CatalogName getParentName() {
        return this.parentName;
    }
}