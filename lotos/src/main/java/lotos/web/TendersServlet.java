package lotos.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.ConstantBase;
import lotos.logic.DataController;
import lotos.model.Tender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/tenders")
public class TendersServlet {
	

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, ModelMap model) {
		
		HttpSession session = request.getSession();
		int code = (Integer) session.getAttribute("id");
		
		DataController data = new DataController();
		List<Tender> tenders = data.getOpenTenders();
		
		String htmlFrom = "-";
		String htmlTo = "-";
		String htmlTransport = "any";
		int htmlMore = 0;
		int htmlLess= 50000;
		
		model.addAttribute("htmlFrom", htmlFrom);	
		model.addAttribute("htmlTo", htmlTo);	
		model.addAttribute("htmlTransport", htmlTransport);	
		model.addAttribute("htmlMore", htmlMore);	
		model.addAttribute("htmlLess", htmlLess);	
		
		String company;
		if(code!=0){
			company = data.getCompanyById(code).getCompany();
		}else{
			company="<a href=\"/lotos/sign_in\" >Sign in</a>";
		}
		
		data.closeConnection();
		
		ConstantBase constant = new ConstantBase();
		List<String> countriesF = constant.getCountryBase();
		List<String> countriesT = constant.getCountryBase();
		if(countriesF.contains(htmlFrom)){
			countriesF.remove(htmlFrom);
		}
		if(countriesT.contains(htmlTo)){
			countriesT.remove(htmlTo);
		}
		List<String> transports = constant.getTransportBase();
		if(transports.contains(htmlTransport)){
			transports.remove(htmlTransport);
		}
	
		model.addAttribute("company", company);	
		
		model.addAttribute("tenders", tenders);
		model.addAttribute("countriesF", countriesF);
		model.addAttribute("countriesT", countriesT);
		model.addAttribute("transports", transports);
		
		return "tenders";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		
		String countryFrom = request.getParameter("countryFrom");
		String countryTo = request.getParameter("countryTo");
		int weightMore = Integer.parseInt(request.getParameter("weightMore"));
		int weightLess = Integer.parseInt(request.getParameter("weightLess"));
		String transport = request.getParameter("transport");
		
		HttpSession session = request.getSession();
		int code = (Integer) session.getAttribute("id");
		
		String htmlFrom = countryFrom;
		String htmlTo = countryTo;
		String htmlTransport = transport;
		int htmlMore = weightMore;
		int htmlLess= weightLess;
		
		model.addAttribute("htmlFrom", htmlFrom);	
		model.addAttribute("htmlTo", htmlTo);	
		model.addAttribute("htmlTransport", htmlTransport);	
		model.addAttribute("htmlMore", htmlMore);	
		model.addAttribute("htmlLess", htmlLess);
		
		DataController data = new DataController();
		List<Tender> tenders = data.getOpenTendersFiltr(weightMore, weightLess, countryFrom, countryTo, transport);
		
		String company;
		if(code!=0){
			company = data.getCompanyById(code).getCompany();
		}else{
			company="<a href=\"/lotos/sign_in\" >Sign in</a>";
		}
		
		data.closeConnection();
		
		ConstantBase constant = new ConstantBase();
		List<String> countriesF = constant.getCountryBase();
		List<String> countriesT = constant.getCountryBase();
		if(countriesF.contains(htmlFrom)){
			countriesF.remove(htmlFrom);
		}
		if(countriesT.contains(htmlTo)){
			countriesT.remove(htmlTo);
		}
		List<String> transports = constant.getTransportBase();
		if(transports.contains(htmlTransport)){
			transports.remove(htmlTransport);
		}
	
		model.addAttribute("company", company);	
		
		model.addAttribute("tenders", tenders);
		model.addAttribute("countriesF", countriesF);
		model.addAttribute("countriesT", countriesT);
		model.addAttribute("transports", transports);

		return "tenders";
	}

}
