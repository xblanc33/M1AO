package ecommerce.application;

import java.util.List;
import java.util.ArrayList;

public class CommandQueue {
    private List<Command> queue;

    public CommandQueue() {
        this.queue = new ArrayList();
    }

    public synchronized void add(Command command) {
        this.queue.add(command);
    }

    public synchronized Command get() {
        if (this.queue.size() > 0) {
            return this.queue.remove(0);
        } else {
            return null;
        }
        
    }
}