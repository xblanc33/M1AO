package fr.ubordeaux.ao.productmanagement.ui.cli;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.Catalog;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.KeyWord2ReferenceLinkMap;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord2ReferenceLink;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.service.SearchEngine;
import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.type.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.CatalogImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.KeyWord2ReferenceLinkMapImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.ProductRepositoryImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.ReferenceRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        createCollections();
        addSomeReferences();
        addSomeKeyWords();
        addSomeProducts();
        addSomeProducts2Catalog();
        performSomeSearches();
    }

    private static void createCollections() {
        CollectionManager.createInstance(new CatalogImpl(new CatalogName("root")), new ProductRepositoryImpl(), new ReferenceRepositoryImpl(), new KeyWord2ReferenceLinkMapImpl());
    }

    private static void addSomeReferences() {
        ReferenceRepository referenceRepository = CollectionManager.getInstance().getReferenceRepository();
        referenceRepository.addReference(new Reference(new ReferenceId(), "The Book", "this is a really interesting book"));
        referenceRepository.addReference(new Reference(new ReferenceId(), "The Bike", "this is a really interesting bike"));
        referenceRepository.addReference(new Reference(new ReferenceId(), "The Blob", "this is a really interesting blob"));
        System.out.println("Did add references");
    }

    private static void addSomeKeyWords() {
        ReferenceRepository referenceRepository = CollectionManager.getInstance().getReferenceRepository();
        KeyWord2ReferenceLinkMap linkMap = CollectionManager.getInstance().getLinkMap();
        KeyWord keyword = new KeyWord("interesting");
        Set<Reference> references = referenceRepository.getReference(0, referenceRepository.size());
        for (Reference reference : references) {
            linkMap.putKeyWordProductLink(new KeyWord2ReferenceLink(keyword, reference));
        }
        System.out.println("Did add keywords");
    }

    private static void addSomeProducts() {
        ReferenceRepository referenceRepository = CollectionManager.getInstance().getReferenceRepository();
        ProductRepository productRepository = CollectionManager.getInstance().getProductRepository();
        Set<Reference> references = referenceRepository.getReference(0, referenceRepository.size());
        for (Reference reference : references) {
            productRepository.addProduct(new Product(reference.getId(), new Price(2)));
        }
        System.out.println("Did add products");
    }

    private static void addSomeProducts2Catalog() {
        Catalog rootCatalog = CollectionManager.getInstance().getRootCatalog();
        ProductRepository productRepository = CollectionManager.getInstance().getProductRepository();
        Set<Product> products = productRepository.getProduct(0, productRepository.size());
        for (Product product : products) {
            rootCatalog.addProduct(product);
        }
        System.out.println("Did add products to catalog");
    }
    

    private static void performSomeSearches() {
        SearchEngine searchEngine = new SearchEngine();
        Set<KeyWord> keywords = new HashSet<KeyWord>();
        keywords.add(new KeyWord("interesting"));
        Set<Reference> references = searchEngine.searchReferencesByKeyWords(keywords);
        for (Reference reference : references) {
            System.out.println("\tFound "+reference.getName());
        }

    }
}