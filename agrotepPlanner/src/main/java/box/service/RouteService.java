package box.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.RouteDAO;
import box.model.Route;


@Service("RouteService")
@Transactional
public class RouteService {

	@Autowired
	private RouteDAO dao;
	
	public List<Route> getListOfRoutesBetweenDatesByTruckId(int truckid, String start, String finish) {
		return dao.getListOfRoutesBetweenDatesByTruckId(truckid, start, finish);
	}
	
	public Route getLastRouteBetweenDatesByTruckId(int truckid, String start, String finish) {
		return dao.getLastRouteBetweenDatesByTruckId(truckid, start, finish).get(0);
	}
	
	public boolean isListOfRoutesBetweenDatesByTruckIdExist(int truckid, String start, String finish) {
		
		int routes = dao.getListOfRoutesBetweenDatesByTruckId(truckid, start, finish).size();
		
		if(routes==0){
			return false;
		}	
		return true;
	}
	
	public Route getLastRouteByTruckId(int truckid, String finish){
		List<Route> routes = dao.getLastRouteByTruckId(truckid, finish);
		Route route = routes.get(0);
		return route;
	}
	
}
