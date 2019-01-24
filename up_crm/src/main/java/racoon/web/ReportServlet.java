package racoon.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import racoon.logic.BaseController;
import racoon.logic.Constants;
import racoon.logic.Sender;
import racoon.model.Client;
import racoon.model.ClientsReport;
import racoon.model.Manager;
import racoon.model.ManagerRequestReport;
import racoon.model.Proposition;
import racoon.model.Request;

@Controller
@RequestMapping("/report")
public class ReportServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		
		String funnel = "partner";
		BaseController base = new BaseController();
		
		List<Manager> managers = base.getAllManagers();
		
		List<ManagerRequestReport> managersReport = new ArrayList();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
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
			rept.setNextCall(df.format(client.getNextcall()));
			rept.setLastComment(client.getAnswer());
			
			clientsReport.add(rept);
		}
		
		model.addAttribute("managersReport", managersReport);
		model.addAttribute("clientsReport", clientsReport);
		model.addAttribute("rep", "");
		
		base.closeConnection();
		
		return "report";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String postProposition(ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		String funnel = "partner";
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String start = req.getParameter("start");
		String ending = req.getParameter("end");
		
		BaseController base = new BaseController();
		
		List<Manager> managers = base.getAllManagers();
		
		List<ManagerRequestReport> managersReport = new ArrayList();
		
		for(Manager manager:managers){
			
		ManagerRequestReport report = new ManagerRequestReport();
		
		report.setName(manager.getName());
		report.setAllAuto(base.getNumberOfAllRequestsByManagerTypeBetweenDates(manager.getName(), "AUTO", start, ending));
		report.setAllSar(base.getNumberOfAllRequestsByManagerTypeBetweenDates(manager.getName(), "SAR", start, ending));
		report.setNotCalcAuto(base.getNumberOfAllRequestsByManagerTypeResultsBetweenDates(manager.getName(), "AUTO", "", start, ending));
		report.setNotCalcSar(base.getNumberOfAllRequestsByManagerTypeResultsBetweenDates(manager.getName(), "SAR", "", start, ending));
		report.setBookedAuto(base.getNumberOfAllRequestsByManagerTypeResultsBetweenDates(manager.getName(), "AUTO", "booking", start, ending));
		report.setBookedSar(base.getNumberOfAllRequestsByManagerTypeResultsBetweenDates(manager.getName(), "SAR", "booking", start, ending));
		report.setPropositions(base.getNumberOfAllPropositionsByManagerTypeAndDates(start, ending, manager.getName(), "booking")+
				base.getNumberOfAllPropositionsByManagerTypeAndDates(start, ending, manager.getName(), "not interesting")+
				base.getNumberOfAllPropositionsByManagerTypeAndDates(start, ending, manager.getName(), "waiting"));
		report.setBooked(base.getNumberOfAllPropositionsByManagerTypeAndDates(start, ending, manager.getName(), "booking"));
		
		managersReport.add(report);
		
		}
		
		List<Client> clients = base.getAllClientsByFunnel(funnel);
		List<ClientsReport> clientsReport = new ArrayList();
		
		for(Client client:clients){
			
			ClientsReport rept = new ClientsReport();
			
			rept.setCompany(client.getCompany());
			rept.setManager(client.getManager());
			rept.setCategory(client.getCategory());
			rept.setRequests(base.getNumberOfAllRequestsByCompanyBetweenDates(client.getCompany(), start, ending));
			rept.setBookings(base.getNumberOfAllBookingRequestsByCompanyBetweenDates(client.getCompany(), start, ending));
			rept.setNextCall(df.format(client.getNextcall()));
			rept.setLastComment(client.getAnswer());
			
			clientsReport.add(rept);
		}
		
		model.addAttribute("managersReport", managersReport);
		model.addAttribute("clientsReport", clientsReport);
		model.addAttribute("rep", " ("+start+" - "+ending+")");
		
		base.closeConnection();
		
		return "report";
	}

}
