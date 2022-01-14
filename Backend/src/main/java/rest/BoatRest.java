package rest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.BoatDTO;
import facades.BoatFacade;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("Boat")
public class BoatRest {
    private BoatFacade boatFacade;

    private BoatFacade GetBoatFacade() {
        if (boatFacade == null)
            boatFacade = BoatFacade.getBoatFacade(ApplicationConfig.GetEMF());

        return boatFacade;
    }

    @PUT
    @RolesAllowed("user")
    @Consumes
    @Produces(MediaType.APPLICATION_JSON)
    public String get(String jsonString) {
        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
        return ApplicationConfig.GetGSON().toJson(GetBoatFacade().getByOwned(json.get("id").getAsLong()));
    }

    @PUT
    @Path("UpdateOwner")
    @RolesAllowed("admin")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateOwner(String jsonString) {
        JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
        GetBoatFacade().updateOwner(json.get("boat").getAsLong(), json.get("owner").getAsLong());
    }

    @PUT
    @Path("Update")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void UpdateBoat(String jsonString) {
        BoatDTO dto = ApplicationConfig.GetGSON().fromJson(jsonString, BoatDTO.class);
        GetBoatFacade().update(dto);
    }

    @POST
    @Path("Add")
    @RolesAllowed("user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void AddBoat(String jsonInput) {
        BoatDTO dto = ApplicationConfig.GetGSON().fromJson(jsonInput, BoatDTO.class);
        GetBoatFacade().create(dto);
    }
}
