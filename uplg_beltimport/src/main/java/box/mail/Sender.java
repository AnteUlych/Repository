package box.mail;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import box.logic.DataBase;
import box.web.Request;

public class Sender {

	final String username = "uplg.monitoring@gmail.com";
	final String password = "Klug0506";

	String responsible = ", anton.ulych@gmail.com, satoru@i.ua";
	String subject = "beltimport order: ";
	String addEX1 = "<tr><td>EX1</td><td>45 eur</td></tr>";
	String addEUR1 = "<tr><td>EUR1</td><td>55 eur</td></tr>";
	int EX1cost = 45;
	int EUR1cost = 55;

	public void sendOrder(Request request, String price, String delivery) {

		String clientMail = getMailOfClient(request.getClient());

		Properties props = new Properties();
		
	
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.debug", "false");
		
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			MimeMessage msg = new MimeMessage(session);
			// msg.setFrom(new InternetAddress("satoru@i.ua"));
			msg.setRecipients(Message.RecipientType.TO, clientMail
					+ responsible);
			msg.setSubject(subject + " "+getContactOfClient(request.getClient()));
			msg.setSentDate(new Date());

			Multipart multipart = new MimeMultipart();

			MimeBodyPart htmlPart = new MimeBodyPart();
			// String htmlContent =
			// "</style></head><body><h2>Table Caption</h2><p>To add a caption to a table, use the caption tag.</p><table ><tr><th>Month</th><th>Savings</th></tr><tr><td>January</td><td>$100</td></tr><tr><td>1</td><td>$50</td></tr><tr><td>February1</td><td>$150</td></tr></table></body></html>";
			String htmlContent = addHtmlContent(request, price, delivery);
			htmlPart.setContent(htmlContent, "text/html");
			multipart.addBodyPart(htmlPart);

			msg.setContent(multipart);
			Transport.send(msg);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private String addHtmlContent(Request request, String price, String delivery) {
	
		String EX1 = "";
		String EUR1 = "";
		/**
		String total = price.replaceAll(" eur", "");
		int totalPrice = Integer.parseInt(total);

		*/
		
		List<String> docs = request.getDocumentation();

		for (String doc : docs) {
			if (doc.contains("EX-1")) {
				EX1 = addEX1;
				//totalPrice = totalPrice + EX1cost;
			}
			if (doc.contains("EUR1")) {
				EUR1 = addEUR1;
				//totalPrice = totalPrice + EUR1cost;
			}

		}
		
		String text1 = "</style></head><body><h2>Order for "
				+ request.getPickup()
				+ ".</h2><p>"
				+ request.getClient()
				+ ", thank You for choosing our service.<br>Our manager will connect with You in 20 minutes for confirmation.</p><table><tr><th>Service</th><th>Cost</th></tr><tr><td>"
				+ request.getAddress() + " - Kyiv, UA, "
				+ request.getQuantity() + " e/p</td><td>"
				+ price + "</td></tr>" + EX1 + EUR1
				
				+ "</table><p>" + delivery
				+ "<br><br> Best Regards,<br>UPLG Team</p></body></html>";
		/**
		String text = "</style></head><body><h2>Order for "
				+ request.getPickup()
				+ ".</h2><p>"
				+ request.getClient()
				+ ", thank You for choosing our service.<br>Our manager will connect with You in 20 minutes for confirmation.</p><table><tr><th>Service</th><th>Cost</th></tr><tr><td>"
				+ request.getAddress() + " - Kyiv, UA, "
				+ request.getQuantity() + " e/p</td><td>"
				+ price + "</td></tr>" + EX1 + EUR1
				+ "<tr><td>Total:</td><td>" + totalPrice + " eur</td></tr>"
				+ "</table><p>" + delivery
				+ "<br><br> Best Regards,<br>UPLG Team</p></body></html>";
			*/
		return text1;
		
		
	//	return "<h2>Order for</h2>";
	}

	private String getMailOfClient(String client) {

		DataBase base = new DataBase();
		List<String> contacts = base.getClientsBase();
	
		for (String contact : contacts) {
			if (contact.contains(client)) {
				String mails[] = contact.split(", ");
				return mails[2];
			}

		}

		return "";
		
	}
	
	private String getContactOfClient(String client) {

		DataBase base = new DataBase();
		List<String> contacts = base.getClientsBase();

		for (String contact : contacts) {
			if (contact.contains(client)) {
				return contact;
			}

		}

		return "";
	}

}
