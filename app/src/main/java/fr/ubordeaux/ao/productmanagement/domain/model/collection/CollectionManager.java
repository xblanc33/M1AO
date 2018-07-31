package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;

public class CollectionManager {

    private Catalog rootCatalog;
    private ProductRepository productRepository;
    private ReferenceRepository referenceRepository;
    private KeyWordMap keywordMap;

    private static CollectionManager singleton = null;

    private CollectionManager(Catalog rootCatalog, ProductRepository productRepository, ReferenceRepository referenceRepository, KeyWordMap keywordMap) {
        this.setRootCatalog(rootCatalog);
        this.setProductRepository(productRepository);
        this.setReferenceRepository(referenceRepository);
        this.setKeyWordMap(keywordMap);
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

    private void setKeyWordMap(KeyWordMap keywordMap) {
        if (keywordMap == null) throw new ProductManagementException("Cannot create CollectionManager with null as linkMap");
        this.keywordMap = keywordMap;
    }

    public static CollectionManager getInstance() {
        if (singleton == null) throw new ProductManagementException("CollectionManger is not initialized, please initialize it !");
        return singleton;
    }

    public static CollectionManager createInstance(Catalog rootCatalog, ProductRepository productRepository, ReferenceRepository referenceRepository, KeyWordMap keywordMap) {
        if (singleton == null) {
            singleton = new CollectionManager(rootCatalog, productRepository, referenceRepository, keywordMap);
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

    public KeyWordMap getKeyWordMap() {
        return keywordMap;
    }
}