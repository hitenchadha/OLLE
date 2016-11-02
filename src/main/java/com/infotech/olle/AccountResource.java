package com.infotech.olle;

import com.infotech.olle.util.UserSession;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest1")

@Path("/account")
public class AccountResource extends Application {

    private static final Logger log = Logger.getLogger(AccountResource.class.getName());
    Account account;
    public String r;

    // create new account
    @POST
    @Path("/createuseraccount/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUserAccount(Account account) {
        try {
            AccountService newAccount = new AccountService();
            if (newAccount.createUserAccount(account))
                return Response.status(201).entity(true).build();
            else 
                return Response.status(500).entity(false).build();
        } catch (Throwable e) {
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);
            return Response.status(500).entity(false).build();
        }

    }

    // validate email address
    @GET
    @Path("/validateuseremail/{email}/{IPAddress}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountService validateUserEmail(
            @PathParam("email") String email,
            @PathParam("IPAddress") String ipaddress) {
        AccountService serviceAccount = new AccountService();
        serviceAccount.validateUserEmail(email, ipaddress);
        return serviceAccount;

    }

    // validate username
    @GET
    @Path("/validateusername/{username}/{IPAddress}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountService validateUsername(
            @PathParam("username") String username,
            @PathParam("IPAddress") String ipaddress) {
        AccountService serviceAccount = new AccountService();
        serviceAccount.validateUsername(username, ipaddress);
        return serviceAccount;

    }

    // Activate Account 
    @GET
    @Path("/activateuseraccount/{activationKey}/{IPAddress}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountService activateUserAccount(
            @PathParam("activationKey") String activationKey,
            @PathParam("IPAddress") String ipaddress) {
        AccountService serviceAccount = new AccountService();
        serviceAccount.activateUserAccount(activationKey, ipaddress);
        return serviceAccount;
    }

    // authenticateUser user - Needs to be a POST request to create user session after login - No userid/password in the URL
    @POST
    @Path("/login/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(UserCredentials credentials) {
        AccountService accountService = new AccountService();
        try{
        UserSession uSession = accountService.authenticateUser(credentials);   
        return Response.status(201).entity(uSession).build();
        }catch(Exception e){
            return Response.status(500).entity(false).build();
        }
    }

    @GET
    @Path("/getuseraccountbyuserid/{userid}/{IPAddress}")
    @Produces(MediaType.APPLICATION_JSON)
    public AccountService getUserAccountByUserID(
            @PathParam("usernid") String userid,
            @PathParam("IPAddress") String ipaddress) {
        AccountService serviceAccount = new AccountService();
        serviceAccount.getUserAccountByUserID(userid, ipaddress);
        return serviceAccount;
    }

    @PUT
    @Path("/manageuseraccount/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response manageUserAccount(Account account) {
        try {
            AccountService serviceAccount = new AccountService();
            serviceAccount.manageUserAccount(account);
            return Response.status(201).entity(true).build();
        } catch (Throwable e) {
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);
            return Response.status(500).entity(false).build();
        }
    }

    // Remove Object
    @GET
    @Path("/deleteuseraccount/{userid}/{IPAddress}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteUserAccount(
            @PathParam("userid") Integer userid,
            @PathParam("IPAddress") String ipaddress) {
        AccountService accountService = new AccountService();
        if (accountService.deleteUserAccount(userid, ipaddress)) {
            return true;
        } else {
            return false;
        }
    }
    
    // Remove Object
    @DELETE
    @Path("/RemoveAccount/")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteAccount(Account account) {
        account.setStatus(5);
        AccountService accountService = new AccountService();
        return accountService.manageUserAccount(account);
    }
}
