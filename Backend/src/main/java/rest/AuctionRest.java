package rest;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.*;
import javax.ws.rs.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.AuctionDTO;
import dtos.BoatDTO;
import dtos.OwnerDTO;
import facades.AuctionFacade;
import utils.EMF_Creator;

import java.util.ArrayList;
import java.util.List;

@Path("Auction")
public class AuctionRest {
    private AuctionFacade auctionFacade;

    private AuctionFacade getAuctionFacade(){
        if(auctionFacade == null)
            auctionFacade = AuctionFacade.getAuctionFacade(ApplicationConfig.GetEMF());

        return auctionFacade;
    }

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        List<AuctionDTO> dtos = new ArrayList<>();
        for (AuctionDTO auctionDTO : getAuctionFacade().getAll())
            dtos.add(auctionDTO);

        return ApplicationConfig.GetGSON().toJson(dtos);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser() {
        String thisUser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisUser + "\"}";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Add")
    public void AddAuction(String jsonString){
        AuctionDTO dto = ApplicationConfig.GetGSON().fromJson(jsonString, AuctionDTO.class);
        System.out.println(dto);
        getAuctionFacade().create(dto);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Remove")
    public void RemoveAuction(String jsonString){
        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
        getAuctionFacade().DeleteByID(json.get("id").getAsLong());
    }
}