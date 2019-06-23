package lotos.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.logic.MailController;
import lotos.model.Company;
import lotos.model.Proposition;
import lotos.model.Tender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TenderServlet {
	
	@RequestMapping(value = "/tender/{idTender}", method = RequestMethod.GET)
	public String selectService(@PathVariable("idTender") String idTender,
			ModelMap model, HttpServletRequest request) {
		
        int tenderId = Integer.parseInt(idTender);
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String logo = (String) session.getAttribute("logo");
		
		DataController data = new DataController();
		
		Tender tender = data.getTenderByTenderId(tenderId);
		List<Proposition> propositions = data.getPropositionsByTenderId(tenderId);
		Company company = data.getCompanyById(tender.getCompanyid());
		
		boolean isOwnTender = company.getId() == id;
		data.closeConnection();
		
		model.addAttribute("isOwnTender", isOwnTender);
		model.addAttribute("logo", logo);
		model.addAttribute("tenderId", tenderId);
		model.addAttribute("id", id);
		
		model.addAttribute("tenderFrom", tender.getCountryfrom());
		model.addAttribute("tenderTo", tender.getCountryto());
		model.addAttribute("tenderWeight", tender.getWeight());
		model.addAttribute("tendeVolume", tender.getSize());	
		model.addAttribute("tenderCompany", tender.getCompany());
		
		model.addAttribute("propositions", propositions);
	
		return "tender";
		
	}
	
		@RequestMapping(value = "/tender/{idTender}", method = RequestMethod.POST)
		public String postProposition(@PathVariable("idTender") String idTender,
				ModelMap model, HttpServletRequest request, HttpServletResponse response) {
			
			 int tenderId = Integer.parseInt(idTender);
				
				HttpSession session = request.getSession();
				int id = (Integer) session.getAttribute("id");
				String logo = (String) session.getAttribute("logo");
				
				DataController data = new DataController();
				
				Tender tender = data.getTenderByTenderId(tenderId);
				List<Proposition> propositions = data.getPropositionsByTenderId(tenderId);
				Company company = data.getCompanyById(tender.getCompanyid());
				
				boolean isOwnTender = company.getId() == id;
				
				model.addAttribute("isOwnTender", isOwnTender);
				model.addAttribute("logo", logo);
				model.addAttribute("tenderId", tenderId);
				model.addAttribute("id", id);
				
				model.addAttribute("tenderFrom", tender.getCountryfrom());
				model.addAttribute("tenderTo", tender.getCountryto());
				model.addAttribute("tenderWeight", tender.getWeight());
				model.addAttribute("tendeVolume", tender.getSize());	
				model.addAttribute("tenderCompany", tender.getCompany());
				
				model.addAttribute("propositions", propositions);
				
				for (Proposition proposition : propositions) {

					if (request.getParameter("delete" + proposition.getId()) != null) {
				
						data.deleteProposition(proposition.getId());
						data.closeConnection();
						return "redirect:";
					}

					if (request.getParameter("confirm" + proposition.getId()) != null) {
						
						data.addDeal(tender.getId(), tender.getCompanyid(), proposition.getCompanyid(), proposition.getId(), tender.getDateofopening(), tender.getWeight(), tender.getSize(), tender.getReadytopickup(), tender.getCountryfrom(), tender.getCountryto(), tender.getPayconditions(), tender.getDayspay(), tender.getFreightinformationandconditions(), tender.getCompany(), proposition.getCompany(), tender.getIncoterms()+" "+tender.getAddresstopickup(), tender.getAddresstodelivery(), proposition.getDeliverydate(), proposition.getPrice(), proposition.getCurrency(), proposition.getOtherinformation(), proposition.getTransport());
						MailController mail = new MailController();
						mail.sendDeal(tender, proposition);
						data.closeTender(tenderId);
					
						data.closeConnection();
						
						try {
		        			response.sendRedirect("/lotos/company/"+id);
		        		} catch (IOException e) {
		        			e.printStackTrace();
		        		}
		        		return "panel";
		        	
					}

				}
				return "redirect:";
	}

}
