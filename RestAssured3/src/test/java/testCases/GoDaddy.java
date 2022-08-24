package testCases;


//import java.io.IOException;
import java.util.Properties;
import javax.mail.MessagingException;
//import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;

public class GoDaddy {


	public static void main(String args[])  {


		Properties props = new Properties();
		props.put("mail.host", "smtpout.secureserver.net");
		props.put("mail.port", "587");
		props.put("mail.username", "registration@plasmamohp.com");
		props.put("mail.password", "Pl@ex#mail.08642");
		props.put("mail.protocol", "smtp");

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", "*");


		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("registration@plasmamohp.com", "Pl@ex#mail.08642");
			}
		});
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setFrom(new InternetAddress("registration@plasmamohp.com",false));
			msg.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse("abdelaziz.talima@excelsystems-eg.com"));
			msg.setSubject("Test SMTP.");
			msg.setContent("Test From Abdullaziz.", "text/html");
			//msg.setSentDate(new Date());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("Test Content.", "text/html");

			//    Multipart multipart = new MimeMultipart();
			//     multipart.addBodyPart(messageBodyPart);
			//    MimeBodyPart attachPart = new MimeBodyPart();

			//  attachPart.attachFile("/var/tmp/abc.txt");
			//   multipart.addBodyPart(attachPart);
			// msg.setContent(multipart);
			Transport.send(msg);
			System.out.println("Email sent successfully.");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




}
