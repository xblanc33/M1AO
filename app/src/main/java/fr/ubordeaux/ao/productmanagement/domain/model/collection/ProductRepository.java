package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.type.ReferenceId;

public interface ProductRepository {
    public void add(Product product);
    public void remove(Product product);
    public Product findByReferenceById(ReferenceId id);
    public Set<Product> getProduct();
    public int size();
}