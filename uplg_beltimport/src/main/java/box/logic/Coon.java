package box.logic;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import box.mail.Sender;

public class Coon {

	public static void main(String[] args) {
		
		 // Recipient's email ID needs to be mentioned.
	    //  String to = "satoru@i.ua";

	      // Sender's email ID needs to be mentioned
	    //  String from = "lksc00001@gmail.com";
	     // final String username = "lksc00001@gmail.com";//change accordingly
	    //  final String password = "xzxzzxzxcaa";//change accordingly
		  Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.port", "587");
	      props.put("mail.debug", "false");
	      Session session = Session.getInstance(props,
	  		  new Authenticator() {
	  			protected PasswordAuthentication getPasswordAuthentication() {
	  				return new PasswordAuthentication("lksc00001@gmail.com", "xzxzzxzxcaa");
	  			}
	  		  });
	    
	       try {
		        MimeMessage msg = new MimeMessage(session);
		        msg.setFrom(new InternetAddress("satoru@i.ua"));
		        msg.setRecipients(Message.RecipientType.TO, "satoru@i.ua, anton.ulych@gmail.com");
		        msg.setSubject("Html Test Mail with Attachement");
		        msg.setSentDate(new Date());
		        
		        Multipart multipart = new MimeMultipart();
		        
		        MimeBodyPart htmlPart = new MimeBodyPart();
		        String htmlContent = "<html><body><h1>\"Html Content</h1></body></html>";
		      //  String htmlContent = addHTML();
		        htmlPart.setContent(htmlContent, "text/html");
		        multipart.addBodyPart(htmlPart);
		        
		     //   MimeBodyPart attachementPart = new MimeBodyPart();
		    //    attachementPart.attachFile(new File("D:/cp/pic.jpg"));
		     //   multipart.addBodyPart(attachementPart);
		        
		        msg.setContent(multipart);
		        Transport.send(msg);
		        System.out.println("---Done---");
	       } catch (Exception ex) {
	    	    ex.printStackTrace();
	       }
	   
	}

	private static String addHTML() {
		// TODO Auto-generated method stub
		return "";
	}

}
