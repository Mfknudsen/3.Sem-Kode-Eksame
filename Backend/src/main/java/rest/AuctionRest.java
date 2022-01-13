package rest;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.*;
import javax.ws.rs.*;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.AuctionDTO;
import dtos.BoatDTO;
import dtos.OwnerDTO;
import entities.*;
import facades.AuctionFacade;
import utils.EMF_Creator;

import java.util.ArrayList;
import java.util.List;

@Path("Auction")
public class AuctionRest {
    private AuctionFacade auctionFacade;

    private AuctionFacade getAuctionFacade() {
        if (auctionFacade == null)
            auctionFacade = AuctionFacade.getAuctionFacade(ApplicationConfig.GetEMF());

        return auctionFacade;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String Populate() {
        EntityManager em = ApplicationConfig.GetEMF().createEntityManager();
        Auction a1 = new Auction("a1","a1","a1","a1"),
                a2 = new Auction("a2","a2","a2","a2"),
                a3 = new Auction("a3","a3","a3","a3");
        Boat b1 = new Boat("boat 1", "brand 1", "make 1", "year 1", "url 1"),
                b2 = new Boat("boat 2", "brand 2", "make 2", "year 2", "url 2");
        Owner o1 = new Owner("owner1", "phone1", "mail1");
        User u1 = new User("user", "user"), u2 = new User("admin", "admin");
        Role r1 = new Role("user"), r2 = new Role("admin");

        u1.addRole(r1);
        u2.addRole(r2);
        b1.setAuction(a2);
        b2.setAuction(a1);
        b1.setOwner(o1);
        b2.setOwner(o1);
        b1.setAuction(a1);
        b2.setAuction(a3);

        try {
            em.getTransaction().begin();
            em.persist(a1);
            em.persist(a2);
            em.persist(a3);
            em.persist(b1);
            em.persist(b2);
            em.persist(o1);
            em.persist(u1);
            em.persist(u2);
            em.persist(r1);
            em.persist(r2);
            em.getTransaction().commit();
        } catch (Exception e) {
            return e.getMessage();
        }


        return "Populated";
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
    public void AddAuction(String jsonString) {
        AuctionDTO dto = ApplicationConfig.GetGSON().fromJson(jsonString, AuctionDTO.class);
        System.out.println(dto);
        getAuctionFacade().create(dto);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("Remove")
    public void RemoveAuction(String jsonString) {
        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
        getAuctionFacade().DeleteByID(json.get("id").getAsLong());
    }
}