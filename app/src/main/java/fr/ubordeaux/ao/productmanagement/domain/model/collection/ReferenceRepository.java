package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

public interface ReferenceRepository {
    public void addReference(Reference reference);
    public void removeRerence(Reference reference);
    public Reference findReferenceById(ReferenceId id);
    public Set<Reference> findReferenceByName(String name);
    public Set<Reference> getReference(int from, int to);
    public int size();
}