package bird.expediter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bird.model.Access;
import bird.model.Client;
import bird.model.Review;
import bird.model.Route;
import bird.model.Visitor;
import bird.service.AccessService;
import bird.service.CargoService;
import bird.service.ClientService;
import bird.service.ReviewService;
import bird.service.RouteService;
import bird.service.VisitorService;
import bird.web.model.Mark;
import bird.model.Cargo;

public class Expediter {

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	ReviewService s = (ReviewService) ctx.getBean("reviewService");

	public int giveAnumber() {

		return s.getCountByRate(5);

	}

	public boolean isAccessAvailable(String guest) {

		AccessService as = (AccessService) ctx.getBean("accessService");
		List<Access> wall = as.getAllAccess();

		for (Access hole : wall) {

			if (hole.getIp().equals(guest)) {
				return true;
			}
		}
		return false;
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

		return kundendienst.getAllActiveCargosByClient(service.getClientBy(id)
				.getCompany());
	}

	public List<Route> getRoutebyCargoId(int cargoID) {
		RouteService service = (RouteService) ctx.getBean("routeService");
		return service.getAllRouteByCargoId(cargoID);
	}
	
	public void deleteRoute(int id){
		RouteService service = (RouteService) ctx.getBean("routeService");
		service.deleteRoute(id);
	}
	
	public String getLastUpdateByCargoId(int cargoID) {
		RouteService service = (RouteService) ctx.getBean("routeService");
		try {
		List<Route> route = service.getAllRouteByCargoId(cargoID);
		Date lastDate = route.get(0).getTime();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String update = df.format(lastDate);
		return update;
		}catch (IndexOutOfBoundsException e) {
			return "";
		}
	}
	
	public String getLastStatusByCargoId(int cargoID) {
		RouteService service = (RouteService) ctx.getBean("routeService");
		try {
		List<Route> route = service.getAllRouteByCargoId(cargoID);
		String status = route.get(0).getStatus();
		return status;
		}catch (IndexOutOfBoundsException e) {
			return "";
		}
	}

	public int getNewestCargo(int id) {

		ClientService service = (ClientService) ctx.getBean("clientService");
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");

		String client = service.getClientBy(id).getCompany();
		List<Cargo> cargoes = kundendienst.getAllActiveCargosByClient(client);

		return cargoes.get(0).getId();
	}

	public boolean isCargoCommentExists(int cargoId) {
		ReviewService service = (ReviewService) ctx.getBean("reviewService");
		List<Review> reviews = service.getAllReviewsByCompany(cargoId);
		if (reviews.isEmpty()) {
			return true;
		}
		return false;
	}

	public String getTimeOfLastUpdateByClient(int clientId) {

		ClientService service = (ClientService) ctx.getBean("clientService");
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");

		String client = service.getClientBy(clientId).getCompany();
		List<Cargo> cargoes = kundendienst.getAllActiveCargosByClient(client);

		RouteService routeService = (RouteService) ctx.getBean("routeService");
		List<Route> route = routeService.getAllRouteByCargoId(cargoes.get(0)
				.getId());

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date update = route.get(0).getTime();

		return df.format(update);
	}

	public String getTotalCargoesByClient(int clientId) {

		ClientService service = (ClientService) ctx.getBean("clientService");
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");

		String client = service.getClientBy(clientId).getCompany();
		List<Cargo> cargoes = kundendienst.getAllCargoByClient(client);

		return cargoes.size() + "";
	}

	public String getSimplInformationByCargoId(int id) {
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");
		return kundendienst.getCargoBy(id).getDescription();
	}

	public void addComment(int cargoId, int rate, String comment) {
		ReviewService service = (ReviewService) ctx.getBean("reviewService");
		service.addReview(cargoId, comment, rate);
	}

	public List<String> getListofClients() {
		ClientService service = (ClientService) ctx.getBean("clientService");
		List<String> clients = new ArrayList<String>();
		List<Client> customers = service.getAllClients();
		for (Client client : customers) {
			clients.add(client.getCompany());
		}
		return clients;
	}

	public void addCargo(String client, String description) {
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");
		kundendienst.addCargo(client, description);
	}

	public void addClient(String company, String name, String email,
			String phone, String login, String password) {
		ClientService service = (ClientService) ctx.getBean("clientService");
		service.addClient(company, name, email, phone, login, password);
	}

	public List<Cargo> getAllActivaCargoes() {
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");
		return kundendienst.getAllActiveCargo();
	}

	public void addRoute(int cargoID, double longitude, double latitude,
			String status) {
		RouteService routeService = (RouteService) ctx.getBean("routeService");
		routeService.addRoute(cargoID, longitude, latitude, status);
	}

	public Cargo getCargoBy(int id) {
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");
		return kundendienst.getCargoBy(id);
	}

	public void finishCargo(int id) {
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");
		kundendienst.finishCargo(id);
	}

	public Route getRouteBy(int id) {
		RouteService service = (RouteService) ctx.getBean("routeService");
		return service.getRouteBy(id);
	}

	public void editRoute(int id, double longitude, double latitude,
			String status) {
		RouteService service = (RouteService) ctx.getBean("routeService");
		service.editRoute(id, longitude, latitude, status);
	}

	public List<Mark> getAllComments() {

		ReviewService service = (ReviewService) ctx.getBean("reviewService");
		CargoService kundendienst = (CargoService) ctx.getBean("cargoService");

		List<Review> reviews = service.getAllReviews();
		List<Mark> comments = new ArrayList<Mark>();

		DateFormat df = new SimpleDateFormat("HH:mm:ss MM/dd/yyyy");

		for (Review review : reviews) {

			String client = kundendienst.getCargoBy(review.getCargoId())
					.getClient();
			String cargo = kundendienst.getCargoBy(review.getCargoId())
					.getDescription();
			String time = df.format(review.getTime());
			String comment = review.getComment();
			int rate = review.getRate();

			Mark mark = new Mark();

			mark.setCargo(cargo);
			mark.setClient(client);
			mark.setComment(comment);
			mark.setRate(rate);
			mark.setTime(time);

			comments.add(mark);
		}

		return comments;
	}

	public int getRatebyMark(int mark) {
		ReviewService service = (ReviewService) ctx.getBean("reviewService");

		int rate = service.getCountByRate(mark);
		return rate;
	}

	public String getStatisticForMap(int cargoID) {

		List<Route> route = this.getRoutebyCargoId(cargoID);
		String waybill = "[";
		DateFormat df = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		for (Route way : route) {

			String time = "'<center>" + df.format(way.getTime())
					+ "</center><center>";
			String status = way.getStatus() + "</center>'";
			waybill = waybill + "[" + time + status + ", " + way.getLongitude()
					+ ", " + way.getLatitude() + "],";
		}
		waybill = waybill.substring(0, waybill.length() - 1) + "]";
		;
		return waybill;
	}

	public boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public void saveVisit(int id) {

		ClientService service = (ClientService) ctx.getBean("clientService");
		VisitorService kundendienst = (VisitorService) ctx
				.getBean("visitorService");

		String company = service.getClientBy(id).getCompany();
		kundendienst.addVisitor(company);

	}

	public List<Visitor> getAllVisitors() {

		VisitorService kundendienst = (VisitorService) ctx
				.getBean("visitorService");
		return kundendienst.getAllVisitors();

	}
}
