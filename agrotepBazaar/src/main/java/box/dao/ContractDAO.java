package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import box.model.Contract;

public class ContractDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Contract contract) {
		Contract transaction = em.merge(contract);
		em.persist(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contract> getListOfContracts() {
		return em.createQuery("from Contract").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Contract> getListOfContractsByManagerId(int managerid) {
		return em.createQuery(
				"from Contract where managerid = '" + managerid + "'")
				.getResultList();
	}
	
	public Contract getContractById(int id) {
		Contract contract = (Contract) em.find(Contract.class, id);
		return contract;
	}
	
	@Transactional
	public void editContract(int id, String company, int managerid, String manager, Date lastday, String status) {

		Contract contract = (Contract) em.find(Contract.class, id);

		contract.setCompany(company);
		contract.setLastday(lastday);
		contract.setManager(manager);
		contract.setManagerid(managerid);
		contract.setStatus(status);

		Contract transaction = em.merge(contract);
		em.persist(transaction);
		em.close();

	}


}
