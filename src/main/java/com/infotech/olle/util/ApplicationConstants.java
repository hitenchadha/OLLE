/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.olle.util;

/**
 *
 * @author hchadha
 */
public interface ApplicationConstants {

    public static final String ACCOUNT_URL = "/rest/profile/";
    public static final String SIGNUP_URL = "/rest/profile/createuserprofile/";
    public static final String LOGIN_URL = "/rest/profile/login/";
    public static final String FORGOTCREDENTIAL_URL = "/rest/profile/forgotcredential/";
    public static final String MANAGEACCOUNT_URL = "/rest/profile/manageuseraccount/";
    public static final String VALIDATEEMAIL_URL = "/rest/profile/validateuseremail/";
    public static final String VALIDATEUSERNAME_URL = "/rest/profile/validateusername/";
    public static final String ACCOUNTACTIVATE_URL = "/rest/profile/activateuseraccount/";

    public static final String DELETEACCOUNT_URL = "/rest/profile/deleteuseraccount/";
    public static final String GETACCOUNT_URL = "/rest/profile/getuseraccountbyuserid/";
    public static final String GETSPOUSE_URL = "/rest/profile/getspousebyuserid/";
    public static final String GETCHILD_URL = "/rest/profile/getchildbyuserid/";
    public static final String GETEMERGENCY_URL = "/rest/profile/getemergencybyuserid/";
    public static final String GETIDENTITY_URL = "/rest/profile/getidentitybyuserid/";
    public static final String GETCONTACT_URL = "/rest/profile/getcontactbyuserid/";
    public static final String UPDATECONTACT_URL = "/rest/profile/updatecontact/";   
    public static final String UPDATESPOUSE_URL = "/rest/profile/updatespouse/"; 
    public static final String UPDATEIDENTITY_URL = "/rest/profile/updateidentity/"; 
    public static final String UPDATECHILD_URL = "/rest/profile/updatechild/"; 
    public static final String UPDATEEMERGENCY_URL = "/rest/profile/updateemergency/"; 
    
    public static final String ACCOUNTEMAILADDRESS_URL = "/rest/profile/emailaddress/";
    public static final String ACCOUNTHASHPHONE_URL = "/rest/profile/hashphone/";
    public static final String ACCOUNTUSERNAME_URL = "/rest/profile/username/";
    public static final String ACCOUNTGETACCOUNT_URL = "/rest/account/getaccount/";

    public static final String FORMS_URL = "/rest/Forms/";
    public static final String FORMS_ID_URL = "/rest/Forms/formid/";
    public static final String AVAILABLE_FORMS_URL = "/rest/AvailableForms/";
    public static final String FORM_LCPSCOAFORMC10_URL = "/rest/Forms/LCPSCoAFormC10/";

    public static final int INACTIVE = 1;
    public static final int ACTIVE = 2;
    public static final int LOCKED = 3;
    public static final int EXPIRED = 4;
    public static final int DELETED = 5;

    public static final String FROM_EMAIL = "Support@olle.com";
    public static final String APPLICATION_NAME = "Olle";

    public static final String WELCOME_SUBJECT = "Olle: Welcome: ";
    public static final String FORGOT_CREDENTIALS = "Olle: Forgot Credentials";
    
}
