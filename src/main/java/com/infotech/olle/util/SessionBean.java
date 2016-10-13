package com.infotech.olle.util;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.logging.Logger;
import java.util.logging.Level;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name = "sessionbean")
@SessionScoped
public class SessionBean implements Serializable {
private static final Logger log = Logger.getLogger(SessionBean.class.getName());
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
                
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	public static String getUserName() {
            HttpSession session = getSession();
		if (session != null)
                    return (String)session.getAttribute("username");
                else 
                    return null;
	}
        
        public void setUserName(String username) {
            HttpSession session = getSession();
            session.setAttribute("username", username);
        }
        
	public static String getUserId() {
		HttpSession session = getSession();
		if (session != null)
                    return (String) session.getAttribute("userid");
		else
                    return null;
	}
        
        public void setUserid(String userid) {
            HttpSession session = getSession();
            session.setAttribute("userid", userid);
        }
                
        public static String getFirstname() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("firstname");
		else
			return null;
	}

        public void setFirstname(String firstname) {
            HttpSession session = getSession();
            session.setAttribute("firstname", firstname);
        }
        
        public static String getLastname() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("lastname");
		else
			return null;
	}

        public void setLastname(String lastname) {
            HttpSession session = getSession();
            session.setAttribute("lastname", lastname);
        }
        
        public static String getPhone() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("phone");
		else
			return null;
	}

        public void setPhone(String phone) {
            HttpSession session = getSession();
            session.setAttribute("phone", phone);
        }
        
        public static String getEmail() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("emailaddress");
		else
			return null;
	}

        public void setEmail(String email) {
            HttpSession session = getSession();
            session.setAttribute("emailAddress", email);
        }
                
	// RequestURI
	public static String getRequestURI() {
		HttpSession session = getSession();
		if (session != null) {
                    return (String) session.getAttribute("requestURI");
                } else {
                    return null;
                }

	}
	
	public static void setRequestURI(String requestURI) {
            log.info("setRequest: " + requestURI);
		HttpSession session = getSession();
                log.info("setRequest1: " + session.getId());
                session.setAttribute("requestURI", requestURI);
	}
	
}
