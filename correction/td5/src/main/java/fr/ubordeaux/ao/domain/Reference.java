package fr.ubordeaux.ao.domain;

/**
 * Value Object
 */
public class Reference {
    AlphabetWord id;
    AlphabetWord name;
    String description;
    Price price;

    public Reference(AlphabetWord id, AlphabetWord name, String description, Price price) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if (description == null) {
            throw new IllegalArgumentException();
        }
        if (price == null) {
            throw new IllegalArgumentException();
        }
        if (description.length() >= 200) {
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public AlphabetWord getId() {
        return this.id;
    }

    public AlphabetWord getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Price getPrice() {
        return this.price;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof Reference) {
            Reference otherR = (Reference) other;
            boolean sameId = id.equals(otherR.id);
            boolean sameName = name.equals(otherR.name);
            boolean sameDescription = description.equals(otherR.description);
            boolean samePrice = price.equals(otherR.price);
            return sameId && sameName && sameDescription && samePrice;
        }
        return false;
    }
    
}