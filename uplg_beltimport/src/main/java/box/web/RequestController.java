package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.BeltService;
import box.logic.DataBase;

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
		
		BeltService service = new BeltService();
		String price = service.getPrice(request.getAddress(), request.getQuantity());
		String delivery = service.getDeliveryDate(request.getAddress(), request.getPickup());
		
		model.addAttribute("price", price);
		model.addAttribute("delivery", delivery);
		
		if (submit.equals("Order"))	{
			nextPage = "order";
		}
		return nextPage;
	}

	private void initModelList(Model model) {
		
		DataBase base = new DataBase();
		
		List<String> addresses = base.getAddresses();
		model.addAttribute("addresses", addresses);
		
		List<String> pallets = new ArrayList<String>();
		pallets.add("1");
		pallets.add("2");
		pallets.add("3");
		pallets.add("4");
		pallets.add("5");
		pallets.add("6");
		pallets.add("7");
		pallets.add("8");
		pallets.add("9");
		pallets.add("10");
		model.addAttribute("pallets", pallets);
		
		List<String> clients = base.getClients();
		model.addAttribute("clients", clients);
		
		List<String> documents = new ArrayList<String>();
		documents.add("EX-1");
		documents.add("EUR1");
		model.addAttribute("documents", documents);
		
		addresses = null;
		pallets = null;
		clients = null;
		documents = null;
		
		base = null;
	}

}
