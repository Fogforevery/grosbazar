package fr.epita.assistants.item_producer.converter;

import fr.epita.assistants.item_producer.data.model.PlayerModel;
import fr.epita.assistants.item_producer.domain.entity.PlayerEntity;

public class PlayerConverter {
    public PlayerModel toPlayerModel(PlayerEntity entity) {
        PlayerModel player = new PlayerModel();
        player.id = entity.getId();
        player.collectRateMultiplier = entity.getCollect_rate_multiplier();
        player.moveSpeedMultiplier = entity.getMove_speed_multiplier();
        player.posX = entity.getPos_x();
        player.posY = entity.getPos_y();
        player.staminaMultiplier = entity.getStamina_multiplier();
        player.lastCollect = entity.getLast_collect();
        player.lastMove = entity.getLast_move();
        return player;
    }
    public PlayerEntity toPlayerEntity(PlayerModel model) {
        PlayerEntity player = new PlayerEntity();
        player.id = model.getId();
        player.collect_rate_multiplier = model.getCollectRateMultiplier();
        player.move_speed_multiplier = model.getMoveSpeedMultiplier();
        player.pos_x = model.getPosX();
        player.pos_y = model.getPosY();
        player.stamina_multiplier = model.getStaminaMultiplier();
        player.last_collect = model.getLastCollect();
        player.last_move = model.getLastMove();
        return player;
    }
}
