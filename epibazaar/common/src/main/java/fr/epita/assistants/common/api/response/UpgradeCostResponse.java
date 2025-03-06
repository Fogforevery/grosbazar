package fr.epita.assistants.common.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpgradeCostResponse {
    public float upgradeCollectCost;
    public float upgradeMoveCost;
    public float upgradeStaminaCost;
}
