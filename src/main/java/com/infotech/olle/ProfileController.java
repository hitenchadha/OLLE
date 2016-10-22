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
import static com.infotech.olle.util.ApplicationConstants.GETCHILD_URL;
import static com.infotech.olle.util.ApplicationConstants.GETCONTACT_URL;
import static com.infotech.olle.util.ApplicationConstants.GETEMERGENCY_URL;
import static com.infotech.olle.util.ApplicationConstants.GETIDENTITY_URL;
import static com.infotech.olle.util.ApplicationConstants.GETSPOUSE_URL;
import static com.infotech.olle.util.ApplicationConstants.UPDATECONTACT_URL;
import static com.infotech.olle.util.ApplicationConstants.UPDATEIDENTITY_URL;
import static com.infotech.olle.util.ApplicationConstants.UPDATESPOUSE_URL;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import javax.faces.application.FacesMessage;

@ManagedBean(name = "profilecontroller")
@SessionScoped

public class ProfileController implements Serializable {
    @ManagedProperty(value = "#{spousebean}")
    private Spouse spouse;
    @ManagedProperty(value = "#{identitybean}")
    private Identity identity;
    @ManagedProperty(value = "#{contactbean}")
    private Contact contact;
    @ManagedProperty(value = "#{childtbean}")
    private Child child;
    @ManagedProperty(value = "#{emergencybean}")
    private Emergency emergency;
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
            if (spouse.getUserid() == null) {

                Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
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
                Type objectType = new TypeToken<Spouse>() {}.getType();
                log.info("Reached here");
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
    
    public String preLoadChild() {

        try {
            // get Contact Object
            if (child.getUserid() == null) {

                Gson gson = new GsonBuilder().create();
                String jsonChild = gson.toJson(account.getUserid());
                URL url = new URL(SessionBean.getRequest().getScheme()
                        + "://" + SessionBean.getRequest().getServerName()
                        + ":" + SessionBean.getRequest().getServerPort()
                        + SessionBean.getRequest().getContextPath()
                        + GETCHILD_URL + account.getUserid());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                OutputStream os = conn.getOutputStream();
                os.write(jsonChild.getBytes());
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
                Type objectType = new TypeToken<Child>() {}.getType();
                setChild((Child) gson.fromJson(jsonAPIResponse.toString(), objectType));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("childbean", child);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "child.xhtml?faces-redirect=true";
    }
    
    public String preLoadEmergency() {

        try {
            // get Contact Object
            if (emergency.getUserid() == null) {

                Gson gson = new GsonBuilder().create();
                String jsonEmergency = gson.toJson(account.getUserid());
                URL url = new URL(SessionBean.getRequest().getScheme()
                        + "://" + SessionBean.getRequest().getServerName()
                        + ":" + SessionBean.getRequest().getServerPort()
                        + SessionBean.getRequest().getContextPath()
                        + GETEMERGENCY_URL + account.getUserid());
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/json");
                OutputStream os = conn.getOutputStream();
                os.write(jsonEmergency.getBytes());
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
                Type objectType = new TypeToken<Emergency>() {
                }.getType();
                setEmergency((Emergency) gson.fromJson(jsonAPIResponse.toString(), objectType));
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("emergencybean", emergency);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "emergency.xhtml?faces-redirect=true";
    }
    
    public void updateContact() {

        try {
                    Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

                    String jsonAccount = gson.toJson(contact);

                    URL url = new URL(SessionBean.getRequest().getScheme()
                            + "://" + SessionBean.getRequest().getServerName()
                            + ":" + SessionBean.getRequest().getServerPort()
                            + SessionBean.getRequest().getContextPath()
                            + UPDATECONTACT_URL);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("PUT");
                    conn.setRequestProperty("Content-Type", "application/json");
                    OutputStream os = conn.getOutputStream();
                    os.write(jsonAccount.getBytes());
                    os.flush();
                    if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                        throw new RuntimeException(
                                "Failed : HTTP error code : "
                                + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader((conn.getInputStream())));
                    conn.disconnect();
                    FacesContext context = FacesContext.getCurrentInstance();

                    context.addMessage(null, new FacesMessage("Successful", "Success: " + "You have successfully updated your contact information."));
                
            
        } catch (IOException | RuntimeException e) {
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);

        }
    }
    
    public void updateSpouse() {

        try {
                    Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

                    String jsonAccount = gson.toJson(spouse);

                    URL url = new URL(SessionBean.getRequest().getScheme()
                            + "://" + SessionBean.getRequest().getServerName()
                            + ":" + SessionBean.getRequest().getServerPort()
                            + SessionBean.getRequest().getContextPath()
                            + UPDATESPOUSE_URL);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("PUT");
                    conn.setRequestProperty("Content-Type", "application/json");
                    OutputStream os = conn.getOutputStream();
                    os.write(jsonAccount.getBytes());
                    os.flush();
                    if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                        throw new RuntimeException(
                                "Failed : HTTP error code : "
                                + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader((conn.getInputStream())));
                    conn.disconnect();
                    FacesContext context = FacesContext.getCurrentInstance();

                    context.addMessage(null, new FacesMessage("Successful", "Success: " + "You have successfully updated your spouse information."));
                
            
        } catch (IOException | RuntimeException e) {
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);

        }
    }
    
    public void updateIdentity() {

        try {
                    Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

                    String jsonAccount = gson.toJson(identity);

                    URL url = new URL(SessionBean.getRequest().getScheme()
                            + "://" + SessionBean.getRequest().getServerName()
                            + ":" + SessionBean.getRequest().getServerPort()
                            + SessionBean.getRequest().getContextPath()
                            + UPDATEIDENTITY_URL);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("PUT");
                    conn.setRequestProperty("Content-Type", "application/json");
                    OutputStream os = conn.getOutputStream();
                    os.write(jsonAccount.getBytes());
                    os.flush();
                    if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                        throw new RuntimeException(
                                "Failed : HTTP error code : "
                                + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader((conn.getInputStream())));
                    conn.disconnect();
                    FacesContext context = FacesContext.getCurrentInstance();

                    context.addMessage(null, new FacesMessage("Successful", "Success: " + "You have successfully updated your identity information."));
                
            
        } catch (IOException | RuntimeException e) {
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);

        }
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

    public void setChild(Child child) {
        this.child = child;
    }
    
    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }
    
    public void setAccount(Account account) {
        this.account = account;
    }

}
