package lk.rasheeda.jta.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lk.rasheeda.jta.entity.Account;

@Stateless
public class AccountBeanimpl implements AccountBean {

    @PersistenceContext(unitName = "JTA-PU")
    private EntityManager em;

    @Override
    public void creditAmount(Integer accountNumber, Double amount) {

        try {

            Account account = em.createQuery("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber",
                    Account.class).setParameter("accountNumber", accountNumber).getSingleResult();

            account.setBalance(account.getBalance() + amount);

        } catch (NoResultException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void debitAmount(Integer accountNumber, Double amount) {

        try {

            Account account = (Account) em.createNamedQuery("Account.findbyAccountNo")
                    .setParameter("accountNumber", accountNumber).getSingleResult();

            account.setBalance(account.getBalance() - amount);

        }catch (NoResultException e){
            e.printStackTrace();
        }

    }
}
