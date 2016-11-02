package com.infotech.olle;

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
import javax.ws.rs.ApplicationPath;

import java.util.logging.Level;
import java.util.logging.Logger;


@ApplicationPath("rest")

@Path("/profile")
public class ProfileResource extends Application {

    private static final Logger log = Logger.getLogger(ProfileResource.class.getName());
    Account account;
    public String r;

    @POST
    @Path("/getcontactbyuserid/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getContactByUserID(@PathParam("userid") Integer userid) {
        try{
            ProfileService contactService = new ProfileService();
            Contact contact = contactService.getContactByUserID(userid);   
            return Response.status(201).entity(contact).build();
        }catch(Exception e){
            return Response.status(500).entity(false).build();
        }
    }
    
    @POST
    @Path("/getidentitybyuserid/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIdentityByUserID(@PathParam("userid") Integer userid) {
        try{
            ProfileService identityService = new ProfileService();
            Identity identity = identityService.getIdentityByUserID(userid);   
            return Response.status(201).entity(identity).build();
        }catch(Exception e){
            return Response.status(500).entity(false).build();
        }
    }
    
    @POST
    @Path("/getspousebyuserid/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSpouseByUserID(@PathParam("userid") Integer userid) {
        try{
            ProfileService spouseService = new ProfileService();
            Spouse spouse = spouseService.getSpouseByUserID(userid);   
            return Response.status(201).entity(spouse).build();
        }catch(Exception e){
            return Response.status(500).entity(false).build();
        }
    }
    
    @POST
    @Path("/getchildbyuserid/{userid}/{seqnumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getChildByUserIDSeqNumber(@PathParam("userid") Integer userid, @PathParam("seqnumber") Integer seqNumber) {
        try{
            ProfileService childService = new ProfileService();
            Child child = childService.getChildByUserIDSeqNumber(userid, seqNumber);   
            return Response.status(201).entity(child).build();
        }catch(Exception e){
            return Response.status(500).entity(false).build();
        }
    }
    
    @POST
    @Path("/getemergencybyuserid/{userid}/{seqnumber}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmergencyByUserID(@PathParam("userid") Integer userid, @PathParam("seqnumber") Integer seqNumber) {
        try{
            ProfileService emergencyService = new ProfileService();
            Emergency emergency = emergencyService.getEmergencyByUserIDSeqNumber(userid, seqNumber);   
            return Response.status(201).entity(emergency).build();
        }catch(Exception e){
            return Response.status(500).entity(false).build();
        }
    }
    
    @PUT
    @Path("/updatecontact")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateContact(Contact contact) {
        try{
            ProfileService contactService = new ProfileService();
            if (contactService.updateContact(contact))   
                return Response.status(201).entity(true).build();
            else
                return Response.status(201).entity(false).build();
        }catch(Exception e){
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);
            return Response.status(500).entity(false).build();
        }
    }
    
    @PUT
    @Path("/updatespouse")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateSpouse(Spouse spouse) {
        try{
            ProfileService contactService = new ProfileService();
            if (contactService.updateSpouse(spouse))   
                return Response.status(201).entity(true).build();
            else
                return Response.status(201).entity(false).build();
        }catch(Exception e){
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);
            return Response.status(500).entity(false).build();
        }
    }

    @PUT
    @Path("/updateidentity")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateIdentity(Identity identity) {
        try{
            ProfileService identityService = new ProfileService();
            if (identityService.updateIdentity(identity))   
                return Response.status(201).entity(true).build();
            else
                return Response.status(201).entity(false).build();
        }catch(Exception e){
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);
            return Response.status(500).entity(false).build();
        }
    }
    
    @PUT
    @Path("/updatechild")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateChild(Child child) {
        try{
            ProfileService childService = new ProfileService();
            if (childService.updateChild(child))   
                return Response.status(201).entity(true).build();
            else
                return Response.status(201).entity(false).build();
        }catch(Exception e){
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);
            return Response.status(500).entity(false).build();
        }
    }
    
    @PUT
    @Path("/updateemergency")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEmergency(Emergency emergency) {
        try{
            ProfileService emergencyService = new ProfileService();
            if (emergencyService.updateEmergency(emergency))   
                return Response.status(201).entity(true).build();
            else
                return Response.status(201).entity(false).build();
        }catch(Exception e){
            log.log(Level.SEVERE, " Exception:{0}" + e.getMessage(), e);
            return Response.status(500).entity(false).build();
        }
    }
    
    // create new account
    @POST
    @Path("/createuserprofile/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUserAccount(Profile profile) {
        try {
            ProfileService profileService = new ProfileService();
            if (profileService.createUserProfile(profile))
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
    @Path("/validateuseremail/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileService validateUserEmail(
            @PathParam("email") String email) {
        ProfileService serviceProfile = new ProfileService();
        serviceProfile.validateUserEmail(email);
        return serviceProfile;

    }

    // validate username
    @GET
    @Path("/validateusername/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileService validateUsername(@PathParam("username") String username) {
        ProfileService serviceProfile = new ProfileService();
        serviceProfile.validateUsername(username);
        return serviceProfile;

    }

    // Activate Account 
    @GET
    @Path("/activateuseraccount/{activationKey}")
    @Produces(MediaType.APPLICATION_JSON)
    public ProfileService activateUserAccount(
            @PathParam("activationKey") String activationKey) {
        ProfileService serviceProfile = new ProfileService();
        serviceProfile.activateUserAccount(activationKey);
        return serviceProfile;
    }
}
