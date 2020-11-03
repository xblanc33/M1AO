package ecommerce.domain;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

public class Basket {
    private int id;
    private Map<Product, CommandLine> commandLineByProduct;

    public Basket(int id) {
        this.id = id;
        this.commandLineByProduct = new HashMap();
    }

    public int getId() {
        return this.id;
    }

    public void addProduct(Product product, int quantity) {
        if (this.commandLineByProduct.containsKey(product)) {
            this.commandLineByProduct.get(product).addQuantity(quantity);
        } else {
            int commandLineId = this.commandLineByProduct.size();
            CommandLine cml = new CommandLine(commandLineId, product, quantity);
            this.commandLineByProduct.put(cml.getProduct(), cml);
        }
    }

    public void removeProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("cannot removeProduct with null as Product");
        }
        this.commandLineByProduct.remove(product);
    }

    public void addQuantityForProduct(int quantity, Product product) {
        if (this.commandLineByProduct.containsKey(product)) {
            this.commandLineByProduct.get(product).addQuantity(quantity);
        }
    }

    public void removeQuantityForProduct(int quantity, Product product) {
        if (this.commandLineByProduct.containsKey(product)) {
            this.commandLineByProduct.get(product).removeQuantity(quantity);
        }
    }

    public Set<CommandLine> getCommandLines() {
        Set<CommandLine> copy = new HashSet();;
        for (CommandLine cml : this.commandLineByProduct.values()) {
            copy.add(new CommandLine(cml.getId(), cml.getProduct(), cml.getPrice()));
        }
        return copy;
    }
}