package bird.expediter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import bird.model.Cargo;
import bird.model.Client;
import bird.model.Route;

public class Tracing {

	public Tracing(Client client, Cargo cargo, Route route) {
		this.client = client;
		this.cargo = cargo;
		this.route = route;
	}

	Client client;
	Cargo cargo;
	Route route;

	String googlemapBeginning = "https://maps.googleapis.com/maps/api/staticmap?zoom=6&size=450x250&sensor=false&maptype=roadmap&markers=color:red|";
	String googlemapMiddle = ",";
	String googlemapEnd = "&key=AIzaSyB9JP_ayj71orucQyQnfyX9j9VOtNs-Jd8";
	String duplicativeMail = "anna@uplg.com.ua"; 
	// "https://maps.googleapis.com/maps/api/staticmap?zoom=6&size=450x250&sensor=false&maptype=roadmap&markers=color:red|51.188188,23.811312&key=AIzaSyB9JP_ayj71orucQyQnfyX9j9VOtNs-Jd8";
	String file = "C:/temp/map.jpg"; 
	
    final String username = "uplg.monitoring@gmail.com";
    final String password = "Klug0506";

	public void trace() {

		try {
			paintMap();
			sendMonitoring();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void paintMap() throws IOException {

		String map = googlemapBeginning + route.getLongitude()
				+ googlemapMiddle + route.getLatitude() + googlemapEnd;
		URL url = new URL(map);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(file);

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();

	}

	private void sendMonitoring() {

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
               InternetAddress.parse(client.getEmail()+", "+duplicativeMail));
            message.setSubject("monitoring: " + cargo.getDescription());
            MimeMultipart multipart = new MimeMultipart("related");
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = writeText();
            messageBodyPart.setContent(htmlText, "text/html");
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource(
            		file);
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<image>");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
     
            Transport.send(message);
            
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
	}

	private String writeText() {
		String text = "Dear "+ client.getName() + ", <br><br>"
				+ "Your cargo in transit at "+route.getStatus()+". <br>"
				+ "Estimated delivery date "+dateTransform(cargo.getDelivery())+ ". <br><br>"
				+"<img src=\"cid:image\"><br><br>"+"<a href=\"http://uplg.info/\">You can track the whole route by UPLG webservice.</a><br><br>login: "+client.getLogin()+"<br>password: "+client.getPassword()+"<br><br>"
				+"Best Regards,<br>UPLG Team";
	
		return text;
	}

	private String dateTransform(Date delivery) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyy");
		return df.format(delivery);
	}

}
