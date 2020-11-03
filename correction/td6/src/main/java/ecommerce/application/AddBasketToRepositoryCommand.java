package ecommerce.application;

import ecommerce.domain.Basket;
import ecommerce.domain.BasketRepository;

public class AddBasketToRepositoryCommand extends Command {
    private BasketRepository repository;
    private Basket basket;

    public AddBasketToRepositoryCommand(BasketRepository repository, Basket basket) {
        this.repository = repository;
        this.basket = basket;
    }

    public void execute() {
        this.repository.addBasket(basket);
    }
}