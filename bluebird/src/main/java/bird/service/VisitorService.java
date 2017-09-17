package bird.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bird.dao.VisitorDAO;
import bird.model.Visitor;

@Service("VisitorService")
@Transactional
public class VisitorService {

	@Autowired
	private VisitorDAO dao;

	public void addVisitor(String company) {

		Visitor visitor = new Visitor();

		visitor.setCompany(company);
		visitor.setTime(new Date());

		dao.persist(visitor);
	}
	
	public List<Visitor> getAllVisitors() {
		return dao.getAllVisitors();
	}
	
	public List<Visitor> getAllVisitorsByDate(Date point){
		
		List<Visitor> allVisitors = dao.getAllVisitors();
		List<Visitor> filtre = new ArrayList<Visitor>();

		for (Visitor visitor : allVisitors) {
				if (visitor.getTime().after(point)) {
					filtre.add(visitor);
				}
			}
		return filtre;
	}
}
