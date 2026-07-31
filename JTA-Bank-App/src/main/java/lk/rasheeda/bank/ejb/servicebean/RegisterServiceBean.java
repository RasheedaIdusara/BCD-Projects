package lk.rasheeda.bank.ejb.servicebean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.rasheeda.bank.ejb.remote.RegisterService;

import java.rmi.RemoteException;

@Stateless
public class RegisterServiceBean implements RegisterService {

    @PersistenceContext(unitName = "JTA-Bank-PU")
    private EntityManager em;

    @Override
    public void register(String username, String email, String password) throws RemoteException {

    }
}
