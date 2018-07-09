package fr.ubordeaux.ao.productmanagement.domain.application;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.ReferenceId;

public interface SearchEngine {

    public Reference searchReferenceById(ReferenceId id);

    public Set<Reference> searchReferencesByKeyWords(Set<KeyWord> keywords);

    public Set<Reference> searchReferencesByName(String name);

    public Set<Product> getOwnProductsOfCatalog(CatalogName catalogName);

    public Set<Product> getAllProductsOfCatalog(CatalogName catalogName);

    public Set<Product> searchProductsByReferenceIdFilteredByPrice(ReferenceId id, Price min, Price max);

    public Set<Product> searchProductsByReferenceIdsFilteredByPrice(Set<ReferenceId> ids, Price min, Price max);

}