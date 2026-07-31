package lk.rasheeda.bank.ejb.remote;

import jakarta.ejb.Local;

import java.rmi.RemoteException;

@Local
public interface RegisterService {
    void register(String username, String email, String password) throws RemoteException;
}
