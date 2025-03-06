package fr.epita.assistants.item_producer.presentation.rest;

import fr.epita.assistants.common.aggregate.ItemAggregate;
import fr.epita.assistants.common.api.response.ItemsResponse;
import fr.epita.assistants.item_producer.data.model.ItemModel;
import fr.epita.assistants.item_producer.data.model.PlayerModel;
import fr.epita.assistants.item_producer.domain.service.ItemService;
import fr.epita.assistants.item_producer.domain.service.PlayerService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getInv() {
        PlayerModel player = PlayerService.getPlayer();
        if (player == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("aled").build();
        }
        List<ItemModel> list = ItemService.getInvlist();
        List<ItemsResponse.Items> biglist = new ArrayList<ItemsResponse.Items>();
        ItemsResponse.Items items;
        for (ItemModel model : list) {
            String type;
            if (model.getType() == ItemAggregate.ResourceType.GROUND)
            {
                type = "GROUND";
            }
            else if (model.getType() == ItemAggregate.ResourceType.ROCK)
            {
                type = "ROCK";
            }
            else if (model.getType() == ItemAggregate.ResourceType.WOOD)
            {
                type = "WOOD";
            }
            else if (model.getType() == ItemAggregate.ResourceType.MONEY)
            {
                type = "MONEY";
            }
            else if (model.getType() == ItemAggregate.ResourceType.WATER)
            {
                type = "WATER";
            }
            else {
                return null;
            }
            items = new ItemsResponse.Items(model.getId(), model.getQuantity(),type);
            biglist.add(items);
        }
        ItemsResponse response = new ItemsResponse(biglist);
        if (response.itemsResponse == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("aled").build();
        }
        return Response.status(Response.Status.OK).entity(response).build();
    }
}
