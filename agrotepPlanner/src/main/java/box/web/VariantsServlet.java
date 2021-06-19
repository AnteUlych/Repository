package box.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.City;
import box.logic.DataBaseController;
import box.logic.GoogleLogic;
import box.model.Client;
import box.model.VariantsHtml;

@Controller
@RequestMapping("/variants")
public class VariantsServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		model.addAttribute("name", name);
		
		return "variants";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String lng1 = request.getParameter("lng");
		String lat1 = request.getParameter("lat");
		
		double longitude = Double.parseDouble(lat1);
		double latitude = Double.parseDouble(lng1);
		
		
				
		
		int needPriceForKm = Integer.parseInt(request.getParameter("needPriceForKm"));
		
		String googleAddress = request.getParameter("googleAddress");
		
		String city = request.getParameter("locality");
		String oblast = request.getParameter("administrative_area_level_1");

		
		if (googleAddress != null){
			try {
				googleAddress = new String(googleAddress.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}

		if (city != null){
			try {
				city = new String(city.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (oblast != null){
			try {
				oblast = new String(oblast.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		List<VariantsHtml> listOfVariants = new ArrayList();		
	
		DataBaseController base = new DataBaseController();
		
		//Kyiv
		VariantsHtml toKyiv = new VariantsHtml();
		
		toKyiv.setFinishPoint(City.KYIV_NAME);
		toKyiv.setFinishPrice(0);
		toKyiv.setListNextClients(new ArrayList());
		toKyiv.setListStartClients(base.getListOfClientsByOblastFtomAndOblastTo(oblast, City.KYIV_NAME));
		toKyiv.setNextClients(0);
		toKyiv.setNextPoint(City.KYIV_NAME);
		
		GoogleLogic google = new GoogleLogic();
		int distanceToKyiv = google.calculateDistanceInKmBetweenCoordinates(longitude, latitude, City.KYIV_LONGITUDE, City.KYIV_LATITUDE);
		int priceToKyiv = distanceToKyiv*needPriceForKm;
		
		toKyiv.setNextPrice(priceToKyiv);
		toKyiv.setStartAddress(city);
		toKyiv.setStartClients(base.getListOfClientsByOblastFtomAndOblastTo(oblast, City.KYIV_NAME).size());
		
		listOfVariants.add(toKyiv);
		
		//Odesa	
		VariantsHtml toOdesa = calculateTheVariant(City.ODESA_LONGITUDE, City.ODESA_LATITUDE, City.ODESA_KYIV, City.ODESA_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toOdesa);	
		
		
		//DNIPRO
		VariantsHtml toDnipro = calculateTheVariant(City.DNIPRO_LONGITUDE, City.DNIPRO_LATITUDE, City.DNIPRO_KYIV, City.DNIPRO_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toDnipro);
		//CHERNIGIV
		VariantsHtml toChernigiv = calculateTheVariant(City.CHERNIGIV_LONGITUDE, City.CHERNIGIV_LATITUDE, City.CHERNIGIV_KYIV, City.CHERNIGIV_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toChernigiv);
		//KHARKIV
		VariantsHtml toKharkiv = calculateTheVariant(City.KHARKIV_LONGITUDE, City.KHARKIV_LATITUDE, City.KHARKIV_KYIV, City.KHARKIV_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toKharkiv);	
	
		//ZHYTOMYR
		VariantsHtml toZhytomyr = calculateTheVariant(City.ZHYTOMYR_LONGITUDE, City.ZHYTOMYR_LATITUDE, City.ZHYTOMYR_KYIV, City.ZHYTOMYR_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toZhytomyr);		
		//POLTAVA
		VariantsHtml toPoltava = calculateTheVariant(City.POLTAVA_LONGITUDE, City.POLTAVA_LATITUDE, City.POLTAVA_KYIV, City.POLTAVA_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toPoltava);	
		//KHERSON
		VariantsHtml toKherson = calculateTheVariant(City.KHERSON_LONGITUDE, City.KHERSON_LATITUDE, City.KHERSON_KYIV, City.KHERSON_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toKherson);
		//ZAPORIZZA
		VariantsHtml toZaporizza = calculateTheVariant(City.ZAPORIZZA_LONGITUDE, City.ZAPORIZZA_LATITUDE, City.ZAPORIZZA_KYIV, City.ZAPORIZZA_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toZaporizza);
		//LUGANSK
		//DONETSK
		//VINNITSA
		VariantsHtml toVinnitsa = calculateTheVariant(City.VINNITSA_LONGITUDE, City.VINNITSA_LATITUDE, City.VINNITSA_KYIV, City.VINNITSA_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toVinnitsa);
		//MYKOLAIV
		VariantsHtml toMykolaiv = calculateTheVariant(City.MYKOLAIV_LONGITUDE, City.MYKOLAIV_LATITUDE, City.MYKOLAIV_KYIV, City.MYKOLAIV_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toMykolaiv);
		//KIROVOGRAD
		VariantsHtml toKirovograd = calculateTheVariant(City.KIROVOGRAD_LONGITUDE, City.KIROVOGRAD_LATITUDE, City.KIROVOGRAD_KYIV, City.KIROVOGRAD_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toKirovograd);
		//SUMY
		VariantsHtml toSumy = calculateTheVariant(City.SUMY_LONGITUDE, City.SUMY_LATITUDE, City.SUMY_KYIV, City.SUMY_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toSumy);
		//LVIV
		VariantsHtml toLviv = calculateTheVariant(City.LVIV_LONGITUDE, City.LVIV_LATITUDE, City.LVIV_KYIV, City.LVIV_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toLviv);
		//CHERKASY
		VariantsHtml toCherkasy = calculateTheVariant(City.CHERKASY_LONGITUDE, City.CHERKASY_LATITUDE, City.CHERKASY_KYIV, City.CHERKASY_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toCherkasy);
		//KHMELNYTSK
		VariantsHtml toKhmelnytsk = calculateTheVariant(City.KHMELNYTSK_LONGITUDE, City.KHMELNYTSK_LATITUDE, City.KHMELNYTSK_KYIV, City.KHMELNYTSK_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toKhmelnytsk);
		//VOLYN
		VariantsHtml toVolyn = calculateTheVariant(City.VOLYN_LONGITUDE, City.VOLYN_LATITUDE, City.VOLYN_KYIV, City.VOLYN_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toVolyn);
		//RIVNE
		VariantsHtml toRivne = calculateTheVariant(City.RIVNE_LONGITUDE, City.RIVNE_LATITUDE, City.RIVNE_KYIV, City.RIVNE_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toRivne);
		//FRANKIVSK
		VariantsHtml toFrankivsk = calculateTheVariant(City.FRANKIVSK_LONGITUDE, City.FRANKIVSK_LATITUDE, City.FRANKIVSK_KYIV, City.FRANKIVSK_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toFrankivsk);
		//TERNOPIL
		VariantsHtml toTernopil = calculateTheVariant(City.TERNOPIL_LONGITUDE, City.TERNOPIL_LATITUDE, City.TERNOPIL_KYIV, City.TERNOPIL_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toTernopil);
		//ZAKARPATTIA
		VariantsHtml toZakarpattia = calculateTheVariant(City.ZAKARPATTIA_LONGITUDE, City.ZAKARPATTIA_LATITUDE, City.ZAKARPATTIA_KYIV, City.ZAKARPATTIA_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toZakarpattia);
		//CHERNIVTSI
		VariantsHtml toChernivtsi = calculateTheVariant(City.CHERNIVTSI_LONGITUDE, City.CHERNIVTSI_LATITUDE, City.CHERNIVTSI_KYIV, City.CHERNIVTSI_NAME, base, needPriceForKm, oblast, city,longitude, latitude);
		listOfVariants.add(toChernivtsi);
		
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("listOfVariants", listOfVariants);
		
		model.addAttribute("googleAddress", googleAddress);
		model.addAttribute("needPriceForKm", needPriceForKm);
		
		return "variants";	
		
	}
	
	    private VariantsHtml calculateTheVariant(double cityLongitude, double cityLatitude, int cityCity, String cityName, DataBaseController base, int needPriceForKm, String oblast, String city, double longitude, double latitude){
		
		GoogleLogic google = new GoogleLogic();
		
        VariantsHtml variant = new VariantsHtml();
		
		variant.setFinishPoint(City.KYIV_NAME); //not change
		variant.setFinishPrice((int) Math.round(cityCity*google.correctkilometr*needPriceForKm));
		List<Client> nextClients = base.getListOfClientsByOblastFtomAndOblastTo(cityName, City.KYIV_NAME);
		variant.setListNextClients(nextClients);
		List<Client> startClients = base.getListOfClientsByOblastFtomAndOblastTo(oblast, cityName);
		variant.setListStartClients(startClients);
		variant.setNextClients(nextClients.size());
		variant.setNextPoint(cityName);
		
		int distanceOfVariant = google.calculateDistanceInKmBetweenCoordinates(longitude, latitude, cityLongitude, cityLatitude);
		int priceOfVariant = distanceOfVariant*needPriceForKm;
		
		variant.setNextPrice(priceOfVariant);
		variant.setStartAddress(city);
		variant.setStartClients(startClients.size());
		
		return variant;
	}

}
