package fr.epita.assistants.item_producer.data.repository;

import fr.epita.assistants.item_producer.data.model.GameModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.transaction.Transactional;

public class GameRepository implements PanacheRepository<GameModel> {
    @Transactional
    public void resetgame() {
        this.deleteAll();
    }
}
