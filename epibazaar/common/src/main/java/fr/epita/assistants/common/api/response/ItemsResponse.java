package fr.epita.assistants.common.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemsResponse {
    public List<Items> itemsResponse;

    @Value
    public static class Items {
        public int id;
        public float quantity;
        public String type;
    }
}
