/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infotech.olle.util;

/**
 *
 * @author hchadha
 */
import com.infotech.olle.AccountController;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SharedDBConnect {
        private static final Logger log = Logger.getLogger(AccountController.class.getName());
	// JDBC driver name and database URL
	SharedPropertyFile spf = new SharedPropertyFile();
	String JDBC_DRIVER = spf.getJDBCDriver();
	String DB_URL = spf.getDBURL();
	// Database credentials
	String USER = spf.getDBUser();
	String PASS = spf.getDBPassword();
	Connection conn = null;

	public Connection createConnection() {
		try {
			// Register JDBC driver
			Class.forName(JDBC_DRIVER);
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e1) {
			log.log(Level.SEVERE, "Exception submiting form:{0}",e1.getMessage());
		}
		return conn;
	}

	public boolean disconnectConnection() {
		boolean blnReturnValue = false;
		try {
			conn.close();
			blnReturnValue = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.log(Level.SEVERE, "Exception submiting form:{0}",e.getMessage());
		}
		return blnReturnValue;
	}

	public java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		long oneDay = 1 * 24 * 60 * 60 * 1000;
		return new java.sql.Timestamp(today.getTime() + oneDay);
	}

}
