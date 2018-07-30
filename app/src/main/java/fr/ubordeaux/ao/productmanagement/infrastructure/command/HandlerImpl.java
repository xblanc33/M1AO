package fr.ubordeaux.ao.productmanagement.infrastructure.command;

import fr.ubordeaux.ao.productmanagement.application.command.Command;
import fr.ubordeaux.ao.productmanagement.application.command.Handler;

public class HandlerImpl implements Handler {
    
	@Override
	public void handle(Command command) {
        command.execute();
	}

}