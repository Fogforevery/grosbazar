package fr.epita.assistants.item_producer.converter;

import fr.epita.assistants.item_producer.data.model.GameModel;
import fr.epita.assistants.item_producer.domain.entity.GameEntity;

public class GameConverter {
    public GameModel toGameModel(GameEntity entity) {
        GameModel game = new GameModel();
        game.id = entity.getId();
        game.map = entity.getMap();
        return game;
    }
    public GameEntity toGameEntity(GameModel model) {
        GameEntity game = new GameEntity();
        game.id = model.getId();
        game.map = model.getMap();
        return game;
    }
}
