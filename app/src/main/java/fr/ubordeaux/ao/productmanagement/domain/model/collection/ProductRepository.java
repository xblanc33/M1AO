package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.type.Price;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

public interface ProductRepository {
    public void addProduct(ReferenceId referenceId, Price price);
    public void removeProduct(ReferenceId referenceId);
    public Product findProductByReferenceById(ReferenceId id);
    public int size();
}