package lotos.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class LoginServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		int id = 0;
		String logo = "sign in";
		
		if (request.getParameter("logIn") != null) {

			String mail = request.getParameter("mail");
			String password = request.getParameter("password");
			
            DataController data = new DataController();
            id = data.getIdByLoginAndPassword(mail, password);
            if(id!=0){
            logo = data.getCompanyById(id).getCompany();
            }
            data.closeConnection();
            
            if(id!=0){
            	
            	HttpSession session = request.getSession();
        		session.setAttribute("id", id);
        		session.setAttribute("logo", logo);
        		
        		try {
        			response.sendRedirect("/lotos/company/"+id);
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        		return "panel";
            }
            try {
    			response.sendRedirect("/lotos/");
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
			return "login";
		}
		
		if (request.getParameter("watch") != null) {
			
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("logo", logo);
		
		try {
			response.sendRedirect("/lotos/tenders");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "panel";
		}

		return "redirect:";
	}
}
