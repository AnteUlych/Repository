package box.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import box.model.Manager;
import box.model.ManagerReport;
import box.model.Product;
import box.model.ProductReport;

@Controller
@RequestMapping("/report")
public class ReportServlet {
	
	Constants constant = new Constants();
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
			
			 int id = (Integer) session.getAttribute("id");
			 int rank = (Integer) session.getAttribute("rank");
			 String name = (String) session.getAttribute("name");
			
			
			 DataBaseController base = new DataBaseController();
			 
			 
			 String messagealert = "";
			 String menuForHead = "";
			 
			 String buttonoff = "";
			 
			 if(rank == constant.MANAGER_RANK_MANAGER){
				 buttonoff = "disabled";
			 }else{

				 menuForHead = constant.MENU_FOR_HEAD;
			 }
			 //Date
			    Calendar timeForLastSaterday = Calendar.getInstance();	
				timeForLastSaterday.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
				timeForLastSaterday.add(Calendar.WEEK_OF_MONTH, -1);	
				Date saturday = timeForLastSaterday.getTime();

				
				Calendar timeForLastMonday = Calendar.getInstance();	
				timeForLastMonday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				timeForLastMonday.add(Calendar.WEEK_OF_MONTH, -1);	
				Date monday = timeForLastMonday.getTime();
				
				String pattern = "yyyy-MM-dd";
				DateFormat df = new SimpleDateFormat(pattern);
		     
				String mondayText = df.format(monday);
				String saturdayText = df.format(saturday);
				
				//Date
				
			 List<Product> products = base.getListOfOpenProducts();
			 
			 List<ProductReport> prodReport = new ArrayList();
			 
			 if(rank != constant.MANAGER_RANK_MANAGER){
			 for(Product prod : products){
				 
				 ProductReport p = new ProductReport();
				 
				 int prodCold = base.getClientsByFunelAndOpenProduct(constant.CLIENT_FUNEL_COLD_CALL, prod.getProduct()).size();
				 int prodLpr = base.getClientsByFunelAndOpenProduct(constant.CLIENT_FUNEL_COMUNICATION_WITH_LPR, prod.getProduct()).size();
				 int prodContract = base.getClientsByFunelAndOpenProduct(constant.CLIENT_FUNEL_CONTRACT_DEALING, prod.getProduct()).size();
				 int prodNewClient = base.getClientsByFunelAndOpenProduct(constant.CLIENT_FUNEL_BECAME_CLIENT, prod.getProduct()).size();
				 
				 p.setNewClients(prodCold);
				 p.setKpiLpr(prodLpr);
				 p.setKpiContract(prodContract);
				 p.setKpiClient(prodNewClient);
				 p.setProductName(prod.getProduct());
				 p.setProductid(prod.getId());
				 
				 prodReport.add(p);
				 
			 }
			 }
			 List <Manager> managers = base.getListOfNotAdminManagers();
			 List<ManagerReport> managerReports = new ArrayList();
			 if(rank != constant.MANAGER_RANK_MANAGER){
			 for(Manager m:managers){
				 
				 ManagerReport mr = new ManagerReport();
				 
				 int kpiLpr = base.getListOfRecordsByManagerIdIdAndStatusBetweenDates(m.getId(), constant.RECORDS_RECORDSTATUS_COMUNICATION_WITH_LPR, mondayText, saturdayText).size();
				 int kpiContract = base.getListOfRecordsByManagerIdIdAndStatusBetweenDates(m.getId(), constant.RECORDS_RECORDSTATUS_CONTRACT_DEALING, mondayText, saturdayText).size();
				 int kpiClient = base.getListOfRecordsByManagerIdIdAndStatusBetweenDates(m.getId(), constant.RECORDS_RECORDSTATUS_BECAME_CLIENT, mondayText, saturdayText).size();
				// int newClients = base.getClientsByManagerIdBetweenDates(m.getId(), mondayText, saturdayText).size();
				 String managername = m.getName();
				 
				 mr.setKpiClient(kpiClient);
				 mr.setKpiContract(kpiContract);
				 mr.setKpiLpr(kpiLpr);
				 mr.setManagerName(managername);
				// mr.setNewClients(newClients);
				 mr.setManagerid(m.getId());
				 
				 managerReports.add(mr);
			 }
			 }
			 
			 base.closeConnection();
			 
			 
			 model.addAttribute("name", name);
			 model.addAttribute("products", products);
			 model.addAttribute("menuForHead", menuForHead);
			 
			 model.addAttribute("mondayText", mondayText);
			 model.addAttribute("saturdayText", saturdayText);
			 
			 model.addAttribute("managerReports", managerReports);
			 model.addAttribute("prodReport", prodReport);
			 
			 model.addAttribute("buttonoff", buttonoff);

	    	 return "report";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		
		 DataBaseController base = new DataBaseController();
		 
		 
		 String messagealert = "";
		 String menuForHead = "";
		 String buttonoff = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){
			 buttonoff = "disabled";
		 }else{

			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		 //Date
			 String mondayText = request.getParameter("startreport");
			 String saturdayText  = request.getParameter("finishreport");
		//Date
			
		 List<Product> products = base.getListOfOpenProducts();
		 
		 List<ProductReport> prodReport = new ArrayList();
		 if(rank != constant.MANAGER_RANK_MANAGER){
		 for(Product prod : products){
			 
			 ProductReport p = new ProductReport();
			 
			 int prodCold = base.getClientsByFunelAndOpenProduct(constant.CLIENT_FUNEL_COLD_CALL, prod.getProduct()).size();
			 int prodLpr = base.getClientsByFunelAndOpenProduct(constant.CLIENT_FUNEL_COMUNICATION_WITH_LPR, prod.getProduct()).size();
			 int prodContract = base.getClientsByFunelAndOpenProduct(constant.CLIENT_FUNEL_CONTRACT_DEALING, prod.getProduct()).size();
			 int prodNewClient = base.getClientsByFunelAndOpenProduct(constant.CLIENT_FUNEL_BECAME_CLIENT, prod.getProduct()).size();
			 
			 p.setNewClients(prodCold);
			 p.setKpiLpr(prodLpr);
			 p.setKpiContract(prodContract);
			 p.setKpiClient(prodNewClient);
			 p.setProductName(prod.getProduct());
			 p.setProductid(prod.getId());
			 
			 prodReport.add(p);
			 
		 }
		 }
		 
		 List <Manager> managers = base.getListOfNotAdminManagers();
		 List<ManagerReport> managerReports = new ArrayList();
		 
		 if(rank != constant.MANAGER_RANK_MANAGER){
		 for(Manager m:managers){
			 
			 ManagerReport mr = new ManagerReport();
			 
			 int kpiLpr = base.getListOfRecordsByManagerIdIdAndStatusBetweenDates(m.getId(), constant.RECORDS_RECORDSTATUS_COMUNICATION_WITH_LPR, mondayText, saturdayText).size();
			 int kpiContract = base.getListOfRecordsByManagerIdIdAndStatusBetweenDates(m.getId(), constant.RECORDS_RECORDSTATUS_CONTRACT_DEALING, mondayText, saturdayText).size();
			 int kpiClient = base.getListOfRecordsByManagerIdIdAndStatusBetweenDates(m.getId(), constant.RECORDS_RECORDSTATUS_BECAME_CLIENT, mondayText, saturdayText).size();
			// int newClients = base.getClientsByManagerIdBetweenDates(m.getId(), mondayText, saturdayText).size();
			 String managername = m.getName();
			 
			 mr.setKpiClient(kpiClient);
			 mr.setKpiContract(kpiContract);
			 mr.setKpiLpr(kpiLpr);
			 mr.setManagerName(managername);
			// mr.setNewClients(newClients);
			 mr.setManagerid(m.getId());
			 
			 managerReports.add(mr);
		 }
		 }
		
		 
		 base.closeConnection();
		 
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 
		 model.addAttribute("mondayText", mondayText);
		 model.addAttribute("saturdayText", saturdayText);
		 
		 model.addAttribute("managerReports", managerReports);
		 model.addAttribute("prodReport", prodReport);
		 
		 model.addAttribute("buttonoff", buttonoff);
		
		return "report";
	}

}
