package rest;

import dtos.BoatDTO;
import facades.BoatFacade;

import javax.annotation.security.RolesAllowed;
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

    @PUT
    @Path("Update")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void UpdateBoat(String jsonString){
        System.out.println(jsonString);
        BoatDTO dto = ApplicationConfig.GetGSON().fromJson(jsonString, BoatDTO.class);
        GetBoatFacade().update(dto);
    }

    @POST
    @Path("Add")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void AddBoat(String jsonInput){
        BoatDTO dto = ApplicationConfig.GetGSON().fromJson(jsonInput, BoatDTO.class);
        GetBoatFacade().create(dto);
    }
}
