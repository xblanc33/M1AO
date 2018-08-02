package fr.ubordeaux.ao.referencemanagement.domain.model;

import fr.ubordeaux.ao.referencemanagement.domain.exception.ReferenceManagementException;

public class CollectionManager {

    private Catalog rootCatalog;
    private KeyWordMap keywordMap;

    private static CollectionManager singleton = null;

    private CollectionManager(Catalog rootCatalog, KeyWordMap keywordMap) {
        this.setRootCatalog(rootCatalog);
        this.setKeyWordMap(keywordMap);
    }

    private void setRootCatalog(Catalog rootCatalog) {
        if (rootCatalog == null) throw new ReferenceManagementException("Cannot create CollectionManager with null as rootCatalog");
        this.rootCatalog = rootCatalog;
    }

    private void setKeyWordMap(KeyWordMap keywordMap) {
        if (keywordMap == null) throw new ReferenceManagementException("Cannot create CollectionManager with null as linkMap");
        this.keywordMap = keywordMap;
    }

    public static CollectionManager getInstance() {
        if (singleton == null) throw new ReferenceManagementException("CollectionManger is not initialized, please initialize it !");
        return singleton;
    }

    public static CollectionManager createInstance(Catalog rootCatalog, KeyWordMap keywordMap) {
        if (singleton == null) {
            singleton = new CollectionManager(rootCatalog, keywordMap);
        }
        return singleton;
    }

    public Catalog getRootCatalog() {
        return rootCatalog;
    }

    public KeyWordMap getKeyWordMap() {
        return keywordMap;
    }
}