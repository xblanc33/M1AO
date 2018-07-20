package fr.ubordeaux.ao.productmanagement.domain.model.collection;

import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.model.concept.Product;
import fr.ubordeaux.ao.productmanagement.domain.model.type.ReferenceId;

public interface ProductRepository {
    public void addProduct(Product product);
    public void removeProduct(Product product);
    public Product findProductByReferenceById(ReferenceId id);
    public Set<Product> getProduct(int from, int to);
    public int size();
}