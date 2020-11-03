package ecommerce.application;

public class Worker extends Thread {
    private CommandQueue commandQueue;

    public Worker(CommandQueue commandQueue) {
        this.commandQueue = commandQueue;
        System.out.println("Worker !");
    }

    public void run() {
        while (true) {
            Command command = this.commandQueue.get();
            if (command != null) {
                System.out.println("Worker execute !");
                command.execute();
            }
        }
    }

}