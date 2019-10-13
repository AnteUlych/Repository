package box.logic;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import box.model.Proposition;
import box.model.Transport;
import box.service.PropositionService;
import box.service.TransportService;


public class LogicDataBase {
	
	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	TransportService transportService = (TransportService) ctx.getBean("transportService");
	PropositionService propositionService = (PropositionService) ctx.getBean("propositionService");

	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
	}
	
	//transport
	public void addTransport(Transport transport){
		transportService.addTransport(transport);
	}
	
	public List<Transport> getAllTransportByDirection(String direction) {
		return transportService.getAllTransportByDirection(direction);
	}
	
	public void setTransportStatus(int id, String status) {
		transportService.setTransportStatus(id, status);
	}
	
	public void setTransportTruckdriver(int id, String truckdriver) {
		transportService.setTransportTruckdriver(id, truckdriver);
	}
	
	public Transport getTransportById(int id) {
		return transportService.getTransportById(id);
	}
	//proposition
	public void addProposition(Proposition proposition) {
		propositionService.addProposition(proposition);
	}
	
	public void deleteProposition(int id) {
		propositionService.deleteProposition(id);
	}
	
	public List<Proposition> getAllPropositionsByTransportId(int transportid) {
		return propositionService.getAllPropositionsByTransportId(transportid);
	}
	
	public void setPropositionStatus(int id, String status) {
		propositionService.setPropositionStatus(id, status);
	}
}
