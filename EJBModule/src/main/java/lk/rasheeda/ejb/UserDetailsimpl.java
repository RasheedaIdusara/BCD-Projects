package lk.rasheeda.ejb;

import jakarta.ejb.Stateless;
import lk.rasheeda.ejb.remote.UserDetails;

@Stateless
public class UserDetailsimpl implements UserDetails {

    @Override
    public String getUsername() {
        return "Rasheeda";
    }

    @Override
    public String getEmail() {
        return "Rasheeda@gmail.com";
    }
}
