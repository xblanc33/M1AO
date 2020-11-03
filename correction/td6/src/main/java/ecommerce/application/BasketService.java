package ecommerce.application;

import ecommerce.domain.Basket;
import ecommerce.domain.BasketRepository;
import ecommerce.domain.CommandLine;
import ecommerce.domain.Product;

import java.util.Set;
import java.util.HashSet;

public class BasketService {
    private BasketRepository repository;

    public BasketService(BasketRepository repository) {
        this.repository = repository;
    }

    public int createBasket() {
        int basketId = (int)(Math.random() * ((Integer.MAX_VALUE - Integer.MIN_VALUE) + 1)) + Integer.MIN_VALUE;
        Basket basket = new Basket(basketId);
        this.repository.addBasket(basket);
        return basketId;
    }

    public void addProductToBasket(int basketId, Product product, int quantity) {
        Basket basket = this.repository.findBasketById(basketId);
        basket.addProduct(product, quantity);
        this.repository.updateBasket(basket);
    }

    public void removeProductFromBasket(int basketId, Product product) {
        Basket basket = this.repository.findBasketById(basketId);
        basket.removeProduct(product);
        this.repository.updateBasket(basket);
    }

    public void addQuantityForProductInBasket(int basketId, Product product, int quantityToAdd) {
        Basket basket = this.repository.findBasketById(basketId);
        basket.addQuantityForProduct(quantityToAdd, product);
        this.repository.updateBasket(basket);
    }

    public void removeQuantityForProductInBasket(int basketId, Product product, int quantityToRemove) {
        Basket basket = this.repository.findBasketById(basketId);
        basket.addQuantityForProduct(quantityToRemove, product);
        this.repository.updateBasket(basket);
    }

    public Set<Product> getProductsInBasket(int basketId) {
        Basket basket = this.repository.findBasketById(basketId);
        Set<Product> products = new HashSet();
        for (CommandLine cml  : basket.getCommandLines()) {
            products.add(cml.getProduct());
        }
        return products;
    }

    public int getQuantityForProductInBasket(int basketId, Product product) {
        Basket basket = this.repository.findBasketById(basketId);
        for (CommandLine cml  : basket.getCommandLines()) {
            if (cml.getProduct().equals(product)) {
                return cml.getQuantity();
            }
        }
        return 0;
    }
}