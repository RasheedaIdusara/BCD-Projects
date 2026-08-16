package lk.rasheeda.web.resource;

import jakarta.inject.Inject;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import jakarta.security.enterprise.identitystore.IdentityStoreHandler;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lk.rasheeda.web.model.LoginRequest;
import lk.rasheeda.web.util.JwtUtil;

import java.util.Map;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    private IdentityStoreHandler identityStoreHandler;

    public record LoginRequest(String username, String password) {} //jdk 16 above

    @Path("/login")
    @POST
    public Response login(LoginRequest loginRequest) {

        if (loginRequest == null || loginRequest.username == null || loginRequest.password == null) {

            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(Map.of("error","Missing UserName And Password"))
                    .build();

        }

        UsernamePasswordCredential credential =
                new UsernamePasswordCredential(loginRequest.username, loginRequest.password);

        CredentialValidationResult result = identityStoreHandler.validate(credential);

        if(result.getStatus() == CredentialValidationResult.Status.VALID) {

            String token = JwtUtil.genrateToken(
                    result.getCallerPrincipal().getName(),
                    result.getCallerGroups()
            );

            return  Response.status(Response.Status.OK).entity(
                    Map.of(
                            "token", token,
                            "username",result.getCallerPrincipal().getName(),
                            "roles", result.getCallerGroups()
                    )
            ).build();

        }

       return Response.status(Response.Status.UNAUTHORIZED).build();

    }

}
