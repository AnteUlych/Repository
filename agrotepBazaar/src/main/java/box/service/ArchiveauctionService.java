package box.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.ArchiveauctionDAO;
import box.model.Archiveauction;

@Service("ArchiveauctionService")
@Transactional
public class ArchiveauctionService {
	
	@Autowired
	private ArchiveauctionDAO dao;
	
	public void addArchiveauction(Archiveauction archiveauction) {
		dao.persist(archiveauction);
	}

}
