package racoon.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import racoon.logic.Encoder;

@Controller
@RequestMapping("/login")
public class AccessServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request,
			HttpServletResponse response) {

		Encoder enigma = new Encoder();
		String code = request.getParameter("password");
		String isAccess = enigma.getAccess(code);
		if (isAccess.equals("denied")) {
			return "login";
		}
		HttpSession session = request.getSession();
		session.setAttribute("code", code);
		session.setAttribute("manager", isAccess);
		try {
			response.sendRedirect("/crm/clients");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "ok";
	}
}
