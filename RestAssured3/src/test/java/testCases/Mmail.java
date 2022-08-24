package testCases;


//import java.util.Properties;
//
//import javax.mail.Authenticator;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.AddressException;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mmail {
	
	

	
//		
//	public static void main(String[] args) {
//		final String fromEmail = "ahmed.abdelstar@excelsystems-eg.com"; //requires valid gmail id
//		final String password = "Ahmed@01113693626"; // correct password for gmail id
//		final String toEmail = "abdelaziz.talima@excelsystems-eg.com"; // can be any email id 
//		
//		System.out.println("SSLEmail Start");
//		Properties props = new Properties();
//		props.put("mail.smtp.host", "mail.excelsystems-eg.com"); //SMTP Host
//		props.put("mail.smtp.socketFactory.port", "587"); //SSL Port
//		props.put("mail.smtp.socketFactory.class",
//				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
//		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
//		props.put("mail.smtp.port", "587"); //SMTP Port
//		
//		Authenticator auth = new Authenticator() {
//			//override the getPasswordAuthentication method
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(fromEmail, password);
//			}
//		};
//		
//		Session session = Session.getDefaultInstance(props, auth);
//		System.out.println("Session created");
//	        EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");
//
//	      //  EmailUtil.sendAttachmentEmail(session, toEmail,"SSLEmail Testing Subject with Attachment", "SSLEmail Testing Body with Attachment");
//
//	       // EmailUtil.sendImageEmail(session, toEmail,"SSLEmail Testing Subject with Image", "SSLEmail Testing Body with Image");
//
//	}


	
	

		Properties emailProperties;
		Session mailSession;
		MimeMessage emailMessage;

		public static void main(String args[]) throws AddressException,
				MessagingException {

			Mmail javaEmail = new Mmail();

			javaEmail.setMailServerProperties();
			javaEmail.createEmailMessage();
			javaEmail.sendEmail();
		}

		public void setMailServerProperties() {

			String emailPort = "587";//gmail's smtp port

			emailProperties = System.getProperties();
			emailProperties.put("mail.smtp.port", emailPort);
			emailProperties.put("mail.smtp.auth", "true");
			emailProperties.put("mail.smtp.starttls.enable", "true");

		}

		public void createEmailMessage() throws AddressException,
				MessagingException {
		//	String[] toEmails = { "abdelaziz.talima@excelsystems-eg.com" };
			String[] toEmails = { "hassan.abdelrasoul@excelsystems-eg.com" };
			String emailSubject = "Java Email";
			String emailBody = "This is an email sent by JavaMail api.";

			mailSession = Session.getDefaultInstance(emailProperties, null);
			emailMessage = new MimeMessage(mailSession);

			for (int i = 0; i < toEmails.length; i++) {
				emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
			}

			emailMessage.setSubject(emailSubject);
			emailMessage.setContent(emailBody, "text/html");//for a html email
			//emailMessage.setText(emailBody);// for a text email

		}

		public void sendEmail() throws AddressException, MessagingException {

			String emailHost = "mail.excelsystems-eg.com";
			String fromUser = "ahmed.abdelstar@excelsystems-eg.com";//just the id alone without @gmail.com
			String fromUserEmailPassword = "Ahmed@01113693626";

			Transport transport = mailSession.getTransport("smtp");

			transport.connect(emailHost, fromUser, fromUserEmailPassword);
			transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
			transport.close();
			System.out.println("Email sent successfully.");
		}

}
