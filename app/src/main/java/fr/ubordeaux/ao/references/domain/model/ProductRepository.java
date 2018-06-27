package fr.ubordeaux.ao.references.domain.model;

public interface ProductRepository {
    public void addProduct(ReferenceId referenceId, double price);
    public void removeProduct(ReferenceId referenceId);
    public Product findProductByReferenceById(ReferenceId id);
    public int size();
}