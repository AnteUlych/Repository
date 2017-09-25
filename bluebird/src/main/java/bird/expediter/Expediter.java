package bird.expediter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bird.model.Client;
import bird.model.Review;
import bird.model.Route;
import bird.service.CargoService;
import bird.service.ClientService;
import bird.service.ReviewService;
import bird.service.RouteService;
import bird.model.Cargo;

public class Expediter {


	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	ReviewService s = (ReviewService) ctx.getBean("reviewService");
	
	public int giveAnumber(){

		return s.getCountByRate(5);
		
	}

	public boolean isAccountExist(String login, String password) {
		ClientService service = (ClientService) ctx.getBean("clientService");
		try {
			service.getClientBy(login, password);
		} catch (NoResultException e) {
			return false;
		}
		return true;
	}
	
	 public int getIdOfClientBy(String login, String password) {
		 ClientService service = (ClientService) ctx.getBean("clientService");
			return service.getClientBy(login, password).getId();
			 
		 }

	public List<Cargo> getActiveCargoesByClient(int id) {
		
		ClientService service = (ClientService) ctx.getBean("clientService");
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");
			
		return kundendienst.getAllActiveCargosByClient(service.getClientBy(id).getCompany());		
	}
	
	public List<Route> getRoutebyCargoId(int cargoID){
		RouteService service = (RouteService)ctx.getBean("routeService");
		return service.getAllRouteByCargoId(cargoID);
	}

	public int getNewestCargo(int id) {
		
		ClientService service = (ClientService) ctx.getBean("clientService");
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");
		
		String client = service.getClientBy(id).getCompany();
		List<Cargo> cargoes = kundendienst.getAllActiveCargosByClient(client);
		
		return cargoes.get(0).getId();
	}
	public boolean isCargoCommentExists(int cargoId){
		ReviewService service = (ReviewService) ctx.getBean("reviewService");
		List<Review> reviews = service.getAllReviewsByCompany(cargoId);
		if(reviews.isEmpty()){
			return true;
		}
		return false;
	}
	
	public String getTimeOfLastUpdateByClient(int clientId){
		
		ClientService service = (ClientService) ctx.getBean("clientService");
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");
		
		String client = service.getClientBy(clientId).getCompany();
		List<Cargo> cargoes = kundendienst.getAllActiveCargosByClient(client);
		
		RouteService routeService = (RouteService)ctx.getBean("routeService");
		List<Route> route = routeService.getAllRouteByCargoId(cargoes.get(0).getId());
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date update = route.get(0).getTime();
		
		return df.format(update);
	}
	
	public String getTotalCargoesByClient(int clientId){
		
		ClientService service = (ClientService) ctx.getBean("clientService");
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");
		
		String client = service.getClientBy(clientId).getCompany();
		List<Cargo> cargoes = kundendienst.getAllCargoByClient(client);
		
		return cargoes.size()+"";
	}
	
	
}
