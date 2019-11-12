package fr.ubordeaux.ao.domain.model;

import java.util.Set;

import fr.ubordeaux.ao.domain.type.CatalogName;

/**
 * Repository
 */
public abstract class Catalog {
    public abstract CatalogName getName();
    public abstract Set<Catalog> getSubCatalogs();
    public abstract Catalog getSubCatalogByName(CatalogName catalogName);
    public abstract Catalog createSubCatalog(CatalogName subCatalogName);
    public abstract int size();
    public abstract Set<Reference> getReferences();
    public abstract void add(Reference reference);
}
