package edu.rms.businessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rms.business.RaListBusiness;
import edu.rms.dao.RaListDao;
import edu.rms.model.RaList;

@Service
public class RaListBusinessImpl implements RaListBusiness{

	@Autowired
	private RaListDao radao;
	
	@Override
	public List<RaList> getAll() {
		return radao.getAll();
	}

	@Override
	public String save(RaList ra) {
		
		return radao.save(ra);
	}

}
