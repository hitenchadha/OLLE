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

    EntityManagerFactory emf;
    EntityManager em;

    // Constructor
    public ProfileService() {
        emf = Persistence.createEntityManagerFactory("OLLE");
        em = emf.createEntityManager();
        em.getTransaction().begin();

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
    
    public Child getChildByUserIDSeqNumber(Integer userid, Integer seqNumber) throws Exception {
        Child child = new Child();
        try {
            Query query = em.createNamedQuery("Child.findByUserIDSeqNumber", Child.class).setParameter("userid", userid).setParameter("seqNumber", seqNumber);
            List<Child> childList = query.getResultList();
            if (!childList.isEmpty()) {
                child = childList.get(0);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "getChild:{0} - e.getMessage()", e);
            throw e;

        } finally {
            em.close();
            emf.close();
        }
        return child;
    }
    
    public Emergency getEmergencyByUserIDSeqNumber(Integer userid, Integer seqNumber) throws Exception {
        Emergency emergency = new Emergency();
        try {
            Query query = em.createNamedQuery("Emergency.findByUserIDSeqNumber", Emergency.class).setParameter("userid", userid).setParameter("seqNumber", seqNumber);
            List<Emergency> emergencyList = query.getResultList();
            if (!emergencyList.isEmpty()) {
                emergency = emergencyList.get(0);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "getEmergency:{0} - e.getMessage()", e);
            throw e;

        } finally {
            em.close();
            emf.close();
        }
        return emergency;
    }
    
    public boolean updateContact (Contact contact) {
        try {
            em.merge(contact);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            log.log(Level.INFO, "updateContact: {0}",e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public boolean updateSpouse (Spouse spouse) {
        try {
            em.merge(spouse);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            log.log(Level.INFO, "updateSpouse: {0}",e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }
        
    public boolean updateIdentity (Identity identity) {
        try {
            em.merge(identity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            log.log(Level.INFO, "updateIdentity: {0}",e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }
    
    public boolean updateChild (Child child) {
        try {
            em.merge(child);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            log.log(Level.INFO, "updateChild: {0}",e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }
    
     public boolean updateEmergency (Emergency emergency) {
        try {
            em.merge(emergency);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            log.log(Level.INFO, "updateEmergency: {0}",e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }
}
