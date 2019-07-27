package lotos.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.logic.MailController;
import lotos.logic.SimpleLogic;
import lotos.model.Company;
import lotos.model.Recomendation;
import lotos.model.Request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminCompanieServlet {
	
	@RequestMapping(value = "/adminCompanie/{code}", method = RequestMethod.GET)
	public String selectService(@PathVariable("code") String code,
			ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String cyrex = (String) session.getAttribute("cyrex");
		SimpleLogic logic = new SimpleLogic();
		if(!logic.isPasswordForAdninRight(cyrex)){
			return "adminAccessDenied";
		}
		
		DataController data = new DataController();
		
		Company client = data.getCompanyByCode(code);
		List<Recomendation> comments = data.getListRecomendationsByCompanyId(client.getId());
		
		data.closeConnection();
      
		model.addAttribute("client", client);
		model.addAttribute("comments", comments);
		
		return "adminCompanie";
		
	}
	
		@RequestMapping(value = "/adminCompanie/{code}", method = RequestMethod.POST)
		public String postProposition(@PathVariable("code") String code,
				ModelMap model, HttpServletRequest request, HttpServletResponse response) {
			
			
		
				HttpSession session = request.getSession();
				String cyrex = (String) session.getAttribute("cyrex");
				SimpleLogic logic = new SimpleLogic();
				if(!logic.isPasswordForAdninRight(cyrex)){
					return "adminAccessDenied";
				}
				
				DataController data = new DataController();
				
				Company client = data.getCompanyByCode(code);
				List<Recomendation> comments = data.getListRecomendationsByCompanyId(client.getId());
		      
				model.addAttribute("client", client);
				model.addAttribute("comments", comments);
				
				String requestEnc = "ISO-8859-1";
				String clientEnc = request.getParameter("charset");
				if (clientEnc == null)
					clientEnc = "Cp1251";
			
				String company = request.getParameter("newCompany");
				String codeCompany = request.getParameter("codeCompany");
				String manager = request.getParameter("manager");
				String mail = request.getParameter("mail");
				String phone = request.getParameter("phone");
				String mobile = request.getParameter("mobile");
				String password = request.getParameter("password");
				String webaddress = request.getParameter("webaddress");
				String youcontrol = request.getParameter("youcontrol");
				
				
				if (company != null){
					try {
						company = new String(company.getBytes(requestEnc), clientEnc);
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
				
				
				    data.editCompanyWithAllParameters(client.getId(), company, codeCompany, manager, mail, phone, mobile, password, webaddress, youcontrol);
					data.closeConnection();
					
					try {
						response.sendRedirect("/lotos/adminCompanie/"+codeCompany);
					} catch (IOException e) {
						e.printStackTrace();
					}
				
					return "adminCompanie";
	}


}
