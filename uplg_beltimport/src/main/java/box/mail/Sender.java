package box.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Sender {
	
	public void order(){
		
		
	}
	
	public void SendOrder(){
		
		final String username = "adiaryservice@gmail.com";
        final String password = "xzxzzxzxcaa1001";
		
		 Properties props = new Properties();
	        props.put("mail.smtp.starttls.enable", "true");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");

	        Session session = Session.getInstance(props,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	          });

	        try {

	            Message message = new MimeMessage(session);     
	            message.setRecipients(Message.RecipientType.TO,
	               InternetAddress.parse("satoru@i.ua"));
	            message.setSubject("html test: ");
	            MimeMultipart multipart = new MimeMultipart("related");
	            BodyPart messageBodyPart = new MimeBodyPart();
	            String htmlText = writeText();
	            messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
	            multipart.addBodyPart(messageBodyPart);
	            messageBodyPart = new MimeBodyPart();
	       
	          
	            messageBodyPart.setHeader("Content-ID", "<image>");
	            multipart.addBodyPart(messageBodyPart);
	            message.setContent(multipart);
	     
	            Transport.send(message);
	            
	        } catch (MessagingException e) {
	            throw new RuntimeException(e);
	        }
		}

		private String writeText() {
			String text = "Dear " + ", <br><br>"
					+ "Your cargo in transit at "+". <br>"
					+ "Estimated delivery date "+ ". <br><br>"
					+"<img src=\"cid:image\"><br><br>"
					+"Best Regards,<br>UPLG Team";
		
			return text;
		}

}
