package box.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.LogicDataBase;
import box.model.Proposition;
import box.model.Transport;

@Controller
public class PropositionsServlet {
	
	@RequestMapping(value = "/propositions/{transportid}", method = RequestMethod.GET)
	public String selectService(@PathVariable("transportid") String transportid,
			ModelMap model) {
		
		int id = Integer.parseInt(transportid);	
		
		LogicDataBase logic = new LogicDataBase();
		List<Proposition> propositions = logic.getAllPropositionsByTransportId(id);
		Transport transport = logic.getTransportById(id);
		
		model.addAttribute("transport", transport);
		model.addAttribute("propositions", propositions);
		
		logic.closeConnection();
		
		return "propositions";
	}
	
	@RequestMapping(value = "/propositions/{transportid}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("transportid") String transportid,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		
        int id = Integer.parseInt(transportid);	
		
		LogicDataBase logic = new LogicDataBase();
		List<Proposition> propositions = logic.getAllPropositionsByTransportId(id);
		Transport transport = logic.getTransportById(id);
		
		model.addAttribute("transport", transport);
		model.addAttribute("propositions", propositions);
		
		for (Proposition deal : propositions) {

			if (req.getParameter("delete" + deal.getId()) != null) {
				
				logic.deleteProposition(deal.getId());
				logic.closeConnection();
				//return "redirect:";
			}

			if (req.getParameter("confirm" + deal.getId()) != null) {
				
				logic.setPropositionStatus(deal.getId(), "w3-green");
				logic.setTransportStatus(id, "w3-green");
				logic.closeConnection();
				//return "redirect:";
			}

		}
		
		try {
			logic.closeConnection();
			resp.sendRedirect("/probe/propositions/"+transportid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return "propositions";
		
	}
	
}
