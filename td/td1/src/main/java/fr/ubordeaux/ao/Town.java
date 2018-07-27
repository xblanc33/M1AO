package fr.ubordeaux.ao;

import java.util.Objects;

public class Town {
    private String name;
    private int zipcode;

    public Town(String name, int zipcode) {
        this.setName(name);
        this.setZipCode(zipcode);
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void setZipCode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getZipCode() {
        return zipcode;
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof Town)) return false;
        Town otherTown = (Town) other;
        boolean sameTown = this.name.compareTo(otherTown.name) == 0;
        boolean sameZipcode = this.zipcode == otherTown.zipcode;
        return  sameTown && sameZipcode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, zipcode);
    }

    @Override
    public String toString() {
        return zipcode+" "+name;
    }
}