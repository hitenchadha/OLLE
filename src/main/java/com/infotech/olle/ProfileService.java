package com.infotech.olle;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

// audit trail
public class ProfileService implements Serializable {

    private static final Logger log = Logger.getLogger(ProfileService.class.getName());
    private static final long serialVersionUID = 1L;
    public String r = "0";
    public String strMessage;
    public String userid;

    EntityManagerFactory emf;
    EntityManager em;

    // Constructor
    public ProfileService() {
        emf = Persistence.createEntityManagerFactory("OLLE");
        em = emf.createEntityManager();
        em.getTransaction().begin();

    }

    // Activate Account
    public String activateUserAccount(String activationkey, String ipaddress) {
        try {
            Query query = em.createNamedQuery("Account.findByActivationKey", Account.class).setParameter("activationKey", activationkey);
            List<Account> accountList = query.getResultList();
            for (Account account : accountList) {
                account.setStatus(2);
                em.persist(account);
                em.getTransaction().commit();
                r = "1";
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "activateAccount:{0}", e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return r;
    }

    // login
    public Contact getContactByUserID(Integer userid) throws Exception {
        Contact contact = new Contact();
        try {
            Query query = em.createNamedQuery("Contact.findByUserid", Contact.class).setParameter("userid", userid);
            List<Contact> contactList = query.getResultList();
            if (!contactList.isEmpty()) {
                contact = contactList.get(0);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "getContact:{0} - e.getMessage()", e);
            throw e;

        } finally {
            em.close();
            emf.close();
        }
        return contact;
    }
    
    public Identity getIdentityByUserID(Integer userid) throws Exception {
        Identity identity = new Identity();
        try {
            Query query = em.createNamedQuery("Identity.findByUserid", Identity.class).setParameter("userid", userid);
            List<Identity> identityList = query.getResultList();
            if (!identityList.isEmpty()) {
                identity = identityList.get(0);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "getIdentity:{0} - e.getMessage()", e);
            throw e;

        } finally {
            em.close();
            emf.close();
        }
        return identity;
    }
    
    public Spouse getSpouseByUserID(Integer userid) throws Exception {
        Spouse spouse = new Spouse();
        try {
            Query query = em.createNamedQuery("Spouse.findByUserid", Spouse.class).setParameter("userid", userid);
            List<Spouse> spouseList = query.getResultList();
            if (!spouseList.isEmpty()) {
                spouse = spouseList.get(0);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "getSpouse:{0} - e.getMessage()", e);
            throw e;

        } finally {
            em.close();
            emf.close();
        }
        return spouse;
    }
}
