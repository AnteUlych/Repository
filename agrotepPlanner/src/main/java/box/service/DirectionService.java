package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.DirectionDAO;
import box.model.Direction;

@Service("DirectionService")
@Transactional
public class DirectionService {
	
	@Autowired
	private DirectionDAO dao;
	
	public List<Direction> getListOfDirections() {
		return dao.getListOfDirections();
	}

}
