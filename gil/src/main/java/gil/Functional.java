package gil;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Functional {

	boolean lastProblem = true;
	boolean isProblemExist = false;
	boolean newProblem = false;

	public void start() {

		Date start = new Date();
		SimpleDateFormat format = new SimpleDateFormat();
		String now = format.format(start);

		System.out.println(now + " gil was started.");
		System.out.println();

		circuit();
	}

	public void circuit() {

		for (;;) {
			isProblemExist = checking();
			if (isProblemExist) {
				newProblem = true;
			} else {
				newProblem = false;
			}

			if (lastProblem != newProblem) {

				String text;
				Date start = new Date();
				SimpleDateFormat format = new SimpleDateFormat();
				String now = format.format(start);

				if (isProblemExist == true) {
					text = now + " " + Constant.NAME + " doesn`t work!";
					lastProblem = true;
				} else {
					text = now + " " + Constant.NAME + " is available!";
					lastProblem = false;
				}

				System.out.println(text);
				inform(text);
			}
			try {
				Thread.sleep(Constant.TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void inform(String text) {

		final String username = "lksc00001@gmail.com";
		final String password = "xzxzzxzxcaa";

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
					InternetAddress.parse(Constant.ADMIN));
			message.setSubject(Constant.NAME);
			message.setText(text);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	private boolean checking() {

		try {
			URL web = new URL(Constant.SITE);
			HttpURLConnection connection = (HttpURLConnection) web
					.openConnection();
			int status = connection.getResponseCode();
			if (status == Constant.OK) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return true;
		}
	}
}