package fr.epita.assistants.item_producer.converter;

import fr.epita.assistants.item_producer.data.model.ItemModel;
import fr.epita.assistants.item_producer.domain.entity.ItemEntity;

public class ItemConverter {
    public ItemModel toItemModel(ItemEntity entity) {
        ItemModel item = new ItemModel();
        item.id = entity.getId();
        item.type = entity.getType();
        item.quantity = entity.getQuantity();
        return item;
    }
    public ItemEntity toItemEntity(ItemModel model) {
        ItemEntity item = new ItemEntity();
        item.id = model.getId();
        item.type = model.getType();
        item.quantity = model.getQuantity();
        return item;
    }
}