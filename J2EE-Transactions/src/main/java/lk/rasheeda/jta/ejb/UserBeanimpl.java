package lk.rasheeda.jta.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.rasheeda.jta.entity.User;

@Stateless
public class UserBeanimpl implements UserBean {

    @PersistenceContext(unitName = "JTA-PU")
    private EntityManager em;

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean register(String email, String name, String password) {

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        em.persist(user);

        return true;
    }
}
