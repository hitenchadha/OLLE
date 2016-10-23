package com.infotech.olle;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.infotech.olle.Contact;
import com.infotech.olle.util.UserSession;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

// mobile phone activation
// assign roles if account created via invitation
// audit trail
public class AccountService implements Serializable {

    private static final Logger log = Logger.getLogger(AccountService.class.getName());
    private static final long serialVersionUID = 1L;
    public String r = "0";
    public String strMessage;
    public String userid;
    public String firstname;
    public String lastname;
    public String email;
    public String phone;
    public String username;
    public String forgot;

    EntityManagerFactory emf;
    EntityManager em;

    // Constructor
    public AccountService() {
        emf = Persistence.createEntityManagerFactory("OLLE");
        em = emf.createEntityManager();
        em.getTransaction().begin();

    }

    // create Account
    public boolean createUserAccount(Account account) {
        try {
            em.persist(account);
            em.getTransaction().commit();

            Contact contact = new Contact();
            contact.setUserid(account.getUserid());
            contact.setMobilePhone(account.getPhone());
            em.getTransaction().begin();
            em.persist(contact);
            em.getTransaction().commit();
            Spouse spouse = new Spouse();
            spouse.setUserid(account.getUserid());
            em.getTransaction().begin();
            em.persist(spouse);
            em.getTransaction().commit();
            Identity identity = new Identity();
            identity.setUserid(account.getUserid());
            em.getTransaction().begin();
            em.persist(identity);
            em.getTransaction().commit();
            Child child = new Child();
            child.setUserid(account.getUserid());
            em.getTransaction().begin();
            em.persist(child);
            em.getTransaction().commit();
            Emergency emergency = new Emergency();
            emergency.setUserid(account.getUserid());
            em.getTransaction().begin();
            em.persist(emergency);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            log.log(Level.SEVERE, "createAccount:{0}", e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
        return true;
    }

    // delete Account
    public boolean deleteUserAccount(Integer userid, String ipaddress) {
        try {
            Account account = em.find(Account.class, userid);
            em.remove(account);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            log.log(Level.SEVERE, "deleteAccount:{0}", e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }

    // update Account
    public boolean manageUserAccount(Integer userid, String attribute, String value, String ipaddress) {
        try {
            Account account = em.find(Account.class, userid);
            switch (attribute) {
                case "firstname":
                    account.setFirstName(value);
                    break;
                case "lastname":
                    account.setLastName(value);
                    break;
                case "email":
                    account.setEmail(value);
                    break;
                case "phone":
                    account.setPhone(value);
                    break;
                default:
                    break;
            }

            em.persist(account);
            em.getTransaction().commit();
            r = "1";
            return true;
        } catch (Exception e) {
            log.log(Level.SEVERE, "updateAccount:{0}", e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }

    //Manage User Account
    public boolean manageUserAccount(Account account) {
        try {
            em.merge(account);
            em.getTransaction().commit();
            r = "1";
            return true;
        } catch (Exception e) {
            log.log(Level.INFO, "manageUserAccount: {0}", e.getMessage());
            return false;
        } finally {
            em.close();
            emf.close();
        }
    }

    // Validate Email
    public String validateUserEmail(String emailaddress, String ipaddress) {
        try {
            Query query = em.createNamedQuery("Account.findByEmail", Account.class).setParameter("email", emailaddress);
            Long l = (Long) query.getSingleResult();
            if (l.intValue() == 1) {
                r = "1";
            }
            return r;
        } catch (Exception e) {
            log.log(Level.SEVERE, "validateEmailaddress:{0}", e.getMessage());
            return r;
        } finally {
            em.close();
            emf.close();
        }
    }

    // validate Username
    public String validateUsername(String username, String ipaddress) {
        log.log(Level.INFO, "Username PASSED: {0}", username);
        try {
            Query query = em.createNamedQuery("Account.findByUsername", Account.class).setParameter("username", username);
            Long l = (Long) query.getSingleResult();
            if (l.intValue() == 1) {
                r = "1";
            }
            return r;
        } catch (Exception e) {
            log.log(Level.SEVERE, "validateUsername:{0}", e.getMessage());
            return r;
        } finally {
            em.close();
            emf.close();
        }
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
            }
            return r = "1";
        } catch (Exception e) {
            log.log(Level.SEVERE, "activateAccount:{0}", e.getMessage());
            return r;
        } finally {
            em.close();
            emf.close();
        }
    }

    // login
    public UserSession authenticateUser(UserCredentials authenticate) throws Exception {
        UserSession uSession = new UserSession();
        try {
            String username = authenticate.getUsername();
            String password = authenticate.getPassword();

            Query query = em.createNamedQuery("Account.findByUsernamePassword", Account.class).setParameter("password", password).setParameter("username", username);
            log.info(username + " " + password);
            List<Account> accountList = query.getResultList();
            if (!accountList.isEmpty()) {
                Account account = accountList.get(0);
                uSession.setUserId(account.getUserid());
                uSession.setAccount(account);
            }
        } catch (Exception e) {
            log.log(Level.SEVERE, "authenticateUser:{0} - e.getMessage()", e);
            throw e;

        } finally {
            em.close();
            emf.close();
        }
        return uSession;
    }

    // get Account by userid
    public Account getUserAccountByUserID(String userid, String ipaddress) {
        Account a = new Account();
        return a;
    }

    // forgotcredentials
    public void getForgotCredentials(String emailaddress, String ipaddress) {

    }

    /*
        public void getForgotCredentials(String emailaddress) {

		PersistenceManagerFactory PMF = JDOHelper
				.getPersistenceManagerFactory("transactions-optional");
		PersistenceManager pm = PMF.getPersistenceManager();
		Query q = pm.newQuery(Account.class);
		q.setFilter("emailaddress == '" + emailaddress + "'");

		try {

			List<Account> results = (List<Account>) q.execute();

			Account account = (Account) results.iterator().next();
			String firstname = account.getFirstname();
			String lastname = account.getLastname();
			
			strMessage="{\"firstname\":\"" + firstname + "\","
			+ "\"lastname\":\"" + lastname + "\"}";
			
			r = "1";

			//
			 // if (!results.isEmpty()) { // Process result p; Username password
			 // matched // THINGS TO DO: Check if the account is Active .. ie
			 // value should be 2
			 // System.getProperty("Active").equals(results.get) r = 1;
			 // strMessage = "SUCCESS"; } else { // Account not found }
			 //
			// Write audit code; make r=1 and use the strMessage
		} catch (Exception e) {
			log.warning("User not found");

		} finally {
			//
			 // ManageDateTime manageDateTime = new ManageDateTime(); Audit audit
			// = new Audit(); audit.createEntry(userName, "Authenticate",
			 // "Login", strMessage, manageDateTime.getCurrentDateTime(),
			 // ipAddress); pm.makePersistent(audit);
			 //
			q.closeAll();
			pm.close();
			PMF.close();
		}

	}
     */
    public String getHashPhone(String emailaddress) {
        return r = "1";
    }
    /*
        public String getHashPhone(String emailaddress) {
		PersistenceManagerFactory PMF = JDOHelper
				.getPersistenceManagerFactory("transactions-optional");
		PersistenceManager pm = PMF.getPersistenceManager();
		Query q = pm.newQuery(Account.class);
		q.setFilter("emailaddress == '" + emailaddress.trim() + "'");
		try {
			List<Account> results = (List<Account>) q.execute();
			if (!results.isEmpty()) {
				r = "1";
				Account account = (Account) results.iterator().next();
				strMessage = "XXX-XXX-" + account.getMobilePhone().substring(10);
			} else
				r = "0";
		} catch (Exception e) {
			log.severe(e.getMessage());
		} finally {
			q.closeAll();
			pm.close();
			PMF.close();
		}
		return emailaddress;
	}
     */
}
