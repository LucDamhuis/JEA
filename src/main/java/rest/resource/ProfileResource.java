package rest.resource;

import business.ProfileService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/profiles")
@RequestScoped
public class ProfileResource {
    ProfileService profileService;

    @Inject
    public void setProfileService(ProfileService profileService){
        this.profileService = profileService;
    }

    @GET
    @Path("/{name}")
    @Produces("application/json")
    public Response getProfiles(@PathParam("name") String name){
        //todo make method restful & all that juicy stuff
        return Response.ok(profileService.getProfileByName(name)).build();

    }

    @GET
    @Produces("application/json")
    public Response getProfiles(){
        //todo make method restful & all that juicy stuff
        return Response.status(Response.Status.OK).entity(profileService.getProfileList()).build();
    }


}
