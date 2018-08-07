package fr.ubordeaux.ao.referencemanagement.domain.service;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ao.referencemanagement.domain.model.KeyWordMap;
import fr.ubordeaux.ao.referencemanagement.domain.model.Catalog;
import fr.ubordeaux.ao.referencemanagement.domain.model.CollectionManager;
import fr.ubordeaux.ao.referencemanagement.domain.model.KeyWord;
import fr.ubordeaux.ao.referencemanagement.domain.model.Reference;
import fr.ubordeaux.ao.referencemanagement.domain.exception.ReferenceManagementException;

public class SearchEngine {

    private Catalog rootCatalog;
    private KeyWordMap keywordMap;

    public SearchEngine() {
        rootCatalog = CollectionManager.getInstance().getRootCatalog();
        keywordMap = CollectionManager.getInstance().getKeyWordMap();
    }

    public Reference searchReferenceById(String id) {
        for (Reference reference : rootCatalog.getReferences()) {
            if (reference.getId().compareTo(id)==0) {
                return reference;
            }
        }
        throw new ReferenceManagementException("cannot find reference, id does not exist");
    }

    public Set<Reference> searchReferencesByKeyWords(Set<KeyWord> keywords) {
        Set<Reference> foundReferences = new HashSet<Reference>();
        for (KeyWord keyword : keywords) {
            foundReferences.addAll(keywordMap.findReferenceByKeyWord(keyword));
        }
        return foundReferences;
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
}