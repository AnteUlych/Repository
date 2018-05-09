package calculator.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import calculator.model.Order;



public class Mail {

	public void send(Order order) {

		final String username = "lksc00001@gmail.com";
		final String password = "xzxzzxzxcaa";

		final String recipient = "satoru@i.ua";
		final String subject = getTime() + " order " + order.getCompany();
		
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
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(recipient));
			message.setSubject(subject);
			message.setText(
					"route: "+order.getWay()+ "\n"+
			"service: "+order.getTransport()+ "\n"+
			"transit time: "+order.getTime()+ "\n"+
			"price: "+order.getPrice()+ " USD\n"+
			"name: "+order.getName()+ "\n"+
			"company: "+order.getCompany()+ "\n"+
			"phone: "+order.getPhone()+ "\n"+
			"mail: "+order.getMail()+ "\n"+
			"date: "+order.getDate()
			
					);


			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private String getTime(){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();        
		String now = df.format(today);
		
		return now;
		
	}
}
