/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.olle.util;

import com.infotech.olle.Account;

/**
 *
 * @author hchadha
 */
public class UserSession {
    
    private String apiKey;
    private int userId;
    private Account account;
    
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
    
}
