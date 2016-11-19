package edu.rms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.rms.dao.BaseDao;
import edu.rms.dao.RaListDao;
import edu.rms.model.RaList;
import edu.rms.model.RiskStateTrack;

@Repository
public class RaListDaoImpl implements RaListDao {

	
	@Autowired
	private BaseDao baseDao;
	
	
	@Override
	public List<RaList> getAll() {	
		try {
			List ls=baseDao.getAllList(RaList.class);
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public String save(RaList ra) {
		
		try {
			int size=baseDao.getAllList(RaList.class).size();
			ra.setRa_id(size+1);
			baseDao.save(ra);
			return "新增计划成功";
		}catch (Exception e) {			
			e.printStackTrace();
			return "计划新增失败";
		}
	}

	
}
