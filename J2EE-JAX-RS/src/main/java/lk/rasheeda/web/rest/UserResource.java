package lk.rasheeda.web.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lk.rasheeda.model.User;

import java.util.List;

@Path("/user")
//@Consumes({MediaType.APPLICATION_JSON})
//@Produces({MediaType.APPLICATION_JSON})
public class UserResource {

    @Path("ID")
    @GET
    public String m(@QueryParam("name") String name, @QueryParam("age")  int age) {
        return "Name: " + name +"and Age: " + age;
    }

    @Path("/nic")
    @GET
    public String nic(@QueryParam("orderBy") List<String> orderBy, @DefaultValue("0") @QueryParam("age")  int age) {
        return "OrderBy: " + orderBy.toString() +" and Age: " + age;
    }

    @Path("post")
    @POST
    public String post(@FormParam("name")  String name) {
        return "Name: " + name ;
    }

    @POST
    public String form(@BeanParam User user) {
        return "User: " + user.getName() + "And Age: " + user.getAge() ;
    }

}
