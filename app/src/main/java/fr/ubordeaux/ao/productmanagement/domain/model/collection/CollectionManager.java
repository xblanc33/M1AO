package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public class CollectionManager {

    private Catalog rootCatalog;
    private ProductRepository productRepository;
    private ReferenceRepository referenceRepository;
    private KeyWord2ReferenceLinkMap linkMap;

    private static CollectionManager singleton = null;

    private CollectionManager(Catalog rootCatalog, ProductRepository productRepository, ReferenceRepository referenceRepository, KeyWord2ReferenceLinkMap linkMap) {
        this.setRootCatalog(rootCatalog);
        this.setProductRepository(productRepository);
        this.setReferenceRepository(referenceRepository);
        this.setLinkMap(linkMap);
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

    private void setLinkMap(KeyWord2ReferenceLinkMap linkMap) {
        if (linkMap == null) throw new ProductManagementException("Cannot create CollectionManager with null as linkMap");
        this.linkMap = linkMap;
    }

    public static CollectionManager getInstance() {
        if (singleton == null) throw new ProductManagementException("CollectionManger is not initialized, please initialize it !");
        return singleton;
    }

    public static CollectionManager createInstance(Catalog rootCatalog, ProductRepository productRepository, ReferenceRepository referenceRepository, KeyWord2ReferenceLinkMap linkMap) {
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

    public KeyWord2ReferenceLinkMap getLinkMap() {
        return linkMap;
    }
}