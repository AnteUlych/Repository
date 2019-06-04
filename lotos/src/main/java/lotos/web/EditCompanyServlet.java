package lotos.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.logic.MailController;
import lotos.model.Company;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/edit_company")
public class EditCompanyServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(HttpServletRequest request, ModelMap model) {
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String logo = (String) session.getAttribute("logo");
		
		DataController data = new DataController();
		
		Company company = data.getCompanyById(id);
		
		data.closeConnection();
		
		model.addAttribute("logo", logo);
		
		model.addAttribute("manager", company.getManager());
		model.addAttribute("mail", company.getMail());
		model.addAttribute("phone", company.getPhone());
		model.addAttribute("mobile", company.getMobile());
		model.addAttribute("password", company.getPassword());
		model.addAttribute("webaddress", company.getWebaddress());
		
		return "edit_company";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
	
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String name = request.getParameter("manager");
		if (name != null){
			try {
				name = new String(name.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
	
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String mobile = request.getParameter("mobile");
		String webaddress = request.getParameter("webaddress");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String logo = (String) session.getAttribute("logo");
		
		DataController data = new DataController();
		Company company = data.getCompanyById(id);
		
		if(password.equals(confirmPassword)){
			data.editCompany(id, name, mail, phone, mobile, password, webaddress);
			
			if(!password.equals(company.getPassword())){
				
				MailController newPassword = new MailController();
				newPassword.sendNewPassword(name, mail, password);
			}
			
			data.closeConnection();
			
			try {
    			response.sendRedirect("/lotos/company/"+id);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		return "company";
		}
		model.addAttribute("logo", logo);
		
		model.addAttribute("manager", name);
		model.addAttribute("mail", mail);
		model.addAttribute("phone", phone);
		model.addAttribute("mobile", mobile);
		model.addAttribute("password", "");
		model.addAttribute("webaddress", webaddress);
		
		data.closeConnection();
	
		return "edit_company";
	}
}
