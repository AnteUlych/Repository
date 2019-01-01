package racoon.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import racoon.logic.BaseController;
import racoon.model.Client;
import racoon.model.ClientsReport;
import racoon.model.Manager;
import racoon.model.ManagerRequestReport;

@Controller
@RequestMapping("/report")
public class ReportServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		
		String funnel = "partner";
		BaseController base = new BaseController();
		
		List<Manager> managers = base.getAllManagers();
		
		List<ManagerRequestReport> managersReport = new ArrayList();
		
		for(Manager manager:managers){
			
		ManagerRequestReport report = new ManagerRequestReport();
		
		report.setName(manager.getName());
		report.setAllAuto(0);
		report.setAllSar(0);
		report.setNotCalcAuto(0);
		report.setNotCalcSar(0);
		report.setRefuseAuto(0);
		report.setRefuseSar(0);
		report.setBookedAuto(0);
		report.setBookedSar(0);
		report.setPropositions(0);
		report.setBooked(0);
		
		managersReport.add(report);
		
		}
		
		List<Client> clients = base.getAllClientsByFunnel(funnel);
		List<ClientsReport> clientsReport = new ArrayList();
		
		for(Client client:clients){
			
			ClientsReport rept = new ClientsReport();
			
			rept.setCompany(client.getCompany());
			rept.setManager(client.getManager());
			rept.setCategory(client.getCategory());
			rept.setRequests(0);
			rept.setBookings(0);
			
			clientsReport.add(rept);
		}
		
		model.addAttribute("managersReport", managersReport);
		model.addAttribute("clientsReport", clientsReport);
		
		return "report";
	}

}
