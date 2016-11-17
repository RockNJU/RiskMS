package edu.rms.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.rms.dao.BaseDao;
import edu.rms.dao.RiskItemDao;
import edu.rms.model.RiskItem;
import edu.rms.model.User;

@Repository
public class RiskItemDaoImpl implements RiskItemDao{

	@Autowired
	private BaseDao baseDao;
	
	
	@Override
	public List<RiskItem> getAll() {
		return baseDao.getAllList(RiskItem.class);
	}

	

	@Override
	public String save(RiskItem riskItem) {
		try {
			baseDao.save(riskItem);
			return "新增风险条目成功";
		}catch (Exception e) {			
			e.printStackTrace();
			return "风险条目新增失败";
		}
	}

	

}
