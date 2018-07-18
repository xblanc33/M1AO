package fr.ubordeaux.ao.productmanagement.domain.application.command;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;

public class CreateSubCatalog implements Command {
    private CatalogName name;
    private CatalogName parentName;
    
    public CreateSubCatalog(CatalogName name, CatalogName parentName) {
        this.setCatalogName(name);
        this.setParentCatalogName(parentName);
    }

    private void setCatalogName(CatalogName name) {
        if (name == null) throw new ProductManagementException("cannot create catalog with null as name");
        this.name = name;
    }

    private void setParentCatalogName(CatalogName parentName) {
        if (parentName == null) throw new ProductManagementException("cannot create catalog with null as name");
        this.parentName = name;
    }

    @Override
    public void execute() {
        Catalog parentCatalog = CollectionManager.getInstance().getRootCatalog().getCatalogByName(parentName);
        parentCatalog.createSubCatalog(name);
    }


}