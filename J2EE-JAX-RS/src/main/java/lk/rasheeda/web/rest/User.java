package lk.rasheeda.web.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/user")
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
