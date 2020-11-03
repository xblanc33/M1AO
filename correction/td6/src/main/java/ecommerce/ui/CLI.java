package ecommerce.ui;

import ecommerce.application.BasketServiceOptim;

public class CLI {
    private int basketId;
    private BasketServiceOptim applicationLayer;

    public CLI(BasketServiceOptim applicationLayer) {
        this.applicationLayer = applicationLayer;
    }

    public void createOrFindBasket() {
        boolean done = false;
        while (!done) {
            try {
                System.out.println("Type (1) to create a basket or (2) to find an existing basket:");
                String answer = System.console().readLine();
                int intAnswer = Integer.parseInt(answer);
                if (intAnswer == 1 ) {
                    this.basketId = this.applicationLayer.createBasket();
                    System.out.println("Your basket is created");
                    done = true;
                } else if (intAnswer == 2 ) {
                    System.out.println("Enter basket id:");
                    String answerBasketId = System.console().readLine();
                    this.basketId = Integer.parseInt(answerBasketId);
                    this.applicationLayer.getProductsInBasket(basketId);
                    System.out.println("Your basket has been found");
                    done = true;
                }
            } catch(Exception e) {
                System.out.println("something goes wrong try again");
            }
        }
        
    }

}