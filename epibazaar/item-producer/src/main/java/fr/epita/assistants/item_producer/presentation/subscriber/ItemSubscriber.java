package fr.epita.assistants.item_producer.presentation.subscriber;

import fr.epita.assistants.common.aggregate.ResetInventoryAggregate;
import fr.epita.assistants.item_producer.converter.ItemConverter;
import fr.epita.assistants.item_producer.domain.entity.ItemEntity;
import fr.epita.assistants.item_producer.domain.service.GameService;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import jakarta.inject.Inject;
import java.util.Collections;

@ApplicationScoped
public class ItemSubscriber {
    ItemConverter itemConverter;
    GameService gameService;

    @Incoming("reset-inventory-aggregate")
    @Broadcast
    public void process(ResetInventoryAggregate aggregate) {
        System.out.println(aggregate.getItems().toString());
        gameService.deletespecific(Collections.singletonList(itemConverter.toItemModel((ItemEntity) aggregate.getItems())));
    }
}
