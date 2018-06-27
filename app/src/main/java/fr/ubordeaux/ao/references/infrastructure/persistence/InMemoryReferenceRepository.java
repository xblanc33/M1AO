package fr.ubordeaux.ao.references.infrastructure.persistence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import fr.ubordeaux.ao.references.domain.model.Reference;
import fr.ubordeaux.ao.references.domain.model.ReferencesException;
import fr.ubordeaux.ao.references.domain.model.ReferenceId;
import fr.ubordeaux.ao.references.domain.model.ReferenceRepository;

public class InMemoryReferenceRepository implements ReferenceRepository {

    private HashMap<ReferenceId,Reference> store;

    public InMemoryReferenceRepository() {
        store = new HashMap<>();
    }

	@Override
	public void addReference(ReferenceId id , String name, String description) {
        if (id == null) throw new ReferencesException("cannot add null to ReferenceRepository");
        if (store.get(id) != null) throw new ReferencesException("ReferenceId already in the repository");
        store.put(id,new Reference(id, name, description));
	}

	@Override
	public void removeRerence(ReferenceId id) {
        if (id == null) throw new ReferencesException("cannot remove null to ReferenceRepository");
        if (store.get(id) == null) throw new ReferencesException("cannot remove, no such id in the ReferenceRepository");
		store.remove(id);
	}

	@Override
	public Optional<Reference> findReferenceById(ReferenceId id) {
        if (id == null) throw new ReferencesException("cannot find a null reference");
        return Optional.ofNullable(store.get(id));
	}

	@Override
	public Set<Reference> findAllReferencesByName(String name) {
        if (name == null) throw new ReferencesException("cannot find references with null as name");
        Set<Reference> foundReferences = new HashSet<Reference>();
		store.forEach((k,v) -> {
            if (v.getName().compareTo(name)==0) {
                foundReferences.add(v);
            }
        });
        return foundReferences;
	}

	@Override
	public int size() {
		return store.size();
	}

}