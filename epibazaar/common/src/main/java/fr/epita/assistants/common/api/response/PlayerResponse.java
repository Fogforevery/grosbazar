package fr.epita.assistants.common.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PlayerResponse {
    public int posX;
    public int posY;
    public LocalDateTime lastMove;
    public LocalDateTime lastCollect;
    public float moveSpeedMultiplier;
    public float staminaMultiplier;
    public float collectRateMultiplier;
}
