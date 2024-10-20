package vn.edu.iuh.fit.week01_lab.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.week01_lab.entities.Account;

import java.util.List;

public class AccountRepository {
    private EntityManager em;
    private EntityTransaction et;

    public AccountRepository() {
        em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    public boolean insertAccount(Account account) {
        try {
            et.begin();
            em.persist(account);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateAccount(Account account) {
        try {
            et.begin();
            em.merge(account);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStatusDelete(String account_id) {
        String sql = "Update Account a set a.status = -1 where a.account_id = :account_id";
        try {
            et.begin();
            em.createQuery(sql)
                    .setParameter("account_id", account_id)
                    .executeUpdate();
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public List<Account> findAll(){
        return em.createNamedQuery("Account.findAll", Account.class).getResultList();
    }

    public Account findAccountById(String id) {
        return em.find(Account.class, id);
    }

    public List<Account> findAccountsByRole(String role) {
        try {
            return em.createNamedQuery("Account.findAccountsByRole", Account.class)
                    .setParameter("role_id", role)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account findAccountByIdPassword(String account_id, String password) {
        try {
            return em.createNamedQuery("Account.findAccountByIdPassword", Account.class)
                    .setParameter("account_id", account_id)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
