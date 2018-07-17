package fr.ubordeaux.ao.productmanagement.domain.model.service;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Catalog;

public abstract class Factory {
    public abstract ProductRepository getProductRepository();

    public abstract ReferenceRepository getReferenceRepository();

    public abstract Catalog getRootCatalog();

}