package fr.ubordeaux.ao.domain;

import java.util.Map;
import java.util.HashMap;

/**
 * Aggregate
 * 
 **/
public class Basket {
    private int id;
    private Map<Reference, CommandLine> commandLineMap;
    private boolean isClosed;

    public Basket(int id) {
        this.id = id;
        commandLineMap = new HashMap<Reference, CommandLine>();
        isClosed = false;
    }
    
    public int getId() {
        return id;
    }

    public void order(Reference reference, int quantity) {
        if (!isClosed) {
            if (commandLineMap.containsKey(reference)) {
                commandLineMap.get(reference).changeQuantity(quantity);
            } else {
                CommandLine cl = new CommandLine(reference, quantity);
                commandLineMap.put(reference, cl);
            }
        }
    }

    public void remove(Reference reference) {
        if (!isClosed) {
            if (commandLineMap.containsKey(reference)) {
                commandLineMap.remove(reference);
            }
        }
    }

    public void close() {
        isClosed = true;
    }

    public Price getPrice() {
        int price = 0;
        for (CommandLine line : commandLineMap.values()) {
            price += line.getPrice().getValue();
        }
        return new Price(price);
    }

    
}
