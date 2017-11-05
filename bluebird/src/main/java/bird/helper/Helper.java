package bird.helper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bird.expediter.Expediter;
import bird.model.Cargo;
import bird.model.Route;
import bird.service.RouteService;
import bird.web.model.Mark;

public class Helper {

	public static void help()  /**main(String[] args)*/{
		
Expediter s = new Expediter();
List <Mark> tests = s.getAllComments();
        
for (Mark m : tests) {
	System.out.println(m.getCargo()+ " "+m.getTime()+" "+m.getComment());
}
//List<Cargo> li = s.getActiveCargoesByClient(1);
//for (Cargo c : li) {
//	System.out.println(c.getId()+". "+ c.getDescription());
	//List<Route> r = s.getRoutebyCargoId(c.getId());
	//for(Route ro:r){
	//	System.out.println(" "+ro.getLatitude());
	//}
	
		/**
		ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
				"spring.xml");
		RouteService s = (RouteService) ctx.getBean("routeService");

		//s.deleteReview(3);
		List<Route> r = s.getAllRouteByCargoId(9);
		for (Route c : r) {
			System.out.println(c.getLatitude() + " " + c.getLongitude());
			}
		System.out.println();
		//System.out.println(s.getCountByRate(2));
		
		/**
		ReviewService s = (ReviewService) ctx.getBean("reviewService");
		
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date point = newDateFormat.parse("16/09/2017");
		
		List<Visitor> visits = s.getAllVisitorsByDate(point);
		for (Visitor c : visits) {
			System.out.println(c.getCompany());
			}
		//System.out.println(serv.getCargoBy(9).getClient());
		/**
		ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
				"spring.xml");
		
		CargoService serv = (CargoService) ctx.getBean("cargoService");		
		//ClientService service = (ClientService) ctx.getBean("clientService");

		List<Cargo> li = serv.getAllActiveCargosByClient("KitKat, Ltd");
		for (Cargo c : li) {
			System.out.println(c.getActive());
			}
		System.out.println(serv.getCargoBy(9).getClient());
		
		/**
	List<Client> list = service.getAllClients();
		for (Client c : list) {
		System.out.println(c.getCompany());
		}
		System.out.println(service.getClientBy(1).getName());
*/
		}
	}

