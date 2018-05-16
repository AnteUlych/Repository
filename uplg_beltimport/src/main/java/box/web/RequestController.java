package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RequestController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		Request request = new Request();
		
		model.addAttribute("request", request);
		initModelList(model);
		return "form";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, Request request, HttpServletRequest servletRequest) {
		
		String submit = servletRequest.getParameter("submit");
		String nextPage = "form";
		
		model.addAttribute("request", request);
		initModelList(model);
		
		String price = request.getClient(); //change
		String delivery = "XX/YY/ZZZZ"; //change
		
		model.addAttribute("price", price);
		model.addAttribute("delivery", delivery);
		
		if (submit.equals("Order"))	{
			nextPage = "order";
		}
		return nextPage;
	}

	private void initModelList(Model model) {
		
		List<String> addresses = new ArrayList<String>();
		addresses.add("Paris, FR");
		addresses.add("Berlin, DE");
		model.addAttribute("addresses", addresses);
		
		List<String> pallets = new ArrayList<String>();
		pallets.add("1");
		pallets.add("2");
		model.addAttribute("pallets", pallets);
		
		List<String> clients = new ArrayList<String>();
		clients.add("Natalia");
		clients.add("Oksana");
		model.addAttribute("clients", clients);
		
		List<String> documents = new ArrayList<String>();
		documents.add("EX-1");
		documents.add("EUR1");
		model.addAttribute("documents", documents);
	}

}
