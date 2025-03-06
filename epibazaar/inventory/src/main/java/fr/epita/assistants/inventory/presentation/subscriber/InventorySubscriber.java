package fr.epita.assistants.inventory.presentation.subscriber;

import fr.epita.assistants.common.command.ResetInventoryCommand;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class InventorySubscriber {
    @Incoming("reset-inventory-aggregate")
    @Broadcast
    public void receive(ResetInventoryCommand command) {System.out.println(command.toString());}
}

