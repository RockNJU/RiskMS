package com.rms.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.rms.dao.BaseDao;
import com.rms.dao.RiskItemDao;
import com.rms.model.RiskItem;
import com.rms.model.User;

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
