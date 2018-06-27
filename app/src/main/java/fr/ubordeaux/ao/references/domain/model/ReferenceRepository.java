package fr.ubordeaux.ao.references.domain.model;

import java.util.Optional;
import java.util.Set;

public interface ReferenceRepository {
    public void addReference(ReferenceId id, String name, String description);
    public void removeRerence(ReferenceId id);
    public Optional<Reference> findReferenceById(ReferenceId id);
    public Set<Reference> findAllReferencesByName(String name);
    public int size();
}