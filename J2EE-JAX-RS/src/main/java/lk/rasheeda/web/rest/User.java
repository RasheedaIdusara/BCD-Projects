package lk.rasheeda.web.rest;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class User {

    @Path("ID")
    @GET
    public String m(){
        return "ID";
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
