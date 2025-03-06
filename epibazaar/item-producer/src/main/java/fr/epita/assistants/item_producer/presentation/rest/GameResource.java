package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.common.api.request.StartRequest;
import fr.epita.assistants.common.api.response.StartResponse;
import fr.epita.assistants.common.command.ResetInventoryCommand;
import fr.epita.assistants.item_producer.domain.service.GameService;
import fr.epita.assistants.item_producer.domain.service.PlayerService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import jakarta.inject.Inject;
import java.io.FileNotFoundException;

@Path("/start")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GameResource {
    @Inject
    GameService gameService;

    @Inject
    @Channel("reset-inventory-command")
    Emitter<ResetInventoryCommand> resetInventoryCommandEmitter;

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response startResponse(StartRequest request) {
            String[][] map = GameService.newGame(request.getMapPath());
            PlayerService.newplayer();
            if (map == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("chemin invalide").build();
            }
            StartResponse startResponse = new StartResponse(map);
            resetInventoryCommandEmitter.send(new ResetInventoryCommand());
            return Response.status(Response.Status.OK).entity(startResponse).build();
    }
}
