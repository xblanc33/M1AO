package fr.ubordeaux.ao.infrastructure.inmemory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;
import fr.ubordeaux.ao.domain.model.Catalog;
import fr.ubordeaux.ao.domain.model.Reference;
import fr.ubordeaux.ao.domain.type.CatalogName;
import fr.ubordeaux.ao.domain.type.CatalogName;

public class CatalogImpl implements Catalog {
    private CatalogName name;
    private Map<String, Reference> references;
    private Map<CatalogName, Catalog> subCatalogs;

    public CatalogImpl(String name) {
        this.setName(name);
        references = new HashMap<String, Reference>();
        subCatalogs = new HashMap<CatalogName, Catalog>();
    }

    private void setName(String name) {
        CatalogName cname = new CatalogName(name);
        this.name = cname;
    }

    public CatalogName getName() {
        return this.name;
    }

    public Set<Catalog> getSubCatalogs() {
        Set<Catalog> subs = new HashSet<Catalog>();
        subs.addAll(this.subCatalogs.values());
        return subs;
    }

    public void addSubCatalog(Catalog catalog) {
        if (subCatalogs.keySet().contains(catalog.getName())) {
            String msg = "cannot add catalog, name already exists";
            throw new ReferenceManagementException(msg);
        }
        subCatalogs.put(catalog.getName(),catalog);
    }

    public int size() {
        return references.size();
    }

    public Set<Reference> getOwnReferences() {
        Set<Reference> result = new HashSet<Reference>();
        result.addAll(references.values());
        return result;
    }

    public Set<Reference> getAllReferences() {
        Set<Reference> result = getOwnReferences();
        for (Catalog subCatalog : subCatalogs.values()) {
            result.addAll(subCatalog.getAllReferences());
        }
        return result;
    }

    public Reference findReferenceById(String id) {
        if (!references.containsKey(id)) throw new ReferenceManagementException("cannot find Reference, id unknown !");
        return references.get(id);
    }

    public void add(Reference reference) {
        references.put(reference.getId(), reference);
    }

    public void remove(Reference reference) {
        references.remove(reference.getId());
    }
}