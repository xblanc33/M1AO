package fr.ubordeaux.ao.domain;

public class Price {
    private int value;

    public Price(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Price) {
            Price otherP = (Price) other;
            return otherP.value == value;
        } else {
            return false;
        }
    }
}