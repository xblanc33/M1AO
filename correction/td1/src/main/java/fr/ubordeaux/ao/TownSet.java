package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Set;

public class TownSet {
    private Set<Town> townSet;

    public TownSet() {
        townSet = new HashSet<Town>();
    }

    public void addTown(Town town) {
        townSet.add(town);
    }

    public Set<Town> getTownSet() {
        Set<Town> result = new HashSet<Town>();
        result.addAll(townSet);
        return result;
    }

    public int size() {
        return townSet.size();
    }
}