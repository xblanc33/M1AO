package fr.ubordeaux.ao.productmanagement.domain.model;

import java.util.Optional;
import java.util.Set;

public interface Catalog {
    public String getName();

    public Set<String> getSubCatalogNames();

    public Optional<Catalog> getSubCatalogByName(String name);

    public Optional<Catalog> getParentCatalog();

    public void addProduct(ReferenceId referenceId, Price price);

    public int ownSize();

    public int allSize();

    public Set<ReferenceId> getOwnReferenceIds(int from, int to);

    public Set<ReferenceId> getAllReferenceIds(int from, int to);

}