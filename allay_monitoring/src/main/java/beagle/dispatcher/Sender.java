package beagle.dispatcher;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
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
	
	public Sender(String name, String clientMail, String managerMail, String key, double longitude, double latitude, String status, String etd, String update) {
		this.name=name;
		this.clientMail=clientMail;
		this.managerMail=managerMail;
		this.key=key;
		this.longitude=longitude;
		this.latitude=latitude;
		this.status=status;
		this.etd=etd;
		this.update=update;
	}
	
	String name;
	String clientMail;
	String managerMail;
	String key;
	double longitude;
	double latitude;
	String status;
	String etd;
	String update;

	String subject = "UPLG monitoring";
	
	final String username = "uplg.monitoring@gmail.com";
	final String password = "Klug0506";

	//String client = "satoru@i.ua";

	//String file = "C:/Users/Ante/Desktop/joke/map.jpg";
	//String logo = "C:/Users/Ante/Desktop/joke/logo.png";
	//String compass = "C:/Users/Ante/Desktop/joke/side2.png";
	
	String file = "map.jpg";
	String logo = "logo.png";
	String compass = "side2.png";
	
	String googlemapBeginning = "https://maps.googleapis.com/maps/api/staticmap?zoom=6&size=580x221&sensor=false&maptype=roadmap&markers=color:red|";
	String googlemapMiddle = ",";
	String googlemapEnd = "&key=AIzaSyB9JP_ayj71orucQyQnfyX9j9VOtNs-Jd8";

	public void sendMonitoring() {
	
		try {
			createMap();
			send();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private void createMap() throws IOException{
		
		
		String map = googlemapBeginning + longitude
				+ googlemapMiddle + latitude + googlemapEnd;
		URL url = new URL(map);
		InputStream is = url.openStream();
		OutputStream os = new FileOutputStream(getWay(file));

		byte[] b = new byte[2048];
		int length;

		while ((length = is.read(b)) != -1) {
			os.write(b, 0, length);
		}
		is.close();
		os.close();
	}
	
	private String writeText() {
	
		String text = "<table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       <td>"
				+ "<table width=\"600\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\" align=\"center\" bgcolor=\"#ffffff\" "
				+ "style=\"font-family:helvetica, sans-serif;\" "
				+ "class=\"MainContainer\">     <tbody>     <tr>       "
				+ "<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td valign=\"top\" width=\"20\">&nbsp;</td>       "
				+ "<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td class=\"movableContentContainer\">       "
				+ "<div class=\"movableContent\" style=\"border: 0px; "
				+ "padding-top: 0px; position: relative;\">       "
				+ "<table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td height=\"15\"></td>     </tr>     <tr>       "
				+ "<td><table width=\"100%\" border=\"0\" "
				+ "cellspacing=\"0\" cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td valign=\"top\"><table width=\"100%\" border=\"0\" "
				+ "cellspacing=\"0\" cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td valign=\"top\" width=\"60\"><img src=\""+"cid:picture"+"\" "  //logo
				+ "alt=\"Logo\"  width=\"60\" height=\"60\" data-max-width=\"100\">"
				+ "</td>       <td width=\"10\" valign=\"top\">&nbsp;"
				+ "</td>          </tr>   </tbody> </table> </td>       "
				+ "<td valign=\"top\" width=\"90\" class=\"spechide\">&nbsp;"
				+ "</td>       <td valign=\"middle\" style='vertical-align: "
				+ "middle;' width='150'>                           "
				+ "<div class='contentEditableContainer contentTextEditable'> "
				+ "<div class='contentEditable' style='text-align: right;'> "
				+ "<a target='_blank' href=\"http://uplg.info/monitoring/"+key+"\" class='link1' >" //Link
				+ "Show all information</a>                             "
				+ "</div> "
				+ "</div>"
				+ "</td>     </tr>   </tbody> </table></td>     </tr>     "
				+ "<tr>        <td height='15'></td>     </tr>     <tr>        "
				+ "<td ><hr style='height:1px;background:#DDDDDD;border:none;'>"
				+ "</td>      </tr>   </tbody> </table> 	  </div>        "
				+ "<div class=\"movableContent\" style=\"border: 0px; "
				+ "padding-top: 0px; position: relative;\">      "
				+ " <table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       <td height=\"40\">"
				+ "</td>     </tr>     <tr>       <td valign=\"top\" width=\"580\">"
				+ "<div class='contentEditableContainer contentImageEditable'> "
				+ "<div class='contentEditable' style=\"text-align: center;\">"
				+ "<img class=\"banner\" src=\""+"cid:image"+"\" alt=\"Logo\"  " //map
				+ "width=\"580\" height=\"221\" border=\"0\"></div></div></td>     "
				+ "</tr>   </tbody> </table>                    </div>       "
				+ "<div class=\"movableContent\" style=\"border: 0px; "
				+ "padding-top: 0px; position: relative;\">       "
				+ "<table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td height='40'></td>     </tr>     <tr>       "
				+ "<td style=\"border: 1px solid #EEEEEE; "
				+ "border-radius:6px;-moz-border-radius:6px;-webkit-border-radius:"
				+ "6px\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td valign=\"top\" width=\"40\">&nbsp;</td>       "
				+ "<td><table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\" align=\"center\">                       "
				+ "<tr><td height='25'></td></tr>                       "
				+ "<tr>  <td> <div class='contentEditableContainer "
				+ "contentTextEditable'>                             "
				+ "<div class='contentEditable' > "
				+ " <p>Dear "+name+",<br> The dislocation of Your freight "       //name
				+ "You can see on the <a target='_blank' "
				+ "href=\"http://uplg.info/monitoring/"+key+"\" class='link4' style='color:#27A1E5;' >map</a>.</p>" //link
				+ "</div>  </div>  </td>  </tr> <tr>"
				+ "<td height='24'></td></tr>  </table></td>       "
				+ "<td valign=\"top\" width=\"40\">&nbsp;</td>     </tr>   "
				+ "</tbody> </table> </td>     </tr>   </tbody> </table>       "
				+ "</div> <div class=\"movableContent\" "
				+ "style=\"border: 0px; padding-top: 0px; position: relative;\"> "
				+ "<table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td height=\"40\"></td>     </tr>     <tr>       <td>"
				+ "<table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td class=\"specbundle\" valign=\"top\" width=\"142\" "
				+ "align=\"center\"><div class='contentEditableContainer "
				+ "contentImageEditable'>                       "
				+ "<div class='contentEditable'>                         "
				+ "<img src=\""+"cid:compass"+"\" alt=\"side image\" width='142' " //compass
				+ "height='142' data-default=\"placeholder\" border=\"0\">        "
				+ "               </div>                     </div></td>       "
				+ "<td width=\"20\" valign=\"top\" class=\"spechide\"></td>       "
				+ "<td class=\"specbundle\"><table width=\"100%\" cellpadding=\"0\""
				+ " cellspacing=\"0\" align=\"center\">                       "
				+ "<tr><td height='15'></td></tr>                       <tr>                  "
				+ "       <td>                           "
				+ "<div class='contentEditableContainer contentTextEditable'>     "
				+ "                        <div class='contentEditable' "
				+ "style='text-align: left;'>                               "
				+ "<p>Staus: "+status+"</p>"   //status
				+ "<p>ETD  : "+etd+"</p>"      //etd
				+ "<p>Last update "+update+"</p>" //update
				+ " <br>"
				+ "</div></div>"
				+ "  </td></tr>"
				+ "</table></td>     </tr>   </tbody> </table> </td>     </tr>  "
				+ " </tbody> </table>        </div>      <tr>"
				+ "<td height='40' colspan=\"3\"></td></tr>                 "
				+ "<tr><td colspan=\"3\">"
				+ "<hr style='height:1px;background:#DDDDDD;border:none;'></td></tr>   "
				+ "</tbody> </table>       </div>       "
				+ "<div class=\"movableContent\" style=\"border: 0px; padding-top: 0px; "
				+ "position: relative;\">       "
				+ "<table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>       "
				+ "<td height=\"28\"></td>     </tr>     <tr>      "
				+ " <td><table width=\"100%\" border=\"0\" cellspacing=\"0\" "
				+ "cellpadding=\"0\">   <tbody>     <tr>      "
				+ " <td valign=\"top\" width=\"90\" class=\"spechide\">&nbsp;</td>"
				+ "       <td><table width=\"100%\" cellpadding=\"0\" "
				+ "cellspacing=\"0\" align=\"center\">                       "
				+ "<tr>                         <td>                           "
				+ "<div class='contentEditableContainer contentTextEditable'> "
				+ "                            <div class='contentEditable' "
				+ "style='text-align: center;color:#AAAAAA;'>                    "
				+ "           <p>Best Regards, UP Logistic Company <br/>      "
				+ "</p></div>   </div>    </td>   </tr> </table></td>      "
				+ " <td valign=\"top\" width=\"90\" class=\"spechide\">&nbsp;</td>"
				+ "     </tr>   </tbody> </table> </td>     </tr>   </tbody> "
				+ "</table>                   </div>             </td>     </tr> "
				+ "  </tbody> </table> </td>       "
				+ "<td valign=\"top\" width=\"20\">&nbsp;</td>     </tr>   "
				+ "</tbody> </table> </td>     </tr>   </tbody></table>     ";

		return text;
	}

	private void send() {
		
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
					InternetAddress.parse(clientMail+", "+managerMail));
			message.setSubject(subject);
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart messageBodyPart = new MimeBodyPart();
			String htmlText = writeText();
			messageBodyPart.setContent(htmlText, "text/html; charset=UTF-8");
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
			DataSource fds = new FileDataSource(getWay(file));		
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<image>");
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
			DataSource fdsLogo = new FileDataSource(getWay(logo));		
			messageBodyPart.setDataHandler(new DataHandler(fdsLogo));
			messageBodyPart.setHeader("Content-ID", "<picture>");
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
			DataSource fdsCompass = new FileDataSource(getWay(compass));		
			messageBodyPart.setDataHandler(new DataHandler(fdsCompass));
			messageBodyPart.setHeader("Content-ID", "<compass>");
			multipart.addBodyPart(messageBodyPart);
			
			message.setContent(multipart);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}
	
	private String getWay(String name){
		try {
			String path = this.getClass().getClassLoader().getResource("").getPath();
			String fullPath;
			
				fullPath = URLDecoder.decode(path, "UTF-8");
		
			String pathArr[] = fullPath.split("WEB-INF/classes/");
			String way = pathArr[0].substring(1)+"resources/images/"+name;
			
			return way;
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		return null;
	}

}
