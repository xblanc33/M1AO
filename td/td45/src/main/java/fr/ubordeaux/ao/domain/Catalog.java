package fr.ubordeaux.ao.domain;

public interface Catalog {
    public void add(Reference reference);
    public void remove(Reference reference);
    public void add(Catalog catalog, String name);
}