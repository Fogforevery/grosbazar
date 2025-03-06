package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.item_producer.data.model.PlayerModel;
import fr.epita.assistants.item_producer.domain.service.PlayerService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.io.FileNotFoundException;

@Path("/player")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlayerResource {

    @GET
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response startResponse() throws FileNotFoundException {
        PlayerModel player = PlayerService.getPlayer();
        if (player == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("aled").build();
        }
        return Response.status(Response.Status.OK).entity(player).build();
    }
}