package box.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.ArchivebetDAO;
import box.model.Archivebet;



@Service("ArchivebetService")
@Transactional
public class ArchivebetService {
	
	@Autowired
	private ArchivebetDAO dao;
	
	public void addArchivebet(Archivebet archivebet) {
		dao.persist(archivebet);
	}


}
