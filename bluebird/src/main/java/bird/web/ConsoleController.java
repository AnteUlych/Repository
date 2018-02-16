package bird.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.model.Cargo;
import bird.web.model.Freight;

@Controller
@RequestMapping("/console")
public class ConsoleController {	

	Expediter monitoring = new Expediter();
	
	@Autowired
    @Qualifier("freightValidator")
    private Validator validator;
	
	 @InitBinder
	    private void initBinder(WebDataBinder binder) {
	        binder.setValidator(validator);
	    }
	 
	
	 @RequestMapping(method = RequestMethod.GET)
		public String initForm(Model model, HttpServletRequest request) {
		 
		 if(!monitoring.isAccessAvailable(request.getRemoteAddr())){
			 return "denied";
		 }
		 
			Freight freight = new Freight();
			List <Cargo> active = monitoring.getAllActivaCargoes();
		
			List <String> updates = getUpdates(active); 
			model.addAttribute("updates", updates);

			model.addAttribute("active", active);
			model.addAttribute("freight", freight);
			initModelList(model);
			return "Console";
		}

		private List<String> getUpdates(List<Cargo> active) {
		List <String> updates = new ArrayList();
		for(Cargo freight:active){
			String lastUpdate = monitoring.getLastUpdateByCargoId(freight.getId());
			updates.add(lastUpdate);
		}
		return updates;
	}


		@RequestMapping(method = RequestMethod.POST)
		public String submitForm(Model model, @Validated Freight freight, BindingResult result, HttpServletResponse response) {
			List <Cargo> active = monitoring.getAllActivaCargoes();
			
			List <String> updates = getUpdates(active); 
			model.addAttribute("updates", updates);
	
			model.addAttribute("active", active);
			model.addAttribute("freight", freight);
			String returnVal = "Console";
			if(result.hasErrors()) {
				initModelList(model);
		
			} else {
				model.addAttribute("freight", freight);
				Expediter monitoring = new Expediter();
				monitoring.addCargo(freight.getClient(), freight.getDescription());
				try {
					response.sendRedirect("/tracing/console");
					return returnVal;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
			return returnVal;
		}

		private void initModelList(Model model) {
			
			List<String> clients = monitoring.getListofClients();
			model.addAttribute("clients", clients);
	
		}
}
