package fr.epita.assistants.item_producer.domain.service;

import fr.epita.assistants.common.utils.Point;
import fr.epita.assistants.item_producer.data.model.PlayerModel;
import fr.epita.assistants.item_producer.data.repository.PlayerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class MoveService {

        @Transactional
        public static Point moveplayer(String dir) {
            Config config = ConfigProvider.getConfig();
            Float tickDuration = (config.getValue("JWS_TICK_DURATION", float.class));
            long delay = (config.getValue("JWS_DELAY_MOVEMENT", long.class));
            PlayerModel p = PlayerService.getPlayer();
            int x = p.posX;
            int y = p.posY;
            if (p.lastMove != null && ChronoUnit.MILLIS.between(p.lastMove, LocalDateTime.now()) < (tickDuration * (delay/ p.moveSpeedMultiplier))) {
                return new Point(-1, -1);
            }
            switch (dir) {
                case "UP":
                    y--;
                    break;
                case "DOWN":
                    y++;
                    break;
                case "LEFT":
                    x--;
                    break;
                case "RIGHT":
                    x++;
                    break;
                default:
                    return null;
            }
            p.setPosX(x);
            p.setPosY(y);
            p.lastMove = LocalDateTime.now();
            new PlayerRepository().persist(p);
            return new Point(x, y);
        }


}
