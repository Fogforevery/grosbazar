package fr.epita.assistants.common.api.request;

import lombok.Value;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemsRequest {
    public List<Items> itemsRequest;

    @Value
    public static class Items {
        public float quantity;
        public String type;
    }
}
