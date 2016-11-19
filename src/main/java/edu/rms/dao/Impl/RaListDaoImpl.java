package edu.rms.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.rms.dao.BaseDao;
import edu.rms.dao.RaListDao;
import edu.rms.model.RaList;

@Repository
public class RaListDaoImpl implements RaListDao {

	
	@Autowired
	private BaseDao baseDao;
	
	
	@Override
	public List<RaList> getAll() {	
		return baseDao.getAllList(RaList.class);
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
