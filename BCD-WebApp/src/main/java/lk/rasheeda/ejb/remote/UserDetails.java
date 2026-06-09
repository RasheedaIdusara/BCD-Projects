package lk.rasheeda.ejb.remote;

import jakarta.ejb.Remote;

@Remote
public interface UserDetails {
    String getUsername();
    String getEmail();
}
