package fr.ubordeaux.ao.productmanagement.domain.model;

public class KeyWord {
    private String value;

    public KeyWord(String value) {
        this.setValue(value);
    }

    private void setValue(String value)  {
        this.value = value;
    }

    public boolean equals(KeyWord other) {
        return this.value == other.value;
    }
}