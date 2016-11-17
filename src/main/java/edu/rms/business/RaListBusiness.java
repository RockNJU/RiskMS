package edu.rms.business;

import java.util.List;

import edu.rms.model.RaList;

public interface RaListBusiness {
	
	//获取所有的风险计划
	public List<RaList> getAll();
	
	
	public String save(RaList ra);
}
