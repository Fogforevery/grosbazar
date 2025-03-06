package fr.epita.assistants.item_producer.domain.service;

import fr.epita.assistants.item_producer.data.model.ItemModel;
import fr.epita.assistants.item_producer.data.repository.ItemRepository;

import java.util.List;

public class ItemService {
    public static List<ItemModel> getInvlist() {
        return new ItemRepository().listAll();
    }
}
