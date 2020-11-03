package ecommerce.application;

public class Worker extends Thread {
    private CommandQueue commandQueue;

    public Worker(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
    }

    public void run() {
        while (true) {
            Command command = this.commandQueue.get();
            if (command != null) {
                command.execute();
            }
        }
    }

}