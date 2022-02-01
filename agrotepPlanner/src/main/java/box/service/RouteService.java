package box.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.RouteDAO;
import box.logic.Constants;
import box.model.Route;


@Service("RouteService")
@Transactional
public class RouteService {

	@Autowired
	private RouteDAO dao;
	
	public List<Route> getListOfRoutesBetweenDatesByTruckIdForHistory(int truckid, String start, String finish) {
		return dao.getListOfRoutesBetweenDatesByTruckIdForHistory(truckid, start, finish);
	}
	
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
	
	public void addRoute(Route route){
		dao.persist(route);
	}
	
	public void deleteRoute(int id) {
		dao.deleteRoute(id);
	}
	
	public Route getRouteById(int id){
		return dao.getRouteById(id);
	}
	
	public List<Route> getListOfRoutesByRouteStatusBetweenDates(int routeStatus, String start, String finish){
		return dao.getListOfRoutesByRouteStatusBetweenDates(routeStatus, start, finish);
	}
	
	public List<Route> getLastTenRoutesByTruckId(int truckid, String finish){
		return dao.getLastTenRoutesByTruckId(truckid, finish);
	}
	
	public List<Route> getLastRemontRouteByTruckId(int truckid, String finish){
		return dao.getLastRemontRouteByTruckId(truckid, finish);		
	}
	
}
