package fr.epita.assistants.item_producer.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class PlayerEntity {
    public int id;
    public float collect_rate_multiplier;
    public float move_speed_multiplier;
    public int pos_x;
    public int pos_y;
    public float stamina_multiplier;
    public LocalDateTime last_collect;
    public LocalDateTime last_move;
}
