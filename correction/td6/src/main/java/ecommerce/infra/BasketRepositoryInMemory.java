package ecommerce.infra;

import ecommerce.domain.Basket;
import ecommerce.domain.BasketRepository;

import java.util.Set;
import java.util.HashSet;

public class BasketRepositoryInMemory implements BasketRepository {
    private Set<Basket> memory;

    public BasketRepositoryInMemory() {
        this.memory = new HashSet();
    }

    public void addBasket(Basket basket) {
        this.memory.add(basket);
    }

    public void updateBasket(Basket basket) {
        this.memory.add(basket);
    }

    public Basket findBasketById(int id) {
        for (Basket basket : this.memory) {
            if (basket.getId() == id) {
                return basket;
            }
        }
        return null;//TODO: Change return type to better express NOT_FOUND
    }

}