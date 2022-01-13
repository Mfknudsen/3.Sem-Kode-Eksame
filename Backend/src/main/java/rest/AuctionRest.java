package rest;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.*;
import javax.ws.rs.*;

import dtos.AuctionDTO;
import dtos.BoatDTO;
import dtos.OwnerDTO;
import utils.EMF_Creator;

public class AuctionRest {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return "{\"msg\": \"Hello anonymous\"}";
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
    @Path("Populate")
    @RolesAllowed("admin")
    public void populateAndGetAuctions() {
        OwnerDTO ownerDTO = new OwnerDTO("popOwner", "12121212", "pop@popmail.pop");
    }
}