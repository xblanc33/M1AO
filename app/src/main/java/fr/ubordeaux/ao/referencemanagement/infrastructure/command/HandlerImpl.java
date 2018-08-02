package fr.ubordeaux.ao.referencemanagement.infrastructure.command;

import fr.ubordeaux.ao.referencemanagement.application.command.Command;
import fr.ubordeaux.ao.referencemanagement.application.command.Handler;

public class HandlerImpl implements Handler {
    
	@Override
	public void handle(Command command) {
        command.execute();
	}

}