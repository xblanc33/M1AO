package ecommerce.application;

import ecommerce.domain.Basket;
import ecommerce.domain.BasketRepository;

public class UpdateBasketToRepositoryCommand extends Command {
    private BasketRepository repository;
    private Basket basket;

    public UpdateBasketToRepositoryCommand(BasketRepository repository, Basket basket) {
        this.repository = repository;
        this.basket = basket;
    }

    public void execute() {
        System.out.println("UpdateBasketToRepositoryCommand is executed");
        this.repository.updateBasket(basket);
    }
}