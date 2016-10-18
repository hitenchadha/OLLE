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
@ManagedBean(name = "emergencybean")
@SessionScoped
@Entity
@Table(name = "\"EMERGENCY\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emergency.findAll", query = "SELECT e FROM Emergency e"),
    @NamedQuery(name = "Emergency.findByFirstName", query = "SELECT e FROM Emergency e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Emergency.findByLastName", query = "SELECT e FROM Emergency e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Emergency.findByMobilePhone", query = "SELECT e FROM Emergency e WHERE e.mobilePhone = :mobilePhone"),
    @NamedQuery(name = "Emergency.findByWorkPhone", query = "SELECT e FROM Emergency e WHERE e.workPhone = :workPhone"),
    @NamedQuery(name = "Emergency.findByHomePhone", query = "SELECT e FROM Emergency e WHERE e.homePhone = :homePhone"),
    @NamedQuery(name = "Emergency.findByOtherPhone", query = "SELECT e FROM Emergency e WHERE e.otherPhone = :otherPhone"),
    @NamedQuery(name = "Emergency.findByAddressLine1", query = "SELECT e FROM Emergency e WHERE e.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Emergency.findByAddressLine2", query = "SELECT e FROM Emergency e WHERE e.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Emergency.findByAddressCity", query = "SELECT e FROM Emergency e WHERE e.addressCity = :addressCity"),
    @NamedQuery(name = "Emergency.findByAddressState", query = "SELECT e FROM Emergency e WHERE e.addressState = :addressState"),
    @NamedQuery(name = "Emergency.findByAddressZip", query = "SELECT e FROM Emergency e WHERE e.addressZip = :addressZip"),
    @NamedQuery(name = "Emergency.findByAddressCountry", query = "SELECT e FROM Emergency e WHERE e.addressCountry = :addressCountry"),
    @NamedQuery(name = "Emergency.findBySeqNumber", query = "SELECT e FROM Emergency e WHERE e.seqNumber = :seqNumber")})
public class Emergency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "\"SEQ_NUMBER\"")
    private Integer seqNumber;
    @NotNull
    @Column(name = "\"USERID\"")
    private Integer userid;
    @Basic(optional = false)
    @Size(max = 30)
    @Column(name = "\"FIRST_NAME\"")
    private String firstName;
    @Size(max = 30)
    @Column(name = "\"LAST_NAME\"")
    private String lastName;
    @Size(max = 14)
    @Column(name = "\"MOBILE_PHONE\"")
    private String mobilePhone;
    @Size(max = 14)
    @Column(name = "\"WORK_PHONE\"")
    private String workPhone;
    @Size(max = 14)
    @Column(name = "\"HOME_PHONE\"")
    private String homePhone;
    @Size(max = 14)
    @Column(name = "\"OTHER_PHONE\"")
    private String otherPhone;
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
    

    public Emergency() {
    }

    public Emergency(Integer seqNumber) {
        this.seqNumber = seqNumber;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
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

    public Integer getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(Integer seqNumber) {
        this.seqNumber = seqNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqNumber != null ? seqNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emergency)) {
            return false;
        }
        Emergency other = (Emergency) object;
        if ((this.seqNumber == null && other.seqNumber != null) || (this.seqNumber != null && !this.seqNumber.equals(other.seqNumber))) {
            return false;
        }
        return true;
    }    
}
