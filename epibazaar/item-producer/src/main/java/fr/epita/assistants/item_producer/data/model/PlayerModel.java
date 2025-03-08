package fr.epita.assistants.item_producer.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "player")
public class PlayerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "collect_rate_multiplier", nullable = false)
    public float collectRateMultiplier;

    @Column(name = "move_speed_multiplier", nullable = false)
    public float moveSpeedMultiplier;

    @Column(name = "pos_x", nullable = false)
    public int posX;

    @Column(name = "pos_y", nullable = false)
    public int posY;

    @Column(name = "stamina_multiplier", nullable = false)
    public float staminaMultiplier;

    @Column(name = "last_collect")
    public LocalDateTime lastCollect;

    @Column(name = "last_move")
    public LocalDateTime lastMove;
}
