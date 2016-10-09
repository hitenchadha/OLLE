package com.infotech.olle.util;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SharedPropertyFile implements Serializable {
    private static final Logger log = Logger.getLogger(SharedPropertyFile.class.getName());
	final static String PROPERTYFILENAME = "OLLE.properties";
	Properties propertiesFile = new Properties();
	public SharedPropertyFile() {
		try {
			String strFile = System.getProperty("catalina.base") + "/conf/" + PROPERTYFILENAME;
			log.log(Level.INFO, "URI: {0}/conf/", System.getProperty("catalina.base"));
                        propertiesFile.load(new FileInputStream(strFile));
		} catch (IOException e) {
			
		}
	}
	
	public String getJDBCDriver() {
		return propertiesFile.getProperty("JDBC_DRIVER");
	}
	
	public String getDBURL() {
		return propertiesFile.getProperty("DB_URL");
	}
	
	public String getDBUser() {
		return propertiesFile.getProperty("DB_USER");
	}
	
	public String getDBPassword() {
		return propertiesFile.getProperty("DB_PASSWORD");
	}
	
        public String getAccountURL() {
		return propertiesFile.getProperty("ACCOUNT_URL");
	}
        
        public String getSignupURL() {
		return propertiesFile.getProperty("SIGNUP_URL");
	}
        
	public String getLoginURL() {
		return propertiesFile.getProperty("LOGIN_URL");
	}
	
	public String getForgotCreadentialURL() {
		return propertiesFile.getProperty("FORGOTCREDENTIAL_URL");
	}
	
	public String getValidateEmailURL() {
		return propertiesFile.getProperty("VALIDATEEMAIL_URL");
	}
	
	public String getValidateUsernameURL() {
		return propertiesFile.getProperty("VALIDATEUSERNAME_URL");
	}
        
	public String getAccountActivateURL() {
		return propertiesFile.getProperty("ACCOUNTACTIVATE_URL");
	}
	
	public String getManageAccountURL() {
		return propertiesFile.getProperty("MANAGEACCOUNT_URL");
	}
        
        public String getEmailAddressURL() {
		return propertiesFile.getProperty("ACCOUNTEMAILADDRESS_URL");
	}
        
        public String getHashPhoneURL() {
		return propertiesFile.getProperty("ACCOUNTHASHPHONE_URL");
	}
        
        public String getUsernameURL() {
		return propertiesFile.getProperty("ACCOUNTUSERNAME_URL");
	}


        // Profile Value
        public String getManageContactURL() {
                return propertiesFile.getProperty("MANAGECONTACT_URL");
	}
        
        public String getManageChildrenURL() {
                return propertiesFile.getProperty("MANAGECHILDREN_URL");
	}
        
        public String getManageSpouseURL() {
                return propertiesFile.getProperty("MANAGESPOUSE_URL");
	}
        
        public String getManageEmergencyContactURL() {
                return propertiesFile.getProperty("MANAGEEMERGENCYCONTACT_URL");
	}
        
        public String getManageIdentityURL() {
                return propertiesFile.getProperty("MANAGEIDENTITY_URL");
	}
        
        public String getAvailableFormsURL() {
                return propertiesFile.getProperty("AVAILABLE_FORMS_URL");
	}
        
        public String getFormLCPSCOAFORMC10URL() {
                return propertiesFile.getProperty("FORM_LCPSCOAFORMC10_URL");
	}
	
	public String getFormsURL() {
		return propertiesFile.getProperty("FORMS_URL");
	}
	
	public String getFormsIDURL() {
		return propertiesFile.getProperty("FORMS_ID_URL");
	}
        
        public String getStatusInactive() {
		return propertiesFile.getProperty("INACTIVE");
	}
        
        public String getStatusActive() {
		return propertiesFile.getProperty("ACTIVE");
	}
        
        public String getStatusLocked() {
		return propertiesFile.getProperty("LOCKED");
	}

        public String getStatusExpired() {
		return propertiesFile.getProperty("EXPIRED");
	}
        
        public String getStatusDeleted() {
		return propertiesFile.getProperty("DELETED");
	}

        public String getEmailFrom() {
		return propertiesFile.getProperty("FROM_EMAIL");
	}
	 
        public String getApplicationName() {
		return propertiesFile.getProperty("APPLICATION_NAME");
	}

        public String getEmailWelcomeSubject() {
		return propertiesFile.getProperty("WELCOME_SUBJECT");
	}

        public String getEmailForgotCredentialsSubject() {
		return propertiesFile.getProperty("FORGOT_CREDENTIALS");
	}        



	
	public boolean writePropFile(String strKey, String strValue) {
		try {
			// Write to properties file
			Properties properties = new Properties();
			properties.load(new FileInputStream(PROPERTYFILENAME));
			properties.setProperty(strKey, strValue);
			properties.store(new FileOutputStream(PROPERTYFILENAME),	null);
			return true;
		} catch (IOException e) {
			log.log(Level.SEVERE, "Severe Execption:{0}", e.getMessage());
			return false;
		}
		
	}
}
