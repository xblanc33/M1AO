package fr.ubordeaux.ao.productmanagement.domain.type;

import java.util.Objects;

import fr.ubordeaux.ao.productmanagement.domain.exception.ProductManagementException;

public class Price {
    private int valueInEuroCents;

    public Price(int valueInEuroCents) {
        this.setPrice(valueInEuroCents);
    }

    private void setPrice(int valueInEuroCents) {
        if (valueInEuroCents < 0) throw new ProductManagementException("prices are in Euro Cents, and therefore must be positive");
        this.valueInEuroCents = valueInEuroCents;
    }

    public int getPrice() {
        return this.valueInEuroCents;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Price)) return false;
        return this.valueInEuroCents == ((Price)other).valueInEuroCents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueInEuroCents);
    }

    @Override
    public String toString() {
        return String.valueOf(this.valueInEuroCents);
    }
}