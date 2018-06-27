package fr.ubordeaux.ao.productmanagement.domain.model;

import java.util.Optional;
import java.util.Set;

public interface Catalog {
    public String getName();

    public Set<Catalog> getSubCatalog();

    public Optional<Catalog> getParentCatalog();

    public int size();

    public Set<ReferenceId> getOwnReferenceIds(int from, int to);

    public Set<ReferenceId> getAllReferenceIds(int from, int to);

}