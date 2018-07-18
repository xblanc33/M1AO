package fr.ubordeaux.ao.productmanagement.domain.model.collection;


import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWord2ReferenceLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Catalog;

public abstract class Collections {
    public abstract ProductRepository getProductRepositorySingleton();

    public abstract ReferenceRepository getReferenceRepositorySingleton();

    public abstract Catalog getRootCatalog();

    public abstract KeyWord2ReferenceLinkMap getKeyWord2ReferenceLinkMapSingleton();

}