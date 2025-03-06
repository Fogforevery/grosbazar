package fr.epita.assistants.inventory.domain.entity;

import fr.epita.assistants.common.aggregate.ItemAggregate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemEntity {
    public int id;
    public float quantity;
    public ItemAggregate.ResourceType type;
}
