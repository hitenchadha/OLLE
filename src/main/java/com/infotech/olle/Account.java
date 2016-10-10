/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.olle;

import java.io.Serializable;
import java.util.Date;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
@ManagedBean(name = "accountbean")

@SessionScoped
@Entity
@Table(name = "\"ACCOUNT\"")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findByUserid", query = "SELECT a FROM Account a WHERE a.userid = :userid"),
    @NamedQuery(name = "Account.findByUsername", query = "SELECT COUNT(a) FROM Account a WHERE a.username = :username"),
    @NamedQuery(name = "Account.findByFirstName", query = "SELECT a FROM Account a WHERE a.firstName = :firstName"),
    @NamedQuery(name = "Account.findByLastName", query = "SELECT a FROM Account a WHERE a.lastName = :lastName"),
    @NamedQuery(name = "Account.findByEmail", query = "SELECT COUNT(a) FROM Account a WHERE a.email = :email"),
    @NamedQuery(name = "Account.findByPhone", query = "SELECT a FROM Account a WHERE a.phone = :phone"),
    @NamedQuery(name = "Account.findByUsernamePassword", query = "SELECT a FROM Account a WHERE a.password = :password AND a.username = :username"),
    @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password"),
    @NamedQuery(name = "Account.findByStatus", query = "SELECT a FROM Account a WHERE a.status = :status"),
    @NamedQuery(name = "Account.findByActivationKey", query = "SELECT a FROM Account a WHERE a.activationKey = :activationKey"),
    // @NamedQuery(name = "Account.findByCreateDate", query = "SELECT a FROM Account a WHERE a.createDate = :createDate"),
  
})


public class Account implements Serializable {
    private static final Logger log = Logger.getLogger(Account.class.getName()); //enable logging
    
    private static final long serialVersionUID = 1L;
    @Id
//    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "\"USERID\"")
    private Integer userid;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "\"LAST_NAME\"")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "\"EMAIL\"")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 12)
    @Column(name = "\"PHONE\"")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "\"PASSWORD\"")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "\"STATUS\"")
    private int status;
    @Basic(optional = false)
    // @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "\"ACTIVATION_KEY\"")
    private String activationKey;
    // @Basic(optional = false)
    //@NotNull
    // @Column(name = "\"CREATE_DATE\"")
    // @Temporal(TemporalType.TIMESTAMP)
    // private Date createDate;

    public Account() {
    }

    public Account(Integer userid) {
        this.userid = userid;
    }

    public Account(Integer userid, String username, String firstName, String lastName, String phone, String email, String password, int status, String activationKey, Date createDate) {
        this.userid = userid;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.status = status;
        this.activationKey = activationKey;
        // this.createDate = createDate;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public int getStatus() {
        return status;
    }

//    public void setStatus(short status) {
//        this.status = status;
//    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }
/*
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infotech.flup.Account[ userid=" + userid + " ]";
    }

    void setStatus(int status) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.status = status;
    }
}
