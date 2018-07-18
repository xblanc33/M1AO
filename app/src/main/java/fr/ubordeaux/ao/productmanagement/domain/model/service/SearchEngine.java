package fr.ubordeaux.ao.productmanagement.domain.model.service;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.Collections;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWord2ReferenceLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Catalog;
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

    public SearchEngine(Collections collections) {
        products = collections.getProductRepositorySingleton();
        references = collections.getReferenceRepositorySingleton();
        rootCatalog = collections.getRootCatalog();
        keyword2referenceMap = collections.getKeyWord2ReferenceLinkMapSingleton();
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
        throw new ProductManagementException("no yet supported");

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