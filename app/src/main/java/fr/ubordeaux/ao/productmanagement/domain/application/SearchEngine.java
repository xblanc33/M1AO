package fr.ubordeaux.ao.productmanagement.domain.application;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.KeyWord;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.concept.Reference;
import fr.ubordeaux.ao.productmanagement.domain.model.type.CatalogName;
import fr.ubordeaux.ao.productmanagement.domain.model.type.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

public interface SearchEngine {

    public Reference searchReferenceById(ReferenceId id);

    public Set<Reference> searchReferencesByKeyWords(Set<KeyWord> keywords);

    public Set<Reference> searchReferencesByName(String name);

    public Set<Product> getOwnProductsOfCatalog(CatalogName catalogName);

    public Set<Product> getAllProductsOfCatalog(CatalogName catalogName);

    public Set<Product> searchProductsByReferenceIdFilteredByPrice(ReferenceId id, Price min, Price max);

    public Set<Product> searchProductsByReferenceIdsFilteredByPrice(Set<ReferenceId> ids, Price min, Price max);

}