package fr.ubordeaux.ao.productmanagement.domain.model.service;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWord2ReferenceLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;
import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.type.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

public class SearchEngine {

    private ProductRepository products;
    private ReferenceRepository references;
    private Catalog rootCatalog;
    private KeyWord2ReferenceLinkMap keyword2referenceMap;

    public SearchEngine() {
        products = CollectionManager.getInstance().getProductRepository();
        references = CollectionManager.getInstance().getReferenceRepository();
        rootCatalog = CollectionManager.getInstance().getRootCatalog();
        keyword2referenceMap = CollectionManager.getInstance().getLinkMap();
    }

    public Reference searchReferenceById(ReferenceId id) {
        return references.findReferenceById(id);
    }

    public Set<Reference> searchReferencesByKeyWords(Set<KeyWord> keywords) {
        Set<Reference> foundReferences = new HashSet<Reference>();
        for (KeyWord keyword : keywords) {
            foundReferences.addAll(keyword2referenceMap.findReferenceFromKeyWord(keyword));
        }
        return foundReferences;
    }

    public Set<Reference> searchReferencesByName(String name) {
        Set<Reference> foundReferences = new HashSet<Reference>();
        foundReferences.addAll(references.findReferenceByName(name));
        return foundReferences;
    }

    public Set<Product> getOwnProductsOfCatalog(CatalogName catalogName) {
        throw new ProductManagementException("no yet supported");
    }

    public Set<Product> getAllProductsOfCatalog(CatalogName catalogName) {
        throw new ProductManagementException("no yet supported");
    }

    public Set<Product> searchProductsByReferenceIdFilteredByPrice(ReferenceId id, Price min, Price max) {
        throw new ProductManagementException("no yet supported");
    }

    public Set<Product> searchProductsByReferenceIdsFilteredByPrice(Set<ReferenceId> ids, Price min, Price max) {
        throw new ProductManagementException("no yet supported");
    }

}