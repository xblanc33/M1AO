package fr.ubordeaux.ao.productmanagement.domain.model;

import java.util.Set;

public interface ReferenceRepository {
    public void addReference(ReferenceId id, String name, String description);
    public void removeRerence(ReferenceId id);
    public Reference findReferenceById(ReferenceId id);
    public Set<Reference> findAllReferencesByName(String name);
    public int size();
}