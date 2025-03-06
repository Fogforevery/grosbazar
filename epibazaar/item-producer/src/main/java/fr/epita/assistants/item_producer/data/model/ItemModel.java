package fr.epita.assistants.item_producer.data.model;

import fr.epita.assistants.common.aggregate.ItemAggregate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item")
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "quantity", nullable = false)
    public float quantity;

    @Column(length = 255, name = "type", nullable = false)
    public ItemAggregate.ResourceType type;
}
