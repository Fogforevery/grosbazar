package fr.epita.assistants.item_producer.data.repository;

import fr.epita.assistants.item_producer.data.model.PlayerModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class PlayerRepository implements PanacheRepository<PlayerModel> {
    public static void saveplayer(PlayerModel p) {
    }
}
