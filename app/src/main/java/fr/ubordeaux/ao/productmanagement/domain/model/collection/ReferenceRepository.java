package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

public interface ReferenceRepository {
    public void addReference(ReferenceId id, String name, String description);
    public void removeRerence(ReferenceId id);
    public Reference findReferenceById(ReferenceId id);
    public Set<Reference> findAllReferencesByName(String name);
    public int size();
}