package fr.ubordeaux.ao.productmanagement.domain.application.command;

public interface Gateway {
    public void pushCommand(Command command);

    public void addCommandHandler(Handler handler);
}