package fr.ubordeaux.ao.domain.type;

import java.util.Objects;

import fr.ubordeaux.ao.domain.exception.ReferenceManagementException;

public class Price {
    private int valueInEuroCents;

    public Price(int valueInEuroCents) {
        this.setPrice(valueInEuroCents);
    }

    private void setPrice(int valueInEuroCents) {
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
