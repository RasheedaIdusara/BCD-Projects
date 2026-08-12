package lk.rasheeda.web.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class User {

    @Path("ID")
    @GET
    public String m(@QueryParam("name") String name) {
        return "Name: " + name;
    }

    @Path("/nic")
    @GET
    public String nic(){
        return "nic";
    }

    @GET
    public String put(){
        return "put";
    }

}
