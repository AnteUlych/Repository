package box.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.ContractDAO;
import box.model.Contract;


@Service("ContractService")
@Transactional
public class ContractService {
			
		@Autowired
		private ContractDAO dao;
		
		public void addContract(Contract contract) {
			dao.persist(contract);
		}
		
		public List<Contract> getListOfContracts() {
			return dao.getListOfContracts();
		}
		
		public List<Contract> getListOfContractsByManagerId(int managerid) {
			return dao.getListOfContractsByManagerId(managerid);
		}
		
		public int getNumberOfContractsByManagerId(int managerid) {
			return dao.getListOfContractsByManagerId(managerid).size();
		}
		
		
		public void editContract(int id, String company, int managerid, String manager, Date lastday, String status) {
			dao.editContract(id, company, managerid, manager, lastday, status);
		}
		
		
		public Contract getContractById(int id) {
			return dao.getContractById(id);
		}

}
