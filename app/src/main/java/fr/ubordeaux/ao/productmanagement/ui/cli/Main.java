package fr.ubordeaux.ao.productmanagement.ui.cli;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.collection.CollectionManager;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ProductRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.collection.ReferenceRepository;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
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

        addSomeProducts();

    }

    public static void createCollections() {
        CollectionManager.createInstance(new CatalogImpl(new CatalogName("root")), new ProductRepositoryImpl(), new ReferenceRepositoryImpl(), new KeyWord2ReferenceLinkMapImpl());
    }

    public static void addSomeReferences() {
        ReferenceRepository referenceRepository = CollectionManager.getInstance().getReferenceRepository();
        referenceRepository.addReference(new Reference(new ReferenceId(), "The Book", "this is a really interesting book"));
        referenceRepository.addReference(new Reference(new ReferenceId(), "The Bike", "this is a really interesting bike"));
        referenceRepository.addReference(new Reference(new ReferenceId(), "The Blob", "this is a really interesting blob"));
        System.out.println("Did add references");
    }

    public static void addSomeProducts() {
        ReferenceRepository referenceRepository = CollectionManager.getInstance().getReferenceRepository();
        ProductRepository productRepository = CollectionManager.getInstance().getProductRepository();
        Set<Reference> references = referenceRepository.getReference(0, referenceRepository.size());
        for (Reference reference : references) {
            productRepository.addProduct(new Product(reference.getId(), new Price(2)));
        }
        System.out.println("Did add products");
    }
}