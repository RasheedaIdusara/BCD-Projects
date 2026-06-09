package lk.rasheeda.web;

import jakarta.ejb.Remote;

@Remote
public interface Cal {
    void getResult(int i1, int i2);
}
