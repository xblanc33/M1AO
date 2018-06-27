package fr.ubordeaux.ao.references.domain.model;

import java.util.Set;

public interface ReferenceRepository {
    public void addReference(Reference reference);
    public void removeRerence(Reference reference);
    public Reference findReferenceById(ReferenceId id);
    public Set<Reference> findAllReferencesByName(String name);
}