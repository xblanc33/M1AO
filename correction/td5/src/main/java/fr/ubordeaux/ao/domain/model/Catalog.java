package fr.ubordeaux.ao.domain.model;

import java.util.Set;

import fr.ubordeaux.ao.domain.type.CatalogName;

public interface Catalog {
    public CatalogName getName();
    public Set<Catalog> getSubCatalogs();
    public void addSubCatalog(Catalog catalog);
    public int size();
    public Set<Reference> getOwnReferences();
    public Set<Reference> getAllReferences();
    public Reference findReferenceById(String id);
    public void add(Reference reference);
    public void remove(Reference reference);
}