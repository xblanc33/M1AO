package fr.ubordeaux.ao.domain.service;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;

/**
 * Service
 *
 */
public class SearchEngine {

    private Catalog rootCatalog;

    public SearchEngine(Catalog rootCatalog) {
        this.setRootCatalog(rootCatalog);
    }

    public Reference searchReferenceById(String id) {
        return null;
    }

    public Set<Reference> searchReferencesByName(String name) {
        Set<Reference> foundReferences = new HashSet<Reference>();
        for (Reference reference : rootCatalog.getReferences()) {
            if (reference.getName().compareTo(name)==0) {
                foundReferences.add(reference);
            }
        }
        return foundReferences;
    }

    private void setRootCatalog(Catalog rootCatalog) {
        if (rootCatalog == null) throw new ReferenceManagementException("cannot create SearchEngine with null as root catalog");
        this.rootCatalog = rootCatalog;
    }
}
