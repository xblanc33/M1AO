package fr.ubordeaux.ao.references.domain.model;

import java.util.Optional;

public interface ProductRepository {
    public void addProduct(ReferenceId referenceId, Price price);
    public void removeProduct(ReferenceId referenceId);
    public Optional<Product> findProductByReferenceById(ReferenceId id);
    public int size();
}