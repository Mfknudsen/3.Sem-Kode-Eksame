package rest;

import dtos.BoatDTO;
import facades.BoatFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("Boat")
public class BoatRest {
    private BoatFacade boatFacade;

    private BoatFacade GetBoatFacade(){
        if(boatFacade == null)
            boatFacade =  BoatFacade.getBoatFacade(ApplicationConfig.GetEMF());

        return boatFacade;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        return "Hej";
    }

    @POST
    @Path("AddBoat")
    @Consumes(MediaType.APPLICATION_JSON)
    public void AddBoat(String jsonInput){
        BoatDTO dto = ApplicationConfig.GetGSON().fromJson(jsonInput, BoatDTO.class);
        GetBoatFacade().create(dto);
    }
}
