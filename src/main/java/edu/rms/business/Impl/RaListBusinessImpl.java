package edu.rms.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rms.business.RaListBusiness;
import edu.rms.dao.RaItemsDao;
import edu.rms.dao.RaListDao;
import edu.rms.model.RaList;

@Service
public class RaListBusinessImpl implements RaListBusiness{

	@Autowired
	private RaListDao radao;
	
	@Autowired
	private RaItemsDao rDao;
	
	@Override
	public List<RaList> getAll() {
		return radao.getAll();
	}

	@Override
	public String save(RaList ra) {
		
		return radao.save(ra);
	}

	@Override
	public void deleteRA(int id) {
		radao.delete(id);
		rDao.delete(id);
		
	}

}
