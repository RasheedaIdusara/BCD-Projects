package lk.rasheeda.web.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.security.enterprise.AuthenticationException;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.authentication.mechanism.http.HttpAuthenticationMechanism;
import jakarta.security.enterprise.authentication.mechanism.http.HttpMessageContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ApplicationScoped
public class JWTAuthMechnisam implements HttpAuthenticationMechanism {
    @Override
    public AuthenticationStatus validateRequest
            (HttpServletRequest request, HttpServletResponse response,
             HttpMessageContext context)
            throws AuthenticationException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            //Validate Token
        }



        return null;
    }
}
