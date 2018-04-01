package bird.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Tracing;
import bird.expediter.Expediter;
import bird.model.Cargo;
import bird.model.Client;
import bird.model.Route;
import bird.web.model.Freight;

@Controller
@RequestMapping("/monitoring")	
public class MonitoringController {
	
        String code = "anna";
		Expediter monitoring = new Expediter();
		
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
				
				return "Monitoring";
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
			public String submitForm(HttpServletRequest request, HttpServletResponse response) {
				String key = request.getParameter("key");
				if(code.equals(key)){
					
					List <Cargo> cargoes = monitoring.getAllActivaCargoes();
					for(Cargo freight:cargoes){
						
						Client client = monitoring.getClientOfCargo(freight.getClient()) ;
						Route route = monitoring.getLastRoute(freight.getId());
						
						Tracing tracing = new Tracing(client, freight, route);
						tracing.trace();
					}
				
					return "ok";
				}
				
				try {
					response.sendRedirect("/tracing/monitoring");
					return "ok";
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "ok";
			}

		
	}

