package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.common.api.request.MoveRequest;
import fr.epita.assistants.common.api.response.MoveResponse;
import fr.epita.assistants.common.utils.Point;
import fr.epita.assistants.item_producer.domain.service.MoveService;
import fr.epita.assistants.item_producer.domain.service.PlayerService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/move")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MoveResource {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response moveResponse(MoveRequest request) {
        if (PlayerService.getPlayer() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("there is no game").build();
        }
        if (request.getDirection() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("bad move request").build();
        }
        Point p = MoveService.moveplayer(request.direction);
        if (p == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("cant move there").build();
        }
        if (p.getPosX() == -1 && p.getPosY() == -1) {
            return Response.status(Response.Status.TOO_MANY_REQUESTS).entity("wait before moving").build();
        }
        MoveResponse moveResponse = new MoveResponse(p.getPosX(), p.getPosY());
        return Response.status(Response.Status.OK).entity(moveResponse).build();
    }
}
