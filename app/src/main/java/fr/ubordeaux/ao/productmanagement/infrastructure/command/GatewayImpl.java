package fr.ubordeaux.ao.productmanagement.infrastructure.command;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import fr.ubordeaux.ao.productmanagement.domain.application.command.Command;
import fr.ubordeaux.ao.productmanagement.domain.application.command.Gateway;
import fr.ubordeaux.ao.productmanagement.domain.application.command.Handler;
import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public class GatewayImpl implements Gateway {
    private Set<Handler> handlers;
    private Random random;

    public GatewayImpl() {
        handlers = new HashSet<Handler>();
        random = new Random();
    }

	@Override
	public void pushCommand(Command command) {
        int index = random.nextInt(handlers.size());
        int i = 0;
		for (Handler handler : handlers) {
            if (i == index) {
                handler.handle(command);
                return;
            }
        }
	}

	@Override
	public void addCommandHandler(Handler handler) {
        if (handler == null) throw new ProductManagementException("cannot add null handler");
        handlers.add(handler);
		
	}
}