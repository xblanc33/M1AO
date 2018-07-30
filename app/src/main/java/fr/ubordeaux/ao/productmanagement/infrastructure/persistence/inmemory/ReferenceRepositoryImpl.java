package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;

public class ReferenceRepositoryImpl implements ReferenceRepository {

    private Map<ReferenceId,Reference> store;

    public ReferenceRepositoryImpl() {
        store = new HashMap<>();
    }

	@Override
	public void add(Reference reference) {
        if (reference == null) throw new ProductManagementException("cannot add null to ReferenceRepository");
        if (store.get(reference.getId()) != null) throw new ProductManagementException("ReferenceId already in the repository");
        store.put(reference.getId(), reference);
	}

	@Override
	public void remove(Reference reference) {
        ReferenceId id = reference.getId();
        if (store.get(id) == null) throw new ProductManagementException("cannot remove, no such id in the ReferenceRepository");
		store.remove(id);
	}

	@Override
	public Reference findById(ReferenceId id) {
        if (id == null) throw new ProductManagementException("cannot find a null reference");
        if (! store.containsKey(id)) throw new ProductManagementException("Unknown reference");
        return store.get(id);
	}

	@Override
	public Set<Reference> findByName(String name) {
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
    public Set<Reference> getReference() {
        Set<Reference> result = new HashSet<Reference>();
        result.addAll(this.store.values());
        return result;
    }

	@Override
	public int size() {
		return store.size();
	}

}