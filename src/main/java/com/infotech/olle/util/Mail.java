package com.infotech.olle.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	Properties props = new Properties();
	Session session = Session.getDefaultInstance(props, null);

	String msgBody = "...";
	public Mail () {
		
	}

	public Mail(String fromEmail, String fromName, String toEmail,
			String toName, String subject, String msgBody) {
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(fromEmail, fromName));

			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(
					toEmail, toName));
			msg.setSubject(subject);
			msg.setText(msgBody);
			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException | UnsupportedEncodingException e) {

		}
            // ...
            
	}
	
	public void welcomeMail(String toEmail,	String toName, String userName, String activationKey) {
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(System.getProperty("FromEmail"), System.getProperty("Application Name")));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress( toEmail, toName));
			msg.setSubject(System.getProperty("Welcome Subject"));
			msg.setText("Dear " + toName +",\n\n" + "Thank you for signing up with Easy Forms. Please click on the following link to validate your email address. \n\n " + SessionBean.getRequest().getScheme() + "://"
					 + SessionBean.getRequest().getServerName() + ":" + SessionBean.getRequest().getServerPort()
						 + System.getProperty("ACCOUNTACTIVATE_URL") + activationKey);
			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {

		} catch (UnsupportedEncodingException e) {
			// ...
		}
	}
	
	public void sendUserName(String toEmail, String toName, String userName) {
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(System.getProperty("FromEmail"), System.getProperty("Application Name")));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress( toEmail, toName));
			msg.setSubject(System.getProperty("Forgot Username Subject"));
			msg.setText("Dear " + toName +",\n\n" + "Username: " + userName);
			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {

		} catch (UnsupportedEncodingException e) {
			// ...
		}
	}
	
	public void sendPassword(String toEmail, String toName, String userName) {
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(System.getProperty("FromEmail"), System.getProperty("Application Name")));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress( toEmail, toName));
			msg.setSubject(System.getProperty("Forgot Password Subject"));
			msg.setText("Dear " + toName +",\n\n" + "Please click the following link to change password \n\n");
			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {

		} catch (UnsupportedEncodingException e) {
			// ...
		}
	}
	
	public void sendUserNamePassword(String toEmail, String toName, String userName) {
		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(System.getProperty("FromEmail"), System.getProperty("Application Name")));
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress( toEmail, toName));
			msg.setSubject(System.getProperty("Forgot Username Password Subject"));
			msg.setText("Dear " + toName +",\n\n" + "Username: " + userName + "\n\n Please click the following link to change password \n\n");
			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {

		} catch (UnsupportedEncodingException e) {
			// ...
		}
	}
}
