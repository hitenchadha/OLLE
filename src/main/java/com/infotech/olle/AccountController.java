package com.infotech.olle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static com.infotech.olle.util.ApplicationConstants.ACCOUNTACTIVATE_URL;
import static com.infotech.olle.util.ApplicationConstants.LOGIN_URL;
import static com.infotech.olle.util.ApplicationConstants.MANAGEACCOUNT_URL;
import static com.infotech.olle.util.ApplicationConstants.SIGNUP_URL;
import static com.infotech.olle.util.ApplicationConstants.VALIDATEEMAIL_URL;
import static com.infotech.olle.util.ApplicationConstants.VALIDATEUSERNAME_URL;

import java.io.Serializable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.UUID;
import java.util.logging.Logger;
import java.util.logging.Level;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONException;

import com.infotech.olle.util.ConsumeJSON;
import com.infotech.olle.util.Mail;
import com.infotech.olle.util.SessionBean;
import com.infotech.olle.util.UserSession;
import java.util.Date;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

@ManagedBean(name = "accountcontroller")
@SessionScoped

public class AccountController implements Serializable {

    @ManagedProperty(value = "#{accountbean}")

    private Account account;

    private static final Logger log = Logger.getLogger(AccountController.class.getName());
    private static final long serialVersionUID = 1L;
    public boolean r;
    private String forgot;

    /**
     * * TO DO **
     */
    // mobile phone activation
    // assign roles if account created via invitation
    // audit trail
    // mail services
    public AccountController() {

    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getForgot() {
        return forgot;
    }

    public void setUserid(String forgot) {
        this.forgot = forgot;
    }

    // AJAX call from JSF page on blur event
    public boolean validateUserEmail() {
        try {
            String email = account.getEmail().toUpperCase();
            if ((SessionBean.getEmail() != null) && (!SessionBean.getEmail().equals(account.getEmail()))) {
                ConsumeJSON cjson = new ConsumeJSON(VALIDATEEMAIL_URL, email, false);
                String strJSONValue = cjson.getResult();
                JSONObject jObj = new JSONObject(strJSONValue);

                if (jObj.getString("r").equals("1")) {
                    FacesContext.getCurrentInstance()
                            .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Email taken:", "Email is already in use. Please enter a different email."));
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
                                "Generic Error:", "A general error occurred. Please try again later."));
            } catch (Exception e) {
                log.log(Level.SEVERE, "FacesContext Exception: ", e.getMessage());

            }
            return false;
        }
    }

    // AJAX call from JSF page on blur event
    public boolean validateUsername() {
        try {
            String username = account.getUsername().toUpperCase();

            if (SessionBean.getUserId() == null) {
                ConsumeJSON cjson = new ConsumeJSON(VALIDATEUSERNAME_URL, username, false);

                String strJSONValue = cjson.getResult();
                JSONObject jObj = new JSONObject(strJSONValue);

                if (jObj.getString("r").equals("1")) {
                    FacesContext.getCurrentInstance()
                            .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Username taken:", "Username is already in use. Please enter a different username."));
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
                                "Generic Error:", "A general error occurred. Please try again later."));
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
                    account.setStatus(1);
                    account.setActivationKey(UUID.randomUUID().toString());
                    // account.setCreateDate(new Date());
                    Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

                    String jsonAccount = gson.toJson(account);

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
                    os.write(jsonAccount.getBytes());
                    os.flush();
log.info("");
                    if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                        throw new RuntimeException(
                                "Failed : HTTP error code : "
                                + conn.getResponseCode());
                    }

                    BufferedReader br = new BufferedReader(
                            new InputStreamReader((conn.getInputStream())));

                    String output;

                    while ((output = br.readLine()) != null) {
                        System.out.println(output);
                    }

                    conn.disconnect();

                    //account = new Account();
                    // Clear the sessionscoped values from the browser
                    FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
                    return "activation.xhtml?faces-redirect=true";

                }
                return targetURI;
            }
            return targetURI;
        } catch (IOException | RuntimeException e) {
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);
            return targetURI;
        }

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
                                            "Activation Key Expired:",
                                            "Activation Key has expired. Please click here to request a new activation key."));
                    break;
                case "3":
                    FacesContext.getCurrentInstance()
                            .addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            "Account already activated:",
                                            "Please click here to re-activate account."));
                    break;
                default:
                    FacesContext.getCurrentInstance()
                            .addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                            "Invalid Activation Key:",
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

    public String authenticateUser() {
        String targetURI = "/secured/dashboard.xhtml";

        try {
            UserCredentials authenticate = new UserCredentials(StringEscapeUtils.escapeHtml4(account.getUsername().trim().toUpperCase()), account.getPassword());

            Gson gson = new GsonBuilder().create();

            String jsonAccount = gson.toJson(authenticate);

            URL url = new URL(SessionBean.getRequest().getScheme()
                    + "://" + SessionBean.getRequest().getServerName()
                    + ":" + SessionBean.getRequest().getServerPort()
                    + SessionBean.getRequest().getContextPath()
                    + LOGIN_URL);
log.info(url.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
log.info(jsonAccount);
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

            String output;
            StringBuffer jsonAPIResponse = new StringBuffer();

            while ((output = br.readLine()) != null) {
                System.out.println(output);
                jsonAPIResponse.append(output);
            }

            conn.disconnect();
            log.info("disconnected");
            
            Type sessionType =  new TypeToken<UserSession>(){}.getType();
            UserSession uSession = (UserSession) gson.fromJson(jsonAPIResponse.toString(), sessionType);
            account = uSession.getAccount();
            
            // return "activation.xhtml?faces-redirect=true";
            log.info(account.getStatus() + "");
            switch (account.getStatus()) {
                case 2:
                    // Active Account
                    // if redirecting from authorizationfilter
                    if (SessionBean.getRequestURI() == null) {
                        log.log(Level.INFO, "targetURI{0}", targetURI);
                        return targetURI;
                    } else {
                        log.log(Level.INFO, "sessionbeanuri{0}", SessionBean.getRequestURI());
                        return SessionBean.getRequestURI();
                        // return SessionBean.getRequestURI().replace("OLLE/", "") + "?faces-redirect=true";
                    }
                case 1:
                    // Inactive account
                    FacesContext.getCurrentInstance()
                            .addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                                            "Inactive account",
                                            "You have not activated the account. Click here to activate the account."));
                    return "login";
                case 3:
                    // Locked account
                    FacesContext.getCurrentInstance()
                            .addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                                            "Locked account",
                                            "Your account is currently locked. Click here to activate the account."));
                    return "login";
                case 4:
                    // Expired account
                    FacesContext.getCurrentInstance()
                            .addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                                            "Expired account",
                                            "Your account has expired. Click here to activate the account."));
                    return "login";
                case 5:
                    // Deleted account
                    FacesContext.getCurrentInstance()
                            .addMessage(
                                    null,
                                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                                            "Deleted account",
                                            "Your account has been deleted. Please contact the administrator."));
                    return "login";
                default:
                    // Expired; Deleted
                    FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_WARN,
                                    "Invalid Username/Password: ",
                                    "Please login with correct credentials."));
                    return "login";
            }
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Invalid Username/Password: ",
                            "Please login with correct credentials."));
            log.log(Level.SEVERE, "Exception Logged: ", e.getMessage());
            return "login";

            //TEMP:
            /*HttpSession userSession = SessionBean.getSession();
			userSession.setAttribute("username", StringEscapeUtils.escapeHtml4(account.getUsername().trim().toUpperCase()));
			userSession.setAttribute("uid", account.getUid());
			userSession.setAttribute("firstname", account.getFirstname());
			userSession.setAttribute("middlename", account.getMiddlename());
			userSession.setAttribute("lastname", account.getLastname());
			// userSession.setAttribute("password", jObj.get("password"));
			userSession.setAttribute("mobilephone", account.getMobilephone());
			userSession.setAttribute("email", account.getEmailaddress());
			if (SessionBean.getRequestURI() == null)
				return targetURI;
			else 
				return SessionBean.getRequestURI();*/
        } catch (Exception ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
            return "login";
        }
    }

    public String forgotCredentials() {
        try {
            String email = account.getEmail();

            ConsumeJSON cjson = new ConsumeJSON(VALIDATEEMAIL_URL, email, false);

            String strJSONValue = cjson.getResult();
            JSONObject jObj = new JSONObject(strJSONValue);

            if (jObj.getString("r").equals("1")) {
                log.log(Level.INFO, "Forgot: ", forgot);
                switch (forgot) {
                    case "Username": {
                        Mail mail = new Mail();
                        mail.sendUserName(email, "Name", SessionBean.getUserName());
                        break;
                    }
                    case "Password": {
                        Mail mail = new Mail();
                        mail.sendPassword(email, "Name", SessionBean.getUserName());
                        break;
                    }
                    case "Both": {
                        Mail mail = new Mail();
                        mail.sendUserName(email, "Name", SessionBean.getUserName());
                        mail.sendPassword(email, "Name", "Password");
                        break;
                    }
                    default:
                        break;
                }

            } else {
                FacesContext
                        .getCurrentInstance()
                        .addMessage(
                                null,
                                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                        "Account not found:",
                                        "There is no account registered with the email address provided."));
            }
        } catch (JSONException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return forgot;
    }

    public void manageUserAccount() {
        // String targetURI = "manageaccount.xhtml";
        try {
            Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

            String jsonAccount = gson.toJson(account);

            URL url = new URL(SessionBean.getRequest().getScheme()
                    + "://" + SessionBean.getRequest().getServerName()
                    + ":" + SessionBean.getRequest().getServerPort()
                    + SessionBean.getRequest().getContextPath()
                    + MANAGEACCOUNT_URL);

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

            String output;

            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

            account = new Account();
            FacesContext context = FacesContext.getCurrentInstance();

            context.addMessage(null, new FacesMessage("Successful", "Success: " + "You have successfully updated your account"));

        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception Logged: ", e.getMessage());
        }

        // return targetURI;
    }

    // logout event, invalidate session
    public String logout() {
        // HttpSession session = SessionBean.getSession();
        // session.invalidate();
        // invalidate faces sessionscope
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "/index.xhtml?faces-redirect=true";
    }
}
