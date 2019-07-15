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
import lotos.model.Proposition;
import lotos.model.Request;
import lotos.model.Tender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminRequestServlet {
	
	@RequestMapping(value = "/adminRequest/{idRequest}", method = RequestMethod.GET)
	public String selectService(@PathVariable("idRequest") String idRequest,
			ModelMap model, HttpServletRequest request) {
		
		 int requestId = Integer.parseInt(idRequest);
		
		HttpSession session = request.getSession();
		String cyrex = (String) session.getAttribute("cyrex");
		SimpleLogic logic = new SimpleLogic();
		if(!logic.isPasswordForAdninRight(cyrex)){
			return "adminAccessDenied";
		}
		
		DataController data = new DataController();
		Request client = data.getRequestByRequestId(requestId);
		String existing = "not exist";
		Company company = new Company();
		company.setCode("");
		company.setCompany("");
		company.setMail("");
		company.setManager("");
		company.setMobile("");
		company.setPassword("");
		company.setPhone("");
		company.setRegistration("");
		company.setWebaddress("");
		company.setYoucontrol("");
		if(data.isCodeExist(client.getCode())){
			existing = "exist";
			company = data.getCompanyByCode(client.getCode());
		}
		data.closeConnection();
      
		model.addAttribute("client", client);
		model.addAttribute("existing", existing);
		model.addAttribute("company", company);
		
		return "adminrequest";
		
	}
	
		@RequestMapping(value = "/adminRequest/{idRequest}", method = RequestMethod.POST)
		public String postProposition(@PathVariable("idRequest") String idRequest,
				ModelMap model, HttpServletRequest request, HttpServletResponse response) {
			
			int requestId = Integer.parseInt(idRequest);
		
				HttpSession session = request.getSession();
				String cyrex = (String) session.getAttribute("cyrex");
				SimpleLogic logic = new SimpleLogic();
				if(!logic.isPasswordForAdninRight(cyrex)){
					return "adminAccessDenied";
				}
				
				DataController data = new DataController();
				Request client = data.getRequestByRequestId(requestId);
				String existing = "not exist";
				Company company = new Company();
				company.setCode("");
				company.setCompany("");
				company.setMail("");
				company.setManager("");
				company.setMobile("");
				company.setPassword("");
				company.setPhone("");
				company.setRegistration("");
				company.setWebaddress("");
				company.setYoucontrol("");
				if(data.isCodeExist(client.getCode())){
					existing = "exist";
					company = data.getCompanyByCode(client.getCode());
				}
		      
				model.addAttribute("client", client);
				model.addAttribute("existing", existing);
				model.addAttribute("company", company);
				
				String requestEnc = "ISO-8859-1";
				String clientEnc = request.getParameter("charset");
				if (clientEnc == null)
					clientEnc = "Cp1251";
			
				String newCompany = request.getParameter("newCompany");
				String code = request.getParameter("code");
				String manager = request.getParameter("manager");
				String mail = request.getParameter("mail");
				String phone = request.getParameter("phone");
				String mobile = request.getParameter("mobile");
				String password = request.getParameter("password");
				String webaddress = request.getParameter("webaddress");
				String youcontrol = request.getParameter("youcontrol");
				
				
				if (newCompany != null){
					try {
						newCompany = new String(newCompany.getBytes(requestEnc), clientEnc);
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
				
				
				    MailController mailSender = new MailController();

					if (request.getParameter("delete") != null) {
						data.deleteRequest(requestId);
						mailSender.sendCreationDenied(client.getMail(), client.getManager());
					}

					if (request.getParameter("add") != null) {
						
						data.addCompany(newCompany, code, manager, mail, phone, mobile, password, webaddress, youcontrol, client.getRegistration());
						mailSender.sendConfirmationOfCreating(client.getMail(), client.getManager(), client.getCompany());
						data.deleteRequest(requestId);
		        	
					}

					data.closeConnection();
					
					try {
						response.sendRedirect("/lotos/adminRequests");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					return "adminRequests";
	}

}
