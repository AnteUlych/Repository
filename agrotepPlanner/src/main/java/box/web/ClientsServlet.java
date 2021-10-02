package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Client;
import box.model.Direction;
import box.model.History;

@Controller
@RequestMapping("/clients")
public class ClientsServlet {

	public static final String ODESA = "Одеська область";
	public static final String DNIPRO = "Дніпропетровська область";
	public static final String CHERNIGIV = "Чернігівська область";
	public static final String KHARKIV = "Харківська область";
	public static final String ZHYTOMYR = "Житомирська область";
	public static final String POLTAVA = "Полтавська область";
	public static final String KHERSON = "Херсонська область";
	public static final String KYIV = "Київська область";
	public static final String ZAPORIZZA = "Запорізька область";
	public static final String LUGANSK = "Луганська область";
	public static final String DONETSK = "Донецька область";
	public static final String VINNITSA = "Вінницька область";
	public static final String KRYM = "???";
	public static final String MYKOLAIV = "Миколаївська область";
	public static final String KIROVOGRAD = "Кіровоградська область";
	public static final String SUMY = "Сумська область";
	public static final String LVIV = "Львівська область";
	public static final String CHERKASY = "Черкаська область";
	public static final String KHMELNYTSK = "Хмельницька область";
	public static final String VOLYN = "Волинська область";
	public static final String RIVNE = "Рівненська область";
	public static final String FRANKIVSK = "Івано-Франківська область";
	public static final String TERNOPIL = "Тернопільська область";
	public static final String ZAKARPATTIA = "Закарпатська область";
	public static final String CHERNIVTSI = "Чернівецька область";
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		DataBaseController base = new DataBaseController(); 
		
		List<Client> clients = base.getListOfClients();
		
		List<Client> clientsODESA = new ArrayList();
		List<Client> clientsDNIPRO = new ArrayList();
		List<Client> clientsCHERNIGIV = new ArrayList();
		List<Client> clientsKHARKIV = new ArrayList();
		List<Client> clientsZHYTOMYR = new ArrayList();
		List<Client> clientsPOLTAVA = new ArrayList();
		List<Client> clientsKHERSON = new ArrayList();
		List<Client> clientsKYIV = new ArrayList();
		List<Client> clientsZAPORIZZA = new ArrayList();
		List<Client> clientsLUGANSK = new ArrayList();
		List<Client> clientsDONETSK = new ArrayList();
		List<Client> clientsVINNITSA = new ArrayList();
		List<Client> clientsKRYM = new ArrayList();
		List<Client> clientsMYKOLAIV = new ArrayList();
		List<Client> clientsKIROVOGRAD = new ArrayList();
		List<Client> clientsSUMY = new ArrayList();
		List<Client> clientsLVIV = new ArrayList();
		List<Client> clientsCHERKASY = new ArrayList();
		List<Client> clientsKHMELNYTSK = new ArrayList();
		List<Client> clientsVOLYN = new ArrayList();
		List<Client> clientsRIVNE = new ArrayList();
		List<Client> clientsFRANKIVSK = new ArrayList();
		List<Client> clientsTERNOPIL = new ArrayList();
		List<Client> clientsZAKARPATTIA = new ArrayList();
		List<Client> clientsCHERNIVTSI = new ArrayList();
		
		
		for(Client c:clients){
			
			if(base.isClientHasOblastFromByDirection(c.getId(), ODESA)){
				clientsODESA.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), DNIPRO)){
				clientsDNIPRO.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), CHERNIGIV)){
				clientsCHERNIGIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KHARKIV)){
				clientsKHARKIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), ZHYTOMYR)){
				clientsZHYTOMYR.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), POLTAVA)){
				clientsPOLTAVA.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KHERSON)){
				clientsKHERSON.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KYIV)){
				clientsKYIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), ZAPORIZZA)){
				clientsZAPORIZZA.add(c);
			}
		
			if(base.isClientHasOblastFromByDirection(c.getId(), LUGANSK)){
				clientsLUGANSK.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), DONETSK)){
				clientsDONETSK.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), VINNITSA)){
				clientsVINNITSA.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KRYM)){
				clientsKRYM.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), MYKOLAIV)){
				clientsMYKOLAIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KIROVOGRAD)){
				clientsKIROVOGRAD.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), SUMY)){
				clientsSUMY.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), LVIV)){
				clientsLVIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), CHERKASY)){
				clientsCHERKASY.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KHMELNYTSK)){
				clientsKHMELNYTSK.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), VOLYN)){
				clientsVOLYN.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), RIVNE)){
				clientsRIVNE.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), FRANKIVSK)){
				clientsFRANKIVSK.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), TERNOPIL)){
				clientsTERNOPIL.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), ZAKARPATTIA)){
				clientsZAKARPATTIA.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), CHERNIVTSI)){
				clientsCHERNIVTSI.add(c);
			}
			
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("clientsODESA", clientsODESA);
		model.addAttribute("clientsDNIPRO", clientsDNIPRO);
		model.addAttribute("clientsCHERNIGIV", clientsCHERNIGIV);
		model.addAttribute("clientsKHARKIV", clientsKHARKIV);
		model.addAttribute("clientsZHYTOMYR", clientsZHYTOMYR);
		model.addAttribute("clientsPOLTAVA", clientsPOLTAVA);
		model.addAttribute("clientsKHERSON", clientsKHERSON);
		model.addAttribute("clientsKYIV", clientsKYIV);
		model.addAttribute("clientsZAPORIZZA", clientsZAPORIZZA);
		model.addAttribute("clientsLUGANSK", clientsLUGANSK);
		model.addAttribute("clientsDONETSK", clientsDONETSK);
		model.addAttribute("clientsVINNITSA", clientsVINNITSA);
		model.addAttribute("clientsKRYM", clientsKRYM);
		model.addAttribute("clientsMYKOLAIV", clientsMYKOLAIV);
		model.addAttribute("clientsKIROVOGRAD", clientsKIROVOGRAD);
		model.addAttribute("clientsSUMY", clientsSUMY);
		model.addAttribute("clientsLVIV", clientsLVIV);
		model.addAttribute("clientsCHERKASY", clientsCHERKASY);
		model.addAttribute("clientsKHMELNYTSK", clientsKHMELNYTSK);
		model.addAttribute("clientsVOLYN", clientsVOLYN);
		model.addAttribute("clientsRIVNE", clientsRIVNE);
		model.addAttribute("clientsFRANKIVSK", clientsFRANKIVSK);
		model.addAttribute("clientsTERNOPIL", clientsTERNOPIL);
		model.addAttribute("clientsZAKARPATTIA", clientsZAKARPATTIA);
		model.addAttribute("clientsCHERNIVTSI", clientsCHERNIVTSI);
	
		return "clients";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		String name = (String) session.getAttribute("name");
		
		DataBaseController base = new DataBaseController(); 
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String company = request.getParameter("company");
		String code = request.getParameter("code");
		String contactPerson = request.getParameter("contactPerson");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String payment = request.getParameter("payment");
		String transportVolume = request.getParameter("transportVolume");
		String season = request.getParameter("season");
		String cargo = request.getParameter("cargo");
		String otherInfo = request.getParameter("otherInfo");
		String typetruck = request.getParameter("typetruck");
		String warning = request.getParameter("warning");
		String driverInstruction = request.getParameter("driverInstruction");
		
		if (driverInstruction != null){
			try {
				driverInstruction = new String(driverInstruction.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (company != null){
			try {
				company = new String(company.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (contactPerson != null){
			try {
				contactPerson = new String(contactPerson.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (phone != null){
			try {
				phone = new String(phone.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (payment != null){
			try {
				payment = new String(payment.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (transportVolume != null){
			try {
				transportVolume = new String(transportVolume.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (season != null){
			try {
				season = new String(season.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (cargo != null){
			try {
				cargo = new String(cargo.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (otherInfo != null){
			try {
				otherInfo = new String(otherInfo.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (typetruck != null){
			try {
				typetruck = new String(typetruck.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (warning != null){
			try {
				warning = new String(warning.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		
		if(!base.isClientExistbyCode(code)){
			
			Client client = new Client();
			
			client.setBlacklist(Constants.CLIENT_NOT_IN_BLACK_LIST);
			client.setCargo(cargo);
			client.setCode(code);
			client.setCompany(company);
			client.setContactPerson(contactPerson);
			client.setCreatingDate(new Date());
			client.setEmail(email);
			client.setOtherInfo(otherInfo);
			client.setPayment(payment);
			client.setPhone(phone);
			client.setSalesId(id);
			client.setSalesName(name);
			client.setSeason(season);
			client.setTransportVolume(transportVolume);
			client.setTypetruck(typetruck);
			client.setWarning(warning);
			client.setDriverInstruction(driverInstruction);
			
			base.addClient(client);
			
			History history = new History();
			
			history.setAction(Constants.ACTION_NEW_CLIENT);
			history.setActionDate(new Date());
			history.setInfo(company+" доданий в систему");
			history.setManager(name);
			history.setManagerid(id);
			
			base.addHistory(history);
			
	    	int idForNextPage = base.getClientIdByCode(code);
					
			base.closeConnection();
			
			try {
				response.sendRedirect("/planner/client/"+idForNextPage);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "client";
			
		}
		
		
		List<Client> clients = base.getListOfClients();
		
		List<Client> clientsODESA = new ArrayList();
		List<Client> clientsDNIPRO = new ArrayList();
		List<Client> clientsCHERNIGIV = new ArrayList();
		List<Client> clientsKHARKIV = new ArrayList();
		List<Client> clientsZHYTOMYR = new ArrayList();
		List<Client> clientsPOLTAVA = new ArrayList();
		List<Client> clientsKHERSON = new ArrayList();
		List<Client> clientsKYIV = new ArrayList();
		List<Client> clientsZAPORIZZA = new ArrayList();
		List<Client> clientsLUGANSK = new ArrayList();
		List<Client> clientsDONETSK = new ArrayList();
		List<Client> clientsVINNITSA = new ArrayList();
		List<Client> clientsKRYM = new ArrayList();
		List<Client> clientsMYKOLAIV = new ArrayList();
		List<Client> clientsKIROVOGRAD = new ArrayList();
		List<Client> clientsSUMY = new ArrayList();
		List<Client> clientsLVIV = new ArrayList();
		List<Client> clientsCHERKASY = new ArrayList();
		List<Client> clientsKHMELNYTSK = new ArrayList();
		List<Client> clientsVOLYN = new ArrayList();
		List<Client> clientsRIVNE = new ArrayList();
		List<Client> clientsFRANKIVSK = new ArrayList();
		List<Client> clientsTERNOPIL = new ArrayList();
		List<Client> clientsZAKARPATTIA = new ArrayList();
		List<Client> clientsCHERNIVTSI = new ArrayList();
		
		
		for(Client c:clients){
			
			if(base.isClientHasOblastFromByDirection(c.getId(), ODESA)){
				clientsODESA.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), DNIPRO)){
				clientsDNIPRO.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), CHERNIGIV)){
				clientsCHERNIGIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KHARKIV)){
				clientsKHARKIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), ZHYTOMYR)){
				clientsZHYTOMYR.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), POLTAVA)){
				clientsPOLTAVA.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KHERSON)){
				clientsKHERSON.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KYIV)){
				clientsKYIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), ZAPORIZZA)){
				clientsZAPORIZZA.add(c);
			}
		
			if(base.isClientHasOblastFromByDirection(c.getId(), LUGANSK)){
				clientsLUGANSK.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), DONETSK)){
				clientsDONETSK.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), VINNITSA)){
				clientsVINNITSA.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KRYM)){
				clientsKRYM.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), MYKOLAIV)){
				clientsMYKOLAIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KIROVOGRAD)){
				clientsKIROVOGRAD.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), SUMY)){
				clientsSUMY.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), LVIV)){
				clientsLVIV.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), CHERKASY)){
				clientsCHERKASY.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), KHMELNYTSK)){
				clientsKHMELNYTSK.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), VOLYN)){
				clientsVOLYN.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), RIVNE)){
				clientsRIVNE.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), FRANKIVSK)){
				clientsFRANKIVSK.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), TERNOPIL)){
				clientsTERNOPIL.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), ZAKARPATTIA)){
				clientsZAKARPATTIA.add(c);
			}
			
			if(base.isClientHasOblastFromByDirection(c.getId(), CHERNIVTSI)){
				clientsCHERNIVTSI.add(c);
			}
			
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("clientsODESA", clientsODESA);
		model.addAttribute("clientsDNIPRO", clientsDNIPRO);
		model.addAttribute("clientsCHERNIGIV", clientsCHERNIGIV);
		model.addAttribute("clientsKHARKIV", clientsKHARKIV);
		model.addAttribute("clientsZHYTOMYR", clientsZHYTOMYR);
		model.addAttribute("clientsPOLTAVA", clientsPOLTAVA);
		model.addAttribute("clientsKHERSON", clientsKHERSON);
		model.addAttribute("clientsKYIV", clientsKYIV);
		model.addAttribute("clientsZAPORIZZA", clientsZAPORIZZA);
		model.addAttribute("clientsLUGANSK", clientsLUGANSK);
		model.addAttribute("clientsDONETSK", clientsDONETSK);
		model.addAttribute("clientsVINNITSA", clientsVINNITSA);
		model.addAttribute("clientsKRYM", clientsKRYM);
		model.addAttribute("clientsMYKOLAIV", clientsMYKOLAIV);
		model.addAttribute("clientsKIROVOGRAD", clientsKIROVOGRAD);
		model.addAttribute("clientsSUMY", clientsSUMY);
		model.addAttribute("clientsLVIV", clientsLVIV);
		model.addAttribute("clientsCHERKASY", clientsCHERKASY);
		model.addAttribute("clientsKHMELNYTSK", clientsKHMELNYTSK);
		model.addAttribute("clientsVOLYN", clientsVOLYN);
		model.addAttribute("clientsRIVNE", clientsRIVNE);
		model.addAttribute("clientsFRANKIVSK", clientsFRANKIVSK);
		model.addAttribute("clientsTERNOPIL", clientsTERNOPIL);
		model.addAttribute("clientsZAKARPATTIA", clientsZAKARPATTIA);
		model.addAttribute("clientsCHERNIVTSI", clientsCHERNIVTSI);
	
		return "clients";

	}

}
