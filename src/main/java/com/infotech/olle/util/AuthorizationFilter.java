package com.infotech.olle.util;

import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotech.olle.Account;
import java.io.IOException;
import java.util.logging.Level;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class AuthorizationFilter implements Filter {

    private static final Logger log = Logger.getLogger(AuthorizationFilter.class.getName());
    /*
    @ManagedProperty(value = "#{accountbean}")

    private Account account;
    public void setAccount(Account account) {
        this.account = account;
    }
    */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException {

        // String username = (String) ((HttpServletRequest)request).getSession().getAttribute("username");
        try {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse) response;
            HttpSession session = req.getSession(true);
            String requestURL = req.getRequestURI().replace("/OLLE","");

            String loginURL = req.getContextPath() + "/account/login.xhtml";
            session.setAttribute("requestURI", requestURL);
            boolean loggedIn = (session.getAttribute("accountbean") != null);       
            // Account account = (Account) req.getSession().getAttribute("accountbean");
            if (loggedIn) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(loginURL);
            }
        } catch (IOException  e) {
            log.severe(e.getMessage());
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // Nothing to do here!
    }

    @Override
    public void destroy() {
        // Nothing to do here!
    }

}
