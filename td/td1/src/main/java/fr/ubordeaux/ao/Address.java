package fr.ubordeaux.ao;

import java.util.Objects;

public class Address {
    private int number;
    private String street;
    private Town town;

    public Address(int number, String street, Town town) {
        this.setNumber(number);
        this.setStreet(street);
        this.setTown(town);
    }

    private void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    private void setTown(Town town) {
        this.town = town;
    }

    public Town getTown() {
        return town;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Address)) return false;
        Address otherAddress = (Address) other;
        boolean sameNumber = this.number == otherAddress.number;
        boolean sameStreet = this.street.compareTo(otherAddress.street) == 0;
        boolean sameTown = this.town.equals(otherAddress.town);
        return  sameNumber && sameStreet && sameTown;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, street, town);
    }

    @Override
    public String toString() {
        return number+" "+street+" "+town.toString();
    }

}