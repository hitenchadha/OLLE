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
@ManagedBean(name = "identitybean")
@SessionScoped
@Entity
@Table(name = "\"IDENTITY\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Identity.findAll", query = "SELECT i FROM Identity i"),
    @NamedQuery(name = "Identity.findByUserid", query = "SELECT i FROM Identity i WHERE i.userid = :userid"),
    @NamedQuery(name = "Identity.findBySsn", query = "SELECT i FROM Identity i WHERE i.ssn = :ssn"),
    @NamedQuery(name = "Identity.findByBirthdayDate", query = "SELECT i FROM Identity i WHERE i.birthdayDate = :birthdayDate"),
    @NamedQuery(name = "Identity.findByBirthCertificateNumber", query = "SELECT i FROM Identity i WHERE i.birthCertificateNumber = :birthCertificateNumber"),
    @NamedQuery(name = "Identity.findByBirthCertificateIssueState", query = "SELECT i FROM Identity i WHERE i.birthCertificateIssueState = :birthCertificateIssueState"),
    @NamedQuery(name = "Identity.findByBirthCertificateIssueDate", query = "SELECT i FROM Identity i WHERE i.birthCertificateIssueDate = :birthCertificateIssueDate"),
    @NamedQuery(name = "Identity.findByDriverLicenseNumber", query = "SELECT i FROM Identity i WHERE i.driverLicenseNumber = :driverLicenseNumber"),
    @NamedQuery(name = "Identity.findByDriverLicenseIssueState", query = "SELECT i FROM Identity i WHERE i.driverLicenseIssueState = :driverLicenseIssueState"),
    @NamedQuery(name = "Identity.findByDriverLicenseIssueDate", query = "SELECT i FROM Identity i WHERE i.driverLicenseIssueDate = :driverLicenseIssueDate"),
    @NamedQuery(name = "Identity.findByDriverLicenseExpirationDate", query = "SELECT i FROM Identity i WHERE i.driverLicenseExpirationDate = :driverLicenseExpirationDate"),
    @NamedQuery(name = "Identity.findByPassportNumber", query = "SELECT i FROM Identity i WHERE i.passportNumber = :passportNumber"),
    @NamedQuery(name = "Identity.findByPassportIssueOffice", query = "SELECT i FROM Identity i WHERE i.passportIssueOffice = :passportIssueOffice"),
    @NamedQuery(name = "Identity.findByPassportIssueDate", query = "SELECT i FROM Identity i WHERE i.passportIssueDate = :passportIssueDate"),
    @NamedQuery(name = "Identity.findByPassportExpirationDate", query = "SELECT i FROM Identity i WHERE i.passportExpirationDate = :passportExpirationDate"),
    @NamedQuery(name = "Identity.findByPassportIssueCountry", query = "SELECT i FROM Identity i WHERE i.passportIssueCountry = :passportIssueCountry"),
    @NamedQuery(name = "Identity.findByInsuranceName", query = "SELECT i FROM Identity i WHERE i.insuranceName = :insuranceName"),
    @NamedQuery(name = "Identity.findByInsuranceNumber", query = "SELECT i FROM Identity i WHERE i.insuranceNumber = :insuranceNumber"),
    @NamedQuery(name = "Identity.findByInsuranceGroupNumber", query = "SELECT i FROM Identity i WHERE i.insuranceGroupNumber = :insuranceGroupNumber"),
    @NamedQuery(name = "Identity.findByInsurancePhone", query = "SELECT i FROM Identity i WHERE i.insurancePhone = :insurancePhone"),
    @NamedQuery(name = "Identity.findByDoctorName", query = "SELECT i FROM Identity i WHERE i.doctorName = :doctorName"),
    @NamedQuery(name = "Identity.findByDoctorPhone", query = "SELECT i FROM Identity i WHERE i.doctorPhone = :doctorPhone")})
public class Identity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"USERID\"")
    private Integer userid;
    @Size(max = 11)
    @Column(name = "\"SSN\"")
    private String ssn;
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
    @Size(max = 25)
    @Column(name = "\"DRIVER_LICENSE_NUMBER\"")
    private String driverLicenseNumber;
    @Size(max = 2)
    @Column(name = "\"DRIVER_LICENSE_ISSUE_STATE\"")
    private String driverLicenseIssueState;
    @Column(name = "\"DRIVER_LICENSE_ISSUE_DATE\"")
    @Temporal(TemporalType.DATE)
    private Date driverLicenseIssueDate;
    @Column(name = "\"DRIVER_LICENSE_EXPIRATION_DATE\"")
    @Temporal(TemporalType.DATE)
    private Date driverLicenseExpirationDate;
    @Size(max = 25)
    @Column(name = "\"PASSPORT_NUMBER\"")
    private String passportNumber;
    @Size(max = 2)
    @Column(name = "\"PASSPORT_ISSUE_OFFICE\"")
    private String passportIssueOffice;
    @Column(name = "\"PASSPORT_ISSUE_DATE\"")
    @Temporal(TemporalType.DATE)
    private Date passportIssueDate;
    @Column(name = "\"PASSPORT_EXPIRATION_DATE\"")
    @Temporal(TemporalType.DATE)
    private Date passportExpirationDate;
    @Size(max = 30)
    @Column(name = "\"PASSPORT_ISSUE_COUNTRY\"")
    private String passportIssueCountry;
    @Size(max = 50)
    @Column(name = "\"INSURANCE_NAME\"")
    private String insuranceName;
    @Size(max = 15)
    @Column(name = "\"INSURANCE_NUMBER\"")
    private String insuranceNumber;
    @Size(max = 15)
    @Column(name = "\"INSURANCE_GROUP_NUMBER\"")
    private String insuranceGroupNumber;
    @Size(max = 14)
    @Column(name = "\"INSURANCE_PHONE\"")
    private String insurancePhone;
    @Size(max = 50)
    @Column(name = "\"DOCTOR_NAME\"")
    private String doctorName;
    @Size(max = 14)
    @Column(name = "\"DOCTOR_PHONE\"")
    private String doctorPhone;

    public Identity() {
    }

    public Identity(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getDriverLicenseIssueState() {
        return driverLicenseIssueState;
    }

    public void setDriverLicenseIssueState(String driverLicenseIssueState) {
        this.driverLicenseIssueState = driverLicenseIssueState;
    }

    public Date getDriverLicenseIssueDate() {
        return driverLicenseIssueDate;
    }

    public void setDriverLicenseIssueDate(Date driverLicenseIssueDate) {
        this.driverLicenseIssueDate = driverLicenseIssueDate;
    }

    public Date getDriverLicenseExpirationDate() {
        return driverLicenseExpirationDate;
    }

    public void setDriverLicenseExpirationDate(Date driverLicenseExpirationDate) {
        this.driverLicenseExpirationDate = driverLicenseExpirationDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPassportIssueOffice() {
        return passportIssueOffice;
    }

    public void setPassportIssueOffice(String passportIssueOffice) {
        this.passportIssueOffice = passportIssueOffice;
    }

    public Date getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(Date passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public Date getPassportExpirationDate() {
        return passportExpirationDate;
    }

    public void setPassportExpirationDate(Date passportExpirationDate) {
        this.passportExpirationDate = passportExpirationDate;
    }

    public String getPassportIssueCountry() {
        return passportIssueCountry;
    }

    public void setPassportIssueCountry(String passportIssueCountry) {
        this.passportIssueCountry = passportIssueCountry;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getInsuranceGroupNumber() {
        return insuranceGroupNumber;
    }

    public void setInsuranceGroupNumber(String insuranceGroupNumber) {
        this.insuranceGroupNumber = insuranceGroupNumber;
    }

    public String getInsurancePhone() {
        return insurancePhone;
    }

    public void setInsurancePhone(String insurancePhone) {
        this.insurancePhone = insurancePhone;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
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
        if (!(object instanceof Identity)) {
            return false;
        }
        Identity other = (Identity) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }
    
}
