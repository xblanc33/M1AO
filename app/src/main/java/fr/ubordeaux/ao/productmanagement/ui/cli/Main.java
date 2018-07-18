package fr.ubordeaux.ao.productmanagement.ui.cli;

import java.util.HashSet;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.application.command.AddProduct;
import fr.ubordeaux.ao.productmanagement.domain.application.command.AddProductToCatalog;
import fr.ubordeaux.ao.productmanagement.domain.application.command.AddReference;
import fr.ubordeaux.ao.productmanagement.domain.application.command.Gateway;
import fr.ubordeaux.ao.productmanagement.domain.application.command.Handler;
import fr.ubordeaux.ao.productmanagement.domain.application.command.LinkKeyWordToReference;
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
import fr.ubordeaux.ao.productmanagement.infrastructure.command.GatewayImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.command.HandlerImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.CatalogImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.KeyWord2ReferenceLinkMapImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.ProductRepositoryImpl;
import fr.ubordeaux.ao.productmanagement.infrastructure.persistence.inmemory.ReferenceRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        createCollections();
        Gateway gateway = createCommandGatewayAndHandler();
        addSomeReferences(gateway);
        addSomeKeyWords(gateway);
        addSomeProducts(gateway);
        addSomeProducts2Catalog(gateway);
        performSomeSearches();
    }

    private static void createCollections() {
        CollectionManager.createInstance(new CatalogImpl(new CatalogName("root")), new ProductRepositoryImpl(), new ReferenceRepositoryImpl(), new KeyWord2ReferenceLinkMapImpl());
    }

    private static Gateway createCommandGatewayAndHandler() {
        Gateway gateway = new GatewayImpl();
        Handler handler = new HandlerImpl();
        gateway.addCommandHandler(handler);
        return gateway;
    }

    private static void addSomeReferences(Gateway gateway) {
        gateway.pushCommand(new AddReference(new Reference(new ReferenceId(), "The Book", "this is a really interesting book")));
        gateway.pushCommand(new AddReference(new Reference(new ReferenceId(), "The Bike", "this is a really interesting bike")));
        gateway.pushCommand(new AddReference(new Reference(new ReferenceId(), "The Blob", "this is a really interesting blob")));
        System.out.println("Did add references");
    }

    private static void addSomeKeyWords(Gateway gateway) {
        ReferenceRepository referenceRepository = CollectionManager.getInstance().getReferenceRepository();
        KeyWord keyword = new KeyWord("interesting");
        Set<Reference> references = referenceRepository.getReference(0, referenceRepository.size());
        for (Reference reference : references) {
            gateway.pushCommand(new LinkKeyWordToReference(new KeyWord2ReferenceLink(keyword, reference)));
        }
        System.out.println("Did add keywords");
    }

    private static void addSomeProducts(Gateway gateway) {
        ReferenceRepository referenceRepository = CollectionManager.getInstance().getReferenceRepository();
        Set<Reference> references = referenceRepository.getReference(0, referenceRepository.size());
        for (Reference reference : references) {
            gateway.pushCommand(new AddProduct(new Product(reference.getId(), new Price(2))));
        }
        System.out.println("Did add products");
    }

    private static void addSomeProducts2Catalog(Gateway gateway) {
        ProductRepository productRepository = CollectionManager.getInstance().getProductRepository();
        Set<Product> products = productRepository.getProduct(0, productRepository.size());
        for (Product product : products) {
            gateway.pushCommand(new AddProductToCatalog(product, new CatalogName("root")));
        }
        System.out.println("Did add products to catalog");
    }
    

    private static void performSomeSearches() {
        System.out.println("Perform some searches");
        SearchEngine searchEngine = new SearchEngine();
        Set<KeyWord> keywords = new HashSet<KeyWord>();
        keywords.add(new KeyWord("interesting"));
        Set<Reference> references = searchEngine.searchReferencesByKeyWords(keywords);
        for (Reference reference : references) {
            System.out.println("\tSearch \"interesting\" keyword, found "+reference.getName());
        }

        Catalog rootCatalog = CollectionManager.getInstance().getRootCatalog();
        Set<Product> products = rootCatalog.getOwnProducts(0, 3);
        for (Product product : products) {
            System.out.println("\tSearch in root catalog, found "+product.getReferenceId()+ " price "+product.getPrice());
        }
    }
}