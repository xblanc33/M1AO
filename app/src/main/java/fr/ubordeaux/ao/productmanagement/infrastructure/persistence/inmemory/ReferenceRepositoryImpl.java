package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;

public class ReferenceRepositoryImpl implements ReferenceRepository {

    private HashMap<ReferenceId,Reference> store;

    public ReferenceRepositoryImpl() {
        store = new HashMap<>();
    }

	@Override
	public void addReference(Reference reference) {
        if (reference == null) throw new ProductManagementException("cannot add null to ReferenceRepository");
        if (store.get(reference.getId()) != null) throw new ProductManagementException("ReferenceId already in the repository");
        store.put(reference.getId(), reference);
	}

	@Override
	public void removeRerence(Reference reference) {
        ReferenceId id = reference.getId();
        if (store.get(id) == null) throw new ProductManagementException("cannot remove, no such id in the ReferenceRepository");
		store.remove(id);
	}

	@Override
	public Reference findReferenceById(ReferenceId id) {
        if (id == null) throw new ProductManagementException("cannot find a null reference");
        if (! store.containsKey(id)) throw new ProductManagementException("Unknown reference");
        return store.get(id);
	}

	@Override
	public Set<Reference> findReferenceByName(String name) {
        if (name == null) throw new ProductManagementException("cannot find references with null as name");
        Set<Reference> foundReferences = new HashSet<Reference>();
		store.forEach((k,v) -> {
            if (v.getName().compareTo(name)==0) {
                foundReferences.add(v);
            }
        });
        return foundReferences;
    }
    
    @Override
    public Set<Reference> getReference(int from, int to) {
        int i = 0;
        Set<Reference> result = new HashSet<Reference>();
        for (Reference reference : store.values()) {
            if ((i >= from) && (i < to)) {
                result.add(reference);
            }
            i++;
        }
        return result;
    }

	@Override
	public int size() {
		return store.size();
	}

}