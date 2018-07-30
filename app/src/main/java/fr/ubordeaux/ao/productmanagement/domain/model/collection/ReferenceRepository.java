package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;

public interface ReferenceRepository {
    public void add(Reference reference);
    public void remove(Reference reference);
    public Reference findById(ReferenceId id);
    public Set<Reference> findByName(String name);
    public Set<Reference> getReference();
    public int size();
}