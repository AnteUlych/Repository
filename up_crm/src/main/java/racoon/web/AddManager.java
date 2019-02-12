package racoon.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import racoon.logic.BaseController;
import racoon.model.Manager;

@Controller
@RequestMapping("/addManager")
public class AddManager {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		return "addManager";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {

		//Encoder enigma = new Encoder();
		BaseController enigma = new BaseController();
		
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		int rank = 2;
		int pass = enigma.giveCodeToManger();
		
		Manager member = new Manager();
		
		member.setName(name);
		member.setMail(mail);
		member.setRank(rank);
		member.setCode(pass);
		
		enigma.addManager(member);		
		enigma.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("password", pass+"");
		
		return "managerWasAdded";
	}

}
