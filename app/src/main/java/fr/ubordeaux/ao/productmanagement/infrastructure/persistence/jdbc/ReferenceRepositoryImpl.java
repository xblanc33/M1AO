package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.jdbc;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

class ReferenceRepositoryImpl extends ConceptMapping implements ReferenceRepository {

    public ReferenceRepositoryImpl() {
        super();
    }

	@Override
	public void addReference(Reference reference) {
		
	}

	@Override
	public void removeRerence(Reference reference) {
		
	}

	@Override
	public Reference findReferenceById(ReferenceId id) {
		return null;
	}

	@Override
	public Set<Reference> findReferenceByName(String name) {
		return null;
	}

	@Override
	public Set<Reference> getReference(int from, int to) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

}