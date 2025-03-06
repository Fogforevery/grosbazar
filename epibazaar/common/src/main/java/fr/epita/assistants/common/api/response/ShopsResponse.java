package fr.epita.assistants.common.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ShopsResponse {
    List<Items> shops;

    @Value
    public static class Items {
        public int id;
        public float priceMultiplier;
        public float upgradePrice;
    }
}
