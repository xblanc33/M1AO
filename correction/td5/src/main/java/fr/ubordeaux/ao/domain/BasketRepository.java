package fr.ubordeaux.ao.domain;

public interface BasketRepository {
    public void add(Basket basket);

    public Basket findBasketById(int id);
}