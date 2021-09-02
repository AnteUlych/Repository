package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Manager;
import box.model.Truck;

@Controller
public class TruckServlet {
	
	@RequestMapping(value = "/truck/{truckid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("truckid") String truckid,
			ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		DataBaseController base = new DataBaseController(); 
		
		int idOfTruck = Integer.parseInt(truckid);
		
		Truck truck = base.getTruckbyId(idOfTruck);
		List<Manager> managers = base.getListOfManagers();
		
		List<String> responsibleManager = new ArrayList();
		
		for(Manager m:managers){
			if(m.getId()==truck.getManagerid()){
				responsibleManager.add("checked");
			}else{
				responsibleManager.add("");
			}
		}
		
		String tilt = "";
		String ref = "";
		String total = "";
		
		if(truck.getType().equals("тент")){
			tilt = "checked";
		}else if(truck.getType().equals("реф")){
			ref = "checked";
		}else if(truck.getType().equals("цільномет")){
			total = "checked";
		}
		
		String checkBlackList = "";
		if(truck.getNotReady()==Constants.CLIENT_IN_BLACK_LIST){
			checkBlackList = "checked";
		}
		
        base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("truck", truck);
		model.addAttribute("managers", managers);
		model.addAttribute("responsibleManager", responsibleManager);
		
		model.addAttribute("tilt", tilt);
		model.addAttribute("ref", ref);
		model.addAttribute("total", total);
		
		model.addAttribute("checkBlackList", checkBlackList);
		
		return "truck";
	}
	
	@RequestMapping(value = "/truck/{truckid}", method = RequestMethod.POST)
	public String doPost(@PathVariable("truckid") String truckid,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
        DataBaseController base = new DataBaseController(); 
		
		int idOfTruck = Integer.parseInt(truckid);
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String tracktor = request.getParameter("tracktor");
		String trailor = request.getParameter("trailor");
		String driver = request.getParameter("driver");
		String phone = request.getParameter("phone");
		String typetruck = request.getParameter("typetruck");
		String manager = request.getParameter("manar");
		String truckKey = request.getParameter("truckKey");
		
		if (truckKey == null){
			truckKey = "";
		}
		
		if (tracktor != null){
			try {
				tracktor = new String(tracktor.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (trailor != null){
			try {
				trailor = new String(trailor.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (driver != null){
			try {
				driver = new String(driver.getBytes(requestEnc), clientEnc);
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
		
		if (typetruck != null){
			try {
				typetruck = new String(typetruck.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (manager != null){
			try {
				manager = new String(manager.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		int notReady = Constants.TRUCK_READY;
		if(request.getParameter("toblacklist")!=null){
			notReady = Constants.TRUCK_NOT_READY;
		}
		
        Manager m = base.getManagersByName(manager);
		
		int idOfmanager = m.getId();
		
		base.editTruckById(idOfTruck, driver, idOfmanager, notReady, phone, tracktor, trailor, typetruck, manager, truckKey);
		base.closeConnection();
		
		try {
			response.sendRedirect("/planner/trucks");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "trucks";
	}

}
