package edu.rms.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rms.business.RaListBusiness;
import edu.rms.dao.RaItemsDao;
import edu.rms.dao.RaListDao;
import edu.rms.model.RaItems;
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

	@Override
	public RaList getRAbyId(int id) {
		
		return radao.getRAbyId(id);
	}

	@Override
	public void updateRAbyId(int ra_id, String ra_name, List<String> itemList) {
		
		RaList ralist=radao.getRAbyId(ra_id);
		ralist.setRa_name(ra_name);
		radao.update(ralist);
		rDao.delete(ra_id);
		RaItems ri=new RaItems();
		if(itemList==null){
			
		}else{
		for(int i=0;i<itemList.size();i++){
			ri.setRiskItem_id(Integer.parseInt(itemList.get(i)));
			ri.setRa_id(ra_id);
			rDao.save(ri);
		}
		}
	}

}
