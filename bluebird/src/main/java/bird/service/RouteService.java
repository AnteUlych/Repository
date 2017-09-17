package bird.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bird.dao.RouteDAO;
import bird.model.Route;

@Service("RouteService")
@Transactional
public class RouteService {
	
	@Autowired
	private RouteDAO dao;
	
	public List<Route> getAllRouteByCargoId(int cargoID) {
		return dao.getAllRouteByCargoId(cargoID);
	}
	
	public void editRoute(int id, double longitude, double latitude, String status) {
		dao.editRoute(id, longitude, latitude, status);
	}
	
	public void deleteRoute(int id) {
		dao.deleteRoute(id);
	}
	
	public void addRoute(int cargoID, double longitude, double latitude, String status){
		
		Route route = new Route();
		
		route.setCargoID(cargoID);
		route.setLatitude(latitude);
		route.setLongitude(longitude);
		route.setStatus(status);
		route.setTime(new Date());
		
		dao.persist(route);
	}
}
