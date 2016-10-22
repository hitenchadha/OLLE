/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.olle;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author hchadha
 */
@ManagedBean(name = "spousebean")
@SessionScoped
@Entity
@Table(name = "\"SPOUSE\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spouse.findAll", query = "SELECT s FROM Spouse s"),
    @NamedQuery(name = "Spouse.findByUserid", query = "SELECT s FROM Spouse s WHERE s.userid = :userid"),
    @NamedQuery(name = "Spouse.findByFirstName", query = "SELECT s FROM Spouse s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Spouse.findByMiddleName", query = "SELECT s FROM Spouse s WHERE s.middleName = :middleName"),
    @NamedQuery(name = "Spouse.findByLastName", query = "SELECT s FROM Spouse s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Spouse.findBySsn", query = "SELECT s FROM Spouse s WHERE s.ssn = :ssn"),
    @NamedQuery(name = "Spouse.findByGender", query = "SELECT s FROM Spouse s WHERE s.gender = :gender"),
    @NamedQuery(name = "Spouse.findByBirthdayDate", query = "SELECT s FROM Spouse s WHERE s.birthdayDate = :birthdayDate"),
    @NamedQuery(name = "Spouse.findByHomePhone", query = "SELECT s FROM Spouse s WHERE s.homePhone = :homePhone"),
    @NamedQuery(name = "Spouse.findByWorkPhone", query = "SELECT s FROM Spouse s WHERE s.workPhone = :workPhone"),
    @NamedQuery(name = "Spouse.findByMobilePhone", query = "SELECT s FROM Spouse s WHERE s.mobilePhone = :mobilePhone"),
    @NamedQuery(name = "Spouse.findByOtherPhone", query = "SELECT s FROM Spouse s WHERE s.otherPhone = :otherPhone"),
    @NamedQuery(name = "Spouse.findByHomeEmail", query = "SELECT s FROM Spouse s WHERE s.homeEmail = :homeEmail"),
    @NamedQuery(name = "Spouse.findByWorkEmail", query = "SELECT s FROM Spouse s WHERE s.workEmail = :workEmail"),
    @NamedQuery(name = "Spouse.findByHomeAddressLine1", query = "SELECT s FROM Spouse s WHERE s.homeAddressLine1 = :homeAddressLine1"),
    @NamedQuery(name = "Spouse.findByHomeAddressLine2", query = "SELECT s FROM Spouse s WHERE s.homeAddressLine2 = :homeAddressLine2"),
    @NamedQuery(name = "Spouse.findByHomeAddressCity", query = "SELECT s FROM Spouse s WHERE s.homeAddressCity = :homeAddressCity"),
    @NamedQuery(name = "Spouse.findByHomeAddressState", query = "SELECT s FROM Spouse s WHERE s.homeAddressState = :homeAddressState"),
    @NamedQuery(name = "Spouse.findByHomeAddressZip", query = "SELECT s FROM Spouse s WHERE s.homeAddressZip = :homeAddressZip"),
    @NamedQuery(name = "Spouse.findByHomeAddressCountry", query = "SELECT s FROM Spouse s WHERE s.homeAddressCountry = :homeAddressCountry"),
    @NamedQuery(name = "Spouse.findByWorkAddressLine1", query = "SELECT s FROM Spouse s WHERE s.workAddressLine1 = :workAddressLine1"),
    @NamedQuery(name = "Spouse.findByWorkAddressLine2", query = "SELECT s FROM Spouse s WHERE s.workAddressLine2 = :workAddressLine2"),
    @NamedQuery(name = "Spouse.findByWorkAddressCity", query = "SELECT s FROM Spouse s WHERE s.workAddressCity = :workAddressCity"),
    @NamedQuery(name = "Spouse.findByWorkAddressState", query = "SELECT s FROM Spouse s WHERE s.workAddressState = :workAddressState"),
    @NamedQuery(name = "Spouse.findByWorkAddressZip", query = "SELECT s FROM Spouse s WHERE s.workAddressZip = :workAddressZip"),
    @NamedQuery(name = "Spouse.findByWorkAddressCountry", query = "SELECT s FROM Spouse s WHERE s.workAddressCountry = :workAddressCountry"),
    @NamedQuery(name = "Spouse.findByMailingAddressLine1", query = "SELECT s FROM Spouse s WHERE s.mailingAddressLine1 = :mailingAddressLine1"),
    @NamedQuery(name = "Spouse.findByMailingAddressLine2", query = "SELECT s FROM Spouse s WHERE s.mailingAddressLine2 = :mailingAddressLine2"),
    @NamedQuery(name = "Spouse.findByMailingAddressCity", query = "SELECT s FROM Spouse s WHERE s.mailingAddressCity = :mailingAddressCity"),
    @NamedQuery(name = "Spouse.findByMailingAddressState", query = "SELECT s FROM Spouse s WHERE s.mailingAddressState = :mailingAddressState"),
    @NamedQuery(name = "Spouse.findByMailingAddressZip", query = "SELECT s FROM Spouse s WHERE s.mailingAddressZip = :mailingAddressZip"),
    @NamedQuery(name = "Spouse.findByMailingAddressCountry", query = "SELECT s FROM Spouse s WHERE s.mailingAddressCountry = :mailingAddressCountry")})
public class Spouse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"USERID\"")
    private Integer userid;
    @Size(max = 30)
    @Column(name = "\"FIRST_NAME\"")
    private String firstName;
    @Size(max = 30)
    @Column(name = "\"MIDDLE_NAME\"")
    private String middleName;
    @Size(max = 30)
    @Column(name = "\"LAST_NAME\"")
    private String lastName;
    @Size(max = 11)
    @Column(name = "\"SSN\"")
    private String ssn;
    @Size(max = 1)
    @Column(name = "\"GENDER\"")
    private String gender;
    @Column(name = "\"BIRTHDAY_DATE\"")
    @Temporal(TemporalType.DATE)
    private Date birthdayDate;
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

    public Spouse() {
    }

    public Spouse(Integer userid) {
        this.userid = userid;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spouse)) {
            return false;
        }
        Spouse other = (Spouse) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infotech.olle.Spouse[ userid=" + userid + " ]";
    }
    
    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
     
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
         
        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
    
}
