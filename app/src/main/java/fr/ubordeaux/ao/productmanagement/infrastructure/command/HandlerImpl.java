package fr.ubordeaux.ao.productmanagement.infrastructure.command;

import fr.ubordeaux.ao.productmanagement.domain.application.command.Command;
import fr.ubordeaux.ao.productmanagement.domain.application.command.Handler;

public class HandlerImpl implements Handler {
    
	@Override
	public void handle(Command command) {
        command.execute();
	}

}