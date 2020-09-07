package fr.ubordeaux.ao.infra;

import java.util.HashMap;
import java.util.Map;

import fr.ubordeaux.ao.domain.Basket;
import fr.ubordeaux.ao.domain.BasketRepository;

public class BasketRepositoryInMemory implements BasketRepository {
    private Map<Integer, Basket> memory;

    public BasketRepositoryInMemory() {
        memory = new HashMap<>();

    }

    @Override
    public void add(Basket basket) {
        Integer basketId = basket.getId();
        if (!memory.containsKey(basketId)) {
            memory.put(basketId, basket);
        }
    }

    @Override
    public Basket findBasketById(int id) {
        return memory.get(new Integer(id));
    }
    
}