package fr.ubordeaux.ao.productmanagement.domain.application.command;

public interface Handler {
    public void handle(Command command);
}