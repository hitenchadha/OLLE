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
import static com.infotech.olle.util.ApplicationConstants.ACCOUNTACTIVATE_URL;
import static com.infotech.olle.util.ApplicationConstants.GETCHILD_URL;
import static com.infotech.olle.util.ApplicationConstants.GETCONTACT_URL;
import static com.infotech.olle.util.ApplicationConstants.GETEMERGENCY_URL;
import static com.infotech.olle.util.ApplicationConstants.GETIDENTITY_URL;
import static com.infotech.olle.util.ApplicationConstants.GETSPOUSE_URL;
import static com.infotech.olle.util.ApplicationConstants.SIGNUP_URL;
import static com.infotech.olle.util.ApplicationConstants.UPDATECHILD_URL;
import static com.infotech.olle.util.ApplicationConstants.UPDATECONTACT_URL;
import static com.infotech.olle.util.ApplicationConstants.UPDATEEMERGENCY_URL;
import static com.infotech.olle.util.ApplicationConstants.UPDATEIDENTITY_URL;
import static com.infotech.olle.util.ApplicationConstants.UPDATESPOUSE_URL;
import static com.infotech.olle.util.ApplicationConstants.VALIDATEEMAIL_URL;
import static com.infotech.olle.util.ApplicationConstants.VALIDATEUSERNAME_URL;
import com.infotech.olle.util.ConsumeJSON;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Map;
import java.util.UUID;
import javax.faces.application.FacesMessage;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@ManagedBean(name = "profilecontroller")
@SessionScoped

public class ProfileController implements Serializable {
    @ManagedProperty(value = "#{profilemb}")
    private Profile profile;
    @ManagedProperty(value = "#{spousebean}")
    private Spouse spouse;
    @ManagedProperty(value = "#{identitybean}")
    private Identity identity;
    @ManagedProperty(value = "#{contactmb}") 
    private Contact contact;
    @ManagedProperty(value = "#{childbean}")
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
    
    // AJAX call from JSF page on blur event
    public boolean validateUserEmail() {
        try {
            String email = profile.getEmail().toUpperCase();
            if ((SessionBean.getEmail() != null) && (!SessionBean.getEmail().equals(profile.getEmail()))) {
                ConsumeJSON cjson = new ConsumeJSON(VALIDATEEMAIL_URL, email, false);
                String strJSONValue = cjson.getResult();
                JSONObject jObj = new JSONObject(strJSONValue);

                if (jObj.getString("r").equals("1")) {
                    FacesContext.getCurrentInstance()
                            .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Email taken: ", "Email is already in use. Please enter a different email."));
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            log.log(Level.SEVERE, "IO Exception: ", e.getMessage());
            return false;
        } catch (JSONException ex) {
            log.log(Level.SEVERE, "JSON Exception: ", ex.getMessage());
            try {
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Generic Error: ", "A general error occurred. Please try again later."));
            } catch (Exception e) {
                log.log(Level.SEVERE, "FacesContext Exception: ", e.getMessage());

            }
            return false;
        }
    }

    // AJAX call from JSF page on blur event
    public boolean validateUsername() {
        try {
            String username = profile.getUsername().toUpperCase();

            if (SessionBean.getUserId() == null) {
                ConsumeJSON cjson = new ConsumeJSON(VALIDATEUSERNAME_URL, username, false);

                String strJSONValue = cjson.getResult();
                JSONObject jObj = new JSONObject(strJSONValue);

                if (jObj.getString("r").equals("1")) {
                    FacesContext.getCurrentInstance()
                            .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Username taken: ", "Username is already in use. Please enter a different username."));
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            log.log(Level.SEVERE, "IO Exception: ", e.getMessage());
            return true;
        } catch (JSONException ex) {
            log.log(Level.SEVERE, "JSON Exception: ", ex.getMessage());
            try {
                FacesContext.getCurrentInstance()
                        .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Generic Error: ", "A general error occurred. Please try again later."));
            } catch (Exception e) {
                log.log(Level.SEVERE, "FacesContext Exception: ", e.getMessage());
                return true;
            }
            return true;
        }
    }
    
    public String createAccount() {
        String targetURI = "signup";
        try {
            // check if account with Email/Username exists
            if (validateUserEmail()) { // if false, it means email exists; Do not proceed!
                if (validateUsername()) { // if false, it means email exists; Do not proceed!
                    profile.setStatus(1);
                    profile.setActivationKey(UUID.randomUUID().toString());
                    // account.setCreateDate(new Date());
                    Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

                    String jsonProfile = gson.toJson(profile);

                    URL url = new URL(SessionBean.getRequest().getScheme()
                            + "://" + SessionBean.getRequest().getServerName()
                            + ":" + SessionBean.getRequest().getServerPort()
                            + SessionBean.getRequest().getContextPath()
                            + SIGNUP_URL);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");
                    OutputStream os = conn.getOutputStream();
                    os.write(jsonProfile.getBytes());
                    os.flush();
                    if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                        throw new RuntimeException(
                                "Failed : HTTP error code : "
                                + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader((conn.getInputStream())));
                    /*
                    String output;

                    while ((output = br.readLine()) != null) {
                        System.out.println(output);
                    }
                     */
                    conn.disconnect();
                    //account = new Account();
                    // Clear the sessionscoped values from the browser
                    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
                    return "activation.xhtml?faces-redirect=true";
                }
            }
        } catch (IOException | RuntimeException e) {
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);

        }
        return targetURI;
    }

    // Activate Account
    public String activateUserAccount() {

        String nextURL = "";
        try {
            String activationkey = account.getActivationKey();
            ConsumeJSON cjson = new ConsumeJSON(ACCOUNTACTIVATE_URL, activationkey, false);
            String strJSONValue = cjson.getResult();
            JSONObject jObj = new JSONObject(strJSONValue);

            switch (jObj.getString("r")) {
                case "1":
                    nextURL = "login.xhtml?faces-redirect=true";
                    break;
                case "2":
                    FacesContext.getCurrentInstance()
                            .addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            "Activation Key Expired: ",
                                            "Activation Key has expired. Please click here to request a new activation key."));
                    break;
                case "3":
                    FacesContext.getCurrentInstance()
                            .addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            "Account already activated: ",
                                            "Please click here to re-activate account."));
                    break;
                default:
                    FacesContext.getCurrentInstance()
                            .addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            "Invalid Activation Key: ",
                                            "Activation Key used by you is invalid. Please verify and try again."));
                    break;
            }
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception Logged: ", e.getMessage());
        } catch (JSONException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return nextURL;
    }
/*
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
*/
    public String preLoadIdentity() {

        try {
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
                Type objectType = new TypeToken<Identity>() {
                }.getType();
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
                Type objectType = new TypeToken<Spouse>() {
                }.getType();
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

    public String preLoadChild(String seq) {
          
        try {
            if (child.getUserid() == null) {
                log.info(seq);
                if (seq.equals("0")) {
                    Map<String, String> params = FacesContext.getCurrentInstance().
                            getExternalContext().getRequestParameterMap();
                    seq = params.get("p");
                }
                Gson gson = new GsonBuilder().create();
                String jsonChild = gson.toJson(account.getUserid());
                URL url = new URL(SessionBean.getRequest().getScheme()
                        + "://" + SessionBean.getRequest().getServerName()
                        + ":" + SessionBean.getRequest().getServerPort()
                        + SessionBean.getRequest().getContextPath()
                        + GETCHILD_URL + account.getUserid() + "/" + seq);
                
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
                Type objectType = new TypeToken<Child>() {
                }.getType();
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
        return "child.xhtml?p=" + seq + "&faces-redirect=true";
    }

    public String preLoadEmergency(String seq) {

        try {
            if (emergency.getUserid() == null) {
                if (seq.equals("0")) {
                    Map<String, String> params = FacesContext.getCurrentInstance().
                            getExternalContext().getRequestParameterMap();
                    seq = params.get("p");
                }
                Gson gson = new GsonBuilder().create();
                String jsonEmergency = gson.toJson(account.getUserid());
                URL url = new URL(SessionBean.getRequest().getScheme()
                        + "://" + SessionBean.getRequest().getServerName()
                        + ":" + SessionBean.getRequest().getServerPort()
                        + SessionBean.getRequest().getContextPath()
                        + GETEMERGENCY_URL + account.getUserid() + "/" + seq);
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
        return "emergency.xhtml?p=" + seq + "&faces-redirect=true";
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

            context.addMessage(null, new FacesMessage("Success: ", "You have updated your contact information!"));

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

            context.addMessage(null, new FacesMessage("Success: ", "You have updated your spouse information!"));

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

            context.addMessage(null, new FacesMessage("Success: ", "You have updated your identity information!"));

        } catch (IOException | RuntimeException e) {
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);

        }
    }

    public void updateChild() {

        try {
            Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

            String jsonAccount = gson.toJson(child);

            URL url = new URL(SessionBean.getRequest().getScheme()
                    + "://" + SessionBean.getRequest().getServerName()
                    + ":" + SessionBean.getRequest().getServerPort()
                    + SessionBean.getRequest().getContextPath()
                    + UPDATECHILD_URL);

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

            context.addMessage(null, new FacesMessage("Success: ", "You have updated your child information!"));

        } catch (IOException | RuntimeException e) {
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);

        }
    }

    public void updateEmergency() {

        try {
            log.info("Userid: " + emergency.getUserid() + " ~~ Seq Number: " + emergency.getSeqNumber());
            Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

            String jsonAccount = gson.toJson(emergency);

            URL url = new URL(SessionBean.getRequest().getScheme()
                    + "://" + SessionBean.getRequest().getServerName()
                    + ":" + SessionBean.getRequest().getServerPort()
                    + SessionBean.getRequest().getContextPath()
                    + UPDATEEMERGENCY_URL);

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

            context.addMessage(null, new FacesMessage("Success: ", "You have updated your emergency information!"));

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

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    
    

}
