package ecommerce;

import ecommerce.ui.CLI;
import ecommerce.application.BasketServiceOptim;
import ecommerce.infra.BasketRepositoryInMemory;

public class Main {
    public static void main(String[] args) {
        CLI cli = new CLI(new BasketServiceOptim(new BasketRepositoryInMemory() ));
        cli.createOrFindBasket();
    }
}