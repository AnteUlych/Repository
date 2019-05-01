package lotos.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.logic.SimpleLogic;
import lotos.model.Request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sign_in")
public class SignInServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		return "sign_in";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request,
			HttpServletResponse response) {

		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String company = request.getParameter("company");
		String name = request.getParameter("name");
		if (company != null){
			try {
				company = new String(company.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (name != null){
			try {
				name = new String(name.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String code = request.getParameter("code");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");

		DataController data = new DataController();
		boolean isMailExist = data.isMailExist(mail);
		boolean isCodeExist = data.isCodeExist(code);
		boolean isRequestMailExist = data.isMailInRequestExist(mail);
		boolean isRequestCodeExist = data.isCodeInRequestExist(code);
		
		if(isMailExist){
			data.closeConnection();
			return "repeats_sign_in";
		}
		if(isCodeExist){
			data.closeConnection();
			return "repeats_sign_in";
		}
		if(isRequestMailExist){
			data.closeConnection();
			return "repeats_sign_in";
		}
		if(isRequestCodeExist){
			data.closeConnection();
			return "repeats_sign_in";
		}
		if(!password.equals(passwordConfirm)){
			return "wrong_password_sign_in";
		}
		if(password.equals(passwordConfirm)&&(!isMailExist)&&(!isCodeExist)&&(!isRequestMailExist)&&(!isRequestCodeExist)){
			
			SimpleLogic logic = new SimpleLogic();
			
			Request newCompany = new Request();
			
			newCompany.setCode(code);
			newCompany.setCompany(company);
			newCompany.setMail(mail);
			newCompany.setManager(name);
			newCompany.setMobile(mobile);
			newCompany.setPassword(passwordConfirm);
			newCompany.setPhone(phone);
			newCompany.setRegistration(logic.fixDateInString());
			
			
			data.createNewRequest(newCompany);
			data.closeConnection();
			
			return "signed_in";
		}
		data.closeConnection();
		return "signed_in";
	}

}
