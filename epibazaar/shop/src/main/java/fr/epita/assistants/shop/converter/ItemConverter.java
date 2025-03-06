package fr.epita.assistants.shop.converter;

import fr.epita.assistants.shop.data.model.ItemModel;
import fr.epita.assistants.shop.domain.entity.ItemEntity;

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
