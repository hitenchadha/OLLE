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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hitenchadha
 */
@ManagedBean(name = "contactmb")
@SessionScoped
@Entity
@Table(name = "\"CONTACT\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c")
    , @NamedQuery(name = "Contact.findByContactId", query = "SELECT c FROM Contact c WHERE c.contactId = :contactId")
    , @NamedQuery(name = "Contact.findByContactType", query = "SELECT c FROM Contact c WHERE c.contactType = :contactType")
    , @NamedQuery(name = "Contact.findByFirstName", query = "SELECT c FROM Contact c WHERE c.firstName = :firstName")
    , @NamedQuery(name = "Contact.findByLastName", query = "SELECT c FROM Contact c WHERE c.lastName = :lastName")
    , @NamedQuery(name = "Contact.findByPhone", query = "SELECT c FROM Contact c WHERE c.phone = :phone")
    , @NamedQuery(name = "Contact.findByEmail", query = "SELECT c FROM Contact c WHERE c.email = :email")
    , @NamedQuery(name = "Contact.findByAddressLine1", query = "SELECT c FROM Contact c WHERE c.addressLine1 = :addressLine1")
    , @NamedQuery(name = "Contact.findByAddressLine2", query = "SELECT c FROM Contact c WHERE c.addressLine2 = :addressLine2")
    , @NamedQuery(name = "Contact.findByAddressCity", query = "SELECT c FROM Contact c WHERE c.addressCity = :addressCity")
    , @NamedQuery(name = "Contact.findByAddressState", query = "SELECT c FROM Contact c WHERE c.addressState = :addressState")
    , @NamedQuery(name = "Contact.findByAddressZip", query = "SELECT c FROM Contact c WHERE c.addressZip = :addressZip")
    , @NamedQuery(name = "Contact.findByAddressCountry", query = "SELECT c FROM Contact c WHERE c.addressCountry = :addressCountry")})
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "\"CONTACT_ID\"")
    private Integer contactId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"CONTACT_TYPE\"")
    private int contactType;
    @Size(max = 30)
    @Column(name = "\"FIRST_NAME\"")
    private String firstName;
    @Size(max = 30)
    @Column(name = "\"LAST_NAME\"")
    private String lastName;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx\"")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 14)
    @Column(name = "\"PHONE\"")
    private String phone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email\"")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "\"EMAIL\"")
    private String email;
    @Size(max = 50)
    @Column(name = "\"ADDRESS_LINE_1\"")
    private String addressLine1;
    @Size(max = 50)
    @Column(name = "\"ADDRESS_LINE_2\"")
    private String addressLine2;
    @Size(max = 30)
    @Column(name = "\"ADDRESS_CITY\"")
    private String addressCity;
    @Size(max = 2)
    @Column(name = "\"ADDRESS_STATE\"")
    private String addressState;
    @Size(max = 10)
    @Column(name = "\"ADDRESS_ZIP\"")
    private String addressZip;
    @Size(max = 30)
    @Column(name = "\"ADDRESS_COUNTRY\"")
    private String addressCountry;
    @JoinColumn(name = "\"CONTACT_ID", referencedColumnName = "PROFILE_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Profile profile;

    public Contact() {
    }

    public Contact(Integer contactId) {
        this.contactId = contactId;
    }

    public Contact(Integer contactId, int contactType) {
        this.contactId = contactId;
        this.contactType = contactType;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public int getContactType() {
        return contactType;
    }

    public void setContactType(int contactType) {
        this.contactType = contactType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(String addressZip) {
        this.addressZip = addressZip;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contactId != null ? contactId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.contactId == null && other.contactId != null) || (this.contactId != null && !this.contactId.equals(other.contactId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infotech.olle.Contact[ contactId=" + contactId + " ]";
    }
    
}
