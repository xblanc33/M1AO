package fr.ubordeaux.ao.references.domain.model;

import java.util.Set;

public interface ReferenceRepository {
    public Reference referenceOfId(ReferenceId id);

    public ReferenceId nextIdentity();
    
}