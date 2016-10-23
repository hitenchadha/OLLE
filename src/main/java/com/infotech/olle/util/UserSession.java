/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.olle.util;

import com.infotech.olle.Account;
import com.infotech.olle.Contact;
import com.infotech.olle.Identity;

/**
 *
 * @author hchadha
 */
public class UserSession {
    
    private String apiKey;
    private int userId;
    private Account account;
    private Contact contact;
    private Identity identity;
    
    public UserSession(){
      apiKey = "APIKEY-"+String.valueOf(Math.random());
    }
    
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Identity getIdentity() {
        return identity;
    }

    public void setIdentity(Identity identity) {
        this.identity = identity;
    }
    
    
    
}
