package lotos.service;

import java.util.List;

import lotos.dao.CompanyDAO;
import lotos.model.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("CompanyService")
@Transactional
public class CompanyService {

	@Autowired
	private CompanyDAO dao;
	//test
	public List<Company> getAllCompanies() {
		return dao.getAllCompanies();
	}
	//test
}
