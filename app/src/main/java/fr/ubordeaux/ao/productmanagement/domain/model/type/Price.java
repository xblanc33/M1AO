package fr.ubordeaux.ao.productmanagement.domain.model.type;

import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public class Price {
    private double price;

    public Price(double price) {
        this.setPrice(price);
    }

    private void setPrice(double price) {
        if (price < 0) throw new ProductManagementException("price must be positive");
        if (hasMoreThanTwoDecimals(price)) throw new ProductManagementException("price should not have more than two decimals");

        this.price = price;

    }

    private static boolean hasMoreThanTwoDecimals(double price){
        String priceAsString = String.valueOf(price);
        int dotIndex = priceAsString.indexOf('.');
        return dotIndex+2 < priceAsString.length();
    }

    public double getPrice() {
        return this.price;
    }
}