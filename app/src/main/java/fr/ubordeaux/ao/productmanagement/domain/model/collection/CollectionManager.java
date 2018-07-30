package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;

public class CollectionManager {

    private Catalog rootCatalog;
    private ProductRepository productRepository;
    private ReferenceRepository referenceRepository;
    private SemanticLinkMap linkMap;

    private static CollectionManager singleton = null;

    private CollectionManager(Catalog rootCatalog, ProductRepository productRepository, ReferenceRepository referenceRepository, SemanticLinkMap linkMap) {
        this.setRootCatalog(rootCatalog);
        this.setProductRepository(productRepository);
        this.setReferenceRepository(referenceRepository);
        this.setSemanticLinkMap(linkMap);
    }

    private void setRootCatalog(Catalog rootCatalog) {
        if (rootCatalog == null) throw new ProductManagementException("Cannot create CollectionManager with null as rootCatalog");
        this.rootCatalog = rootCatalog;
    }

    private void setProductRepository(ProductRepository productRepository) {
        if (productRepository == null) throw new ProductManagementException("Cannot create CollectionManager with null as productRepository");
        this.productRepository = productRepository;
    }

    private void setReferenceRepository(ReferenceRepository referenceRepository) {
        if (referenceRepository == null) throw new ProductManagementException("Cannot create CollectionManager with null as referenceRepository");
        this.referenceRepository = referenceRepository;
    }

    private void setSemanticLinkMap(SemanticLinkMap linkMap) {
        if (linkMap == null) throw new ProductManagementException("Cannot create CollectionManager with null as linkMap");
        this.linkMap = linkMap;
    }

    public static CollectionManager getInstance() {
        if (singleton == null) throw new ProductManagementException("CollectionManger is not initialized, please initialize it !");
        return singleton;
    }

    public static CollectionManager createInstance(Catalog rootCatalog, ProductRepository productRepository, ReferenceRepository referenceRepository, SemanticLinkMap linkMap) {
        if (singleton == null) {
            singleton = new CollectionManager(rootCatalog, productRepository, referenceRepository, linkMap);
        }
        return singleton;
    }

    public Catalog getRootCatalog() {
        return rootCatalog;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public ReferenceRepository getReferenceRepository() {
        return referenceRepository;
    }

    public SemanticLinkMap getLinkMap() {
        return linkMap;
    }
}