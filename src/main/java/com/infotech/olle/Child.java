/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.olle;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hchadha
 */
@ManagedBean(name = "childbean")
@SessionScoped
@Entity
@Table(name = "\"CHILD\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Child.findAll", query = "SELECT c FROM Child c"),
    @NamedQuery(name = "Child.findBySeqNumber", query = "SELECT c FROM Child c WHERE c.seqNumber = :seqNumber"),
    @NamedQuery(name = "Child.findByFirstName", query = "SELECT c FROM Child c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Child.findByMiddleName", query = "SELECT c FROM Child c WHERE c.middleName = :middleName"),
    @NamedQuery(name = "Child.findByLastName", query = "SELECT c FROM Child c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Child.findBySsn", query = "SELECT c FROM Child c WHERE c.ssn = :ssn"),
    @NamedQuery(name = "Child.findByGender", query = "SELECT c FROM Child c WHERE c.gender = :gender"),
    @NamedQuery(name = "Child.findByBirthdayDate", query = "SELECT c FROM Child c WHERE c.birthdayDate = :birthdayDate"),
    @NamedQuery(name = "Child.findByBirthCertificateNumber", query = "SELECT c FROM Child c WHERE c.birthCertificateNumber = :birthCertificateNumber"),
    @NamedQuery(name = "Child.findByBirthCertificateIssueState", query = "SELECT c FROM Child c WHERE c.birthCertificateIssueState = :birthCertificateIssueState"),
    @NamedQuery(name = "Child.findByBirthCertificateIssueDate", query = "SELECT c FROM Child c WHERE c.birthCertificateIssueDate = :birthCertificateIssueDate"),
    @NamedQuery(name = "Child.findBySchoolName", query = "SELECT c FROM Child c WHERE c.schoolName = :schoolName"),
    @NamedQuery(name = "Child.findBySchoolId", query = "SELECT c FROM Child c WHERE c.schoolId = :schoolId"),
    @NamedQuery(name = "Child.findByHomePhone", query = "SELECT c FROM Child c WHERE c.homePhone = :homePhone"),
    @NamedQuery(name = "Child.findByWorkPhone", query = "SELECT c FROM Child c WHERE c.workPhone = :workPhone"),
    @NamedQuery(name = "Child.findByMobilePhone", query = "SELECT c FROM Child c WHERE c.mobilePhone = :mobilePhone"),
    @NamedQuery(name = "Child.findByOtherPhone", query = "SELECT c FROM Child c WHERE c.otherPhone = :otherPhone"),
    @NamedQuery(name = "Child.findByHomeEmail", query = "SELECT c FROM Child c WHERE c.homeEmail = :homeEmail"),
    @NamedQuery(name = "Child.findByWorkEmail", query = "SELECT c FROM Child c WHERE c.workEmail = :workEmail"),
    @NamedQuery(name = "Child.findByHomeAddressLine1", query = "SELECT c FROM Child c WHERE c.homeAddressLine1 = :homeAddressLine1"),
    @NamedQuery(name = "Child.findByHomeAddressLine2", query = "SELECT c FROM Child c WHERE c.homeAddressLine2 = :homeAddressLine2"),
    @NamedQuery(name = "Child.findByHomeAddressCity", query = "SELECT c FROM Child c WHERE c.homeAddressCity = :homeAddressCity"),
    @NamedQuery(name = "Child.findByHomeAddressState", query = "SELECT c FROM Child c WHERE c.homeAddressState = :homeAddressState"),
    @NamedQuery(name = "Child.findByHomeAddressZip", query = "SELECT c FROM Child c WHERE c.homeAddressZip = :homeAddressZip"),
    @NamedQuery(name = "Child.findByHomeAddressCountry", query = "SELECT c FROM Child c WHERE c.homeAddressCountry = :homeAddressCountry"),
    @NamedQuery(name = "Child.findByWorkAddressLine1", query = "SELECT c FROM Child c WHERE c.workAddressLine1 = :workAddressLine1"),
    @NamedQuery(name = "Child.findByWorkAddressLine2", query = "SELECT c FROM Child c WHERE c.workAddressLine2 = :workAddressLine2"),
    @NamedQuery(name = "Child.findByWorkAddressCity", query = "SELECT c FROM Child c WHERE c.workAddressCity = :workAddressCity"),
    @NamedQuery(name = "Child.findByWorkAddressState", query = "SELECT c FROM Child c WHERE c.workAddressState = :workAddressState"),
    @NamedQuery(name = "Child.findByWorkAddressZip", query = "SELECT c FROM Child c WHERE c.workAddressZip = :workAddressZip"),
    @NamedQuery(name = "Child.findByWorkAddressCountry", query = "SELECT c FROM Child c WHERE c.workAddressCountry = :workAddressCountry"),
    @NamedQuery(name = "Child.findByMailingAddressLine1", query = "SELECT c FROM Child c WHERE c.mailingAddressLine1 = :mailingAddressLine1"),
    @NamedQuery(name = "Child.findByMailingAddressLine2", query = "SELECT c FROM Child c WHERE c.mailingAddressLine2 = :mailingAddressLine2"),
    @NamedQuery(name = "Child.findByMailingAddressCity", query = "SELECT c FROM Child c WHERE c.mailingAddressCity = :mailingAddressCity"),
    @NamedQuery(name = "Child.findByMailingAddressState", query = "SELECT c FROM Child c WHERE c.mailingAddressState = :mailingAddressState"),
    @NamedQuery(name = "Child.findByMailingAddressZip", query = "SELECT c FROM Child c WHERE c.mailingAddressZip = :mailingAddressZip"),
    @NamedQuery(name = "Child.findByMailingAddressCountry", query = "SELECT c FROM Child c WHERE c.mailingAddressCountry = :mailingAddressCountry")})
public class Child implements Serializable {

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
    @Size(max = 25)
    @Column(name = "\"BIRTH_CERTIFICATE_NUMBER\"")
    private String birthCertificateNumber;
    @Size(max = 2)
    @Column(name = "\"BIRTH_CERTIFICATE_ISSUE_STATE\"")
    private String birthCertificateIssueState;
    @Column(name = "\"BIRTH_CERTIFICATE_ISSUE_DATE\"")
    @Temporal(TemporalType.DATE)
    private Date birthCertificateIssueDate;
    @Size(max = 50)
    @Column(name = "\"SCHOOL_NAME\"")
    private String schoolName;
    @Size(max = 20)
    @Column(name = "\"SCHOOL_ID\"")
    private String schoolId;
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

    public Child() {
    }

    public Child(Integer seqNumber) {
        this.seqNumber = seqNumber;
    }

    public Integer getSeqNumber() {
        return seqNumber;
    }

    public void setSeqNumber(Integer seqNumber) {
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

    public String getBirthCertificateNumber() {
        return birthCertificateNumber;
    }

    public void setBirthCertificateNumber(String birthCertificateNumber) {
        this.birthCertificateNumber = birthCertificateNumber;
    }

    public String getBirthCertificateIssueState() {
        return birthCertificateIssueState;
    }

    public void setBirthCertificateIssueState(String birthCertificateIssueState) {
        this.birthCertificateIssueState = birthCertificateIssueState;
    }

    public Date getBirthCertificateIssueDate() {
        return birthCertificateIssueDate;
    }

    public void setBirthCertificateIssueDate(Date birthCertificateIssueDate) {
        this.birthCertificateIssueDate = birthCertificateIssueDate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
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
        hash += (seqNumber != null ? seqNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Child)) {
            return false;
        }
        Child other = (Child) object;
        if ((this.seqNumber == null && other.seqNumber != null) || (this.seqNumber != null && !this.seqNumber.equals(other.seqNumber))) {
            return false;
        }
        return true;
    }
    
}
