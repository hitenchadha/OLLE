package com.infotech.olle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import com.infotech.olle.util.SessionBean;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import static com.infotech.olle.util.ApplicationConstants.GETCONTACT_URL;
import static com.infotech.olle.util.ApplicationConstants.GETIDENTITY_URL;
import static com.infotech.olle.util.ApplicationConstants.GETSPOUSE_URL;
import java.net.MalformedURLException;
import java.net.ProtocolException;

@ManagedBean(name = "profilecontroller")
@SessionScoped

public class ProfileController implements Serializable {
    @ManagedProperty(value = "#{spousebean}")
    private Spouse spouse;
    @ManagedProperty(value = "#{identitybean}")
    private Identity identity;
    @ManagedProperty(value = "#{contactbean}")
    private Contact contact;
    @ManagedProperty(value = "#{accountbean}")
    private Account account;
    private static final Logger log = Logger.getLogger(AccountController.class.getName());
    private static final long serialVersionUID = 1L;
    public boolean r;

    public ProfileController() {

    }

    public String preLoadContact() {

        try {
            // get Contact Object
            if (contact.getUserid() == null) {

                Gson gson = new GsonBuilder().create();
                String jsonContact = gson.toJson(account.getUserid());
                URL url = new URL(SessionBean.getRequest().getScheme()
                        + "://" + SessionBean.getRequest().getServerName()
                        + ":" + SessionBean.getRequest().getServerPort()
                        + SessionBean.getRequest().getContextPath()
                        + GETCONTACT_URL + account.getUserid());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                OutputStream os = conn.getOutputStream();
                os.write(jsonContact.getBytes());
                os.flush();

                if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                    throw new RuntimeException(
                            "Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                StringBuilder jsonAPIResponse = new StringBuilder();
                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    jsonAPIResponse.append(output);
                }
                conn.disconnect();
                Type objectType = new TypeToken<Contact>() {
                }.getType();
                setContact((Contact) gson.fromJson(jsonAPIResponse.toString(), objectType));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("contactbean", contact);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "contact.xhtml?faces-redirect=true";
    }
    
    public String preLoadIdentity() {

        try {
            // get Contact Object
            if (identity.getUserid() == null) {

                Gson gson = new GsonBuilder().create();
                String jsonIdentity = gson.toJson(account.getUserid());
                URL url = new URL(SessionBean.getRequest().getScheme()
                        + "://" + SessionBean.getRequest().getServerName()
                        + ":" + SessionBean.getRequest().getServerPort()
                        + SessionBean.getRequest().getContextPath()
                        + GETIDENTITY_URL + account.getUserid());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                OutputStream os = conn.getOutputStream();
                os.write(jsonIdentity.getBytes());
                os.flush();

                if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                    throw new RuntimeException(
                            "Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                StringBuilder jsonAPIResponse = new StringBuilder();
                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    jsonAPIResponse.append(output);
                }
                conn.disconnect();
                Type objectType = new TypeToken<Identity>() {}.getType();
                setIdentity((Identity) gson.fromJson(jsonAPIResponse.toString(), objectType));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("identitybean", identity);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "identity.xhtml?faces-redirect=true";
    }
    
    public String preLoadSpouse() {

        try {
            // get Contact Object
            if (contact.getUserid() == null) {

                Gson gson = new GsonBuilder().create();
                String jsonSpouse = gson.toJson(account.getUserid());
                URL url = new URL(SessionBean.getRequest().getScheme()
                        + "://" + SessionBean.getRequest().getServerName()
                        + ":" + SessionBean.getRequest().getServerPort()
                        + SessionBean.getRequest().getContextPath()
                        + GETSPOUSE_URL + account.getUserid());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                OutputStream os = conn.getOutputStream();
                os.write(jsonSpouse.getBytes());
                os.flush();

                if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                    throw new RuntimeException(
                            "Failed : HTTP error code : "
                            + conn.getResponseCode());
                }
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                StringBuilder jsonAPIResponse = new StringBuilder();
                String output;
                while ((output = br.readLine()) != null) {
                    System.out.println(output);
                    jsonAPIResponse.append(output);
                }
                conn.disconnect();
                Type objectType = new TypeToken<Spouse>() {
                }.getType();
                setSpouse((Spouse) gson.fromJson(jsonAPIResponse.toString(), objectType));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("spousebean", spouse);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "spouse.xhtml?faces-redirect=true";
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
    
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
    
    public void setSpouse(Spouse spouse) {
        this.spouse = spouse;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}