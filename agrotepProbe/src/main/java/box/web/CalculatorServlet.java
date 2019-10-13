package box.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.LogicDataBase;
import box.model.Transport;

@Controller
public class CalculatorServlet {

	@RequestMapping(value = "/calculator", method = RequestMethod.GET)
	public String selectService(ModelMap model) {

		model.addAttribute("answer", "");

		return "calculator";
	}

	@RequestMapping(value = "/calculator", method = RequestMethod.POST)
	public String postProposition(ModelMap model, HttpServletRequest req,
			HttpServletResponse resp) {
		
		int random = (int)(Math.random() * 500 + 100)*10;

		model.addAttribute("answer", random + " EUR");

		return "calculator";
	}
}
