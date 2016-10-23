/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.olle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hchadha
 */
@ManagedBean(name = "contactbean")
@SessionScoped
@Entity
@Table(name = "\"CONTACT\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByHomePhone", query = "SELECT c FROM Contact c WHERE c.homePhone = :homePhone"),
    @NamedQuery(name = "Contact.findByWorkPhone", query = "SELECT c FROM Contact c WHERE c.workPhone = :workPhone"),
    @NamedQuery(name = "Contact.findByMobilePhone", query = "SELECT c FROM Contact c WHERE c.mobilePhone = :mobilePhone"),
    @NamedQuery(name = "Contact.findByOtherPhone", query = "SELECT c FROM Contact c WHERE c.otherPhone = :otherPhone"),
    @NamedQuery(name = "Contact.findByHomeEmail", query = "SELECT c FROM Contact c WHERE c.homeEmail = :homeEmail"),
    @NamedQuery(name = "Contact.findByWorkEmail", query = "SELECT c FROM Contact c WHERE c.workEmail = :workEmail"),
    @NamedQuery(name = "Contact.findByHomeAddressLine1", query = "SELECT c FROM Contact c WHERE c.homeAddressLine1 = :homeAddressLine1"),
    @NamedQuery(name = "Contact.findByHomeAddressLine2", query = "SELECT c FROM Contact c WHERE c.homeAddressLine2 = :homeAddressLine2"),
    @NamedQuery(name = "Contact.findByHomeAddressCity", query = "SELECT c FROM Contact c WHERE c.homeAddressCity = :homeAddressCity"),
    @NamedQuery(name = "Contact.findByHomeAddressState", query = "SELECT c FROM Contact c WHERE c.homeAddressState = :homeAddressState"),
    @NamedQuery(name = "Contact.findByHomeAddressZip", query = "SELECT c FROM Contact c WHERE c.homeAddressZip = :homeAddressZip"),
    @NamedQuery(name = "Contact.findByHomeAddressCountry", query = "SELECT c FROM Contact c WHERE c.homeAddressCountry = :homeAddressCountry"),
    @NamedQuery(name = "Contact.findByWorkAddressLine1", query = "SELECT c FROM Contact c WHERE c.workAddressLine1 = :workAddressLine1"),
    @NamedQuery(name = "Contact.findByWorkAddressLine2", query = "SELECT c FROM Contact c WHERE c.workAddressLine2 = :workAddressLine2"),
    @NamedQuery(name = "Contact.findByWorkAddressCity", query = "SELECT c FROM Contact c WHERE c.workAddressCity = :workAddressCity"),
    @NamedQuery(name = "Contact.findByWorkAddressState", query = "SELECT c FROM Contact c WHERE c.workAddressState = :workAddressState"),
    @NamedQuery(name = "Contact.findByWorkAddressZip", query = "SELECT c FROM Contact c WHERE c.workAddressZip = :workAddressZip"),
    @NamedQuery(name = "Contact.findByWorkAddressCountry", query = "SELECT c FROM Contact c WHERE c.workAddressCountry = :workAddressCountry"),
    @NamedQuery(name = "Contact.findByBillingAddressLine1", query = "SELECT c FROM Contact c WHERE c.billingAddressLine1 = :billingAddressLine1"),
    @NamedQuery(name = "Contact.findByBillingAddressLine2", query = "SELECT c FROM Contact c WHERE c.billingAddressLine2 = :billingAddressLine2"),
    @NamedQuery(name = "Contact.findByBillingAddressCity", query = "SELECT c FROM Contact c WHERE c.billingAddressCity = :billingAddressCity"),
    @NamedQuery(name = "Contact.findByBillingAddressState", query = "SELECT c FROM Contact c WHERE c.billingAddressState = :billingAddressState"),
    @NamedQuery(name = "Contact.findByBillingAddressZip", query = "SELECT c FROM Contact c WHERE c.billingAddressZip = :billingAddressZip"),
    @NamedQuery(name = "Contact.findByBillingAddressCountry", query = "SELECT c FROM Contact c WHERE c.billingAddressCountry = :billingAddressCountry"),
    @NamedQuery(name = "Contact.findByMailingAddressLine1", query = "SELECT c FROM Contact c WHERE c.mailingAddressLine1 = :mailingAddressLine1"),
    @NamedQuery(name = "Contact.findByMailingAddressLine2", query = "SELECT c FROM Contact c WHERE c.mailingAddressLine2 = :mailingAddressLine2"),
    @NamedQuery(name = "Contact.findByMailingAddressCity", query = "SELECT c FROM Contact c WHERE c.mailingAddressCity = :mailingAddressCity"),
    @NamedQuery(name = "Contact.findByMailingAddressState", query = "SELECT c FROM Contact c WHERE c.mailingAddressState = :mailingAddressState"),
    @NamedQuery(name = "Contact.findByMailingAddressZip", query = "SELECT c FROM Contact c WHERE c.mailingAddressZip = :mailingAddressZip"),
    @NamedQuery(name = "Contact.findByMailingAddressCountry", query = "SELECT c FROM Contact c WHERE c.mailingAddressCountry = :mailingAddressCountry"),
    @NamedQuery(name = "Contact.findByUserid", query = "SELECT c FROM Contact c WHERE c.userid = :userid")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Size(max = 14)
    @Column(name = "\"HOME_PHONE\"")
    private String homePhone;
    @Size(max = 14)
    @Column(name = "\"WORK_PHONE\"")
    private String workPhone;
    @Size(max = 14)
    @Column(name = "\"MOBILE_PHONE\"")
    private String mobilePhone;
    @Size(max = 14)
    @Column(name = "\"OTHER_PHONE\"")
    private String otherPhone;
    @Size(max = 50)
    @Column(name = "\"HOME_EMAIL\"")
    private String homeEmail;
    @Size(max = 50)
    @Column(name = "\"WORK_EMAIL\"")
    private String workEmail;
    @Size(max = 50)
    @Column(name = "\"HOME_ADDRESS_LINE_1\"")
    private String homeAddressLine1;
    @Size(max = 50)
    @Column(name = "\"HOME_ADDRESS_LINE_2\"")
    private String homeAddressLine2;
    @Size(max = 30)
    @Column(name = "\"HOME_ADDRESS_CITY\"")
    private String homeAddressCity;
    @Size(max = 2)
    @Column(name = "\"HOME_ADDRESS_STATE\"")
    private String homeAddressState;
    @Size(max = 10)
    @Column(name = "\"HOME_ADDRESS_ZIP\"")
    private String homeAddressZip;
    @Size(max = 30)
    @Column(name = "\"HOME_ADDRESS_COUNTRY\"")
    private String homeAddressCountry;
    @Size(max = 50)
    @Column(name = "\"WORK_ADDRESS_LINE_1\"")
    private String workAddressLine1;
    @Size(max = 50)
    @Column(name = "\"WORK_ADDRESS_LINE_2\"")
    private String workAddressLine2;
    @Size(max = 30)
    @Column(name = "\"WORK_ADDRESS_CITY\"")
    private String workAddressCity;
    @Size(max = 2)
    @Column(name = "\"WORK_ADDRESS_STATE\"")
    private String workAddressState;
    @Size(max = 10)
    @Column(name = "\"WORK_ADDRESS_ZIP\"")
    private String workAddressZip;
    @Size(max = 30)
    @Column(name = "\"WORK_ADDRESS_COUNTRY\"")
    private String workAddressCountry;
    @Size(max = 50)
    @Column(name = "\"BILLING_ADDRESS_LINE_1\"")
    private String billingAddressLine1;
    @Size(max = 50)
    @Column(name = "\"BILLING_ADDRESS_LINE_2\"")
    private String billingAddressLine2;
    @Size(max = 30)
    @Column(name = "\"BILLING_ADDRESS_CITY\"")
    private String billingAddressCity;
    @Size(max = 2)
    @Column(name = "\"BILLING_ADDRESS_STATE\"")
    private String billingAddressState;
    @Size(max = 10)
    @Column(name = "\"BILLING_ADDRESS_ZIP\"")
    private String billingAddressZip;
    @Size(max = 30)
    @Column(name = "\"BILLING_ADDRESS_COUNTRY\"")
    private String billingAddressCountry;
    @Size(max = 50)
    @Column(name = "\"MAILING_ADDRESS_LINE_1\"")
    private String mailingAddressLine1;
    @Size(max = 50)
    @Column(name = "\"MAILING_ADDRESS_LINE_2\"")
    private String mailingAddressLine2;
    @Size(max = 30)
    @Column(name = "\"MAILING_ADDRESS_CITY\"")
    private String mailingAddressCity;
    @Size(max = 2)
    @Column(name = "\"MAILING_ADDRESS_STATE\"")
    private String mailingAddressState;
    @Size(max = 10)
    @Column(name = "\"MAILING_ADDRESS_ZIP\"")
    private String mailingAddressZip;
    @Size(max = 30)
    @Column(name = "\"MAILING_ADDRESS_COUNTRY\"")
    private String mailingAddressCountry;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"USERID\"")
    private Integer userid;

    public Contact() {
    }

    public Contact(Integer userid) {
        this.userid = userid;
    }
    
    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getHomeEmail() {
        return homeEmail;
    }

    public void setHomeEmail(String homeEmail) {
        this.homeEmail = homeEmail;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getHomeAddressLine1() {
        return homeAddressLine1;
    }

    public void setHomeAddressLine1(String homeAddressLine1) {
        this.homeAddressLine1 = homeAddressLine1;
    }

    public String getHomeAddressLine2() {
        return homeAddressLine2;
    }

    public void setHomeAddressLine2(String homeAddressLine2) {
        this.homeAddressLine2 = homeAddressLine2;
    }

    public String getHomeAddressCity() {
        return homeAddressCity;
    }

    public void setHomeAddressCity(String homeAddressCity) {
        this.homeAddressCity = homeAddressCity;
    }

    public String getHomeAddressState() {
        return homeAddressState;
    }

    public void setHomeAddressState(String homeAddressState) {
        this.homeAddressState = homeAddressState;
    }

    public String getHomeAddressZip() {
        return homeAddressZip;
    }

    public void setHomeAddressZip(String homeAddressZip) {
        this.homeAddressZip = homeAddressZip;
    }

    public String getHomeAddressCountry() {
        return homeAddressCountry;
    }

    public void setHomeAddressCountry(String homeAddressCountry) {
        this.homeAddressCountry = homeAddressCountry;
    }

    public String getWorkAddressLine1() {
        return workAddressLine1;
    }

    public void setWorkAddressLine1(String workAddressLine1) {
        this.workAddressLine1 = workAddressLine1;
    }

    public String getWorkAddressLine2() {
        return workAddressLine2;
    }

    public void setWorkAddressLine2(String workAddressLine2) {
        this.workAddressLine2 = workAddressLine2;
    }

    public String getWorkAddressCity() {
        return workAddressCity;
    }

    public void setWorkAddressCity(String workAddressCity) {
        this.workAddressCity = workAddressCity;
    }

    public String getWorkAddressState() {
        return workAddressState;
    }

    public void setWorkAddressState(String workAddressState) {
        this.workAddressState = workAddressState;
    }

    public String getWorkAddressZip() {
        return workAddressZip;
    }

    public void setWorkAddressZip(String workAddressZip) {
        this.workAddressZip = workAddressZip;
    }

    public String getWorkAddressCountry() {
        return workAddressCountry;
    }

    public void setWorkAddressCountry(String workAddressCountry) {
        this.workAddressCountry = workAddressCountry;
    }

    public String getBillingAddressLine1() {
        return billingAddressLine1;
    }

    public void setBillingAddressLine1(String billingAddressLine1) {
        this.billingAddressLine1 = billingAddressLine1;
    }

    public String getBillingAddressLine2() {
        return billingAddressLine2;
    }

    public void setBillingAddressLine2(String billingAddressLine2) {
        this.billingAddressLine2 = billingAddressLine2;
    }

    public String getBillingAddressCity() {
        return billingAddressCity;
    }

    public void setBillingAddressCity(String billingAddressCity) {
        this.billingAddressCity = billingAddressCity;
    }

    public String getBillingAddressState() {
        return billingAddressState;
    }

    public void setBillingAddressState(String billingAddressState) {
        this.billingAddressState = billingAddressState;
    }

    public String getBillingAddressZip() {
        return billingAddressZip;
    }

    public void setBillingAddressZip(String billingAddressZip) {
        this.billingAddressZip = billingAddressZip;
    }

    public String getBillingAddressCountry() {
        return billingAddressCountry;
    }

    public void setBillingAddressCountry(String billingAddressCountry) {
        this.billingAddressCountry = billingAddressCountry;
    }

    public String getMailingAddressLine1() {
        return mailingAddressLine1;
    }

    public void setMailingAddressLine1(String mailingAddressLine1) {
        this.mailingAddressLine1 = mailingAddressLine1;
    }

    public String getMailingAddressLine2() {
        return mailingAddressLine2;
    }

    public void setMailingAddressLine2(String mailingAddressLine2) {
        this.mailingAddressLine2 = mailingAddressLine2;
    }

    public String getMailingAddressCity() {
        return mailingAddressCity;
    }

    public void setMailingAddressCity(String mailingAddressCity) {
        this.mailingAddressCity = mailingAddressCity;
    }

    public String getMailingAddressState() {
        return mailingAddressState;
    }

    public void setMailingAddressState(String mailingAddressState) {
        this.mailingAddressState = mailingAddressState;
    }

    public String getMailingAddressZip() {
        return mailingAddressZip;
    }

    public void setMailingAddressZip(String mailingAddressZip) {
        this.mailingAddressZip = mailingAddressZip;
    }

    public String getMailingAddressCountry() {
        return mailingAddressCountry;
    }

    public void setMailingAddressCountry(String mailingAddressCountry) {
        this.mailingAddressCountry = mailingAddressCountry;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }
 
}
