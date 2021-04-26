package box.service;

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
	
	public List<Route> getListOfRoutes() {
		return dao.getListOfRoutes();
	}
	
}
