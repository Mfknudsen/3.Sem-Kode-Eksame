package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.EMF_Creator;

import java.util.Set;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {
    private static EntityManagerFactory emf;
    private static Gson gson = new GsonBuilder().create();

    public static EntityManagerFactory GetEMF() {
        if (emf == null)
            emf = EMF_Creator.createEntityManagerFactory();

        return emf;
    }

    public static Gson GetGSON(){
        return gson;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(cors.CorsFilter.class);
        resources.add(errorhandling.API_ExceptionMapper.class);
        resources.add(errorhandling.GenericExceptionMapper.class);
        resources.add(org.glassfish.jersey.server.wadl.internal.WadlResource.class);

        resources.add(AuctionRest.class);

        resources.add(security.JWTAuthenticationFilter.class);
        resources.add(security.LoginEndpoint.class);
        resources.add(security.RolesAllowedFilter.class);
        resources.add(security.errorhandling.AuthenticationExceptionMapper.class);
        resources.add(security.errorhandling.NotAuthorizedExceptionMapper.class);
        //Insert new Rest Classes Here

        //
    }

}
