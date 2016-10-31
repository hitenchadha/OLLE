/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.olle;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author hitenchadha
 */
@ManagedBean(name = "profilemb")
@SessionScoped
@Entity
@Table(name = "\"PROFILE\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profile.findAll", query = "SELECT p FROM Profile p")
    , @NamedQuery(name = "Profile.findByProfileId", query = "SELECT p FROM Profile p WHERE p.profileId = :profileId")
    , @NamedQuery(name = "Profile.findByParentId", query = "SELECT p FROM Profile p WHERE p.parentId = :parentId")
    , @NamedQuery(name = "Profile.findByProfileType", query = "SELECT p FROM Profile p WHERE p.profileType = :profileType")
    , @NamedQuery(name = "Profile.findByUsername", query = "SELECT p FROM Profile p WHERE p.username = :username")
    , @NamedQuery(name = "Profile.findByFirstName", query = "SELECT p FROM Profile p WHERE p.firstName = :firstName")
    , @NamedQuery(name = "Profile.findByMiddleName", query = "SELECT p FROM Profile p WHERE p.middleName = :middleName")
    , @NamedQuery(name = "Profile.findByLastName", query = "SELECT p FROM Profile p WHERE p.lastName = :lastName")
    , @NamedQuery(name = "Profile.findByEmail", query = "SELECT p FROM Profile p WHERE p.email = :email")
    , @NamedQuery(name = "Profile.findByPhone", query = "SELECT p FROM Profile p WHERE p.phone = :phone")
    , @NamedQuery(name = "Profile.findByPassword", query = "SELECT p FROM Profile p WHERE p.password = :password")
    , @NamedQuery(name = "Profile.findBySsn", query = "SELECT p FROM Profile p WHERE p.ssn = :ssn")
    , @NamedQuery(name = "Profile.findByGender", query = "SELECT p FROM Profile p WHERE p.gender = :gender")
    , @NamedQuery(name = "Profile.findByBirthDate", query = "SELECT p FROM Profile p WHERE p.birthDate = :birthDate")
    , @NamedQuery(name = "Profile.findByBirthCertificateNumber", query = "SELECT p FROM Profile p WHERE p.birthCertificateNumber = :birthCertificateNumber")
    , @NamedQuery(name = "Profile.findByBirthCertificateIssueState", query = "SELECT p FROM Profile p WHERE p.birthCertificateIssueState = :birthCertificateIssueState")
    , @NamedQuery(name = "Profile.findByBirthCertificateIssueDate", query = "SELECT p FROM Profile p WHERE p.birthCertificateIssueDate = :birthCertificateIssueDate")
    , @NamedQuery(name = "Profile.findByInstitutionName", query = "SELECT p FROM Profile p WHERE p.institutionName = :institutionName")
    , @NamedQuery(name = "Profile.findByInstitutionId", query = "SELECT p FROM Profile p WHERE p.institutionId = :institutionId")
    , @NamedQuery(name = "Profile.findByDriverLicenseNumber", query = "SELECT p FROM Profile p WHERE p.driverLicenseNumber = :driverLicenseNumber")
    , @NamedQuery(name = "Profile.findByDriverLicenseIssueState", query = "SELECT p FROM Profile p WHERE p.driverLicenseIssueState = :driverLicenseIssueState")
    , @NamedQuery(name = "Profile.findByDriverLicenseIssueDate", query = "SELECT p FROM Profile p WHERE p.driverLicenseIssueDate = :driverLicenseIssueDate")
    , @NamedQuery(name = "Profile.findByDriverLicenseExpirationDate", query = "SELECT p FROM Profile p WHERE p.driverLicenseExpirationDate = :driverLicenseExpirationDate")
    , @NamedQuery(name = "Profile.findByPassportNumber", query = "SELECT p FROM Profile p WHERE p.passportNumber = :passportNumber")
    , @NamedQuery(name = "Profile.findByPassportIssueOffice", query = "SELECT p FROM Profile p WHERE p.passportIssueOffice = :passportIssueOffice")
    , @NamedQuery(name = "Profile.findByPassportIssueDate", query = "SELECT p FROM Profile p WHERE p.passportIssueDate = :passportIssueDate")
    , @NamedQuery(name = "Profile.findByPassportExpirationDate", query = "SELECT p FROM Profile p WHERE p.passportExpirationDate = :passportExpirationDate")
    , @NamedQuery(name = "Profile.findByPassportIssueCountry", query = "SELECT p FROM Profile p WHERE p.passportIssueCountry = :passportIssueCountry")
    , @NamedQuery(name = "Profile.findByInsuranceName", query = "SELECT p FROM Profile p WHERE p.insuranceName = :insuranceName")
    , @NamedQuery(name = "Profile.findByInsuranceNumber", query = "SELECT p FROM Profile p WHERE p.insuranceNumber = :insuranceNumber")
    , @NamedQuery(name = "Profile.findByInsuranceGroupNumber", query = "SELECT p FROM Profile p WHERE p.insuranceGroupNumber = :insuranceGroupNumber")
    , @NamedQuery(name = "Profile.findByInsurancePhone", query = "SELECT p FROM Profile p WHERE p.insurancePhone = :insurancePhone")
    , @NamedQuery(name = "Profile.findByDoctorName", query = "SELECT p FROM Profile p WHERE p.doctorName = :doctorName")
    , @NamedQuery(name = "Profile.findByDoctorPhone", query = "SELECT p FROM Profile p WHERE p.doctorPhone = :doctorPhone")
    , @NamedQuery(name = "Profile.findByActivationKey", query = "SELECT p FROM Profile p WHERE p.activationKey = :activationKey")
    , @NamedQuery(name = "Profile.findByStatus", query = "SELECT p FROM Profile p WHERE p.status = :status")
    , @NamedQuery(name = "Profile.findByCreateDate", query = "SELECT p FROM Profile p WHERE p.createDate = :createDate")})
public class Profile implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "\"PROFILE_ID\"")
    private Integer profileId;
    @Column(name = "\"PARENT_ID\"")
    private Integer parentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"PROFILE_TYPE\"")
    private int profileType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "\"USERNAME\"")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "\"FIRST_NAME\"")
    private String firstName;
    @Size(max = 30)
    @Column(name = "\"MIDDLE_NAME\"")
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "\"LAST_NAME\"")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email\"")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "\"EMAIL\"")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx\"")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 14)
    @Column(name = "\"PHONE\"")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "\"PASSWORD\"")
    private String password;
    @Size(max = 11)
    @Column(name = "\"SSN\"")
    private String ssn;
    @Size(max = 1)
    @Column(name = "\"GENDER\"")
    private String gender;
    @Column(name = "\"BIRTH_DATE\"")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
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
    @Column(name = "\"INSTITUTION_NAME\"")
    private String institutionName;
    @Size(max = 20)
    @Column(name = "\"INSTITUTION_ID\"")
    private String institutionId;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 36)
    @Column(name = "\"ACTIVATION_KEY\"")
    private String activationKey;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"STATUS\"")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"CREATE_DATE\"")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "profile")
    private Contact contact;
    @ManyToOne
    private Profile parent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="parent")
    private Collection<Profile> children;
    @OneToOne(cascade = CascadeType.ALL, mappedBy="parent")
    private Profile spouse;

    
    public Profile() {
    }

    public Profile(Integer profileId) {
        this.profileId = profileId;
    }

    public Profile(Integer profileId, int profileType, String username, String firstName, String lastName, String email, String password, String activationKey, int status, Date createDate) {
        this.profileId = profileId;
        this.profileType = profileType;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.activationKey = activationKey;
        this.status = status;
        this.createDate = createDate;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public int getProfileType() {
        return profileType;
    }

    public void setProfileType(int profileType) {
        this.profileType = profileType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
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

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Profile getParent() {
        return parent;
    }

    public void setParent(Profile parent) {
        this.parent = parent;
    }

    public Collection<Profile> getChildren() {
        return children;
    }

    public void setChildren(Collection<Profile> children) {
        this.children = children;
    }

    public Profile getSpouse() {
        return spouse;
    }

    public void setSpouse(Profile spouse) {
        this.spouse = spouse;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileId != null ? profileId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.profileId == null && other.profileId != null) || (this.profileId != null && !this.profileId.equals(other.profileId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infotech.olle.Profile[ profileId=" + profileId + " ]";
    }
    
}
