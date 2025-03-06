package fr.epita.assistants.common.api.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class StartResponse {
    public String[][] map;
    public StartResponse(String[][] map) {
        this.map = map;
    }
}
