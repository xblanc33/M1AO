package ecommerce.domain;

public interface BasketRepository {
    public void addBasket(Basket basket);
    public void updateBasket(Basket basket);
    public Basket findBasketById(int id);
}