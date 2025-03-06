package fr.epita.assistants.item_producer.domain.service;

import fr.epita.assistants.item_producer.data.model.PlayerModel;
import fr.epita.assistants.item_producer.data.repository.PlayerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PlayerService {

    @Transactional
    public static void newplayer() {
        new PlayerRepository().deleteAll();
        PlayerModel player = new PlayerModel();
        player.posX = 0;
        player.posY = 0;
        player.lastMove = null;
        player.lastCollect = null;
        player.moveSpeedMultiplier = 1;
        player.staminaMultiplier = 1;
        player.collectRateMultiplier = 1;
        new PlayerRepository().persist(player);
    }


    public static PlayerModel getPlayer() {
        if (new PlayerRepository().listAll().isEmpty()) {
            return null;
        }
        return new PlayerRepository().listAll().getFirst();
    }
}
