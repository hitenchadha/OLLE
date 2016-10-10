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
    // @ManagedProperty(value = "#{accountbean}")

    // private Account account;

    /**
     * Checks if user is logged in. If not it redirects to the login.xhtml page.
     *
     * @param request
     * @param response
     * @param chain
     * @throws javax.servlet.ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException {
        // Get the username from session

        Account account = (Account) ((HttpServletRequest) request).getSession().getAttribute("accountbean");
        
        // String username = (String) ((HttpServletRequest)request).getSession().getAttribute("username");
        try {
            HttpServletRequest req = (HttpServletRequest)request;
            HttpServletResponse resp = (HttpServletResponse) response;
            // HttpSession session = req.getSession(true);
            String requestURL = req.getRequestURI();
            if (account == null) {

                resp.sendRedirect(((HttpServletRequest) request).getContextPath() + "/account/login.xhtml");

            } else {
            log.log(Level.INFO, "Requested URL: {0}", requestURL);
            log.log(Level.INFO, " User First Name="+account.getFirstName()+" & last name="+account.getLastName());
            chain.doFilter(request, response);
            }
        } catch (IOException  e) {
            // TODO Auto-generated catch block
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
