package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.DecoderDBtoHTML;
import box.model.Product;
import box.model.Records;

@Controller
public class ManagerreportServlet {
	
	Constants constant = new Constants();
	String encoderforSplit = "&_";
	
	@RequestMapping(value = "/managerreport/{code}", method = RequestMethod.GET)
	public String doGet(@PathVariable("code") String code, ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		
		 DataBaseController base = new DataBaseController();
		 List<Product> products = base.getListOfOpenProducts();

		 String menuForHead = "";
		 		 
		 if(rank == constant.MANAGER_RANK_MANAGER){
			 base.closeConnection();
			 return "reportwithclients";
		 }else{

			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		 

			String [] comand = code.split(encoderforSplit);			
			DecoderDBtoHTML decoder = new DecoderDBtoHTML();
			
			int managerid = Integer.parseInt(comand[0]);
			String fromDate = comand[1];
			String toDate = comand[2];	
		
			String managerbetweendates = base.getManagerById(managerid).getName()+" "+fromDate+" - "+toDate;
			
			List<Records> records = base.getListOfRecordsByManagerIdsBetweenDates(managerid, fromDate, toDate);
			List<String> icons = decoder.translateForRecordsFunelfromDBtoIcons(records);
			
			List<String> companies = new ArrayList();
			List<Integer> companiesid = new ArrayList();
			
			for(Records r:records){
				String company = base.getClientById(r.getClientid()).getCompany();
				int comId = base.getClientById(r.getClientid()).getId();
				companies.add(company);
				companiesid.add(comId);
			}
			
			base.closeConnection();
			
			 model.addAttribute("name", name);
			 model.addAttribute("products", products);
			 model.addAttribute("menuForHead", menuForHead);
			 
			 model.addAttribute("records", records);
			 model.addAttribute("icons", icons);
			 model.addAttribute("companies", companies);
			 model.addAttribute("companiesid", companiesid);
			 model.addAttribute("managerbetweendates", managerbetweendates);
			 
			
		return "managerreport";
	}
    	

}
